package it.carvin.carvinwebappjpa.entities;

import it.carvin.carvinwebappjpa.entities.ActiveContrattiSediCliente;
import it.carvin.carvinwebappjpa.entities.AnagraficaContratti;
import it.carvin.carvinwebappjpa.entities.Contracts;
import it.carvin.carvinwebappjpa.entities.HisContracts;
import it.carvin.carvinwebappjpa.entities.TipoContratto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-02T10:41:47")
@StaticMetamodel(ActiveContracts.class)
public class ActiveContracts_ { 

    public static volatile CollectionAttribute<ActiveContracts, HisContracts> hisContractsCollection;
    public static volatile SingularAttribute<ActiveContracts, Date> dataFin;
    public static volatile SingularAttribute<ActiveContracts, AnagraficaContratti> anagraficaContratti;
    public static volatile CollectionAttribute<ActiveContracts, ActiveContrattiSediCliente> activeContrattiSediClienteCollection;
    public static volatile SingularAttribute<ActiveContracts, String> id;
    public static volatile SingularAttribute<ActiveContracts, String> codicecontratto;
    public static volatile SingularAttribute<ActiveContracts, Contracts> contracts;
    public static volatile SingularAttribute<ActiveContracts, TipoContratto> idTipoContratto;
    public static volatile SingularAttribute<ActiveContracts, Date> dataIni;

}