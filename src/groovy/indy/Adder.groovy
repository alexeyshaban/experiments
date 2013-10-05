package groovy.indy

class Adder {
    def add(a, b) {
        return a + b
    };

    def f() {
        def a = 5;
        def b = Math.random() < 0.5 ? "23" : 2.3;
        return add(a, b);
    }
}
