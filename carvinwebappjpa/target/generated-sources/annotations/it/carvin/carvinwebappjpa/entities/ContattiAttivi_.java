package it.carvin.carvinwebappjpa.entities;

import it.carvin.carvinwebappjpa.entities.Contatti;
import it.carvin.carvinwebappjpa.entities.HisContatti;
import it.carvin.carvinwebappjpa.entities.MansionarioContatto;
import it.carvin.carvinwebappjpa.entities.SediAttive;
import it.carvin.carvinwebappjpa.entities.ValoreTipoContatto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-02T10:41:47")
@StaticMetamodel(ContattiAttivi.class)
public class ContattiAttivi_ { 

    public static volatile CollectionAttribute<ContattiAttivi, HisContatti> hisContattiCollection;
    public static volatile SingularAttribute<ContattiAttivi, Date> dataFin;
    public static volatile CollectionAttribute<ContattiAttivi, ValoreTipoContatto> valoreTipoContattoCollection;
    public static volatile CollectionAttribute<ContattiAttivi, SediAttive> sediAttiveCollection;
    public static volatile SingularAttribute<ContattiAttivi, Contatti> contatti;
    public static volatile SingularAttribute<ContattiAttivi, String> codicecontatto;
    public static volatile SingularAttribute<ContattiAttivi, String> id;
    public static volatile SingularAttribute<ContattiAttivi, Date> dataIni;
    public static volatile CollectionAttribute<ContattiAttivi, MansionarioContatto> mansionarioContattoCollection;

}