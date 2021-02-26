package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Libri;

@Repository
public class LibriRepository {

	@PersistenceContext
	private EntityManager em;
	@Transactional
	public void insertLibri(Libri c) {
		em.persist(c);
	}
	@Transactional
	public void updateLibri(Libri c) {
		em.merge(c);
	}
	@Transactional
	public void deleteLibri(int id) {
		em.remove(em.find(Libri.class, id));
	}
	public Libri selectById(int id) {
		return em.find(Libri.class, id);
	}
	public List<Libri> getLibri(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Libri> cq = builder.createQuery(Libri.class);
		Root<Libri> root = cq.from(Libri.class);
		cq.select(root);
		return em.createQuery(cq).getResultList();
}
	
}
