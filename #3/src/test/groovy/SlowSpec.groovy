import spock.lang.Specification

class SlowSpec extends Specification {
    @Slow
    def "a very slow test"() {
        expect:
        true
    }
}
