package groovy.fn

Functions f = new Functions();

println f.add(3, 4)

println f.addf(8)(5)

println f.applyf(f.add)(2)(7)

def fib = f.fibonaccif(0, 1)
print fib()
print fib()
print fib()
print fib()
print fib()
print fib()
print fib()