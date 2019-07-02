package it.carvin.carvinwebappjpa.entities;

import it.carvin.carvinwebappjpa.entities.ContattiAttivi;
import it.carvin.carvinwebappjpa.entities.TipoContatto;
import it.carvin.carvinwebappjpa.entities.ValoreTipoContattoPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-02T10:41:47")
@StaticMetamodel(ValoreTipoContatto.class)
public class ValoreTipoContatto_ { 

    public static volatile SingularAttribute<ValoreTipoContatto, TipoContatto> tipoContatto;
    public static volatile SingularAttribute<ValoreTipoContatto, String> valoreContatto;
    public static volatile SingularAttribute<ValoreTipoContatto, Boolean> principale;
    public static volatile SingularAttribute<ValoreTipoContatto, ValoreTipoContattoPK> valoreTipoContattoPK;
    public static volatile SingularAttribute<ValoreTipoContatto, ContattiAttivi> contattiAttivi;

}