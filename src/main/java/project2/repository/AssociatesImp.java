package project2.repository;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import project2.model.Associates;

@Repository
@Transactional
@EnableTransactionManagement
public class AssociatesImp {

  @Autowired
  private SessionFactory sf;

  public AssociatesImp(SessionFactory sf) {
    this.sf = sf;
  }

  public Associates getUserInfoByUsername(String username) {
    
    Session session = sf.getCurrentSession();    
    
    Associates user = (Associates) session.get(Associates.class, username);    
    
    return user;    
  }
  
  public List<Associates> getAllUsers(){
    Session session = sf.getCurrentSession();
    
    Query q = session.createQuery("from Associates");
    List<Associates> users = q.list();
    
    return users;
  }
  
  public Associates getById(Integer id) {
    Session session = sf.getCurrentSession();
    
    Associates user = (Associates) session.get(Associates.class, id);
    
    return user;    
  }
  
  public void saveOrUpdate(Associates user) {
    Session session = sf.getCurrentSession();
    
    session.saveOrUpdate(user);
  }

}


