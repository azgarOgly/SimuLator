package az.simulator.universe;

import java.util.ArrayList;
import java.util.List;

public class Universe {
    private final List<Particle> particles = new ArrayList<>();

    public void update() {
        double timeStep = updateTimeStep(particles);
        updateVelocities(particles, timeStep);
        updateCoordinates(particles, timeStep);
    }

    public double getEnergy() {
        return particles.stream().mapToDouble(Particle::getEnergy).sum();
    }

    private void updateVelocities(List<Particle> particles, double timeStep) {
        for (int i = 0; i < particles.size(); i++) {
            Particle particle = particles.get(i);
            Vector acceleration = new Vector(0, 0, 0);
            for (int j = 0; j < particles.size(); j++) {
                if (i != j) {
                    Particle other = particles.get(j);
                    Vector distance = particle.getCoordinates().subtract(other.getCoordinates());
                    double distanceLength2 = distance.getLength2();
                    double accelerationScalar = other.getMass() / distanceLength2;
                    Vector accelerationVector = distance.multiply(accelerationScalar / distance.getLength());
                    acceleration = acceleration.add(accelerationVector);
                }
            }
            particle.setVelocity(particle.getVelocity().add(acceleration.multiply(timeStep)));
        }
    }

    private void updateCoordinates(List<Particle> particles, double timeStep) {
        particles
                .forEach(
                        particle -> particle.setCoordinates(
                                particle.getCoordinates().add(particle.getVelocity().multiply(timeStep))
                        )
                );
    }

    private double updateTimeStep(List<Particle> particles) {
        return 1;
    }
}
