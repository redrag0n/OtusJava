package hw04;

import hw04.annotations.Before;
import hw04.annotations.Test;
import hw04.annotations.After;

import java.util.Random;

public class Tester {
    @Test
    public void useTest() {
        assert (new Random().nextBoolean());
    }

    @Before
    public void useBefore() {
        assert (new Random().nextBoolean());
    }

    @After
    public void useAfter() {
        assert (new Random().nextBoolean());
    }
}
