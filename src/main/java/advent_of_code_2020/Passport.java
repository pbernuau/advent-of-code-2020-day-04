package advent_of_code_2020;

import java.util.*;
import java.util.stream.Collectors;

public final class Passport {

    private final Map<PassportField, String> fields;

    public Passport(Map<PassportField, String> fields) {
        this.fields = Map.copyOf(fields);
    }

    public static Passport of(String... entries) {
        Objects.requireNonNull(entries);
        if (entries.length % 2 != 0) {
            throw new IllegalArgumentException("expected an even number of parameters, got: " + entries.length);
        }

        Map<PassportField, String> fields = new HashMap<>();
        for (int i = 0; i < entries.length; i += 2) {
            String code = Objects.requireNonNull(entries[i]);
            String value = Objects.requireNonNull(entries[i + 1]);

            fields.put(PassportField.fromCode(code), value);
        }

        return new Passport(fields);
    }

    public Optional<String> getFieldValue(PassportField field) {
        Objects.requireNonNull(field);
        return Optional.ofNullable(fields.get(field));
    }

    public Set<PassportField> getPresentField() {
        return fields.keySet();
    }

    @Override
    public String toString() {
        return new EnumMap<>(fields).entrySet().stream()
                .map(e -> String.format("%s:%s", e.getKey().getCode(), e.getValue()))
                .collect(Collectors.joining(" "));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return Objects.equals(fields, passport.fields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fields);
    }

}
