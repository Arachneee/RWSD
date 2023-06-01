package chapter2.src.main.java;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class BankStatementValidator
{
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private String description;
    private String date;
    private String amount;
    public BankStatementValidator(final String description, final String date, final String amount)
    {
        this.description = Objects.requireNonNull(description);
        this.date = Objects.requireNonNull(date);
        this.amount = Objects.requireNonNull(amount);
    }
    public Notification validate()
    {
        final Notification notification = new Notification();

        if(this.description.length() > 100)
        {
            notification.addError("The descriptino is too long");
        }

        final LocalDate parsedDate;
        try
        {
            parsedDate = LocalDate.parse(this.date, DATE_PATTERN);
            if(parsedDate.isAfter(LocalDate.now()))
            {
                notification.addError("date cannot be in the future");
            }
        } catch (DateTimeException e)
        {
            notification.addError("Invalid format for date");
        }

        final double amount;
        try
        {
            amount = Double.parseDouble(this.amount);
        } catch (NumberFormatException e)
        {
            notification.addError("Invalid format for amount");
        }
        return notification;
    }
}
