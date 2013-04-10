//package ohtu.mini.domain;
//
//import java.io.Serializable;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToOne;
//
////@Entity
//public class AuthorReference implements Serializable {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.TABLE)
//	private long id;
//
//	@Column(name = "author")
//	@OneToOne
//	private Author author;
//
//	@Column(name = "reference")
//	@OneToOne
//	private Reference reference;
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public Author getAuthor() {
//		return author;
//	}
//
//	public void setAuthor(Author author) {
//		this.author = author;
//	}
//
//	public Reference getReference() {
//		return reference;
//	}
//
//	public void setReference(Reference reference) {
//		this.reference = reference;
//	}
//
//}
