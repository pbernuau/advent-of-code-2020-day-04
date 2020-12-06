package advent_of_code_2020;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static advent_of_code_2020.PassportField.*;
import static org.assertj.core.api.Assertions.assertThat;

class PassportTest {

    Passport passport;

    @BeforeEach
    void setUp() {
        passport = Passport.of(
                "hcl", "#cfa07d",
                "eyr", "2025",
                "pid", "166559648",
                "iyr", "2011",
                "ecl", "brn",
                "hgt", "59in"
        );
    }

    @Test
    void test_getFieldValue() {
        assertThat(passport.getFieldValue(Height)).get().isEqualTo("59in");
        assertThat(passport.getFieldValue(BirthYear)).isEmpty();
    }

    @Test
    void test_getPresentFields() {
        assertThat(passport.getPresentField()).containsExactlyInAnyOrder(
                HairColor, ExpirationYear, PassportId, IssueYear, EyeColor, Height
        );
    }

    @Test
    void test_toString() {
        assertThat(passport).hasToString("iyr:2011 eyr:2025 hgt:59in hcl:#cfa07d ecl:brn pid:166559648");
    }

}