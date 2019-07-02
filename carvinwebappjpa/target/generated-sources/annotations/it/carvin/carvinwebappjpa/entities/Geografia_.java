package it.carvin.carvinwebappjpa.entities;

import it.carvin.carvinwebappjpa.entities.SediAttive;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-02T10:41:47")
@StaticMetamodel(Geografia.class)
public class Geografia_ { 

    public static volatile SingularAttribute<Geografia, String> codicegeografia;
    public static volatile CollectionAttribute<Geografia, SediAttive> sediAttiveCollection;
    public static volatile SingularAttribute<Geografia, String> microzona;
    public static volatile SingularAttribute<Geografia, String> id;
    public static volatile SingularAttribute<Geografia, String> provincia;
    public static volatile SingularAttribute<Geografia, String> macrozona;

}