package it.carvin.carvinwebappjpa.entities;

import it.carvin.carvinwebappjpa.entities.Clients;
import it.carvin.carvinwebappjpa.entities.Contatti;
import it.carvin.carvinwebappjpa.entities.Contracts;
import it.carvin.carvinwebappjpa.entities.Sedi;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-02T10:41:47")
@StaticMetamodel(TipoCausa.class)
public class TipoCausa_ { 

    public static volatile SingularAttribute<TipoCausa, String> causa;
    public static volatile CollectionAttribute<TipoCausa, Contracts> contractsCollection;
    public static volatile CollectionAttribute<TipoCausa, Sedi> sediCollection;
    public static volatile SingularAttribute<TipoCausa, Integer> id;
    public static volatile CollectionAttribute<TipoCausa, Contatti> contattiCollection;
    public static volatile CollectionAttribute<TipoCausa, Clients> clientsCollection;

}