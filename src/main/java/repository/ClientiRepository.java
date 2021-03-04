package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Clienti;

@Repository
public class ClientiRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void insertClienti(Clienti c) {
		em.persist(c);
	}
	
	@Transactional
	public void updateClienti(Clienti c) {
		em.merge(c);
	}
	@Transactional
	public void deleteClienti(int id) {
		em.remove(em.find(Clienti.class, id));
	}
	public Clienti selectById(int id) {
		return em.find(Clienti.class, id);
	}
	public List<Clienti> getClienti(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Clienti> cq = builder.createQuery(Clienti.class);
		Root<Clienti> root = cq.from(Clienti.class);
		cq.select(root);
		return em.createQuery(cq).getResultList();
}
}