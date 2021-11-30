package blog.spring.datajpa.model; 

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Tag extends AbstractTimestampEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long tag_id;
	
	@Column(name = "tag")
	private String tag;
	
	public long getTag_id() {
		return tag_id;
	}

	public void setTag_id(long tag_id) {
		this.tag_id = tag_id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
}
