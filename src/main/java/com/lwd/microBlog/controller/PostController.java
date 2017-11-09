package com.lwd.microBlog.controller;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lwd.microBlog.model.Post;
import com.lwd.microBlog.service.PostService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/")
	public String index(ModelMap map) {
		List<Post> posts = postService.list();
		Collections.reverse(posts);
		map.addAttribute("postList", posts);
		return "index";
	}
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	@ResponseBody
	public List<Post> getPosts() {
		return postService.list();
	}
	
	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Post getPost(@PathVariable("id") Long id) {
		return postService.findOneById(id);
	}
	
	@RequestMapping(value = "/posts", method = RequestMethod.POST)
	public String savePost(@Valid Post post) {
		postService.add(post);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
	public String deletePost(@PathVariable Long id) {
		postService.delete(id);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/posts", method = RequestMethod.PUT)
	public String updatePost(@Valid Post post) {
		postService.update(post);
		return "redirect:/";
	}

}
