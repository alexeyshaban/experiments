package groovy.fn

class Functions {
    def add = {a, b ->  a + b}

    def addf = {a -> {b -> a + b}}

    def applyf = {f -> {a -> {b -> f(a, b)}}}

    def fibonaccif = {a, b ->
        {
            ->
            def tmp = a;
            a = b;
            b += tmp;
            return tmp;
        }
    }
}
