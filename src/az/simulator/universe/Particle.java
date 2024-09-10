package az.simulator.universe;

import lombok.Data;

@Data
public class Particle {
    private Vector coordinates;
    private Vector velocity;
    private double mass;

    public double getEnergy() {
        return 0.5 * mass * velocity.getLength2();
    }
}
