package  com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.News;
import com.example.demo.service.NewsService;


@RestController
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)

public class NewsController {
	@Autowired
	private NewsService newsService;

	@GetMapping("/getTopicList")
	public List<News> getTopicList() {
		
	return newsService.getTopicList();
	}
	@GetMapping("/getNewContent")
	public News getNew(@RequestParam(value = "id") int id) {
		return newsService.getNewContent(id);
	}
}

  
