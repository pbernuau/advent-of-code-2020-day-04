package advent_of_code_2020;

import java.util.Objects;

public enum PassportField {
    BirthYear("byr"),
    IssueYear("iyr"),
    ExpirationYear("eyr"),
    Height("hgt"),
    HairColor("hcl"),
    EyeColor("ecl"),
    PassportId("pid"),
    CountryId("cid");

    private final String code;

    PassportField(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static PassportField fromCode(String code) {
        Objects.requireNonNull(code);

        for (PassportField field : values()) {
            if (field.code.equals(code)) {
                return field;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}