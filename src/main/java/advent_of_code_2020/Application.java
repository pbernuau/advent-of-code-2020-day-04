package advent_of_code_2020;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Application {

    public static void main(String[] argv) {
        List<Passport> passports = new ArrayList<>();

        try (Reader reader = new FileReader("./input", StandardCharsets.UTF_8);
             PassportParser parser = new PassportParser(reader)) {
            Optional<Passport> passport;
            while ((passport = parser.parse()).isPresent()) {
                passports.add(passport.get());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.format("There are %s / %s lenient valid passports.\n",
                countValidPassports(passports, new LenientPassportValidator()),
                passports.size());

        System.out.format("There are %s / %s lenient valid passports.\n",
                countValidPassports(passports, new StrictPassportValidator()),
                passports.size());
    }

    private static long countValidPassports(List<Passport> passports, PassportValidator validator) {
        return passports.stream()
                .filter(validator)
                .count();
    }

}
