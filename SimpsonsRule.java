// Simpson's rule - Approximates the definite integral of f from a to b.
public static double SimpsonsRule(double a, double b, double s, int n) {
        double simpson, dx, x, sum4x, sum2x;

        dx = (b-a) / n;
        sum4x = 0.0;
        sum2x = 0.0;

        // 4/3 terms
        for (int i = 1; i < n; i += 2) {
        x = a + i * dx;
        sum4x += function(x,s);
        }

        // 2/3 terms
        for (int i = 2; i < n-1; i += 2) {
        x = a + i * dx;
        sum2x += function(x,s);
        }

        // Compute the integral approximation.
        simpson = function(a,s) + function(a,b);
        simpson = (dx / 3)*(simpson + 4 * sum4x + 2 * sum2x);
        return simpson;
        }

// Handles the error for for f(x) = t^s * sech(t)^2. The integration is
// done from 0 to 100.
// Stop Simspson's Method when the relative error is less than 1 * 10^-6
public static double SimpsonError(double a, double b, double s, int n)
        {
        double futureVal;
        double absError = 1.0;
        double finalValueOfN;
        double numberOfIterations = 0.0;
        double currentVal = SimpsonsRule(a,b,s,n);

        while (absError / currentVal > 0.000001) {
        n = 2*n;
        futureVal = SimpsonsRule(a,b,s,n);
        absError = Math.abs(futureVal - currentVal) / 15;
        currentVal = futureVal;
        }

        // Find the number of iterations. N starts at 8 and doubles every iteration.
        finalValueOfN = n / 8;
        while (finalValueOfN % 2 == 0) {
        finalValueOfN = finalValueOfN / 2;
        numberOfIterations++;
        }
        System.out.println("The number of iterations is " + numberOfIterations + ".");
        return currentVal;
        }