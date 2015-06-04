import org.junit.Rule
import org.junit.rules.TemporaryFolder
import spock.lang.Specification

class TemporaryFolderSpec extends Specification {

    @Rule TemporaryFolder tempDir

    def "using a temporary dir in a test"() {
        given:
        def file = tempDir.newFile()

        when:
        file << "foo"

        then:
        file.text == "foo"
    }
}