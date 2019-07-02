package it.carvin.carvinwebappjpa.entities;

import it.carvin.carvinwebappjpa.entities.ActiveClients;
import it.carvin.carvinwebappjpa.entities.Clients;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-02T10:41:47")
@StaticMetamodel(TipoCliente.class)
public class TipoCliente_ { 

    public static volatile SingularAttribute<TipoCliente, String> tipoCliente;
    public static volatile CollectionAttribute<TipoCliente, ActiveClients> activeClientsCollection;
    public static volatile SingularAttribute<TipoCliente, Integer> id;
    public static volatile CollectionAttribute<TipoCliente, Clients> clientsCollection;

}