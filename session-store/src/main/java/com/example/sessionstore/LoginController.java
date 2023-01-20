package com.example.sessionstore;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// cd build/libs
// java -Dserver.port=8080 -jar session-store-0.0.1-SNAPSHOT.jar
// java -Dserver.port=8081 -jar session-store-0.0.1-SNAPSHOT.jar
@RestController
public class LoginController {

  //Map<String, String> sessionMap = new HashMap<String, String>();

  @GetMapping("/login")
  public String login(HttpSession httpSession, @RequestParam String name) {
    httpSession.setAttribute("name", name);
    //sessionMap.put(httpSession.getId(), name);
    return "saved";
  }

  @GetMapping("/name")
  public String name(HttpSession httpSession) {
    String name = (String) httpSession.getAttribute("name");
    //String name = sessionMap.get(httpSession.getId());
    return name;
  }
}