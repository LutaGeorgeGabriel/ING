package nl.ing.mortgages.service;

import nl.ing.mortgages.model.MortgageRate;
import nl.ing.mortgages.repository.MortgageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MortgageService {

    @Autowired
    MortgageRepository repository;

    /**
     * @returns all the in-memory mortgages from the repository
     */
    public List<MortgageRate> getMortgages() {
        return repository.getMortgageRates();
    }

    /**
     * calculating the mortgage monthly payment
     * @param loanAmount - mortgage itself
     * @param termInYears - maturity period
     * @param interestRate - interest rate of the given mortgage, based on its maturity period
     * @returns mortgage monthly payment
     */
    public static double calculateMonthlyPayment(double loanAmount, int termInYears, double interestRate) {

        // Convert interest rate into a decimal
        // eg. 6.5% = 0.065

        interestRate /= 100.0;

        // Monthly interest rate
        // is the yearly rate divided by 12

        double monthlyRate = interestRate / 12.0;

        // The length of the term in months
        // is the number of years times 12

        int termInMonths = termInYears * 12;

        // Calculate the monthly payment
        // Typically this formula is provided so
        // we won't go into the details

        // The Math.pow() method is used calculate values raised to a power

        return (loanAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -termInMonths));
    }
}
