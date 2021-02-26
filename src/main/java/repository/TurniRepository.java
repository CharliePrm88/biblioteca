package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import entity.Turni;

@Repository
public class TurniRepository {

		@PersistenceContext
		private EntityManager em;
		
		@Transactional
		public void insertTurni(Turni c) {
			em.persist(c);
		}
		@Transactional
		public void updateTurni(Turni c) {
			em.merge(c);
		}
		@Transactional
		public void deleteTurni(int id) {
			em.remove(em.find(Turni.class, id));
		}
		public Turni selectById(int id) {
			return em.find(Turni.class, id);
		}
		public List<Turni> getTurni(){
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Turni> cq = builder.createQuery(Turni.class);
			Root<Turni> root = cq.from(Turni.class);
			cq.select(root);
			return em.createQuery(cq).getResultList();
	}
}
