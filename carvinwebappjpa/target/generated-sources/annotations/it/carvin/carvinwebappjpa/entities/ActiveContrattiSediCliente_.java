package it.carvin.carvinwebappjpa.entities;

import it.carvin.carvinwebappjpa.entities.ActiveClients;
import it.carvin.carvinwebappjpa.entities.ActiveContracts;
import it.carvin.carvinwebappjpa.entities.ActiveContrattiSediClientePK;
import it.carvin.carvinwebappjpa.entities.SediAttive;
import it.carvin.carvinwebappjpa.entities.TipoModContratto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-02T10:41:47")
@StaticMetamodel(ActiveContrattiSediCliente.class)
public class ActiveContrattiSediCliente_ { 

    public static volatile SingularAttribute<ActiveContrattiSediCliente, TipoModContratto> idTipoModContratto;
    public static volatile SingularAttribute<ActiveContrattiSediCliente, ActiveClients> idPartner;
    public static volatile SingularAttribute<ActiveContrattiSediCliente, ActiveClients> idCliente;
    public static volatile SingularAttribute<ActiveContrattiSediCliente, ActiveContrattiSediClientePK> activeContrattiSediClientePK;
    public static volatile SingularAttribute<ActiveContrattiSediCliente, SediAttive> sediAttive;
    public static volatile SingularAttribute<ActiveContrattiSediCliente, ActiveContracts> activeContracts;

}