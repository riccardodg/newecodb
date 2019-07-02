package it.carvin.carvinwebappjpa.entities;

import it.carvin.carvinwebappjpa.entities.Sedi;
import it.carvin.carvinwebappjpa.entities.SediAttive;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-02T10:41:47")
@StaticMetamodel(TipoSede.class)
public class TipoSede_ { 

    public static volatile CollectionAttribute<TipoSede, SediAttive> sediAttiveCollection;
    public static volatile CollectionAttribute<TipoSede, Sedi> sediCollection;
    public static volatile SingularAttribute<TipoSede, Integer> id;
    public static volatile SingularAttribute<TipoSede, String> tipoSede;

}