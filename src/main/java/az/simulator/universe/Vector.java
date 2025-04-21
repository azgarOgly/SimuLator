package az.simulator.universe;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vector {

    private static final double TOLERANCE = 1e-6;
    private static final Vector ZERO = new Vector(0, 0, 0);

    private double x;
    private double y;
    private double z;

    public double getLength() {
        return Math.sqrt(x * x + y * y + z * z);
    }
    public double getLength2() {
        return x * x + y * y + z * z;
    }

    public Vector subtract(Vector other) {
        return new Vector(x - other.x, y - other.y, z - other.z);
    }
    public Vector add(Vector other) {
        return new Vector(x + other.x, y + other.y, z + other.z);
    }
    public Vector multiply(double factor) {
        return new Vector(x * factor, y * factor, z * factor);
    }
    public Vector normalize() {
        double length = getLength();
        return length == 0 ? ZERO : multiply(1/ length);
    }
    public boolean eq(Vector other) {
        if (other == null) { return false; }
        double length = Math.max(getLength(), other.getLength());
        double epsilon = length*TOLERANCE;
        return eq(other, epsilon);
    }
    public boolean eq(Vector other, double epsilon) {
        return subtract(other).getLength() <= epsilon;
    }
}
