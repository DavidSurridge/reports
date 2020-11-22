package liabilityreports;

import org.junit.Before;
import org.junit.Test;
import power.reports.Report;
import power.reports.liability.LiabilityReportByCurrencyAndSelectionName;
import static junit.framework.TestCase.assertNotNull;

public class LiabilityReportByCurrencyAndSelectionNameTest extends LiabilityAbstractTestCase {
    private Report report = new LiabilityReportByCurrencyAndSelectionName();

    @Override
    public Report getReport() {
        return report;
    }

    @Before
    public void setUp() {
        initialiseDummyData();
        generateReport();
    }

    @Test
    public void reportShouldSetKeyValueOnCurrencyAndName() {
        assertNotNull(report.getReportData().get("EUR.Fan the Flames"));
    }
}
