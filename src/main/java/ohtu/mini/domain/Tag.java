package ohtu.mini.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tag implements Serializable {

	@Id
	@Column (name="id")
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long Id;

	@Column(name="tag")
	private String tag;

    public Tag() {
    }

    public Tag(String tag) {
        this.tag = tag;
    }

	public long getId() {
		return Id;
	}

	public void setId(long Id) {
		this.Id = Id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
