package sweb.disi.unitn.it;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import sweb.disi.unitn.it.Utils.ProjectExample;
import sweb.disi.unitn.it.objects.experiment.Experiment;

import java.net.ConnectException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(classes = {REST.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DataTests {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    private final String token = "test:token";

    private Experiment experiment;

    @BeforeAll
    void beforeAll() throws ConnectException {
        objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
    }

    @Nested
    class ExperimentTest {

        @BeforeEach
        void beforeEach() {

            experiment = ProjectExample.getExperiment();

        }

        @AfterEach
        void afterEach() throws Exception {


        }
    }

        private MvcResult getData() throws Exception{

        MvcResult response = mockMvc.perform(get("/v2/experiment/{experimentId}", experiment.getId())
                .header("authorization", token))
                .andExpect(status().isOk())
                .andReturn();
        return response;
    }
}
