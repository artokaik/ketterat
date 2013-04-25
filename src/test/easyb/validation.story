import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can post an article reference into the system'

scenario "user can't post an article reference without title", {
    given 'form for posting references to the system is opened', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/miniprojekti/alkunakyma");      
    }
    when 'all the information except the title is entered', {

        element = driver.findElement(By.name("author"));
        element.sendKeys("Huolimaton, Hannu");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("Joku lehti");
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
    }     
    then 'reference is not saved to the database', {
        driver.getPageSource().contains("Syöte oli virheellinen!").shouldBe true
        driver.getPageSource().contains("Huolimaton, Hannu").shouldBe false
    }
}

scenario "user can't post a reference if there are letters in year field", {
    given 'form for posting references to the system is opened', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/miniprojekti/alkunakyma");      
    }
    when 'all the information is entered but there are letters in year field', {

        element = driver.findElement(By.name("author"));
        element.sendKeys("Huono, Kirjoittaja");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("Joku lehti");
        element = driver.findElement(By.name("number"));
        element.sendKeys("3");
        element = driver.findElement(By.name("year"));
        element.sendKeys("1992w");
        element = driver.findElement(By.name("pages"));
        element.sendKeys("12-15");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("WSOY");
        element = driver.findElement(By.name("address"));
        element.sendKeys("Tiekat 1A1, Helsinki, Finland");

        element = driver.findElement(By.name("viite"));
        element.submit();
    }     
    then 'reference is not saved to the database', {
        driver.getPageSource().contains("Syöte oli virheellinen!").shouldBe true
        driver.getPageSource().contains("Huono, Kirjoittaja").shouldBe false
    }
}

