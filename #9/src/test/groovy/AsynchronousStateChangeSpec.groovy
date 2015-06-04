import spock.lang.Specification
import spock.util.concurrent.PollingConditions

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class AsynchronouslyInitialized {
    boolean initialized

    ExecutorService executor = Executors.newSingleThreadExecutor()

    void stop() {
        executor.shutdown()
    }

    void initialize() {
        executor.execute {
            sleep(1500)
            initialized = true
        }
    }
}

class AsynchronousStateChangeSpec extends Specification {

    def initializable = new AsynchronouslyInitialized()
    final conditions = new PollingConditions()

    def cleanup() {
        initializable.stop()
    }

    def "can use polling condition to test asynchronous events"() {
        when:
        initializable.initialize()

        then:
        conditions.eventually { initializable.initialized }
    }
}