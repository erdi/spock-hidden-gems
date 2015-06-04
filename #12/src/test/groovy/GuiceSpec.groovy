import com.google.inject.AbstractModule
import spock.guice.UseModules
import spock.lang.Specification

import javax.inject.Inject

class TestModule extends AbstractModule {

    protected void configure() {
        bind(String).toInstance("foo")
    }
}

@UseModules(TestModule)
class GuiceSpec extends Specification {
    @Inject
    String injected

    def "injection from module"() {
        expect:
        injected == "foo"
    }
}