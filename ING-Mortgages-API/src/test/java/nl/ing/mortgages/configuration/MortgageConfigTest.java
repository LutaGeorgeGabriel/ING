package nl.ing.mortgages.configuration;

import nl.ing.mortgages.repository.MortgageRepository;
import nl.ing.mortgages.service.MortgageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MortgageConfig.class)
public class MortgageConfigTest {

    @Autowired
    MortgageConfig config;

    @Test
    public void mortgageRepository() {
        MortgageRepository repo = config.mortgageRepository();
        assert repo != null;
    }

    @Test
    public void mortgageService() {
        MortgageService service = config.mortgageService();
        assert  service != null;
    }
}