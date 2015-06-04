import spock.lang.Specification

class OptimizedSpec extends Specification {

    def "fast passing"() {
        expect:
        true
    }

    def "slow passing"() {
        expect:
        sleep(1000)
    }

    def "failing"() {
        expect:
        false
    }

    def "slow failing"() {
        given:
        sleep(1000)

        expect:
        false
    }

    def "sometimes failing"() {
        given:
        sleep(500)

        expect:
        System.currentTimeMillis() % 3
    }
}