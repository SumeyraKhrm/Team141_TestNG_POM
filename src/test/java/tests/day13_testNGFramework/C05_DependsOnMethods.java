package tests.day13_testNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C05_DependsOnMethods {

    // 3 farkli test methodu olusturup, asagidaki gorevleri yapin
    // 1- testotomasyonu anasayfaya gidip url'in testotomasyonu icerdigini test edin
    // 2- phone icin arama yapip urun bulunabildigini test edin
    // 3- ilk urunu tiklayip, urun isminde case sensitive olmadan "phone" bulundugunu test edin

    /*
        dependsOnMethods = "anasayfaTesti"

        1- siralama icin degil, method'lari birbirine baglamak icin kullanilir
           eger anasayfa testi calisip PASSED olmazsa
           phoneAramaTestini calistirmanin hicbir anlami olmayacaksa
           dependsOnMethods = "anasayfaTesti" yazabiliriz

        2- her test method'u bagimsiz olarak calistirilabilir
           ancak dependsOnMethods ile calismasi baska class'in calismasina baglanan bir method
           bagimsiz olarak calistirilmak istendiginde
           ONCE bagli oldugu method'u calistirir,
           O method calisip PASSED olursa, kendisi de calisir

           ANCAAAKKK bu sadece 2 method icin gecerlidir
           eger 3 method bu ornekte oldugu gibi birbirine bagli ise
           3.method'u bagimsiz calistirmak istedigimizde tum method'lar calismaz
            No tests were found ==> calistirilacak Test bulunamadi der
        3- Her ne kadar siralama icin kullanilmasa da
           dependsOnmethod kullanmis olan bir method'a sira geldiginde
           once bagli oldugu method'un calismasini saglayacagi icin
           otomatik olarak bir siralama da yapmis olur
     */


    @Test
    public void anasayfaTesti(){
        // 1- testotomasyonu anasayfaya gidip
        Driver.getDriver().get("https://www.testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }

    @Test(dependsOnMethods = "anasayfaTesti")
    public void phoneAramaTesti(){
        // 2- phone icin arama yapip
        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // urun bulunabildigini test edin
        WebElement aramaSonucuElementi = Driver.getDriver().findElement(By.className("product-count-text"));

        String unExpectedSonuc = "0 Products Found";
        String actualSonuc = aramaSonucuElementi.getText();

        Assert.assertNotEquals(actualSonuc,unExpectedSonuc);

    }

    @Test(dependsOnMethods = "phoneAramaTesti")
    public void ilkUrunIsimTesti(){
        // 3- ilk urunu tiklayip,
        Driver.getDriver().findElement(By.xpath("(//*[@class='prod-img'])[1]"))
                .click();

        // urun isminde case sensitive olmadan "phone" bulundugunu test edin

        String expectedIsimIcerik = "phone";

        String actualUrunIsmi = Driver.getDriver().findElement(By.xpath("//div[@class=' heading-sm mb-4']"))
                                                    .getText()
                                                    .toLowerCase();

        Assert.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik));

        Driver.quitDriver();
    }
}
