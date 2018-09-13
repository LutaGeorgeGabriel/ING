package nl.ing.mortgages.api;

import nl.ing.mortgages.model.MortgageInfo;
import nl.ing.mortgages.model.MortgageRate;
import nl.ing.mortgages.service.MortgageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MortgageAPI {

    @Autowired
    MortgageService mortgageService;

    private final double MORTGAGE_DECLINED = -1.0;

    /**
     * @returns a {@link List<Double>} of interest rates based on the dummy data provided to the @{@link nl.ing.mortgages.repository.MortgageRepository}
     */

    @GetMapping(value = "/api/interest-rates", produces = "application/json")
    public ResponseEntity<List<Double>> getInterestRates() {
        return ResponseEntity.ok(mortgageService.getMortgages().stream()
                .map(MortgageRate::getInterestRate)
                .collect(Collectors.toList()));
    }

    /**
     * @param info
     * I used {@link MortgageInfo} to wrap all the information inside an object and take advantage of Spring's
     * Jackson serialization/deserialization library
     *
     * @returns the monthly mortgage payment if the conditions of eligibility are met.
     * In case the conditions are not met, the methods @returns -1.0 as a flag
     */

    @PostMapping(value = "/api/mortgage-check", consumes = "application/json")
    public double mortgageCheck(@RequestBody final MortgageInfo info) {

        // fetching the interest rate from the in-memory list of mortgage rates, based on the maturity period of the input data
        double interestRate = mortgageService.getMortgages().stream()
                .filter(mort -> mort.getMaturityPeriod().equals(info.getMaturityPeriod()))
                .findFirst().get().getInterestRate();

        // conditions of eligibility
        if((info.getLoanValue() > 4 * info.getIncome()) || (info.getLoanValue() > info.getHomeValue())) {
            // used this flag because it was not clear if I should return a boolean or a double
            return MORTGAGE_DECLINED;
        }
        return MortgageService.calculateMonthlyPayment(info.getLoanValue(), info.getMaturityPeriod(), interestRate);
    }
}