package ohtu.mini.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.text.Normalizer;
import java.util.HashMap;

@Entity
public class Reference implements Serializable {
    
    private HashMap<Integer,String> accents = new HashMap<Integer,String>();

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
//	@Column(name="title")
//	@OneToOne
//	private RefType refType;
    @Column(name = "abbreviation")
    private String abbreviation;
    @Column(name = "title")
    private String title;
    @Column(name = "publish_year")
    private int year;
//    @Column(name = "book_title")
//    private String bookTitle;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "pages")
    private String pages;
    @Column(name = "address")
    private String address;
    @Column(name = "journal")
    private String journal;
    @Column(name = "volume")
    private int volume;
    @Column(name = "number")
    private int number;
    @Column(name = "author")
    private String author;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

//	public RefType getRefType() {
//		return refType;
//	}
//
//	public void setRefType(RefType refType) {
//		this.refType = refType;
//	}
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

//    public String getBookTitle() {
//        return bookTitle;
//    }
//
//    public void setBookTitle(String bookTitle) {
//        this.bookTitle = bookTitle;
//    }
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String toBibtex() {
        createAccents();
        StringBuilder sb = new StringBuilder();
        sb.append("@article{");
        sb.append(this.getAbbreviation()).append(",\n");
        
        sb.append("    author").append(" = {").append(stringToBib(this.getAuthor())).append("},\n");
        sb.append("    title").append(" = {").append(stringToBib(this.getTitle())).append("},\n");
        sb.append("    journal").append(" = {").append(stringToBib(this.getJournal())).append("},\n");
        sb.append("    volume").append(" = {").append(this.getVolume()).append("},\n");
        sb.append("    number").append(" = {").append(this.getNumber()).append("},\n");
        sb.append("    year = {").append(this.getYear()).append("},\n");
        sb.append("    pages = {").append(this.getPages()).append("},\n");
        sb.append("    publisher = {").append(stringToBib(this.getPublisher())).append("},\n");
        sb.append("    address = {").append(stringToBib(this.getAddress())).append("},\n");

        sb.append("}");
        return sb.toString();
    }
    
    public String stringToBib(String s) {
    	String output = "";
    	for (char ch: s.toCharArray()) {
            output = output+normalize(Character.toString(ch));
    	}
           return output;	
    }
    
    private String normalize(String s) {
        if (s.equals("{") || s.equals("}")|| s.equals("$"))
            return "\\"+s;
    	if (Normalizer.isNormalized(s, Normalizer.Form.NFD)){
    		return s;
    	}
    	s = (Normalizer.normalize(s, Normalizer.Form.NFD));
    	if (s.charAt(1) == 778)
    		return "\\"+s.charAt(0)+s.charAt(0);
        if (accents.get(0+s.charAt(1)) == null)
                return Character.toString(s.charAt(0));
    	return "\\"+accents.get(0+s.charAt(1))+"{"+s.charAt(0)+"}";	
    }
    
    private void createAccents() {
    	accents.put(768,"`"); // `
    	accents.put(769,"´"); // ´
    	accents.put(770,"^"); // ^
    	accents.put(771,"~"); // ~
    	accents.put(776,"\""); // ¨
    	accents.put(780,"v"); // 
        accents.put(774,"u"); // 
        accents.put(772,"="); // 
        accents.put(807,"c"); // 
        accents.put(808,"c"); // 
    }

    @Override
    public String toString() {
        String string = getAuthor() + " (" + getYear() + "). " + getTitle() + ". " + getJournal() + " (" + getPublisher() + ", " + getAddress() + ") " + getVolume() + " (" + getNumber() + "): " + getPages();
        return string;
    }

}
