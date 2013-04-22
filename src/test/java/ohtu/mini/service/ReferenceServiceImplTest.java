/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.mini.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import junit.framework.Assert;
import ohtu.mini.domain.Reference;
import ohtu.mini.repository.ReferenceRepository;
import org.junit.After;
import org.junit.AfterClass;
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
public class ReferenceServiceImplTest {

    @Autowired
    ReferenceServiceInterface rsi;

    public ReferenceServiceImplTest() {
    }

    @Test
    public void generateAbbreviationWorksIfThreeReferenceHasTheSameAbbreviation() {
        Reference reference = new Reference();
        reference.setAuthor("Whittington, James");
        reference.setTitle("Pretty good article");
        reference.setJournal("J. Comput. Small Coll.");
        reference.setVolume(19);
        reference.setNumber(6);
        reference.setYear(2004);
        reference.setPages("259--269");
        reference.setPublisher("Consortium for Computing Sciences in Colleges");
        reference.setAddress("USA");
        rsi.add(reference);
        Assert.assertEquals("Whi04", reference.getAbbreviation());

        reference = new Reference();
        reference.setAuthor("Whittington, James");
        reference.setTitle("Another pretty good article");
        reference.setJournal("J. Comput. Small Coll.");
        reference.setVolume(19);
        reference.setNumber(6);
        reference.setYear(2004);
        reference.setPages("259--269");
        reference.setPublisher("Consortium for Computing Sciences in Colleges");
        reference.setAddress("USA");
        rsi.add(reference);
        Assert.assertEquals("Whi04a", reference.getAbbreviation());

        reference = new Reference();
        reference.setAuthor("Whittington, James");
        reference.setTitle("Third pretty good article");
        reference.setJournal("J. Comput. Small Coll.");
        reference.setVolume(19);
        reference.setNumber(6);
        reference.setYear(2004);
        reference.setPages("259--269");
        reference.setPublisher("Consortium for Computing Sciences in Colleges");
        reference.setAddress("USA");
        rsi.add(reference);
        Assert.assertEquals("Whi04b", reference.getAbbreviation());
    }

    @Test
    public void testGenerateBibtex_String_List() throws Exception {
        String filename = "BibtexTest.txt";
        rsi.generateBibtex(filename, addSomeReferences());
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine() + "\n");
        }
        Assert.assertEquals(this.addedReferencesToString(), sb.toString());

    }

    private List<Reference> addSomeReferences() {
        List<Reference> references = new ArrayList<Reference>();
        Reference reference = new Reference();
        reference.setId(1);
        reference.setAbbreviation("Whi04");
        reference.setAuthor("Whittington, Keith J.");
        reference.setTitle("Infusing active learning into introductory programming courses");
        reference.setJournal("J. Comput. Small Coll.");
        reference.setVolume(19);
        reference.setNumber(5);
        reference.setYear(2004);
        reference.setPages("249--259");
        reference.setPublisher("Consortium for Computing Sciences in Colleges");
        reference.setAddress("USA");
        references.add(reference);

        reference = new Reference();
        reference.setId(2);
        reference.setAbbreviation("Kai13");
        reference.setAuthor("Kaikkonen, Arto");
        reference.setTitle("otsikko");
        reference.setJournal("lehti");
        reference.setVolume(0);
        reference.setNumber(0);
        reference.setYear(0);
        reference.setPages("sivut");
        reference.setPublisher("julkaisija");
        reference.setAddress("osoite");
        references.add(reference);
        return references;
    }

    private String addedReferencesToString() {
        String bibtex = "@article{Whi04,\n"
                + "    author = {Whittington, Keith J.},\n"
                + "    title = {Infusing active learning into introductory programming courses},\n"
                + "    journal = {J. Comput. Small Coll.},\n"
                + "    volume = {19},\n"
                + "    number = {5},\n"
                + "    year = {2004},\n"
                + "    pages = {249--259},\n"
                + "    publisher = {Consortium for Computing Sciences in Colleges},\n"
                + "    address = {USA},\n"
                + "}"
                + "\n"
                + "@article{Kai13,\n"
                + "    author = {Kaikkonen, Arto},\n"
                + "    title = {otsikko},\n"
                + "    journal = {lehti},\n"
                + "    volume = {0},\n"
                + "    number = {0},\n"
                + "    year = {0},\n"
                + "    pages = {sivut},\n"
                + "    publisher = {julkaisija},\n"
                + "    address = {osoite},\n"
                + "}"
                + "\n";
        return bibtex;

    }
}
