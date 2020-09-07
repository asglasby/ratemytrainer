package project2.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_comments")
public class UserComments {
  
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
  
  @Column(name="comment_text")
  private String commentText;
  
  @Column(name="date_posted")
  //private String datePosted;
  private Date datePosted;
  
  @Column(name="approval")
  private String approval;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCommentText() {
    return commentText;
  }

  public void setCommentText(String commentText) {
    this.commentText = commentText;
  }

  public Date getDatePosted() {
    return datePosted;
  }

  public void setDatePosted(Date datePosted) {
    this.datePosted = datePosted;
  }

  public String getApproval() {
    return approval;
  }

  public void setApproval(String approval) {
    this.approval = approval;
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
    return "UserComments [id=" + id + ", trainerUser=" + trainerUser + ", userUser=" + userUser
        + ", commentText=" + commentText + ", datePosted=" + datePosted + ", approval=" + approval
        + "]";
  }
  
}
