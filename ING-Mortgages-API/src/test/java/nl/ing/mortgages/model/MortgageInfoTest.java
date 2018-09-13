package nl.ing.mortgages.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class MortgageInfoTest {

    @Test
    public void getIncome() {
        MortgageInfo info = new MortgageInfo(100.0,15,55.0,200.0);
        assertTrue(info.getIncome() == 100.0);
    }

    @Test
    public void getMaturityPeriod() {
        MortgageInfo info = new MortgageInfo(100.0,15,55.0,200.0);
        assertTrue(info.getMaturityPeriod() == 15);
    }

    @Test
    public void getLoanValue() {
        MortgageInfo info = new MortgageInfo(100.0,15,55.0,200.0);
        assertTrue(info.getLoanValue() == 55.0);
    }

    @Test
    public void getHomeValue() {
        MortgageInfo info = new MortgageInfo(100.0,15,55.0,200.0);
        assertTrue(info.getHomeValue() == 200.0);
    }

    @Test
    public void setIncome() {
        MortgageInfo info = new MortgageInfo();
        info.setIncome(100.0);
        assertTrue(info.getIncome() == 100.0);
    }

    @Test
    public void setMaturityPeriod() {
        MortgageInfo info = new MortgageInfo();
        info.setMaturityPeriod(15);
        assertTrue(info.getMaturityPeriod() == 15);
    }

    @Test
    public void setLoanValue() {
        MortgageInfo info = new MortgageInfo();
        info.setLoanValue(55.0);
        assertTrue(info.getLoanValue() == 55.0);
    }

    @Test
    public void setHomeValue() {
        MortgageInfo info = new MortgageInfo();
        info.setHomeValue(200.0);
        assertTrue(info.getHomeValue() == 200.0);
    }
}