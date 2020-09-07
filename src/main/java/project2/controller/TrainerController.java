package project2.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project2.model.Trainers;
import project2.repository.TrainersImp;

@RestController
@RequestMapping("/trainers")
public class TrainerController {
  
  @Autowired
  private TrainersImp trainDao;
  
  @CrossOrigin
  @GetMapping
  public List<Trainers> get() {
	  return trainDao.getAllTrainerInformation();
  }
  
  @CrossOrigin
  @GetMapping("/{username}")
  public Trainers get(@PathVariable String username) {
      return trainDao.getTrainerInfoByUsername(username);
  }
  


}
