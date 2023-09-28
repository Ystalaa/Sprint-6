import org.example.*;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private Cat CAT;

    @Mock
    private Feline FELINE;

    @Before
    public void createNewInstance() {
        CAT = new Cat(FELINE);
    }

    @Test
    public void getSound() {
        String actual = CAT.getSound();
        String expected = "Мяу";
        assertEquals(expected, actual);
    }

    @Test
    public void getFood() throws Exception {
        Mockito.when(FELINE.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = CAT.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);
    }
}