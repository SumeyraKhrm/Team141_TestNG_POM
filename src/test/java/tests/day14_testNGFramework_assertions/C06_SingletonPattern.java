package tests.day14_testNGFramework_assertions;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C06_SingletonPattern {

    @Test
    public void test01(){

        /*
            Page Object Model'i dizayn edenler
            Driver class'indan getDriver() yerine farkli kullanimlarin onune gecmek icin

            Bir class'dan obje olusturulabilmesini ENGELLEMEK icin
            kullanilabilecek farkli yontemler var
            POM'i hazirlayanlar bu alternatifler icerisinde
            Singleton pattern'i tercih etmisler

            Singleton pattern : bir classdan obje olusturmayi engeller

            Xukardaki yontemle driver variable'ini kullanmak istedigimizde
            baslangicta driver'a bir deger atanmadigi icin null olarak isaretlendiginden
            null olarak isaretlenen bir objeyi method ile kullanmak istersek
            NullPointerException verin

            Pekii getDriver() 'unu abie elusturarak kullanabilir miyiz ?
            Driver driver = new Driver();
            driver. getDriver(.get(ConfigReader.getProperty("toUrl"));


            bu kullanim mumkundur ama TestNG'yi dizayn edenler
            WebDriver abjesini static yontemle
            Driver. getDriverO seklinde kullanilmasini ZORUNLU HALE getirmek icin
            Driver class'ini singleton pattern kullanarak sinirlamislardir.
            Singleton Pattern,
            bir class'dan obie olusturulmasini engelleyen yontemlerden birisidir ve soyle calisir
            Bir class'dan obje elusturmak icin, o class'in constructon'i calistinilmalidir
            Eger o class'in constructoriina kimse ulasamazsa o zaman o class'dan kimse obje olusturamaz


         */

        // testotomasyon anasayfaya gidin
        // Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //Driver driver = new Driver();
        //driver.driver.get(ConfigReader.getProperty("toUrl"));

        //Driver.driver.get(ConfigReader.getProperty("toUrl"));


        ReusableMethods.bekle(3);
        //Driver.quitDriver();
    }
}
