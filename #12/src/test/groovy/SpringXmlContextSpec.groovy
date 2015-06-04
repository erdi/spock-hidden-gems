import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration("/application-context.xml")
class SpringXmlContextSpec extends Specification {

    @Autowired
    String injected

    def "injection from xml context"() {
        expect:
        injected == "foo"
    }
}