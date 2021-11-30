package blog.spring.datajpa.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "post")
public class Post extends AbstractTimestampEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long post_id;

	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;
	
	@ElementCollection
	private List<String> tags;

	@Column(name = "published")
	private boolean published;

	@ManyToOne(optional = false)
	@JoinColumn(name = "author_id", referencedColumnName = "author_id")
	private Author author;

	public long getPost_id() {
		return post_id;
	}

	public void setPost_id(long post_id) {
		this.post_id = post_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getTags() {
		return tags;
	}
	
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public Post(String title, String content, List<String> tags, boolean published, Author author) {
		super();
		this.title = title;
		this.content = content;
		this.tags = tags;
		this.published = published;
		this.author = author;
	}
	
	public Post(){
	   super();
	}

}
