package project2.model;

import java.util.Arrays;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trainers")
public class Trainers {
  
  @Id
  @Column(name="username")
  private String username;
  
  @Column(name="passcode")
  private String passcode;
  
  @Column(name="first_name")
  private String firstName;
  
  @Column(name="last_name")
  private String lastName;
  
  @Column(name="picture")
  private byte[] picture;
  
  @Column(name="location")
  private String location;
  
  @Column(name="curriculum")
  private String curriculum;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPasscode() {
    return passcode;
  }

  public void setPasscode(String passcode) {
    this.passcode = passcode;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public byte[] getPicture() {
    return picture;
  }

  public void setPicture(byte[] picture) {
    this.picture = picture;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getCurriculum() {
    return curriculum;
  }

  public void setCurriculum(String curriculum) {
    this.curriculum = curriculum;
  }

  @Override
  public String toString() {
    return "Trainers [username=" + username + ", passcode=" + passcode + ", firstName=" + firstName
        + ", lastName=" + lastName + ", picture=" + Arrays.toString(picture) + ", location="
        + location + ", curriculum=" + curriculum + "]";
  }

  

}
