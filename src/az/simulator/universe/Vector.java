package az.simulator.universe;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vector {
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
}
