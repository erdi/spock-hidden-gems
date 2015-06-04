import spock.lang.Specification
import spock.util.concurrent.BlockingVariable

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.function.Consumer

class AsynchronousService {
    ExecutorService executor = Executors.newSingleThreadExecutor()

    void stop() {
        executor.shutdown()
    }

    void reverse(String message, Consumer<String> handler) {
        executor.execute {
            sleep(500)
            handler.accept(message.reverse())
        }
    }
}

class AsynchronousEventsSpec extends Specification {

    def result = new BlockingVariable<String>()
    def service = new AsynchronousService()

    def cleanup() {
        service.stop()
    }

    def "can use blocking variables to test asynchronous events"() {
        when:
        service.reverse("groovy") { result.set(it) }

        then:
        result.get() == "yvoorg"
    }
}