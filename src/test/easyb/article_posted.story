import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can see a list of references posted to the system'

scenario "If user posts a reference, that one can be found from the list", {
    given 'form for posting articles to the system is opened', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/miniprojekti/alkunakyma");      
    }
    when 'reference is saved', {
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
    then 'the reference can be found from the list of references', {
        driver.getPageSource().contains("Kirjoittaja/Author: Arto Koo").shouldBe true
    }
}

scenario "If user posts two references, the first one can be found from the list", {
    given 'form for posting articles to the system is opened', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/miniprojekti/alkunakyma");      
    }
    when 'two references are saved', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Täti Testaaja");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Sairaan hyvä artikkeli");
        element = driver.findElement(By.name("viite"));
        element.submit();

        element = driver.findElement(By.name("author"));
        element.sendKeys("Arto Kaikkonen");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Hiton hyvä artikkeli");
        element = driver.findElement(By.name("viite"));
        element.submit();
    }     
    then 'the first reference can be found from the list of references', {
        driver.getPageSource().contains("Kirjoittaja/Author: Täti Testaaja").shouldBe true
    }
}

scenario "If user posts two references, the second one can be found from the list", {
    given 'form for posting articles to the system is opened', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/miniprojekti/alkunakyma");      
    }
    when 'two references are saved', {
        element = driver.findElement(By.name("author"));
        element.sendKeys("Kalle kirjoittaja");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Pirun hyvä artikkeli");
        element = driver.findElement(By.name("viite"));
        element.submit();

        element = driver.findElement(By.name("author"));
        element.sendKeys("Joku Jaarittelija");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Aika hyvä artikkeli");
        element = driver.findElement(By.name("viite"));
        element.submit();
    }     
    then 'the first reference can be found from the list of references', {
        driver.getPageSource().contains("Kirjoittaja/Author: Joku Jaarittelija").shouldBe true
    }
}

