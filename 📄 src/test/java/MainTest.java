import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixTest {

    // C = a * B
    @Test
    public void testMatrixMultiplication() {

        char[][] B = {
                {'A', 'B'},
                {'C', 'D'}
        };

        int a = 2;

        char[][] C = new char[2][2];

        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                C[i][j] = (char) (B[i][j] * a);
            }
        }

        assertEquals((char) ('A' * 2), C[0][0]);
        assertEquals((char) ('D' * 2), C[1][1]);
    }

    // сума max/min по рядках
    @Test
    public void testSumLogic() {

        char[][] C = {
                {'A', 'B'}, // max = B
                {'C', 'D'}  // min = C
        };

        int sum = 0;

        for (int i = 0; i < C.length; i++) {

            char max = C[i][0];
            char min = C[i][0];

            for (int j = 1; j < C[i].length; j++) {
                if (C[i][j] > max) max = C[i][j];
                if (C[i][j] < min) min = C[i][j];
            }

            if (i % 2 == 0)
                sum += max;
            else
                sum += min;
        }

        // A=65, B=66, C=67
        // max row0 = B(66)
        // min row1 = C(67)
        // sum = 133

        assertEquals(133, sum);
    }

    // відсутність помилки при пустих даних
    @Test
    public void testNoCrashSmallMatrix() {

        char[][] C = {
                {'A'}
        };

        assertDoesNotThrow(() -> {
            char max = C[0][0];
            assertEquals('A', max);
        });
    }
}
