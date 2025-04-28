package tests.day16_htmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_DataProviderIleTopluAramaTesti {


    /*
        Data provider ile verilen bir listedeki her bir deger icin
        test method'unu bagimsiz olarak calistirabiliriz

        DataProvider ile test yapabilmek icin
        1- once test methodumuzu parametre ile calisacak sekilde
           tek bir urun icin yazalim

        2- Test method'una disardan bir dataProvider tanimlayalim

        3- yazdigimiz data provider isminin ustune yaklasip
           intelliJ'in data provider'i olusturmasini isteyelim

        4- data provider, @DataProvider notasyonuna sahip ozel bir method'dur
           MUTLAKA iki katli bir Object Array DONDURMELIDIR
     */

    @DataProvider
    public static Object[][] UrunProvideri() {
        //Data provider must return Object[][]

        String[][] urunlerArrayi = {{"phone"}, {"java"}, {"dress"}, {"baby"}, {"nutella"},
                                    {"samsung"}, {"iphone"}, {"shirt"} };

        return urunlerArrayi;
    }


    @Test(dataProvider = "UrunProvideri")
    public void aramaTesti( String aranacakUrun){

        // testotomasyonu sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        // arama kutusuna aranacakUrun'u yazdirip enter'a basin

        testotomasyonuPage.aramaKutusu.sendKeys(aranacakUrun + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin

        String unexpectedAramaSonucu = ConfigReader.getProperty("toUnexpectedSonuc");
        String actualAramaSonucYazisi = testotomasyonuPage.aramaSonucuElementi.getText();

        Assert.assertNotEquals(actualAramaSonucYazisi,unexpectedAramaSonucu,aranacakUrun+" bulunamadi" );

        Driver.quitDriver();
    }
}
