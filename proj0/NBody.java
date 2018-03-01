public class NBody {
    public static double readRadius(String planetsPath) {
        In in = new In(planetsPath);
        in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String planetsPath) {
        In in = new In(planetsPath);
        int planetNum = in.readInt();
        Planet[] planets = new Planet[planetNum];
        in.readDouble();
        for (int i = 0; i < planetNum; i++) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = "./images/" + in.readString();
            planets[i] = new Planet(xP, yP, xV, yV, mass, imgFileName);
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        double radius = readRadius(args[2]);
        Planet[] planets = readPlanets(args[2]);
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();

        for (Planet planet : planets) {
            planet.draw();
        }
        int planetNum = planets.length;
        double time = 0;
        while (time < T) {
            double[] xForces = new double[planetNum];
            double[] yForces = new double[planetNum];
            for (int i = 0; i < planetNum; i++) {
                double xForce = planets[i].calcNetForceExertedByX(planets);
                double yForce = planets[i].calcNetForceExertedByY(planets);
                xForces[i] = xForce;
                yForces[i] = yForce;

            }
            StdDraw.picture(0, 0, "./images/starfield.jpg");
            for (int i = 0; i < planetNum; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
                planets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            // System.out.println(time);
            time += dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", planets[i].xxPos, planets[i].yyPos,
                    planets[i].xxVel, planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}