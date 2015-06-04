import spock.lang.Specification

class ClassUnderTest {
    Collaborator collaborator
    Listener listener

    void process() {
        collaborator.start()
        collaborator.allGood ? listener.success() : listener.failure()
        collaborator.stop()
    }
}

interface Collaborator {
    void start()
    boolean isAllGood()
    void stop()
}

interface Listener {
    void success()
    void failure()
}

class MocksAndStubsSpec extends Specification {

    def collaborator = Mock(Collaborator)
    def listener = Mock(Listener)
    def tested = new ClassUnderTest(collaborator: collaborator, listener: listener)

    def "stubs are not taken into consideration when using strict mocking"() {
        given:
        collaborator.allGood >> true

        when:
        tested.process()

        then:
        1 * listener.success()
        0 * _
    }
}