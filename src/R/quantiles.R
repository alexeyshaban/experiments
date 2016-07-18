library(binom)

quantileCI <- function(x, prob, method, conf.level = 0.95) {
  int <- binom.confint(
    x = prob * length(x),
    n = length(x),
    methods = method,
    conf.level = conf.level)
  
  c(
    quantile(x, max(int$lower, 0)),
    quantile(x, min(int$upper, 1)))
}

testCI <- function(n, prob, method, conf.level = 0.95) {
  success = 0
  for (i in 1:n) {
    x = rexp(1000, 0.1)
    ci = quantileCI(x, prob, method, conf.level)
    uci = unname(ci)
    if (uci[1] < qexp(prob, 0.1) && uci[2] > qexp(prob, 0.1)) {
      success = success + 1
    }
  }
  success / n
}
