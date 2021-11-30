package blog.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import blog.spring.datajpa.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
	
}
