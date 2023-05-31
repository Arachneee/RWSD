package chapter2;

import java.io.IOException;

public class MainApplication
{
    public static void main(final String... args) throws IOException
    {
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        final BankStatementParser bankStatementParser = new BankStatementCSVParser();

        bankStatementAnalyzer.analyze("test1.csv", bankStatementParser);

    }
}
