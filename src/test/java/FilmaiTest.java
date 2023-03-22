import org.example.Filmai;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FilmaiTest {
    @Before
    public void setUp(){
        Filmai.setUp(Filmai.URL);
    }

    @Test
    public void fillInTheFieldsIfsuccessful(){
        String message = Filmai.fillInTheFields("Vesper", "Fantasy", "Raffiella Chapman, Eddie Marsan, Rosy McEwen", "Kristina Buožytė ir Bruno Samper", 112);
        Assert.assertEquals("Duomenys įrašyti sėkmingai", message);
    }

    @Test
    public void fillInTheFieldsIfFailure(){
        String message = Filmai.fillInTheFields("", "Fantasy", "Raffiella Chapman, Eddie Marsan, Rosy McEwen", "Kristina Buožytė ir Bruno Samper", 112);
        Assert.assertEquals("Duomenų įvedimo klaida", message);
    }

    @Test
    public void deleteTest(){
        String message = Filmai.deleteFilm(107);
        Assert.assertEquals("Įrašas ištrintas sėkmingai", message);
    }

    @Test
    public void editFieldsIfsuccessful(){
        String message = Filmai.editFields(108, "Avatar: The Way of Water", "Action, adventure, fantasy", "Sam Worthington, Zoe Saldana", "James Cameron", 192);
        Assert.assertEquals("Įrašas paredaguotas sėkmingai", message);
    }

    @Test
    public void editFieldsIfFailure(){
        String message = Filmai.editFields(108, "", "Action, adventure, fantasy", "Sam Worthington, Zoe Saldana", "James Cameron", 192);
        Assert.assertEquals("Blogai įvesti duomenys redaguojant įrašą", message);
    }


}
