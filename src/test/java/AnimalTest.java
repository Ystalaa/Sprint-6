import java.util.List;

import org.example.Animal;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;

public class AnimalTest {
    private static final String exceptionMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
    private Animal animal;
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Before
    public void createNewInstance() {
        animal = new Animal();
    }
    @Test
    public void getFoodCheckException() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage(exceptionMessage);
        List<String> list = animal.getFood("Всеядное");
    }
    @Test
    public void getFamily() {
        String actual = animal.getFamily();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, actual);
    }
}