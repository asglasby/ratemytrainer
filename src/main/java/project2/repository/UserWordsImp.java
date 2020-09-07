package project2.repository;

import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import project2.model.UserWords;

@Repository
@Transactional
@EnableTransactionManagement
public class UserWordsImp {
  
  @Autowired
  private SessionFactory sf;

  public UserWordsImp(SessionFactory sf) {
    this.sf = sf;
  }

  public UserWords getWordInfoById(Integer id) {
    
    Session session = sf.getCurrentSession();    
    UserWords user = (UserWords) session.get(UserWords.class, id);    
    return user;
  }
  
  public List<UserWords> getAllWordsByTrainer(String trainerUsername){
    Session session = sf.getCurrentSession();
    Query q = session.createQuery("from UserWords word where word.trainerUser.username = :trainerUsername");
    q.setString("trainerUsername", trainerUsername);
    
    //Criteria q = session.createCriteria(UserWords.class);
    
    
    List<UserWords> result = q.list();
    
    System.out.println(result);
    
    return result;
    
  }
  
  public List<UserWords> getAllWordsByAssociate(String associateUsername){
    Session session = sf.getCurrentSession();
    
    Query q = session.createQuery("from UserWords word where word.userUser.username = :associateUsername");
    q.setString("associateUsername", associateUsername);
    
    List<UserWords> result = q.list();
    
    System.out.println(result);
    
    return result;
    
  }
  
  public void save(UserWords newWord) {
    
    Session session = sf.getCurrentSession();
    
    session.save(newWord);
  }
  
  public List getWordsByTrainerWithCount(String trainerUsername){
    Session session = sf.getCurrentSession();
    
    System.out.println("USERDAO:" + trainerUsername);
    
    Query q = session.createQuery(
        "select userword.word, count(userword.word) "
        + "from UserWords userword "
        + "where userword.trainerUser.username = :trainerUsername "
        + "group by userword.word");
    q.setParameter("trainerUsername", trainerUsername);
    
    List result = q.list();
    
    for(int i = 0; i < result.size(); i++) {
      System.out.println(result.get(i).toString());
    }
    
    return result;
  }

}
