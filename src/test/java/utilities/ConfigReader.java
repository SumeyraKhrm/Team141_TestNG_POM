package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    /*
        Bu class'in 2 temel gorevi var
        1- configuration.properties dosyasindaki bilgileri okumak
           ConfigReader calistirildiginda ONCELIKLE bu okuma isleminin yapilmasi icin
           okuma islemini bir static blok icerisinde yapiyoruz

           static blok calistiginda
           configuration.properties dosyasindaki tum key - value ikililerini okuyup
           class level'da bulunan "properties" objesine yukluyor

        2- ilk gorevde configuration.properties dosyasindaki
           tum key - value ikilileri okunup properties objesine yuklendi

           getProperty(istenenKey) method'u ise
           properties objesine yuklenen key-value'lerden
           bizim verecegimiz key'in karsiligindaki value'yu alip
           test method'una dondurur
     */

    static Properties properties; // configuration.properties'deki tum key-value'ler yuklendi

    static {// static blok herseyden once calisir yani method dan once

        String dosyaYolu= "configuration.properties";
        try {

            FileInputStream fis= new FileInputStream(dosyaYolu); // gidip belirttigimiz dosya yolunundaki belirttigimiz bilgileri alip getirir
            properties= new Properties();
            properties.load(fis);  //fis deki bilgileri properties objesine eklenir


        } catch (IOException e) {
            System.out.println("properties dosyasi okunamadi");
        }
    }

    //method calismaya basladiginda configuration.properties'deki tum key-value'lere sahip
    public static String getProperty(String key){

        return properties.getProperty(key);

    }


}
