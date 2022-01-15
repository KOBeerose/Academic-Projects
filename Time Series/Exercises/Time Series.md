# Time Series

# **Assignment**

### Exercise 1:

Consider the process $ARMA(1,1)$: $(1−ϕB)Xt=(1−θB)at$

 with 𝜙 being two reals and 𝜃 being two reals; |𝜃| < 1, |𝜙| < 1, at is white noise (0.σ2)

*1. Show that there is an absolutely convergent series $\sum_{k=1}^{\infty} b_k$ such that the optimal prediction of process $X_t$ at date $t + 1$ is
$\hat{X}_{t+1} = \sum_{k=1}^{\infty}b_k\hat{X}_{t+1-k}$*

We have $\frac{(1−ϕB)}{(1−θB)}X_t = a_t$

⇒ $\sum_{k=0}^{\infty}θ^k{X}_{tk} - ϕ\sum_{k=0}^{\infty}θ^k{X}_{tk-1} = a_t$

⇒ $X_t + \sum_{k=1}^{\infty}θ^k{X}_{tk} - \sum_{p=1}^{\infty}ϕ.θ^{p-1}{X }_{tp} = a_t$

⇒ $X_{t+1} = a_{t+1} - \sum_{k=1}^{\infty}(θ-ϕ)θ^{k-1}{X}_{t-k+1 }$

⇒ $\hat{X}_{t+1} = \sum_{k=1}^{\infty} -(θ-ϕ)θ^{k-1}{X}_{t-k+1} $

and since $t-k+1 \ge 0 \Rightarrow k \le t+1$

then: $\hat{X}_{t+1} = \sum_{k=1}^{\infty} b_k{X}_{t-k+1}$

with $b_k = -(θ-ϕ)θ^{k-1}$ and $\sum_{k=1}^{\infty}b_k$ and convergent because $|θ|\lt 1$

*2. Calculate the best forecast for* ${X}_{2012}, {X}_{2013}$

$\hat{X}_{2012}= -(θ-ϕ)({X}_{2012}+θ{X}_{2010}+θ^2{X}_{2009}+θ^3{ X}_{2008}++θ^4{X}_{2007})$

$= -(0.413047-0.495639)(2.4 + 0.413047\times 2.2+(0.413047)^2\times3.2+(0.413047)^3\times1.9+(0.413047)^4\times1.5)$
<br>

>$\hat{X}_{2012}= 0.336$
<br>

Same for $\hat{X}_{2013}$ :
<br>

>$\hat{X}_{2013}= 0.167$


### Exercise 2:

*Calculate the best prediction, the variance of the prediction error, and the confidence interval (95%) for each of $X_{2012}, X_{2013}, X_{2014}$*



We have: $X_t = μ + ϕX_{t-1}+ a_t$

⇒ $E(X_t) = μ + ϕE(X_t)$

⇒ $(1-ϕ)E(X_t) = μ$

⇒ $E(X_t) = \frac{μ} {(1-ϕ)}=ct$

So: $μ=ct(1-ϕ)$

$= 7.125 \times(1-0.298)$

$μ= $5

And we have $\hat{X}_{n+1} = μ + + ϕX_n$

⇒ $\hat{X}_{2012} = 5 + + 0.298 \times X_{2011}$

>$\hat{X}_{2012} = 8.1$

⇒ $\hat{X}_{2013} = 5 + + 0.298 \times X_{2012}$

>$\hat{X}_{2012} = 7.42$

⇒ $\hat{X}_{2014} = 5 + + 0.298 \times X_{2013}$

>$\hat{X}_{2012} = 7.22$

Since $a_t \sim N(0,1)$ therefore $z_{1-\frac{ {\alpha }}{2}} = 1.96$

So: $IC_{2012} = [\hat{X}_{2012}\pm z_{1-\frac{ {\alpha }}{2}}] = [6.14;10.06]$

$IC_{2013} = [\hat{X}_{2013}\pm z_{1-\frac{ {\alpha }}{2}} \sqrt{1+0.298^2}] = [5.36;9.46] $

$IC_{2014} = [\hat{X}_{2014}\pm z_{1-\frac{ {\alpha }}{2}} \sqrt{1+0.298^2+0.298^4}] = [ 5.16;9.26]$