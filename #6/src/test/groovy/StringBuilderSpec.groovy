import spock.lang.Specification


class StringBuilderSpec extends Specification {

    def "can use old() to test for a state change regardless of what the initial state is"() {
        given:
        def builder = new StringBuilder("a" * new Random().nextInt(100))

        when:
        builder.append("a")

        then:
        builder.size() == old(builder.size()) + 1
    }
}