package it.carvin.carvinwebappjpa.entities;

import it.carvin.carvinwebappjpa.entities.ActiveContrattiSediCliente;
import it.carvin.carvinwebappjpa.entities.Clients;
import it.carvin.carvinwebappjpa.entities.HisClients;
import it.carvin.carvinwebappjpa.entities.SediAttive;
import it.carvin.carvinwebappjpa.entities.TipoCliente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-02T10:41:47")
@StaticMetamodel(ActiveClients.class)
public class ActiveClients_ { 

    public static volatile CollectionAttribute<ActiveClients, ActiveContrattiSediCliente> activeContrattiSediClienteCollection1;
    public static volatile CollectionAttribute<ActiveClients, HisClients> hisClientsCollection;
    public static volatile SingularAttribute<ActiveClients, Clients> clients;
    public static volatile SingularAttribute<ActiveClients, Date> dataFin;
    public static volatile CollectionAttribute<ActiveClients, ActiveContrattiSediCliente> activeContrattiSediClienteCollection;
    public static volatile SingularAttribute<ActiveClients, String> codicecliente;
    public static volatile CollectionAttribute<ActiveClients, SediAttive> sediAttiveCollection;
    public static volatile SingularAttribute<ActiveClients, TipoCliente> idTipoCliente;
    public static volatile SingularAttribute<ActiveClients, String> id;
    public static volatile SingularAttribute<ActiveClients, Date> dataIni;

}