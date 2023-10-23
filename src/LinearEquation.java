public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;








    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;








    }








    public double distance() {
        double distanceEquation = Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
        return Math.round(distanceEquation * 100) / 100.0;
    }








    public double yIntercept() {
        double slope = slope();
        return y1 - (slope * x1);
    }








    public double slope() {
        double slopeUnrounded = (double) (y2-y1) / (x2-x1);
        return roundToHundredth(slopeUnrounded);
    }








    public String equation() {
        if (y1 == y2) {
            return "y = " + yIntercept();
        }
        String slope = (y2-y1) + "/" + (x2-x1) + "x ";
        String yInt = "+ " + yIntercept();

        boolean slopeWhole = Math.abs((y2 - y1)) % Math.abs((x2 - x1)) == 0;
        boolean yInterceptNeg = yIntercept() < 0;
        boolean slopeExact1 = slope() == 1;
        boolean slopeExactNeg1 = slope() == -1;
        boolean negOnDenominator = (x2 - x1) < 0;
        boolean bothNeg = (y2 - y1 < 0) && (x2 - x1 < 0);
        boolean zeroYIntercept = yIntercept() == 0;

        if (bothNeg && !slopeWhole) {
            slope = Math.abs(y2-y1) + "/" + Math.abs(x2-x1) + "x ";
        }
        if (negOnDenominator & !bothNeg) {
            slope = "-" + (y2-y1) + "/" + Math.abs(x2-x1) + "x ";
        }
        if (slopeWhole) {
            slope = (y2-y1)/(x2-x1) + "x ";
        }
        if (slopeExact1) {
            slope = "x ";
        }
        if (slopeExactNeg1) {
            slope = "-x ";
        }
        if (yInterceptNeg) {
            yInt = " - " + Math.abs(yIntercept());
        }
        if (zeroYIntercept) {
            yInt = "";
        }


        return "y = " + slope + yInt;
    }

    // coord for x here
    public String coordinateForX(double x) {
        double yValue = slope() * x + yIntercept();
        return "\nThe point on the line is (" + x + ", " + yValue + ")";
    }
    public String lineInfo() {
        return "\nThe two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\nThe equation of the line between these points is: " + equation() + "\nThe slope of this line is: " + slope() + "\nThe y-intercept of this line is: " + yIntercept() + "\nThe distance between these points is " + distance();
    }

    public boolean isSlopeDefined() {
        if (x1 == x2) {
            return false;
        }
        return true;
    }

    public String vertLine() {
        return "\nThese points are on a vertical line: x = " + x1;
    }








    private double roundToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }
}
