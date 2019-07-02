package it.carvin.carvinwebappjpa.entities;

import it.carvin.carvinwebappjpa.entities.ActiveClients;
import it.carvin.carvinwebappjpa.entities.TipoCausa;
import it.carvin.carvinwebappjpa.entities.TipoCliente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-02T10:41:47")
@StaticMetamodel(Clients.class)
public class Clients_ { 

    public static volatile SingularAttribute<Clients, String> cofi;
    public static volatile SingularAttribute<Clients, String> ragionesoc;
    public static volatile SingularAttribute<Clients, Date> dataFin;
    public static volatile SingularAttribute<Clients, String> codicecliente;
    public static volatile SingularAttribute<Clients, TipoCliente> idTipoCliente;
    public static volatile SingularAttribute<Clients, String> paiv;
    public static volatile SingularAttribute<Clients, TipoCausa> idCausa;
    public static volatile SingularAttribute<Clients, String> id;
    public static volatile SingularAttribute<Clients, ActiveClients> activeClients;
    public static volatile SingularAttribute<Clients, Date> dataIni;

}