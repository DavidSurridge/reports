package liabilityreports;
import org.junit.Ignore;
import power.reports.Report;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Ignore
public abstract class LiabilityAbstractTestCase {

    private List<Map<String, String>> data = new ArrayList<>();

    public List<Map<String, String>> getData() {
        return data;
    }

    public abstract Report getReport();

    public void initialiseDummyData() {

        Map<String, String> record1 = new HashMap<>();
        record1.put("currency", "EUR");
        record1.put("selectionName", "Fan the Flames");
        record1.put("stake", "1.1");
        record1.put("price", "4.5");

        Map<String, String> record2 = new HashMap<>();
        record2.put("currency", "EUR");
        record2.put("selectionName", "Fan the Flames");
        record2.put("stake", "2.1");
        record2.put("price", "4.5");

        getData().add(record1);
        getData().add(record2);
    }

    public void generateReport() {
        for (Map<String, String> recordValue : getData()) {
            getReport().addRecordToReport(recordValue);
        }
    }

}