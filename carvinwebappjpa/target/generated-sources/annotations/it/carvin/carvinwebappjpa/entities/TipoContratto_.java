package it.carvin.carvinwebappjpa.entities;

import it.carvin.carvinwebappjpa.entities.ActiveContracts;
import it.carvin.carvinwebappjpa.entities.Contracts;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-02T10:41:47")
@StaticMetamodel(TipoContratto.class)
public class TipoContratto_ { 

    public static volatile CollectionAttribute<TipoContratto, Contracts> contractsCollection;
    public static volatile CollectionAttribute<TipoContratto, ActiveContracts> activeContractsCollection;
    public static volatile SingularAttribute<TipoContratto, Integer> id;
    public static volatile SingularAttribute<TipoContratto, String> tipoContratto;

}