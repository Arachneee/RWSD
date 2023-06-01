package chapter2.src.main.java;

@FunctionalInterface
public interface BankTransactionFilter
{
    boolean test(BankTransaction bankTransaction);
}
