import ohtu.*
import ohtu.authentication.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can post an article reference into the system'

scenario "user can post an article reference if all the fields are filled", {
    given 'form for posting articles to the system is opened', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/miniprojekti/alkunakyma");      
    }
    when 'all the information is entered', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Arto Kaikkonen");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Hemmetin hyvä artikkeli");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("Joku lehti");
        element = driver.findElement(By.name("volume"));
        element.sendKeys("1994");
        element = driver.findElement(By.name("number"));
        element.sendKeys("3");
        element = driver.findElement(By.name("year"));
        element.sendKeys("1995");
        element = driver.findElement(By.name("pages"));
        element.sendKeys("12-15");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("WSOY");
        element = driver.findElement(By.name("address"));
        element.sendKeys("Tiekat 1A1, Helsinki, Finland");

        element = driver.findElement(By.name("viite"));
        element.submit();
    }     
    then 'reference is saved to the database', {
        driver.getPageSource().contains("Viite lisätty!").shouldBe true
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
        element.sendKeys("1995");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("WSOY");

        element = driver.findElement(By.name("viite"));
        element.submit();
    }     
    then 'reference is saved to the database', {
        driver.getPageSource().contains("Viite lisätty!").shouldBe true
    }
}

