package project2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import project2.model.UserWords;
import project2.repository.UserWordsImp;

@RestController
@CrossOrigin
@RequestMapping("/words")
public class UserWordController {
  
  @Autowired
  private UserWordsImp wordDao;
  
  
  @GetMapping("/{id}")
  public UserWords get(@PathVariable Integer id) {
      return wordDao.getWordInfoById(id);
  }
  
  
  @GetMapping("/trainer/{username}")
  public List<UserWords> getAllWordsByTrainer(@PathVariable String username){
    System.out.println(username);
    return wordDao.getAllWordsByTrainer(username);
  }
  
  
  @GetMapping("/associate/{username}")
  public List<UserWords> getAllWordsByAssociate(@PathVariable String username){
    System.out.println(username);
    return wordDao.getAllWordsByAssociate(username);
  }
  
  
  @PostMapping("/addWord")
  @ResponseStatus(code = HttpStatus.CREATED)
  public void saveNewWord(@RequestBody UserWords newWord) {
    wordDao.save(newWord);
  }
  
  
  @GetMapping("/trainer/wCount/{username}")
  public List getTrainerWordsWithCount(@PathVariable String username) {
    return wordDao.getWordsByTrainerWithCount(username);
  }

}
