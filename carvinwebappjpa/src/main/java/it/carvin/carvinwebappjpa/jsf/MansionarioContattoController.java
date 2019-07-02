package it.carvin.carvinwebappjpa.jsf;

import it.carvin.carvinwebappjpa.entities.MansionarioContatto;
import it.carvin.carvinwebappjpa.jsf.util.JsfUtil;
import it.carvin.carvinwebappjpa.jsf.util.PaginationHelper;
import it.carvin.carvinwebappjpa.entities.MansionarioContattoFacade;

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

@Named("mansionarioContattoController")
@SessionScoped
public class MansionarioContattoController implements Serializable {

    private MansionarioContatto current;
    private DataModel items = null;
    @EJB
    private it.carvin.carvinwebappjpa.entities.MansionarioContattoFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public MansionarioContattoController() {
    }

    public MansionarioContatto getSelected() {
        if (current == null) {
            current = new MansionarioContatto();
            current.setMansionarioContattoPK(new it.carvin.carvinwebappjpa.entities.MansionarioContattoPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private MansionarioContattoFacade getFacade() {
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
        current = (MansionarioContatto) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new MansionarioContatto();
        current.setMansionarioContattoPK(new it.carvin.carvinwebappjpa.entities.MansionarioContattoPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getMansionarioContattoPK().setIdTipoMansione(current.getTipoMansione().getId());
            current.getMansionarioContattoPK().setIdContatto(current.getContattiAttivi().getId());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("MansionarioContattoCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (MansionarioContatto) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getMansionarioContattoPK().setIdTipoMansione(current.getTipoMansione().getId());
            current.getMansionarioContattoPK().setIdContatto(current.getContattiAttivi().getId());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("MansionarioContattoUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (MansionarioContatto) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("MansionarioContattoDeleted"));
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

    public MansionarioContatto getMansionarioContatto(it.carvin.carvinwebappjpa.entities.MansionarioContattoPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = MansionarioContatto.class)
    public static class MansionarioContattoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MansionarioContattoController controller = (MansionarioContattoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "mansionarioContattoController");
            return controller.getMansionarioContatto(getKey(value));
        }

        it.carvin.carvinwebappjpa.entities.MansionarioContattoPK getKey(String value) {
            it.carvin.carvinwebappjpa.entities.MansionarioContattoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new it.carvin.carvinwebappjpa.entities.MansionarioContattoPK();
            key.setIdContatto(values[0]);
            key.setIdTipoMansione(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(it.carvin.carvinwebappjpa.entities.MansionarioContattoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdContatto());
            sb.append(SEPARATOR);
            sb.append(value.getIdTipoMansione());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof MansionarioContatto) {
                MansionarioContatto o = (MansionarioContatto) object;
                return getStringKey(o.getMansionarioContattoPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + MansionarioContatto.class.getName());
            }
        }

    }

}
