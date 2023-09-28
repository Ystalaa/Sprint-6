import org.example.*;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class AnimalParametrizedTest {
    private final String ANIMAL_KIND;
    private final List<String> EXPECTED;

    public AnimalParametrizedTest(String animalKind, List<String> expected) {
        this.ANIMAL_KIND = animalKind;
        this.EXPECTED = expected;
    }

    @Parameterized.Parameters(name = "{index} : getFood({0}) = {1}")
    public static Object[][] getFoodData() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        };
    }

    @Test
    public void getFood() throws Exception {
        Animal animal = new Animal();
        List<String> list = animal.getFood(ANIMAL_KIND);
        int actual = list.size();
        assertEquals(EXPECTED.size(), actual);
    }
}