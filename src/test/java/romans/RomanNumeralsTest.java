package romans;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RomanNumeralsTest {

    @ParameterizedTest
    @CsvSource({
            "1, I",
            "2, II",
            "3, III",
            "4, IV",
            "5, V",
            "6, VI",
            "7, VII",
            "8, VIII",
            "9, IX",
            "10, X",
            "11, XI",
            "14, XIV",
            "15, XV",
            "16, XVI",
            "19, XIX",
            "20, XX",
            "39, XXXIX",
            "40, XL",
            "41, XLI",
            "46, XLVI",
            "49, XLIX",
            "50, L",
    })
    void arabicToRoman(int arabic, String roman) {
        assertThat(romanOf(arabic)).isEqualTo(roman);
    }

    private String romanOf(final int arabic) {
        Map<Integer, String> romans = new HashMap<>() {{
            put(1, "I");
            put(4, "IV");
            put(5, "V");
            put(9, "IX");
            put(10, "X");
            put(40, "XL");
            put(50, "L");
        }};

        if (romans.containsKey(arabic)) return romans.get(arabic);

        if (arabic > 40) return romanOf(40) + romanOf(arabic - 40);
        if (arabic > 10) return romanOf(10) + romanOf(arabic - 10);
        if (arabic > 5) return romanOf(5) + romanOf(arabic - 5);
        if (arabic > 4) return romanOf(4) + romanOf(arabic - 4);
        return romanOf(1) + romanOf(arabic - 1);
    }
}
