package team.common;


import team.PushApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { PushApplication.class })
public class CucumberSpingConfiguration {
    
}
