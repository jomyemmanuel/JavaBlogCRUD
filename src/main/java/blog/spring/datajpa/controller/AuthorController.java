package blog.spring.datajpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import blog.spring.datajpa.model.Author;
import blog.spring.datajpa.repository.AuthorRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class AuthorController {

	@Autowired
	AuthorRepository authorRepository;

	@GetMapping("/authors")
	public ResponseEntity<List<Author>> getAllAuthors() {
		try {
			List<Author> authors = new ArrayList<Author>();
			
//			System.out.println("\n first \n");

			authorRepository.findAll().forEach(authors::add);
			
//			System.out.println("\n second \n");

			if (authors.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
//			System.out.println("\n third \n");
			
//			String listString = authors.stream().map(Object::toString)
//          .collect(Collectors.joining(", "));
//			System.out.println("\n" + listString + "\n");
			
			return new ResponseEntity<>(authors, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/authors/{id}")
	public ResponseEntity<Author> getAuthorById(@PathVariable("id") long id) {
		Optional<Author> authorData = authorRepository.findById(id);

		if (authorData.isPresent()) {
			return new ResponseEntity<>(authorData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/authors")
	public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
		try {
			Author _author = authorRepository.save(new Author(author.getUsername(), author.getName(), author.getEmail()));
			return new ResponseEntity<>(_author, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/authors/{id}")
	public ResponseEntity<Author> updateAuthor(@PathVariable("id") long id, @RequestBody Author author) {
		Optional<Author> authorData = authorRepository.findById(id);

		if (authorData.isPresent()) {
			Author _author = authorData.get();
			_author.setName(author.getName());
			_author.setEmail(author.getEmail());
			return new ResponseEntity<>(authorRepository.save(_author), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/authors/{id}")
	public ResponseEntity<HttpStatus> deleteAuthor(@PathVariable("id") long id) {
		try {
			authorRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/authors")
	public ResponseEntity<HttpStatus> deleteAllAuthors() {
		try {
			authorRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}