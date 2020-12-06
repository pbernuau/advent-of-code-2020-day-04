package advent_of_code_2020;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PassportParser implements Closeable {

    private static final Pattern FIELD_PATTERN = Pattern.compile("(\\S+):(\\S+)");

    private final BufferedReader reader;

    public PassportParser(Reader reader) {
        this.reader = reader instanceof BufferedReader
                ? (BufferedReader) reader
                : new BufferedReader(reader);
    }

    public Optional<Passport> parse() throws IOException {
        String input = readNext();
        if (input.isBlank()) {
            return Optional.empty();
        }

        Map<PassportField, String> fields = new HashMap<>();

        Matcher matcher = FIELD_PATTERN.matcher(input);
        while (matcher.find()) {
            String code = matcher.group(1);
            String value = matcher.group(2);

            fields.put(PassportField.fromCode(code), value);
        }

        Passport passport = new Passport(fields);
        return Optional.of(passport);
    }

    private String readNext() throws IOException {
        StringBuilder input = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                break;
            }

            input.append(line).append(" ");
        }

        return input.toString();
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
