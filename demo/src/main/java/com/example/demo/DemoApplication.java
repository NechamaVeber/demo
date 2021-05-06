package com.example.demo;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;




@SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)

@RestController
public class DemoApplication {

public static void main(String[] args) {
	
SpringApplication.run(DemoApplication.class, args);


System.out.println("Application is app");

}
@GetMapping("/xx")
public String getTopicList() {

return "dfsaf";
}


}