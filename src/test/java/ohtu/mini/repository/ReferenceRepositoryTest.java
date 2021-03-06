package ohtu.mini.repository;

import ohtu.mini.domain.Reference;
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
public class ReferenceRepositoryTest {

    @Autowired
    ReferenceRepository repo;
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
        ref.setYear(1999);
        ref.setAuthor("Tekija");
        ref.setVolume(1);
        ref.setNumber(1);
        ref.setTitle("Nimeke");
        repo.deleteAll();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testRepositoryExists() {
        long actual = repo.count();
        long expected = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddingAReference() {
        long id = 1;
        ref.setId(id);
        repo.save(ref);
        Assert.assertTrue(repo.exists(id));
    }

    @Test
    public void testAddingMultipleReferences() {
        for (long i = 1; i <= 5; i++) {
            ref.setId(i);
            repo.save(ref);
        }
        long actual = repo.count();
        long expected = 5;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindById() {
        long id = 2;
        ref.setId(id);
        ref.setAddress("Testimainen testi");
        repo.save(ref);
        Assert.assertTrue(repo.findById(id).getAddress().equals("Testimainen testi"));
    }

    @Test
    public void testFindByTitle() {
        ref.setTitle("Otsikkoinen otsikko");
        repo.save(ref);
        Assert.assertTrue(!repo.findByTitle("Otsikkoinen otsikko").isEmpty());
    }

    @Test
    public void testEntityDeletedByIdCannotBeFound() {
        long id = 1;
        ref.setId(id);
        repo.save(ref);
        repo.delete(id);
        Assert.assertTrue(!repo.exists(id));
    }

    @Test
    public void testDirectlyDeletedEntityCannotBeFound() {
        long id = 1;
        ref.setId(id);
        repo.save(ref);
        repo.delete(ref);
        Assert.assertTrue(!repo.exists(id));
    }
    
}
