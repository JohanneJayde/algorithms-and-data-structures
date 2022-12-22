import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class methodsTest {

    int [] arr;

    @BeforeEach
    void setUp() {
        arr = new int[]{100, 5, 20, 9, 7, 19, 10, 12, 16, 13};

    }

    @AfterEach
    void tearDown() {
        arr = null;

    }

    @Test
    void HeapSortDescending_normalBehavior(){
        int [] correctArr = new int[]{5,7,9,10,12,13,16,19,20,100};
        assertArrayEquals(correctArr, methods.HeapSortDescending(arr));

    }
}