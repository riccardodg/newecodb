/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.carvin.carvinwebappjpa.entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Riccardo Del Gratta &lt;riccardo.delgratta@ilc.cnr.it&gt;
 */
@Stateless
public class AnagraficaContrattiFacade extends AbstractFacade<AnagraficaContratti> {

    @PersistenceContext(unitName = "it.carvin_carvinwebappjpa_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnagraficaContrattiFacade() {
        super(AnagraficaContratti.class);
    }
    
}
