import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import org.example.*;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    private final String GENDER;
    private final boolean EXPECTED;
    public LionParametrizedTest(String gender, boolean expected) {
        this.GENDER = gender;
        this.EXPECTED = expected;
    }

    @Parameterized.Parameters(name = "{index} : doesHaveMane() = {1}")
    public static Object[][] lionIsCreateData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void lionIsCreate() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(GENDER, feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(EXPECTED, actual);
    }
}