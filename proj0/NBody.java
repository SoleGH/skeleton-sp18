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
            String imgFileName = in.readString();
            planets[i] = new Planet(xP, yP, xV, yV, mass, imgFileName);
        }
        return planets;
    }
}