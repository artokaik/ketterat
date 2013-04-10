package ohtu.mini.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Reference implements Serializable {

	@Column(name="id")
	@Id
	private long id;

	@Column(name="title")
	@OneToOne
	private RefType refType;

	@Column(name = "title")
	private String title;
	@Column(name="publish_year")
	private int year;
	@Column(name="book_title")
	private String bookTitle;
	@Column(name = "publisher")
	private String publisher;
	@Column(name="pages")
	private String pages;
	@Column(name="address")
	private String address;
	@Column(name="journal")
	private String journal;
	@Column(name="volume")
	private int volume;
	@Column(name="number")
	private int number;

    public Reference() {
    }

    public Reference(RefType refType, String title, int year, String bookTitle, String publisher, String pages, String address, String journal, int volume, int number) {
        this.refType = refType;
        this.title = title;
        this.year = year;
        this.bookTitle = bookTitle;
        this.publisher = publisher;
        this.pages = pages;
        this.address = address;
        this.journal = journal;
        this.volume = volume;
        this.number = number;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public RefType getRefType() {
		return refType;
	}

	public void setRefType(RefType refType) {
		this.refType = refType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
