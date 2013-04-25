import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User can remove references from the system'

scenario "An article can be removed from the system", {
    given 'An article has been posted to the system', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/miniprojekti/alkunakyma");      

        element = driver.findElement(By.name("author"));
        element.sendKeys("Zorro");
        element = driver.findElement(By.name("title"));
        element.sendKeys("Miten minusta tuli zorro");
        element = driver.findElement(By.name("journal"));
        element.sendKeys("Seiska");
        element = driver.findElement(By.name("volume"));
        element.sendKeys("1994");
        element = driver.findElement(By.name("number"));
        element.sendKeys("3");
        element = driver.findElement(By.name("year"));
        element.sendKeys("1955");
        element = driver.findElement(By.name("pages"));
        element.sendKeys("12-15");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("Sanoma-Magazines");
        element = driver.findElement(By.name("address"));
        element.sendKeys("Suomi");

        element = driver.findElement(By.name("viite"));
        element.submit();


    }
    when 'the remove button is clicked', {
        element = driver.findElement(By.linkText("Poista z55"));
        element.click();

    }     
    then 'the removed reference cannot be found from the list of references', {
        driver.getPageSource().contains("Järjestelmässä olevat viitteet").shouldBe true
        driver.getPageSource().contains("Miten minusta tuli zorro").shouldBe false
    }
}
