package nl.ing.mortgages.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               // provides getters, setters, toString, equals, as well as hasCode
@AllArgsConstructor // provides all the combination of constructors, based on the entity fields
@NoArgsConstructor  // provides the default constructor
public class MortgageInfo {
    private Double income;
    private Integer maturityPeriod;
    private Double loanValue;
    private Double homeValue;
}