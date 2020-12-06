package advent_of_code_2020;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PassportFieldTest {

    @ParameterizedTest
    @MethodSource("providePassportFieldCodeMapping")
    void test_from_valid_code(String code, PassportField field) {
        assertThat(PassportField.fromCode(code)).isEqualTo(field);
    }

    private static Stream<Arguments> providePassportFieldCodeMapping() {
        return Stream.of(
                Arguments.of("byr", PassportField.BirthYear),
                Arguments.of("iyr", PassportField.IssueYear),
                Arguments.of("eyr", PassportField.ExpirationYear),
                Arguments.of("hgt", PassportField.Height),
                Arguments.of("hcl", PassportField.HairColor),
                Arguments.of("ecl", PassportField.EyeColor),
                Arguments.of("pid", PassportField.PassportId),
                Arguments.of("cid", PassportField.CountryId)
        );
    }

}