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

             Singleton pattern
             obje olusturmayi engellemek icin

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
