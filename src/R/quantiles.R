# Approximate quantiles CI based on asymptotic method from MKmisc

quantileCIApprox <- function(x, prob = 0.95, conf.level = 0.95) {
  alpha <- 1 - conf.level
  z <- qnorm(1-alpha/2)
  n <- length(x)
  xs <- sort(x)
  
  prob.sd <- sqrt(n*prob*(1-prob))
  k.lo <- max(1, floor(n*prob - z*prob.sd))
  k.up <- min(n, ceiling(n*prob + z*prob.sd))
  CI <- c(xs[k.lo], xs[k.up])
  CIapprox <- c(quantile(x, k.lo/n), quantile(x, k.up/n))
    
  list("CI" = CI, "CIapprox" = CIapprox)
}