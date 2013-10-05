function add(a, b) {
	return a + b;
}

function mul(a, b) {
	return a * b;
}

function sub(a, b) {
	return a - b;
}

function identityf(a) {
	return function() {
		return a;
	}
}

function addf(a) {
	return function(b) {
		return a + b;
	}
}

// applyf(add)(3)(4) = 7
function applyf(f) {
	return function(a) {
		return function(b) {
			return f(a, b);
		}
	}
}

function curry(f, a) {
	return function(b) {
		return f(a, b)
	}
}

function curry(f, a) {
	return applyf(f)(a);
}

inc = addf(1)

inc = applyf(add)(1)

inc = curry(add, 1)

function twice(f) {
	return function(a) {
		return f(a, a)
	}
}

function switcheroo(f) {
	return function(a, b) {
		return f(b, a)
	}
}

doubl = twice(add)

square = twice(mul)

// composeu(doubl, square)(3) = 36
function composeu(f, g) {
	return function(a) {
		return g(f(a))
	}
}

// composeb(add, mul)(2, 3, 5) = 25
function composeb(f, g) {
	return function(a, b, c) {
		return g(f(a, b), c)
	}
}

function once(f) {
	return function(a, b) {
		if (f) {
			var result = f(a, b)
			f = null // save memory
			return result
		}
		return "error"
	}
}

function counterf(a) {
	return {
		inc : function() {
			return ++a;
		},
		dec : function() {
			return --a;
		}
	}
}

function revocalbe(f) {
	return {
		invoke : function(a) {
			return f ? f(a) : "error"
		},
		revoke : function() {
			f = null;
		}
	}
}

// gen = gensymf("G")
// gen(), ...
function gensymf(prefix) {
	var suffix = 0;
	return function() {
		return prefix + (++suffix);
	}
}

// var fib = fibonaccif(0, 1)
// fib() = 0, ...
function fibonaccif(a, b) {
	return function() {
		var tmp = a;
		a = b;
		b += tmp;
		return tmp;
	}
}