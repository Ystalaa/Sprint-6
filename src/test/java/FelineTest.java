import java.util.List;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import org.example.*;

public class FelineTest {
    private Feline FELINE;

    @Before
    public void createNewInstance() {
        FELINE = new Feline();
    }
    @Test

    public void eatMeat() throws Exception {
        List<String> list = FELINE.eatMeat();
        int actual = list.size();
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void getFamily() {
        String actual = FELINE.getFamily();
        String expected = "Кошачьи";
        assertEquals(expected, actual);
    }

    @Test
    public void getKittens() {
        int actual = FELINE.getKittens();
        int expected = 1;
        assertEquals(expected, actual);
    }
}