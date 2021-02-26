package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Registrolibri;

@Repository
public class RegistroLibriRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void insertRegistrolibri(Registrolibri c) {
		em.persist(c);
	}
	@Transactional
	public void updateRegistrolibri(Registrolibri c) {
		em.merge(c);
	}
	@Transactional
	public void deleteRegistrolibri(int id) {
		em.remove(em.find(Registrolibri.class, id));
	}
	public Registrolibri selectById(int id) {
		return em.find(Registrolibri.class, id);
	}
	public List<Registrolibri> getRegistrolibri(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Registrolibri> cq = builder.createQuery(Registrolibri.class);
		Root<Registrolibri> root = cq.from(Registrolibri.class);
		cq.select(root);
		return em.createQuery(cq).getResultList();
}
}
