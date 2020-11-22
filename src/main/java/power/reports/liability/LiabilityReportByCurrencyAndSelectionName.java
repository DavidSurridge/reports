package power.reports.liability;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class LiabilityReportByCurrencyAndSelectionName extends LiabilityReportByCurrency {


    @Override
    public String obtainKeyValues(Map<String, String> recordValue) {
        final ArrayList<String> keys = new ArrayList<>(Arrays.asList("currency", "selectionName"));
        StringJoiner finalKey = new StringJoiner(".");
        for (String key : keys) {
            finalKey.add(recordValue.get(key));
        }

        return finalKey.toString();
    }

    @Override
    public void display() {

        String headerLeftAlignFormat = "| %-17s | %-17s | %-17s | %-17s | %-17s |%n";
        String dataleftAlignFormat   = "| %-17s | %-17s | %-17.0f | %-17.2f | %-17.2f |%n";
        String lineBreak ="+-------------------+-------------------+-------------------+-------------------+-------------------+%n";
        System.out.format(lineBreak);
        System.out.format(headerLeftAlignFormat, "Currency","Selection Name", NUMCOUNT, TOTALSTAKES, TOTALLIABILITY);
        System.out.format(lineBreak);

        for (Map.Entry<String, HashMap<String, Double>> stringHashMapEntry : getReportData().entrySet()) {
            HashMap<String, Double> value = stringHashMapEntry.getValue();
            String[] keys = stringHashMapEntry.getKey().split("\\.");
            System.out.format(dataleftAlignFormat, keys[0],keys[1], value.get(NUMCOUNT), value.get(TOTALSTAKES), value.get(TOTALLIABILITY));
        }
        System.out.format(lineBreak);
    }
}
