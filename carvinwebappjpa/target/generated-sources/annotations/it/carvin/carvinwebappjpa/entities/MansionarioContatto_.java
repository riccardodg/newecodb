package it.carvin.carvinwebappjpa.entities;

import it.carvin.carvinwebappjpa.entities.ContattiAttivi;
import it.carvin.carvinwebappjpa.entities.MansionarioContattoPK;
import it.carvin.carvinwebappjpa.entities.TipoMansione;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-02T10:41:47")
@StaticMetamodel(MansionarioContatto.class)
public class MansionarioContatto_ { 

    public static volatile SingularAttribute<MansionarioContatto, TipoMansione> tipoMansione;
    public static volatile SingularAttribute<MansionarioContatto, MansionarioContattoPK> mansionarioContattoPK;
    public static volatile SingularAttribute<MansionarioContatto, Boolean> principale;
    public static volatile SingularAttribute<MansionarioContatto, ContattiAttivi> contattiAttivi;

}