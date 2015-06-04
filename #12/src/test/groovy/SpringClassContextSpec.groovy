import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@Configuration
class TestApplicationContext {
    @Bean
    String injected() {
        "foo"
    }
}

@ContextConfiguration(classes = TestApplicationContext)
class SpringClassContextSpec extends Specification {

    @Autowired
    String injected

    def "injection from configuration class"() {
        expect:
        injected == "foo"
    }
}