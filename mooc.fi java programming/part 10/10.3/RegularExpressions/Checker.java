

public class Checker {
    public boolean isDayOfWeek(String string) {
        // Correct regular expression for day of week
        return string.matches("^(mon|tue|wed|thu|fri|sat|sun)$");
    }

    public boolean allVowels(String string) {
        // Correct regular expression for all vowels
        return string.matches("^[aeiouAEIOU]*$");
    }

    public boolean timeOfDay(String string) {
        // Correct regular expression for time of day
        return string.matches("^(?:[01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$");
    }

}
