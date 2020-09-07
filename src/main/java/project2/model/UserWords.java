package project2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_words")
public class UserWords {
  
  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @ManyToOne
  @JoinColumn(name="trainer_username")
  private Trainers trainerUser;
  
  @ManyToOne
  @JoinColumn(name="user_username")
  private Associates userUser;
  
  @Column(name="word")
  private String word;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public Trainers getTrainerUser() {
    return trainerUser;
  }

  public void setTrainerUser(Trainers trainerUser) {
    this.trainerUser = trainerUser;
  }

  public Associates getUserUser() {
    return userUser;
  }

  public void setUserUser(Associates userUser) {
    this.userUser = userUser;
  }

  @Override
  public String toString() {
    return "UserWords [id=" + id + ", trainerUser=" + trainerUser + ", userUser=" + userUser
        + ", word=" + word + "]";
  }

}
