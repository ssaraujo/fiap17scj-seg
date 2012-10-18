package br.com.fiap.segurancafiap.dao;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import br.com.fiap.segurancafiap.entity.Funcionario;
@Stateless
public class FuncionarioDAO {

	@PersistenceContext
	   private EntityManager em;
	

	public Funcionario salva(Funcionario funcionario){
		em.persist(funcionario);
		em.flush();
		return funcionario;
	}
	
	
	/*
	  @PostConstruct
   public void retrieveAllMembersOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Member> criteria = cb.createQuery(Member.class);
      Root<Member> member = criteria.from(Member.class);
      // Swap criteria statements if you would like to try out type-safe criteria queries, a new
      // feature in JPA 2.0
      // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
      criteria.select(member).orderBy(cb.asc(member.get("name")));
      members = em.createQuery(criteria).getResultList();
   }
	 */
}
