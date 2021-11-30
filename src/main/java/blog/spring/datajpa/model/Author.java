package blog.spring.datajpa.model;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "author")
public class Author extends AbstractTimestampEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long author_id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@ElementCollection
	private List<Post> post;
	
	public long getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(long author_id) {
		this.author_id = author_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Author(String username, String name, String email) {
		super();
		this.username = username;
		this.name = name;
		this.email = email;
	}
	
	public Author(){
	   super();
	}
	
}
