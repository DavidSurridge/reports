import org.junit.*;
import power.importdata.CSVDataImporter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.*;


public class CSVDataImporterTest {
    private List<Map<String, String>> data;

    @Before
    public void initialiseData() {
        try {
            data = CSVDataImporter.sourceData("src\\main\\java\\power\\sourcefiles\\Bets.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void importDataShouldStoreAllRowsTest() {
        assertEquals(24, data.size());
    }

    @Test
    public void importDataShouldStoreAllFieldsTest() {
        assertEquals(7, data.get(0).keySet().size());
    }

}
