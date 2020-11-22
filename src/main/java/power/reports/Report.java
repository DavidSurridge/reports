package power.reports;

import java.util.HashMap;
import java.util.Map;

public interface Report {

    Map<String, HashMap<String, Double>> getReportData();

    void display();

    void addRecordToReport(Map<String, String> recordValue);
}
