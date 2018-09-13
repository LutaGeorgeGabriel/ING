package nl.ing.mortgages.configuration;

import nl.ing.mortgages.repository.MortgageRepository;
import nl.ing.mortgages.service.MortgageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MortgageConfig {

    /**
     * Created MortgageRepository bean
     * @return MortgageRepository instance
     */
    @Bean
    public MortgageRepository mortgageRepository() {
        return new MortgageRepository();
    }

    /**
     * Created MortgageService bean
     * @return MortgageService instance
     */
    @Bean
    public MortgageService mortgageService() {
        return new MortgageService();
    }
}