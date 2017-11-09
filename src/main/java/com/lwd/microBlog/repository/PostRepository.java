package com.lwd.microBlog.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.lwd.microBlog.model.Post;

public interface PostRepository extends JpaRepository<Post, Serializable> {

	Post findOneById(Long id);
	Post findOneByTitle(String title);
	Post findOneByDescription(String description);
	Post findOneBySource(String source);
	
	@Modifying
	@Transactional
	@Query("update Post p set p.title = :title, p.description = :description, p.source = :source "
			+ "where p.id = :id")
	int updatePost(
			@Param("id") Long id,
			@Param("title") String title,
			@Param("description") String description,
			@Param("source") String source);
	
}
