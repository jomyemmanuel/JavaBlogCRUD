package blog.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import blog.spring.datajpa.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	List<Post> findByPublished(boolean published);
	List<Post> findByTitleContaining(String title);
}
