import spock.lang.IgnoreIf
import spock.lang.Specification

class ConditionallyIgnoredSpec extends Specification {

    @IgnoreIf({ os.macOs && jvm.java8 })
    def "this should not be executed"() {
        expect:
        false
    }
}