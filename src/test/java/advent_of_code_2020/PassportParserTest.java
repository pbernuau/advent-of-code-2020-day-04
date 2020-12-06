package advent_of_code_2020;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringReader;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class PassportParserTest {

    @Test
    void test_parse() throws IOException {
        String input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\n" +
                "byr:1937 iyr:2017 cid:147 hgt:183cm";

        PassportParser parser = new PassportParser(new StringReader(input));
        Optional<Passport> actual = parser.parse();
        Passport expected = Passport.of(
                "ecl", "gry",
                "pid", "860033327",
                "eyr", "2020",
                "hcl", "#fffffd",
                "byr", "1937",
                "iyr", "2017",
                "cid", "147",
                "hgt", "183cm"
        );

        assertThat(actual).get().isEqualTo(expected);
        assertThat(parser.parse()).isEmpty();
    }

    @Test
    void test_parse_multiple_passport() throws IOException {
        String input = "" +
                "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\n" +
                "byr:1937 iyr:2017 cid:147 hgt:183cm\n" +
                "\n" +
                "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884\n" +
                "hcl:#cfa07d byr:1929\n" +
                "\n" +
                "hcl:#ae17e1 iyr:2013\n" +
                "eyr:2024\n" +
                "ecl:brn pid:760753108 byr:1931\n" +
                "hgt:179cm\n" +
                "\n" +
                "hcl:#cfa07d eyr:2025 pid:166559648\n" +
                "iyr:2011 ecl:brn hgt:59in\n";

        PassportParser parser = new PassportParser(new StringReader(input));
        assertThat(parser.parse()).isPresent();
        assertThat(parser.parse()).isPresent();
        assertThat(parser.parse()).isPresent();
        assertThat(parser.parse()).isPresent();
        assertThat(parser.parse()).isEmpty();
    }

}