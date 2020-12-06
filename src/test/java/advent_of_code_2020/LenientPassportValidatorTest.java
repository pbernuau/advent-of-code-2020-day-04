package advent_of_code_2020;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.io.StringReader;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LenientPassportValidatorTest {

    LenientPassportValidator validator;

    @BeforeEach
    void setUp() {
        validator = new LenientPassportValidator();
    }

    @ParameterizedTest
    @MethodSource("provideTestParameters")
    void test_isValid(Passport passport, boolean valid) {
        assertThat(validator.test(passport)).isEqualTo(valid);
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    static Stream<Arguments> provideTestParameters() throws IOException {
        String input = "" +
                "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm\n\n" +
                "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884 hcl:#cfa07d byr:1929\n\n" +
                "hcl:#ae17e1 iyr:2013 eyr:2024 ecl:brn pid:760753108 byr:1931 hgt:179cm\n\n" +
                "hcl:#cfa07d eyr:2025 pid:166559648 iyr:2011 ecl:brn hgt:59in\n\n";

        PassportParser parser = new PassportParser(new StringReader(input));
        return Stream.of(
                Arguments.of(parser.parse().get(), true),
                Arguments.of(parser.parse().get(), false),
                Arguments.of(parser.parse().get(), true),
                Arguments.of(parser.parse().get(), false)
        );
    }

}