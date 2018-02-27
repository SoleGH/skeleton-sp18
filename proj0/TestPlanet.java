public class TestPlanet {
    public static void main(String[] args) {
        checkPairwiseForce();
    }

    private static void checkPairwiseForce() {
        System.out.println("checking PairwiseForce...");
        Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Planet p2 = new Planet(2.0, 2.0, 4.0, 5.0, 7.0, "jupiter.gif");

        double f1x = p1.calcForceExertedByX(p2);
        double f1y = p1.calcForceExertedByY(p2);
        double f2x = p2.calcForceExertedByX(p1);
        double f2y = p2.calcForceExertedByY(p1);
        double sumx = f1x + f2x;
        double sumy = f1y + f2y;
        checkEquals(0.0, sumx, "pairwise force between two planets in X direction are opposite number", 0.01);
        checkEquals(0.0, sumy, "pairwise force between two planets in Y direction are opposite number", 0.01);
    }

    private static void checkEquals(double expected, double actual, String label, double eps) {
        if (Math.abs(expected - actual) <=  Math.abs(eps)) {
            System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
        }
    }
}