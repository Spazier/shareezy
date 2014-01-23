/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	Tim Treibmann
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.shareezy.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.shareezy.entities.Ressource;

/**
 * Diese Klasse stellt die Eigenschaften und Funktinen für das Listen von
 * Ressourcen zur Verfügung. Ressourcen werden in der Ressourcenansicht.xhtml,
 * EigeneRessourcen.xhtml, Gruppenverwaltung.xhtml und eigeneBuchungen.xhtml
 * gelistet.
 * 
 * @author e1_treibmann
 * 
 */
@Named
@RequestScoped
public class RessourceListen {

	@Inject
	private EntityManagerFactory emf;

	/**
	 * Die Methode ressourceClicked leitet bei einem Klick auf den Namen der
	 * Ressource, den Benutzer auf die Detailansicht der Ressource weiter.
	 * 
	 * @return "ressourcendetail" gibt die ressourcendetail zurück wenn auf
	 *         einen Ressourcennamen geklickt wurde.
	 */
	public String ressourceClicked() {
		return "ressourcendetail";
	}

	/**
	 * Die Methode getRessourcenListe gibt eine Liste aller Ressourcen in der
	 * Datenbank zurück.
	 * 
	 * @return Liste von Ressourcenobjekten.
	 */
	public List<Ressource> getRessourcenListe() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select r from Ressource r");
		@SuppressWarnings("unchecked")
		List<Ressource> listeRessourcen = q.getResultList();
		em.getTransaction().commit();
		if (listeRessourcen.size() == 0) {
			listeRessourcen = new ArrayList<Ressource>();
		}
		return listeRessourcen;
	}

}
