package it.carvin.carvinwebappjpa.entities;

import it.carvin.carvinwebappjpa.entities.ActiveContracts;
import it.carvin.carvinwebappjpa.entities.TipoCausa;
import it.carvin.carvinwebappjpa.entities.TipoContratto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-02T10:41:47")
@StaticMetamodel(Contracts.class)
public class Contracts_ { 

    public static volatile SingularAttribute<Contracts, Date> dataFin;
    public static volatile SingularAttribute<Contracts, TipoCausa> idCausa;
    public static volatile SingularAttribute<Contracts, String> id;
    public static volatile SingularAttribute<Contracts, String> codicecontratto;
    public static volatile SingularAttribute<Contracts, ActiveContracts> activeContracts;
    public static volatile SingularAttribute<Contracts, TipoContratto> idTipoContratto;
    public static volatile SingularAttribute<Contracts, Date> dataIni;

}