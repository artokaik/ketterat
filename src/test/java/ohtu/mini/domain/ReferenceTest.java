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
        String author = "Tekijä";
        ref.setAuthor(author);
        String result = ref.getAuthor();
        Assert.assertEquals(author, result);
    }
}
