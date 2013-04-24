import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can post any reference into the system'

scenario "user can post an inproceedings reference to the system", {
    given 'form for posting articles to the system is opened', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/miniprojekti/alkunakyma");      
    }
    when 'all the information is entered, add-button and bibtex-button clicked', {
        SelectElement select = new SelectElement(driver.findElement( By.name("reftype"));
        select.SelectByText("Inproceedings");
        select.Submit();

        element = driver.findElement(By.name("author"));
        element.sendKeys("Arto Koo");
        element = driver.findElement(By.name("title"));
        element.sendKeys("In");

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
        element.sendKeys("Tiekat 1A1, Helsinki, Finland");

        element = driver.findElement(By.name("viite"));
        element.submit();
        element = driver.findElement(By.linkText("BibTex-linkki"));
        element.click();
    }     
    then 'reference is saved as inproceedings to the database and can be found from the bibtex-list', {
        driver.getPageSource().contains("@inproceedings{a92,").shouldBe true
    }
}

scenario "user can post article even if some fields are empty", {
    given 'form for posting articles to the system is opened', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/miniprojekti/alkunakyma");      
    }
    when 'some information is entered but some fields are empty', {

        element = driver.findElement(By.name("author"));
        element.sendKeys("Arto Kaikkonen");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Hemmetin hyvä artikkeli");
        element = driver.findElement(By.name("year"));
        element.sendKeys("1990");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("WSOY");

        element = driver.findElement(By.name("viite"));
        element.submit();
    }     
    then 'reference is saved to the database', {
        driver.getPageSource().contains("Arto Kaikkonen (1990)").shouldBe true
    }
}

