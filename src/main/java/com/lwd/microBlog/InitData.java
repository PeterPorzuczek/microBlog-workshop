package com.lwd.microBlog;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lwd.microBlog.model.Post;
import com.lwd.microBlog.service.PostService;

@Component
public class InitData {
	
	@Autowired
	private PostService postService;
	
	@PostConstruct
	public void init() {
		
		List<Post> posts = new ArrayList<Post>();
		Post post;
		
		post = new Post(1L, "Mobile UX", "Opis projektowania aplikacji mobilnych w oparciu o UX", "Strona 54 Aplikacje Informatyczne w Biznesie S. Wrycza");
		posts.add(post);
		post = new Post(2L, "Nowości w IT", "Blog poświęcony nowoczesnym technologiom IT", "dailyweb.pl");
		posts.add(post);
		post = new Post(3L, "TDD", "Python TDD", "Test-Driven Developmentw praktyce. Niezawodny kod w języku Python. Chimera");
		posts.add(post);
		post = new Post(4L, "Książki IT", "Strona z książkami", "helion.pl");
		posts.add(post);
		
		for(Post p : posts) {
			postService.add(p);
		}
	}
	
}
