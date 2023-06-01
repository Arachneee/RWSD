package chapter2.src.main.java;

public class HtmlExporter implements Exporter
{

    @Override
    public String export(SummaryStatistics summaryStatistics) {
        String result = "<!doctype html>";
        result += "<html lang='en'>";
        result += "<head><title>Bank Transaction Report</title></head>";
        result += "<body>";
        result += "<ul>";
        result += "<li><strong>The sum is</stron>:"+ summaryStatistics.getSum() + "</li>";
        result += "<li><strong>The average is</stron>:"+ summaryStatistics.getAverage() + "</li>";
        result += "<li><strong>The max is</stron>:"+ summaryStatistics.getMax() + "</li>";
        result += "<li><strong>The min is</stron>:"+ summaryStatistics.getMin() + "</li>";
        result += "</ul>";
        result += "</body>";
        result += "</html>";
        return result;
    }
}
