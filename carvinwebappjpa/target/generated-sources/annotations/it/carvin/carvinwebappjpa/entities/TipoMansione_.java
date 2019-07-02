package it.carvin.carvinwebappjpa.entities;

import it.carvin.carvinwebappjpa.entities.MansionarioContatto;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-02T10:41:47")
@StaticMetamodel(TipoMansione.class)
public class TipoMansione_ { 

    public static volatile SingularAttribute<TipoMansione, String> tipoMansione;
    public static volatile SingularAttribute<TipoMansione, Integer> id;
    public static volatile CollectionAttribute<TipoMansione, MansionarioContatto> mansionarioContattoCollection;

}