package project2.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
  
  @RequestMapping(value = "/hello", method=RequestMethod.GET)
  public ResponseEntity<String> sayHello() {
      return new ResponseEntity<String>("Hello from Servlet!", HttpStatus.OK);
  }  
  
  @RequestMapping(value = "/responsebodystring", method=RequestMethod.GET)
  @ResponseBody
  public String writeStringAsResp() {
      return "Written as just a String";
  }
  
  @GetMapping("/listresp")
  @ResponseBody
  public List<String> writeListAsResp() {
      return Arrays.asList("HI", "FROM", "CONTROLLER");
  }
  
  @GetMapping("/redirectme")
  public String redirectExample() {
      return "redirect:/static/index.html";
  }

}
