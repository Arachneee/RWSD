package chapter2.src.main.java;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor
{
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount()
    {
        double total = 0d;
        for(final BankTransaction bankTransaction: bankTransactions)
        {
            total += bankTransaction.getAmount();
        }
        return total;
    }
    public double calculateTotalInMonth (final Month month)
    {
        double total = 0;
        for(final BankTransaction bankTransaction:bankTransactions)
        {
            if (bankTransaction.getDate().getMonth() == month)
            {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }
    public double calculateTotalForCategory (final String category)
    {
        double total = 0;
        for(final BankTransaction bankTransaction:bankTransactions)
        {
            if (bankTransaction.getDescription().equals(category))
            {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }
    public BankTransaction findMaxBankTransaction (final LocalDate from, final LocalDate to)
    {
        BankTransaction maxTransaction = null;
        for(final BankTransaction bankTransaction: bankTransactions.stream().filter(i->(i.getDate().isBefore(to) && i.getDate().isAfter(from))).toList())
        {
            if ((maxTransaction == null) || (bankTransaction.getAmount() > maxTransaction.getAmount()))
            {
                maxTransaction = bankTransaction;
            }
        }
        return maxTransaction;
    }
    public BankTransaction findMinBankTransaction (final LocalDate from, final LocalDate to)
    {
        BankTransaction maxTransaction = null;
        for(final BankTransaction bankTransaction: bankTransactions.stream().filter(i->(i.getDate().isBefore(to) && i.getDate().isAfter(from))).toList())
        {
            if ((maxTransaction == null) || (bankTransaction.getAmount() < maxTransaction.getAmount()))
            {
                maxTransaction = bankTransaction;
            }
        }
        return maxTransaction;
    }
    public List<BankTransaction> findTransactions (final BankTransactionFilter bankTransactionFilter)
    {
        final List<BankTransaction> result = new ArrayList<>();
        for(final BankTransaction bankTransaction : bankTransactions)
        {
            if(bankTransactionFilter.test(bankTransaction))
            {
                result.add(bankTransaction);
            }
        }
        return result;
    }

}
