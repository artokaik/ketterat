package ohtu.mini.domain;

import ohtu.mini.repository.ReferenceRepository;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context-test.xml",
    "classpath:spring-database-test.xml"})
public class ReferenceTest {

    public ReferenceTest() {
    }
    
    Reference ref;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ref = new Reference();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testId() {
        long id = 1;
        ref.setId(id);
        long result = ref.getId();
        Assert.assertEquals(id, result);
    }

    @Test
    public void testTitle() {
        String title = "Otsikko";
        ref.setTitle(title);
        String result = ref.getTitle();
        Assert.assertEquals(title, result);
    }

    @Test
    public void testAbbreviation() {
        String abbreviation = "A2004";
        ref.setAbbreviation(abbreviation);
        String result = ref.getAbbreviation();
        Assert.assertEquals(abbreviation, result);
    }

    @Test
    public void testYear() {
        int year = 2013;
        ref.setYear(year);
        int result = ref.getYear();
        Assert.assertEquals(year, result);
    }

    @Test
    public void testPublisher() {
        String publisher = "Julkaisija";
        ref.setPublisher(publisher);
        String result = ref.getPublisher();
        Assert.assertEquals(publisher, result);
    }

    @Test
    public void testPages() {
        String pages = "100-200";
        ref.setPages(pages);
        String result = ref.getPages();
        Assert.assertEquals(pages, result);
    }

    @Test
    public void testAddress() {
        String address = "Osoite";
        ref.setAddress(address);
        String result = ref.getAddress();
        Assert.assertEquals(address, result);
    }

    @Test
    public void testJournal() {
        String journal = "Julkaisu";
        ref.setJournal(journal);
        String result = ref.getJournal();
        Assert.assertEquals(journal, result);
    }

    @Test
    public void testVolume() {
        int volume = 50;
        ref.setVolume(volume);
        int result = ref.getVolume();
        Assert.assertEquals(volume, result);
    }

    @Test
    public void testNumber() {
        int number = 1;
        ref.setNumber(number);
        int result = ref.getNumber();
        Assert.assertEquals(number, result);
    }

    @Test
    public void testAuthor() {
        String author = "Tekija";
        ref.setAuthor(author);
        String result = ref.getAuthor();
        Assert.assertEquals(author, result);
    }


    @Test
    public void testToBibtex() {
        Reference reference = new Reference();
        reference.setAbbreviation("w04");
        reference.setReftype("article");
        reference.setAuthor("Whittington, Keith J.");
        reference.setTitle("Infusing active learning into introductory programming courses");
        reference.setJournal("J. Comput. Small Coll.");
        reference.setVolume(19);
        reference.setNumber(5);
        reference.setYear(2004);
        reference.setPages("249--259");
        reference.setPublisher("Consortium for Computing Sciences in Colleges");
        reference.setAddress("USA");
        reference.setMonth("");
        reference.setOrganization("");
        reference.setEditor("");
        reference.setBookTitle("");

        String refModel = "@article{w04,\n"
                + "    author = {Whittington, Keith J.},\n"
                + "    title = {Infusing active learning into introductory programming courses},\n"
                + "    journal = {J. Comput. Small Coll.},\n"
                + "    volume = {19},\n"
                + "    number = {5},\n"
                + "    year = {2004},\n"
                + "    pages = {249--259},\n"
                + "    publisher = {Consortium for Computing Sciences in Colleges},\n"
                + "    address = {USA},\n"
                + "    month = {},\n"
                + "    booktitle = {},\n"
                + "    editor = {},\n"
                + "    organization = {},\n"
                + "}";

//        System.out.println(refModel +"\n-------------\n" + reference.toBibtex());
//        System.out.println("Tulostus !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        System.out.println(refModel);
//        System.out.println(reference.toBibtex());
        Assert.assertTrue("Failed to create refence bibtex", refModel.equals(reference.toBibtex()));
    }
    
    @Test 
    public void testToString(){
        Reference reference = new Reference();
        reference.setReftype("article");
        reference.setAuthor("Whittington, Keith J.");
        reference.setTitle("Infusing active learning into introductory programming courses");
        reference.setJournal("J. Comput. Small Coll.");
        reference.setVolume(19);
        reference.setNumber(5);
        reference.setYear(2004);
        reference.setPages("249--259");
        reference.setPublisher("Consortium for Computing Sciences in Colleges");
        reference.setAddress("USA");
        reference.setMonth("");
        reference.setOrganization("");
        reference.setEditor("");
        reference.setBookTitle("");
        String actual = reference.toString();
        String expected = "Whittington, Keith J. (2004). Infusing active learning into introductory programming courses. J. Comput. Small Coll. (Consortium for Computing Sciences in Colleges, USA) 19 (5): 249--259";
        Assert.assertTrue(expected.equals(actual));
    }
}
