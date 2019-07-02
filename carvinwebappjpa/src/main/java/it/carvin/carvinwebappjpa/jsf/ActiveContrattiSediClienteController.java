package it.carvin.carvinwebappjpa.jsf;

import it.carvin.carvinwebappjpa.entities.ActiveContrattiSediCliente;
import it.carvin.carvinwebappjpa.jsf.util.JsfUtil;
import it.carvin.carvinwebappjpa.jsf.util.PaginationHelper;
import it.carvin.carvinwebappjpa.entities.ActiveContrattiSediClienteFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("activeContrattiSediClienteController")
@SessionScoped
public class ActiveContrattiSediClienteController implements Serializable {

    private ActiveContrattiSediCliente current;
    private DataModel items = null;
    @EJB
    private it.carvin.carvinwebappjpa.entities.ActiveContrattiSediClienteFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public ActiveContrattiSediClienteController() {
    }

    public ActiveContrattiSediCliente getSelected() {
        if (current == null) {
            current = new ActiveContrattiSediCliente();
            current.setActiveContrattiSediClientePK(new it.carvin.carvinwebappjpa.entities.ActiveContrattiSediClientePK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private ActiveContrattiSediClienteFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (ActiveContrattiSediCliente) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new ActiveContrattiSediCliente();
        current.setActiveContrattiSediClientePK(new it.carvin.carvinwebappjpa.entities.ActiveContrattiSediClientePK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getActiveContrattiSediClientePK().setIdSede(current.getSediAttive().getId());
            current.getActiveContrattiSediClientePK().setIdContratto(current.getActiveContracts().getId());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("ActiveContrattiSediClienteCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (ActiveContrattiSediCliente) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getActiveContrattiSediClientePK().setIdSede(current.getSediAttive().getId());
            current.getActiveContrattiSediClientePK().setIdContratto(current.getActiveContracts().getId());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("ActiveContrattiSediClienteUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (ActiveContrattiSediCliente) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("ActiveContrattiSediClienteDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public ActiveContrattiSediCliente getActiveContrattiSediCliente(it.carvin.carvinwebappjpa.entities.ActiveContrattiSediClientePK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = ActiveContrattiSediCliente.class)
    public static class ActiveContrattiSediClienteControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ActiveContrattiSediClienteController controller = (ActiveContrattiSediClienteController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "activeContrattiSediClienteController");
            return controller.getActiveContrattiSediCliente(getKey(value));
        }

        it.carvin.carvinwebappjpa.entities.ActiveContrattiSediClientePK getKey(String value) {
            it.carvin.carvinwebappjpa.entities.ActiveContrattiSediClientePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new it.carvin.carvinwebappjpa.entities.ActiveContrattiSediClientePK();
            key.setIdContratto(values[0]);
            key.setIdSede(values[1]);
            return key;
        }

        String getStringKey(it.carvin.carvinwebappjpa.entities.ActiveContrattiSediClientePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdContratto());
            sb.append(SEPARATOR);
            sb.append(value.getIdSede());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ActiveContrattiSediCliente) {
                ActiveContrattiSediCliente o = (ActiveContrattiSediCliente) object;
                return getStringKey(o.getActiveContrattiSediClientePK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + ActiveContrattiSediCliente.class.getName());
            }
        }

    }

}
