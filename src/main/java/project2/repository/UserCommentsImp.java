package project2.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import project2.model.UserComments;

@Repository
@Transactional
@EnableTransactionManagement
public class UserCommentsImp {
  
	@Autowired
	private SessionFactory sf;

  	public UserCommentsImp(SessionFactory sf) {
    this.sf = sf;
  	}

  
  	public List<UserComments> getAllUserComments() {
		Session session = sf.getCurrentSession();
		Criteria c = session.createCriteria(UserComments.class);
		List<UserComments> userComments = c.list();
		return userComments;
	}
	
  	public List<UserComments> getAllCommentsOfTrainer(String username){
  	  Session session = sf.getCurrentSession();
  	  Query q = session.createQuery("from UserComments userComments where userComments.trainerUser.username = :trainerUsername");
  	  q.setParameter("trainerUsername", username);
  	  List<UserComments> userComments = q.list();
  	  //System.out.println(userComments);
  	  return userComments;
  	}
  	
  
	public UserComments getCommentInfoById(Integer id) {
		Session session = sf.getCurrentSession();
		UserComments userComments = (UserComments) session.get(UserComments.class, id);
		return userComments;
	}
	
	
	public void saveOrUpdate(UserComments userComments) {
		Session session = sf.getCurrentSession();
		session.saveOrUpdate(userComments);
	}
	
	
	public Integer save(UserComments userComments) {
		Session session = sf.getCurrentSession();
		System.out.println("Hello");
		Integer id = (Integer) session.save(userComments);
		System.out.println(id);
		return id;
	}
	
	
	public void update(UserComments userComments) {
		Session session = sf.getCurrentSession();
		session.update(userComments);
	}
	
	
//	public void delete(UserComments userComments) {
//		Session session = sf.getCurrentSession();
//		session.delete(userComments);
//	}
	public void deleteById(int  id) {
		System.out.println("deleteById() here" + id);
		Session session = sf.getCurrentSession();
		 Query q = session.createQuery("delete from UserComments userComments where userComments.id = :Id");
	  	  q.setParameter("Id", id);
	  	  q.executeUpdate();
	  	}
	
}
