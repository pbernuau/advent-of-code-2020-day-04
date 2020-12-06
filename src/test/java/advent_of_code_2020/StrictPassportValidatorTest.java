package advent_of_code_2020;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.io.StringReader;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StrictPassportValidatorTest {

    StrictPassportValidator validator;

    @BeforeEach
    void setUp() {
        validator = new StrictPassportValidator();
    }

    @ParameterizedTest
    @MethodSource("provideTestParameters")
    void test_isValid(Passport passport, boolean valid) {
        assertThat(validator.test(passport)).isEqualTo(valid);
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    static Stream<Arguments> provideTestParameters() throws IOException {
        String input = "" +
                "eyr:1972 cid:100 hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926\n\n" +
                "iyr:2019 hcl:#602927 eyr:1967 hgt:170cm ecl:grn pid:012533040 byr:1946\n\n" +
                "hcl:dab227 iyr:2012 ecl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277\n\n" +
                "hgt:59cm ecl:zzz eyr:2038 hcl:74454a iyr:2023 pid:3556412378 byr:2007\n\n" +
                "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980 hcl:#623a2f\n\n" +
                "eyr:2029 ecl:blu cid:129 byr:1989 iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm\n\n" +
                "hcl:#888785 hgt:164cm byr:2001 iyr:2015 cid:88 pid:545766238 ecl:hzl eyr:2022\n\n" +
                "iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719\n\n";

        PassportParser parser = new PassportParser(new StringReader(input));
        return Stream.of(
                Arguments.of(parser.parse().get(), false),
                Arguments.of(parser.parse().get(), false),
                Arguments.of(parser.parse().get(), false),
                Arguments.of(parser.parse().get(), false),
                Arguments.of(parser.parse().get(), true),
                Arguments.of(parser.parse().get(), true),
                Arguments.of(parser.parse().get(), true),
                Arguments.of(parser.parse().get(), true)
        );
    }

}