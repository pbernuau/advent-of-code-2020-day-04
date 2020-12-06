package advent_of_code_2020;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public final class PassportValidator {

    /**
     * Returns true if the given {@code passport} has all {@link PassportField} except {@link PassportField#CountryId}
     * which is optional.
     */
    public boolean isValid(Passport passport) {
        Objects.requireNonNull(passport);

        Set<PassportField> missingFields = EnumSet.allOf(PassportField.class);
        missingFields.remove(PassportField.CountryId);
        missingFields.removeAll(passport.getPresentField());
        return missingFields.isEmpty();
    }

}
