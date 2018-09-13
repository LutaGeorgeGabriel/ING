package nl.ing.mortgages.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.ing.mortgages.model.MortgageInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class MortgagesApplicationIntegrationTest {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.webApplicationContext);
        this.mockMvc = builder.build();
    }


    @Test
    public void testFetchInterestRatesGetEndpoint() throws Exception {
        // built up the POST request with all the needed headers and contents
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/api/interest-rates");
        // performing the status check upon the response and the fetched data as well
        this.mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().json("[4.25,4.5,4.625]"));
    }

    @Test
    public void testMortgageCheckPostEndpoint() throws Exception {
        // created mock object for the body of the POST request
        MortgageInfo mortgageInfo = new MortgageInfo(100.0,15,55.0,200.0);
        // deserialize object into a JSON string using ObjectMapper, to be used as the content of the request
        String body = mapper.writeValueAsString(mortgageInfo);
        // built up the POST request with all the needed headers and contents
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/api/mortgage-check")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body)
                .accept(MediaType.APPLICATION_JSON);

        // performing the status check upon the response
        mockMvc.perform(builder).andExpect(status().isOk());
    }

}
