import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;


description 'User can post any reference into the system'

scenario "user can post an inproceedings reference to the system", {
    given 'form for posting articles to the system is opened', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/miniprojekti/alkunakyma");      
    }
    when 'all the information is entered with reftype inproceedings chosen, add-button and bibtex-button clicked', {
        webElement = driver.findElement(By.name("reftype"));
        Select select = new Select(webElement);
        select.selectByValue("inproceedings");

        element = driver.findElement(By.name("author"));
        element.sendKeys("Arto Koo");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Inp. title");

        element = driver.findElement(By.name("volume"));
        element.sendKeys("1994");
        element = driver.findElement(By.name("number"));
        element.sendKeys("3");
        element = driver.findElement(By.name("year"));
        element.sendKeys("1992");
        element = driver.findElement(By.name("pages"));
        element.sendKeys("12-15");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("WSOY");
        element = driver.findElement(By.name("address"));
        element.sendKeys("Ruotsi");

        element = driver.findElement(By.name("viite"));
        element.submit();
        element = driver.findElement(By.linkText("BibTex-linkki"));
        element.click();
    }     
    then 'reference is saved as inproceedings to the database and can be found from the bibtex-list', {
        driver.getPageSource().contains("@inproceedings").shouldBe true
        driver.getPageSource().contains("a92").shouldBe true
    }
}

scenario "user can post a book reference to the system", {
    given 'form for posting articles to the system is opened', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/miniprojekti/alkunakyma");      
    }
    when 'all the information is entered with reftype book chosen,, add-button and bibtex-button clicked', {
        webElement = driver.findElement(By.name("reftype"));
        Select select = new Select(webElement);
        select.selectByValue("book");

        element = driver.findElement(By.name("author"));
        element.sendKeys("Qirjoittaja, Kalle");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Kirjan nimi");

        element = driver.findElement(By.name("volume"));
        element.sendKeys("1994");
        element = driver.findElement(By.name("number"));
        element.sendKeys("3");
        element = driver.findElement(By.name("year"));
        element.sendKeys("1944");
        element = driver.findElement(By.name("pages"));
        element.sendKeys("12-15");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("WSOY");
        element = driver.findElement(By.name("address"));
        element.sendKeys("Suomi");

        element = driver.findElement(By.name("viite"));
        element.submit();
        element = driver.findElement(By.linkText("BibTex-linkki"));
        element.click();
    }     
    then 'reference is saved as inproceedings to the database and can be found from the bibtex-list', {
        driver.getPageSource().contains("@book{q44,").shouldBe true
    }
}
