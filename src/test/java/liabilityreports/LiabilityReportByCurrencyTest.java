package liabilityreports;

import liabilityreports.LiabilityAbstractTestCase;

import org.junit.Before;
import org.junit.Test;
import power.reports.Report;
import power.reports.liability.LiabilityReportByCurrency;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static junit.framework.TestCase.*;

public class LiabilityReportByCurrencyTest extends LiabilityAbstractTestCase {


    private Report report = new LiabilityReportByCurrency();

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
    public void reportShouldAggregateMatchingRowsTest() {
        assertEquals(1, getReport().getReportData().size());
    }

    @Test
    public void reportShouldCountNumBetsForRowTest() {
        assertEquals(2.0, getReport().getReportData().get("EUR").get("Num Bets"));
    }

    @Test
    public void reportShouldAggregateStakesTest() {
        assertEquals(3.20, getReport().getReportData().get("EUR").get("Total Stakes"));
    }

    @Test
    public void reportShouldCalculateLiabilityTest() {
        BigDecimal bd = new BigDecimal(getReport().getReportData().get("EUR").get("Total Liability")).setScale(2, RoundingMode.HALF_UP);
        assertEquals(14.40,  bd.doubleValue());
    }

}
