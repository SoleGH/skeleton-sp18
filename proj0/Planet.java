public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double caldx(Planet planet) {
        return planet.xxPos - xxPos;
    }

    public double caldy(Planet planet) {
        return planet.yyPos - yyPos;
    }

    /** calculates the distance between two Planets. */
    public double calcDistance(Planet planet) {
        double dx = caldx(planet);
        double dy = caldy(planet);
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet planet) {
        double r = calcDistance(planet);
        return (G * mass * planet.mass) / (r * r);
    }

    public double calcForceExertedByX(Planet planet) {
        double dx = caldx(planet);
        double f = calcForceExertedBy(planet);
        double r = calcDistance(planet);
        return (f * dx) / r;
    }

    public double calcForceExertedByY(Planet planet) {
        double dy = caldy(planet);
        double f = calcForceExertedBy(planet);
        double r = calcDistance(planet);
        return (f * dy) / r;
    }

    /**calculates netforce of x */
    public double calcNetForceExertedByX(Planet[] planets) {
        double netForceX = 0;
        for (Planet planet : planets) {
            if (this != planet) {
                netForceX += calcForceExertedByX(planet);
            }
        }
        return netForceX;
    }

    /**calculates netforce of y */
    public double calcNetForceExertedByY(Planet[] planets) {
        double netForceY = 0;
        for (Planet planet : planets) {
            if (this != planet) {
                netForceY += calcForceExertedByY(planet);
            }
        }
        return netForceY;
    }

    /**update position of planet */
    public void update(double dt, double fX, double fY) {
        double ax = fX / mass;
        double ay = fY / mass;
        xxVel += dt * ax;
        yyVel += dt * ay;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }
}