package sweb.disi.unitn.it;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.ResultActions;
import sweb.disi.unitn.it.Utils.ProjectExample;
import sweb.disi.unitn.it.objects.User;
import sweb.disi.unitn.it.objects.experiment.Experiment;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;


import java.net.ConnectException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static sweb.disi.unitn.it.objects.subscription.Entity.USER_TYPE;

@AutoConfigureMockMvc
@SpringBootTest(classes = {REST.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IlogbaseEntitiesTests {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    private final String token = "test:token";

    private Experiment experiment;

    private MockHttpServletRequestBuilder endpointPostExperiment = post("/v2/experiment/");

    @BeforeAll
    void beforeAll() throws ConnectException {
        objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
    }


    @Nested
    class ExperimentTest {

        @BeforeEach
        void beforeEach() throws Exception {

            experiment = ProjectExample.getExperiment();
            createExperiment(experiment);
        }

        @AfterEach
        void afterEach() throws Exception {

            deleteExperiment(experiment);
        }


        @Test
        void createExperimentTest() throws Exception {

            /* Delete project created in beforeeach method */
            deleteExperiment(experiment);

            /* Make sure there is no experiment */
            getExperiment(experiment).andExpect(status().isNotFound());

            /* Create new experiment */
            createExperiment(experiment);

            /* Retrieve the newly created experiment */
            Experiment actual = objectMapper.readValue(getExperiment(experiment).andReturn().getResponse().getContentAsString(), Experiment.class);

            /* Make sure the actual experiment is equal to the expected one */
            assertThat(actual).isEqualToComparingFieldByFieldRecursively(experiment);
        }

        @Test
        void experimentConfigurationNullTest() throws Exception {

            experiment.setConfiguration(null);

            createExperiment(experiment)
                    .andExpect(status().isBadRequest())
                    .andReturn();
        }

        @Test
        void experimentDescriptionNullTest() throws Exception {

            /* Delete project created in beforeeach method */
            deleteExperiment(experiment);

            experiment.setDescription(null);

            createExperiment(experiment)
                    .andExpect(status().isOk())
                    .andReturn();

        }

        @Test
        void deleteExperimentTest() throws Exception {

            MvcResult response = deleteExperiment(experiment)
                    .andExpect(status().isOk())
                    .andReturn();

            getExperiment(experiment).andExpect(status().isNotFound());

        }

        @Test
        void getExperimentTest() throws Exception {

            MvcResult response = getExperiment(experiment)
                    .andExpect(status().isOk())
                    .andReturn();

            Experiment actual = objectMapper.readValue(response.getResponse().getContentAsString(), Experiment.class);

            assertThat(actual).isEqualToComparingFieldByFieldRecursively(experiment);

        }
    }

    @Nested
    class UserTest {

        @Test
        void createUserTest() throws Exception {

            User user = new User("createUsertest@test.it", "createUserTest", "firebase", "user", "createUserTest");

            MvcResult response = createUser(user)
                    .andExpect(status().isOk())
                    .andReturn();

            User actual = objectMapper.readValue(getUser(user).andReturn().getResponse().getContentAsString(), User.class);
            deleteUser(user);
            assertThat(actual).isEqualToComparingFieldByFieldRecursively(user);
        }

        @Test
        void createUserNullEmailTest() throws Exception {

            User user = new User(null, "createUserTest", "firebase", "user", "createUserTest");

            MvcResult response = createUser(user)
                    .andExpect(status().isBadRequest())
                    .andReturn();
        }

        @Test
        void createUserNullTokenTest() throws Exception {

            User user = new User("createUserNullTokenTest@test.it", "createUserTest", "firebase", "user", "createUserTest");
            MvcResult response = createUser(user)
                    .andExpect(status().isOk())
                    .andReturn();

            User actual = objectMapper.readValue(getUser(user).andReturn().getResponse().getContentAsString(), User.class);
            deleteUser(user);
            assertThat(actual).isEqualToComparingFieldByFieldRecursively(user);
        }

        @Test
        void createUserNullRoleTest() throws Exception {

            User user = new User("createUserNullRoleTest@test.it", "createUserTest", null, null, "createUserTest");

            createUser(user).andExpect(status().isOk());
            User actual = objectMapper.readValue(getUser(user).andReturn().getResponse().getContentAsString(), User.class);

            deleteUser(user);
            assertThat(actual.getRole()).isEqualTo(USER_TYPE);
            assertThat(actual).isEqualToComparingFieldByFieldRecursively(user);
        }

        @Test
        void getUserTest() throws Exception {

            String userId = "getUserTest";
            User user = new User("getUserTest@test.it", userId, "token", "user", "createUserTest");

            createUser(user).andExpect(status().isOk());

            MvcResult response = getUser(user)
                    .andExpect(status().isOk())
                    .andReturn();

            User actual = objectMapper.readValue(response.getResponse().getContentAsString(), User.class);

            deleteUser(user);
            assertThat(actual).isEqualToComparingFieldByFieldRecursively(user);
        }

    }

    @Nested
    class TypesTest{

        @Test
        void getTypesTest() throws Exception {

            MvcResult response = mockMvc.perform(get("/v2/types")
                    .header("authorization", token))
                    .andExpect(status().isOk())
                    .andReturn();

        }
    }

    public ResultActions createUser(User user) throws Exception {

        ResultActions result = mockMvc.perform(post("/v2/user")
                .header("authorization",  token)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)));

        return result;
    }

    public ResultActions getUser(User user) throws Exception {

        ResultActions result = mockMvc.perform(get("/v2/user/{userId}", user.getSalt())
                .header("authorization",  token));

        return result;
    }

    public ResultActions deleteUser(User user) throws Exception {

        ResultActions result = mockMvc.perform(delete("/v2/user/{userId}", user.getSalt())
                .header("authorization", token));

        return result;
    }

    public ResultActions createExperiment(Experiment experiment) throws Exception {

        ResultActions result = mockMvc.perform(post("/v2/experiment")
                .header("authorization",  token)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(experiment)));

        return result;
    }

    public ResultActions getExperiment(Experiment experiment) throws Exception {

        ResultActions result = mockMvc.perform(get("/v2/experiment/{experimentId}", experiment.getId())
                .header("authorization",  token));

        return result;
    }

    public ResultActions deleteExperiment(Experiment experiment) throws Exception {

        ResultActions result = mockMvc.perform(delete("/v2/experiment/{experimentId}", experiment.getId())
                .header("authorization", token));

        return result;
    }
}