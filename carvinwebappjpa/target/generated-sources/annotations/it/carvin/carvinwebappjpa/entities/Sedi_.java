package it.carvin.carvinwebappjpa.entities;

import it.carvin.carvinwebappjpa.entities.SediAttive;
import it.carvin.carvinwebappjpa.entities.TipoCausa;
import it.carvin.carvinwebappjpa.entities.TipoSede;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-02T10:41:47")
@StaticMetamodel(Sedi.class)
public class Sedi_ { 

    public static volatile SingularAttribute<Sedi, Date> dataFin;
    public static volatile SingularAttribute<Sedi, TipoCausa> idCausa;
    public static volatile SingularAttribute<Sedi, String> id;
    public static volatile SingularAttribute<Sedi, SediAttive> sediAttive;
    public static volatile SingularAttribute<Sedi, TipoSede> idTipoSede;
    public static volatile SingularAttribute<Sedi, String> codicesede;
    public static volatile SingularAttribute<Sedi, Date> dataIni;

}