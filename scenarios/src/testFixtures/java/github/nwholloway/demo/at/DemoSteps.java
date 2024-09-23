package github.nwholloway.demo.at;

import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

public class DemoSteps {

    private final RestTemplate restTemplate;

    public DemoSteps(@Value("http://localhost:${local.server.port}") String rootUri) {
        restTemplate = new RestTemplateBuilder()
                .rootUri(rootUri)
                .build();
    }

    @Then("application home page is")
    public void applicationHomePageIs(String expected) {
        String homePage = restTemplate.getForObject("/", String.class);

        assertThat(homePage).isEqualTo(expected);
    }
}
