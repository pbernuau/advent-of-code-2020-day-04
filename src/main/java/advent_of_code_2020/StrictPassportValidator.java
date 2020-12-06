package advent_of_code_2020;

import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static advent_of_code_2020.PassportField.*;

public final class StrictPassportValidator implements PassportValidator {

    private static final Map<PassportField, Pattern> VALIDATION_RULES = Map.of(
            BirthYear, // four digits; at least 1920 and at most 2002
            Pattern.compile("19[2-9][0-9]|200[0-2]"),

            IssueYear, // four digits; at least 2010 and at most 2020
            Pattern.compile("20(1[0-9]|20)"),

            ExpirationYear, // four digits; at least 2020 and at most 2030
            Pattern.compile("20(2[0-9]|30)"),

            Height, // a number followed by either cm or in:
            // - If cm, the number must be at least 150 and at most 193
            // - If in, the number must be at least 59 and at most 76
            Pattern.compile("1([5-8][0-9]|9[0-3])cm|(59|6[0-9]|7[0-6])in"),

            HairColor, // a # followed by exactly six characters 0-9 or a-f
            Pattern.compile("#[0-9a-f]{6}"),

            EyeColor, // exactly one of: amb blu brn gry grn hzl oth.
            Pattern.compile("amb|blu|brn|gry|grn|hzl|oth"),

            PassportId, // a nine-digit number, including leading zeroes
            Pattern.compile("[0-9]{9}")
    );

    /**
     * Returns true if the given {@code passport}'s required fields are present and respect the strict validation rules.
     * Otherwise, returns false.
     */
    public boolean test(Passport passport) {
        Objects.requireNonNull(passport);
        return VALIDATION_RULES.entrySet().stream()
                .allMatch(rule -> test(passport, rule.getKey(), rule.getValue()));
    }

    private boolean test(Passport passport, PassportField field, Pattern pattern) {
        return passport.getFieldValue(field)
                .map(pattern::matcher)
                .map(Matcher::matches)
                .orElse(false);
    }

}
