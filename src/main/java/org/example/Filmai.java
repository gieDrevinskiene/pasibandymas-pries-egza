package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Filmai {
    private static WebDriver browser;
    public static final String URL = "http://kitm.infinityfreeapp.com/filmai.php";


    public static void main(String[] args) {
        setUp(URL);
        String message = fillInTheFields("Vesper", "Fantasy", "Raffiella Chapman, Eddie Marsan, Rosy McEwen", "Kristina Buožytė ir Bruno Samper", 112);
        System.out.println("Funkcija grąžina sėkmingą arba nesėkmingą filmo įrašo sukūrimą: " + message);
//        String message1 = deleteFilm(101);
//        System.out.println("Fukcija sėkmingai ištrynė norimą filmą: " + message1);
//        String message2 = editFields(107, "Avatar: The Way of Water", "Action, adventure, fantasy", "Sam Worthington, Zoe Saldana", "James Cameron", 192);
//        System.out.println("Funkcija, kuri grąžina sėkmingą arba nesėkmingą filmo įrašo redagavimą: " + message2);


    }

    public static void setUp(String url) {
        System.setProperty("webdriver.chrome.driver", "libs/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--start-maximized");
        browser = new ChromeDriver(options);
        browser.get(url);
    }

    public static String getMessage() {
        try {
            WebElement messageGood = browser.findElement(By.className("msg-good"));
            return messageGood.getText();

        } catch (NoSuchElementException e) {

        }

        WebElement messageBad = browser.findElement(By.className("msg-bad"));

        return messageBad.getText();
    }

    public static String fillInTheFields(String title, String genre, String actors, String director, int time) {
        WebElement fieldTitle = browser.findElement(By.name("pavadinimas"));
        fieldTitle.sendKeys(title);
        WebElement fieldGenre = browser.findElement(By.name("zanras"));
        fieldGenre.sendKeys(genre);
        WebElement fieldActors = browser.findElement(By.name("aktoriai"));
        fieldActors.sendKeys(actors);
        WebElement fieldDirector = browser.findElement(By.name("rezisierius"));
        fieldDirector.sendKeys(director);
        WebElement fieldTime = browser.findElement(By.name("trukme"));
        fieldTime.sendKeys(Integer.toString(time));
        WebElement send = browser.findElement(By.name("insert"));
        send.click();

        return getMessage();
    }

    public static String deleteFilm(int id) {
        WebElement delete = browser.findElement(By.name("id"));
        delete.sendKeys(Integer.toString(id));
        WebElement clickDelete = browser.findElement(By.name("delete"));
        clickDelete.click();

        return getMessage();
    }

    public static String editFields(int id, String title, String genre, String actors, String director, int time) {
        WebElement fieldId = browser.findElement(By.name("id"));
        fieldId.sendKeys(Integer.toString(id));
        WebElement fieldTitle = browser.findElement(By.name("pavadinimas"));
        fieldTitle.sendKeys(title);
        WebElement fieldGenre = browser.findElement(By.name("zanras"));
        fieldGenre.sendKeys(genre);
        WebElement fieldActors = browser.findElement(By.name("aktoriai"));
        fieldActors.sendKeys(actors);
        WebElement fieldDirector = browser.findElement(By.name("rezisierius"));
        fieldDirector.sendKeys(director);
        WebElement fieldTime = browser.findElement(By.name("trukme"));
        fieldTime.sendKeys(Integer.toString(time));
        WebElement send = browser.findElement(By.name("update"));
        send.click();

        return getMessage();
    }
}