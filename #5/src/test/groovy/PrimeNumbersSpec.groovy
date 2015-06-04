import spock.lang.Specification
import spock.lang.Unroll


class PrimeNumbersSpec extends Specification {

    @Unroll("#number is #status number")
    def "checking if number is a prime"() {
        expect:
        number.prime == isPrime

        where:
        number | isPrime
        -1     | false
        0      | false
        1      | true
        2      | true
        3      | true
        237    | false
        569    | true
        721    | false
        1049   | true

        status = isPrime ? "a prime" : "not a prime"
    }
}