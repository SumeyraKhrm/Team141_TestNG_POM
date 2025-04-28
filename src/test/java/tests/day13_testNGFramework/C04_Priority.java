package tests.day13_testNGFramework;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_Priority {

    // uc farkli test method'u olusturun
    // testotomasyonu, wisequarter ve bestbuy sitelerine gidip
    // url'in bu kelimeleri icerdigini test edin
    // ve windowlari kapatin

    /*
        TestNG biz birsey soylemedi isek
        test method'larini alfabetik siraya uygun olarak calistirir

        1- biz test method'larina priority tanimlarsak
           priority degerlerini kucukten buyuge dogru calistirir

        2- bazi method'lar priority atayip, bazilarina atama yapmazsak
           atama yapilmayan method'larin priority degeri
           default deger olan 0 olur ve buna uygun sirada calisir

        3- ayni priority degerine sahip birden fazla method olursa
           esit priority degeri olanlar, kendi iclerinde alfabetik siraya uyarlar
     */

    @Test(priority = 15,groups = {"smoke","E2E"})
    public void testotomasyonuTest(){
        Driver.getDriver().get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(1);
        Driver.quitDriver();
    }

    @Test @Ignore // priority == 0
    public void wisequarterTest(){
        Driver.getDriver().get("https://www.wisequarter.com");

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(1);
        Driver.quitDriver();
    }

    @Test (groups = "smoke")// priority == 0
    public void bestbuyTest(){
        Driver.getDriver().get("https://www.bestbuy.com");

        String expectedUrlIcerik = "bestbuy";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(1);
        Driver.quitDriver();
    }
}
