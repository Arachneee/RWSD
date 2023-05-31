package chapter2;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BankStatementCSVParser
{
    public class BankTransaction
    {
        private final LocalDate date;
        private final double amount;
        private final String description;

        public BankTransaction(final LocalDate date, final double amount, final String description)
        {
            this.date = date;
            this.amount = amount;
            this.description = description;
        }

        public LocalDate getDate()
        {
            return date;
        }
        public double getAmount()
        {
            return amount;
        }
        public String getDescription()
        {
            return description;
        }
        @Override
        public String toString()
        {
            return "BankTransaction{" +
                    "data=" + date +
                    ", amount=" + amount +
                    ", description='" + description + '\''+'}';
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BankTransaction that = (BankTransaction) o;
            return Double.compare(that.amount, amount) == 0 &&
                    date.equals(that.date) &&
                    description.equals(that.description);
        }
        @Override
        public int hashCode()
        {
            return Objects.hash(date, amount, description);
        }

    }
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private BankTransaction pareFormCSV(final String line)
    {
        final String[] columns = line.split(",");

        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final Double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];

        return new BankTransaction(date,amount,description);
    }

    public List<BankTransaction> parseLinesFormCSV(final List<String> lines)
    {
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for(final String line:lines)
        {
            bankTransactions.add(pareFormCSV(line));
        }
        return bankTransactions;
    }
}
