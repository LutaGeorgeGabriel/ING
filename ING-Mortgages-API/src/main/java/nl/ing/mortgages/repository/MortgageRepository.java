package nl.ing.mortgages.repository;

import nl.ing.mortgages.model.MortgageRate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class MortgageRepository {

    /**
     * the list acts as a persistence method (in-memory)
     */
    private final List<MortgageRate> mortgageRates = new ArrayList<>();

    /**
     * @returns the in-mempry list of mortgage rates
     */
    public List<MortgageRate> getMortgageRates() {
        return this.mortgageRates;
    }

    /**
     * generated a list of random mortgage rates with dummy data
     */
    public MortgageRepository() {
        this.mortgageRates.add(new MortgageRate(15, 4.25, new Date()));
        this.mortgageRates.add(new MortgageRate(20, 4.5, new Date()));
        this.mortgageRates.add(new MortgageRate(30, 4.625, new Date()));
    }
}
