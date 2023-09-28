import java.util.List;
import org.junit.Test;
import org.junit.Rule;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.junit.rules.ExpectedException;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.example.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private static final String VALID_GENDER = "Самец";
    private static final String INVALID_GENDER = "invalidGender";
    private static final String EXPECTION_MESSAGE = "Используйте допустимые значения пола животного - самец или самка";

    @Mock
    private Feline FELINE;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void getKittens() throws Exception {
        Lion lion = new Lion(VALID_GENDER, FELINE);
        Mockito.when(FELINE.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion(VALID_GENDER, FELINE);
        boolean actual = lion.doesHaveMane();
        assertTrue(actual);
    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion(VALID_GENDER, FELINE);
        Mockito.when(FELINE.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);
    }

    @Test
    public void checkExceptionByCreateLion() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage(EXPECTION_MESSAGE);
        Lion lion = new Lion(INVALID_GENDER, FELINE);
    }
}