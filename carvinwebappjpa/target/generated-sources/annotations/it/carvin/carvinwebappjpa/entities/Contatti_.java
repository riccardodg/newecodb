package it.carvin.carvinwebappjpa.entities;

import it.carvin.carvinwebappjpa.entities.ContattiAttivi;
import it.carvin.carvinwebappjpa.entities.TipoCausa;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-02T10:41:47")
@StaticMetamodel(Contatti.class)
public class Contatti_ { 

    public static volatile SingularAttribute<Contatti, Date> dataFin;
    public static volatile SingularAttribute<Contatti, String> cognome;
    public static volatile SingularAttribute<Contatti, String> codicecontatto;
    public static volatile SingularAttribute<Contatti, String> nome;
    public static volatile SingularAttribute<Contatti, TipoCausa> idCausa;
    public static volatile SingularAttribute<Contatti, String> id;
    public static volatile SingularAttribute<Contatti, ContattiAttivi> contattiAttivi;
    public static volatile SingularAttribute<Contatti, String> sal;
    public static volatile SingularAttribute<Contatti, Date> dataIni;

}