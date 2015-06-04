import spock.lang.IgnoreIf
import spock.lang.Specification

class DryConditionallyIgnoredSpec extends Specification {

    @IgnoreIf(Java8OnMac)
    def "this should not be executed"() {
        expect:
        false
    }
}