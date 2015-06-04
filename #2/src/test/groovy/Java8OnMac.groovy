import groovy.transform.InheritConstructors

@InheritConstructors
class Java8OnMac extends Closure<Boolean> {
    Boolean doCall() {
        os.macOs && jvm.java8
    }
}
