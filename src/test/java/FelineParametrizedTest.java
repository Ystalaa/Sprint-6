import org.example.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class FelineParametrizedTest {
    private final int KITTENS_COUNT;
    private final int EXPECTED;

    public FelineParametrizedTest(int kittensCount, int expected) {
        this.KITTENS_COUNT = kittensCount;
        this.EXPECTED = expected;
    }

    @Parameterized.Parameters(name = "{index} : getKittens({0}) = {1}")
    public static Object[][] getKittensByCountData() {
        return new Object[][] {
                {1, 1},
                {2, 2},
                {3, 3}
        };
    }

    @Test
    public void getKittensByCount() {
        Feline feline = new Feline();
        int actual = feline.getKittens(KITTENS_COUNT);
        assertEquals(EXPECTED, actual);
    }
}