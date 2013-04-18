import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can print references to bibtex-format'

scenario "user can create a bibtex if there is at least one reference in the system", {
    given 'a reference is entered to the system', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/miniprojekti/alkunakyma");
        element = driver.findElement(By.name("abbreviation"));
        element.sendKeys("ako89"); 
        element = driver.findElement(By.name("author"));
        element.sendKeys("Arto Koo");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Hemmetin hyvä artikkeli");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("Joku lehti");
        element = driver.findElement(By.name("volume"));
        element.sendKeys("1994");
        element = driver.findElement(By.name("number"));
        element.sendKeys("3");
        element = driver.findElement(By.name("year"));
        element.sendKeys("1989");
        element = driver.findElement(By.name("pages"));
        element.sendKeys("12-15");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("WSOY");
        element = driver.findElement(By.name("address"));
        element.sendKeys("Tiekat 1A1, Helsinki, Finland");

        element = driver.findElement(By.name("viite"));
        element.submit();     
    }
    when 'user clicks Bibtex button', {
       
        element = driver.findElement(By.linkText("BibTex-linkki"));
        element.click();
    }     
    then 'the reference is printed to the screen in bibtex-format', {
        driver.getPageSource().contains("@article{ako89,").shouldBe true
        driver.getPageSource().contains("author = {Arto Koo},").shouldBe true
        driver.getPageSource().contains("publisher = {WSOY},").shouldBe true
    }
}
