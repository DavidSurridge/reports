package power;

import power.importdata.CSVDataImporter;
import power.reports.Report;
import power.reports.liability.LiabilityReportByCurrency;
import power.reports.liability.LiabilityReportByCurrencyAndSelectionName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LiabilityReportRunner {

    public static void main(String[] args) {
        String defaultSourceLocation = "src\\main\\java\\power\\sourcefiles\\Bets.csv";
        String sourceLocation;
        if (args.length > 0) {
            sourceLocation = args[0];
        } else {
            sourceLocation = defaultSourceLocation;
        }
        ArrayList<Report> reports = new ArrayList<>(Arrays.asList(new LiabilityReportByCurrencyAndSelectionName(), new LiabilityReportByCurrency()));
        generateReports(sourceLocation, reports);
        displayReports(reports);

    }

    public static void generateReports(String sourceLocation, ArrayList<Report> reports) {

        try {
            List<Map<String, String>> allRecords = CSVDataImporter.sourceData(sourceLocation);

            for (Map<String, String> recordValue : allRecords) {
                for (Report report : reports) {
                    report.addRecordToReport(recordValue);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayReports(ArrayList<Report> reports) {

        for (Report report : reports) {
            report.display();
        }

    }
}
