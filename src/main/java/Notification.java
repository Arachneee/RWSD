package main.java;

import java.util.*;
public class Notification {
    private final List<String> errors = new ArrayList<>();

    public void addError(final String message)
    {
        errors.add(message);
    }
    public boolean hasErrors()
    {
        return !errors.isEmpty();
    }
    public String errorMessage()
    {
        return errors.toString();
    }
    public List<String> getErrors()
    {
        return this.errors;
    }
}
