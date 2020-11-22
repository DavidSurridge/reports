package power.reports.liability;

import power.reports.Report;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LiabilityReportByCurrency implements Report {
    private Map<String, HashMap<String, Double>> reportData = new TreeMap<>(Collections.reverseOrder());
    final String NUMCOUNT = "Num Bets";
    final String TOTALSTAKES = "Total Stakes";
    final String TOTALLIABILITY = "Total Liability";

    public String obtainKeyValues(Map<String, String> recordValue) {
        return recordValue.get("currency");
    }
    @Override
    public Map<String, HashMap<String, Double>> getReportData() {
        return reportData;
    }

    @Override
    public void display() {

        String headerLeftAlignFormat = "| %-17s | %-17s | %-17s | %-17s |%n";
        String dataleftAlignFormat   = "| %-17s | %-17.0f | %-17.2f | %-17.2f |%n";
        String lineBreak ="+-------------------+-------------------+-------------------+-------------------+%n";
        System.out.format(lineBreak);
        System.out.format(headerLeftAlignFormat, "Currency", NUMCOUNT, TOTALSTAKES, TOTALLIABILITY);
        System.out.format(lineBreak);

        for (Map.Entry<String, HashMap<String, Double>> stringHashMapEntry : getReportData().entrySet()) {
            HashMap<String, Double> value = stringHashMapEntry.getValue();
            System.out.format(dataleftAlignFormat, stringHashMapEntry.getKey(), value.get(NUMCOUNT), value.get(TOTALSTAKES), value.get(TOTALLIABILITY));
        }
        System.out.format(lineBreak);
    }

    @Override
    public void addRecordToReport(Map<String, String> recordValue) {

        String report1KeyValue = obtainKeyValues(recordValue);
        HashMap<String, Double> reportEntry = getReportData().get(report1KeyValue);
        //TODO protect against null pointers in missing data
        if (reportEntry != null) {
            Double newNum = reportEntry.get(NUMCOUNT) + 1.0;
            Double stake = reportEntry.get(TOTALSTAKES) + Double.parseDouble(recordValue.get("stake"));
            Double betLiability = reportEntry.get(TOTALLIABILITY) + (Double.parseDouble(recordValue.get("stake")) * Double.parseDouble(recordValue.get("price")));

            reportEntry.put(NUMCOUNT, newNum);
            reportEntry.put(TOTALSTAKES, stake);
            reportEntry.put(TOTALLIABILITY, betLiability);

        } else {
            Double stake = Double.parseDouble(recordValue.get("stake"));
            Double price = Double.parseDouble(recordValue.get("price"));
            Double betLiability = stake * price;

            HashMap<String, Double> newEntry = new HashMap<>();
            newEntry.put(NUMCOUNT, 1.0);
            newEntry.put(TOTALSTAKES, stake);
            newEntry.put(TOTALLIABILITY, betLiability);
            getReportData().put(report1KeyValue, newEntry);
        }
    }
}
