import static java.lang.Math.floor
import static java.lang.Math.sqrt

class PrimeNumbersExtension {
    static boolean isPrime(Integer value) {
        if (value <= 0) {
            return false
        }
        if (value <= 3) {
            return true
        }
        for (int divider : 2..floor(sqrt(value))) {
            if (value % divider == 0) {
                return false
            }
        }
        true
    }
}
