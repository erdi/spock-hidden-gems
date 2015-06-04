import spock.lang.AutoCleanup
import spock.lang.Specification

class ResourceWithClose implements AutoCloseable {
    @Override
    void close() throws Exception {
        println "close called"
    }
}

class ResourceWithStop {
    void stop() throws Exception {
        println "stop called"
    }
}

class AutoCloseableSpec extends Specification {

    @AutoCleanup regular = new ResourceWithClose()
    @AutoCleanup("stop") custom = new ResourceWithStop()

    def "some test using resources"() {
        expect:
        regular && custom
    }
}