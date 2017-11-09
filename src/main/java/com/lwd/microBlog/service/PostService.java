package com.lwd.microBlog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwd.microBlog.model.Post;
import com.lwd.microBlog.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public List<Post> list() {
		return postRepository.findAll();
	}
	
	public Post findOneById(Long id) {
		return postRepository.findOneById(id);
	}
	
	public Post findOneByTitle(String title) {
		return postRepository.findOneByTitle(title);
	}
	
	public Post add(Post beer) {
		if (this.postRepository.findOneById(beer.getId()) == null) {
			this.postRepository.save(beer);
			return beer;
		}else {
			return null;
		}
	}
	
	public Boolean delete(Long id) {
	    	Post post = postRepository.findOneById(id);
	    	if ( post != null) {
	    		this.postRepository.delete(post);
	    		return true;
	    	} else {
	    		return false;
	    	}
	}
	
    public Post update(Post post) {
    		this.postRepository.updatePost(
	                    post.getId(), 
	                    post.getTitle(),
	                    post.getDescription(),
	                    post.getSource());
    		return post;
    }
}
