package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Dipendenti;

@Repository
public class DipendentiRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void insertDipendenti(Dipendenti d) {
		em.persist(d);
	}
	@Transactional
	public void updateDipendenti(Dipendenti d) {
		em.merge(d);
	}
	@Transactional
	public void deleteDipendenti(int matricola) {
		em.remove(em.find(Dipendenti.class, matricola));
	}
	public Dipendenti selectById(int matricola) {
		return em.find(Dipendenti.class, matricola);
	}
	public List<Dipendenti> getDipendenti(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Dipendenti> cq = builder.createQuery(Dipendenti.class);
		Root<Dipendenti> root = cq.from(Dipendenti.class);
		cq.select(root);
		return em.createQuery(cq).getResultList();
	}
}
