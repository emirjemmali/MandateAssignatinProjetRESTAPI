package tn.esprit.Map.services;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import tn.esprit.Map.interfaces.MandateServiceLocal;
import tn.esprit.Map.persistences.Mandate;
import tn.esprit.Map.persistences.Request;
import tn.esprit.Map.persistences.Resource;
import tn.esprit.Map.persistences.Skill;

@Stateless
public class MandateService implements MandateServiceLocal {
	@PersistenceContext(unitName = "MAP")
	EntityManager em;
	@EJB
	Mail mail;
	
	@Override
	public Resource SearchResourceBySkill(Skill skill) {
		
		return null;
	}

	@Override
	public boolean isAvailable(int resourceId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void notify(String receiver ,String topic, String textMessage) {
		
		
		mail.send(receiver, topic, textMessage);

	}

	@Override
	public List<Mandate> getAll() {
		TypedQuery<Mandate> query = em.createQuery("SELECT m FROM Mandate m", Mandate.class);
		List<Mandate> results = query.getResultList();
		return results;
	}

	@Override
	public List<Mandate> getByResource(int resourceId) {
		TypedQuery<Mandate> query = em.createQuery("SELECT m FROM Mandate m where m.ressourceId=:rId", Mandate.class);
		query.setParameter("rId", resourceId);
		List<Mandate> results = query.getResultList();
		return results;
	}

	@Override
	public List<Mandate> getByProject(int projectId) {
		TypedQuery<Mandate> query = em.createQuery("SELECT m FROM Mandate m where m.projetId = :pId", Mandate.class);
		query.setParameter("pId", projectId);
		List<Mandate> results = query.getResultList();
		return results;
	}

	@Override
	public List<Mandate> getByStartDate(Date startDate) {
		TypedQuery<Mandate> query = em.createQuery("SELECT m FROM Mandate m where m.dateDebut = :startDate",
				Mandate.class);
		query.setParameter("startDate", new java.util.Date(), TemporalType.DATE);
		List<Mandate> results = query.getResultList();
		return results;
	}

	@Override
	public List<Mandate> getByEndDate(Date endDate) {
		TypedQuery<Mandate> query = em.createQuery("SELECT m FROM Mandate m where m.dateFin = :endDate", Mandate.class);
		query.setParameter("endDate", new java.util.Date(), TemporalType.DATE);
		List<Mandate> results = query.getResultList();
		return results;
	}

	@Override
	public List<Mandate> getByPeriod(Date startDate, Date endDate) {
		TypedQuery<Mandate> query = em
				.createQuery("SELECT m FROM Mandate m where m.dateFin BETWEEN :endDate AND :startDate", Mandate.class);
		query.setParameter("endDate", new java.util.Date(), TemporalType.DATE);
		query.setParameter("startDate", new java.util.Date(), TemporalType.DATE);
		List<Mandate> results = query.getResultList();
		return results;
	}

	@Override
	public boolean archive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float calculateCost(Mandate mandate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void AlertEndMandate(Mandate mandate) {
		// TODO Auto-generated method stub

	}

	


	@Override
	public boolean addMandate(Request request) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addGps(int ressourceId, int projetId, Date dateDebut, Date dateFin, int gpsId) {
		// TODO Auto-generated method stub
		return false;
	}

}
