package it.carvin.carvinwebappjpa.entities;

import it.carvin.carvinwebappjpa.entities.ActiveClients;
import it.carvin.carvinwebappjpa.entities.ActiveContrattiSediCliente;
import it.carvin.carvinwebappjpa.entities.ContattiAttivi;
import it.carvin.carvinwebappjpa.entities.Geografia;
import it.carvin.carvinwebappjpa.entities.HisSedi;
import it.carvin.carvinwebappjpa.entities.Sedi;
import it.carvin.carvinwebappjpa.entities.TipoSede;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-02T10:41:47")
@StaticMetamodel(SediAttive.class)
public class SediAttive_ { 

    public static volatile SingularAttribute<SediAttive, Sedi> sedi;
    public static volatile SingularAttribute<SediAttive, Date> dataFin;
    public static volatile CollectionAttribute<SediAttive, ContattiAttivi> contattiAttiviCollection;
    public static volatile CollectionAttribute<SediAttive, Geografia> geografiaCollection;
    public static volatile CollectionAttribute<SediAttive, ActiveContrattiSediCliente> activeContrattiSediClienteCollection;
    public static volatile CollectionAttribute<SediAttive, ActiveClients> activeClientsCollection;
    public static volatile SingularAttribute<SediAttive, String> id;
    public static volatile SingularAttribute<SediAttive, TipoSede> idTipoSede;
    public static volatile SingularAttribute<SediAttive, String> codicesede;
    public static volatile CollectionAttribute<SediAttive, HisSedi> hisSediCollection;
    public static volatile SingularAttribute<SediAttive, Date> dataIni;

}