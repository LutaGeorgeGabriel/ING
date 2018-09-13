package nl.ing.mortgages.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MortgageRateTest {

    @Test
    public void getMaturityPeriod() {
        MortgageRate mortgageRate = new MortgageRate(15, 4.25, new Date());
        assertTrue(mortgageRate.getMaturityPeriod() == 15);
    }

    @Test
    public void getInterestRate() {
        MortgageRate mortgageRate = new MortgageRate(15, 4.25, new Date());
        assertTrue(mortgageRate.getInterestRate() == 4.25);
    }

    @Test
    public void getLastUpdate() {
        Date date = new Date();
        MortgageRate mortgageRate = new MortgageRate(15, 4.25, date);
        assertTrue(mortgageRate.getLastUpdate() == date);
    }

    @Test
    public void setMaturityPeriod() {
        MortgageRate mortgageRate = new MortgageRate();
        mortgageRate.setMaturityPeriod(15);
        assertTrue(mortgageRate.getMaturityPeriod() == 15);
    }

    @Test
    public void setInterestRate() {
        MortgageRate mortgageRate = new MortgageRate();
        mortgageRate.setInterestRate(4.25);
        assertTrue(mortgageRate.getInterestRate() == 4.25);
    }

    @Test
    public void setLastUpdate() {
        Date date = new Date();
        MortgageRate mortgageRate = new MortgageRate();
        mortgageRate.setLastUpdate(date);
        assertTrue(mortgageRate.getLastUpdate() == date);
    }
}