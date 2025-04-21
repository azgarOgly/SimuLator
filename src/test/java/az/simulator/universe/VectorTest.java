package az.simulator.universe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VectorTest {
    @Test
    public void testGetLength() {
        Vector vector = new Vector(3, 4, 0);
        assertEquals(5.0, vector.getLength(), 0.001);
    }
    @Test
    public void testGetLength2() {
        Vector vector = new Vector(3, 4, 0);
        assertEquals(25.0, vector.getLength2(), 0.001);
    }
    @Test
    public void testZeroLength() {
        Vector vector = new Vector(0, 0, 0);
        assertEquals(0.0, vector.getLength(), 0.001);
    }
    @Test
    public void testZeroLength2() {
        Vector vector = new Vector(0, 0, 0);
        assertEquals(0.0, vector.getLength2(), 0.001);
    }
    @Test
    public void testSubtract() {
        Vector vector1 = new Vector(5, 6, 7);
        Vector vector2 = new Vector(3, 2, 1);
        Vector result = vector1.subtract(vector2);
        assertEquals(new Vector(2, 4, 6), result);
    }
    @Test
    public void testAdd() {
        Vector vector1 = new Vector(1, 2, 3);
        Vector vector2 = new Vector(4, 5, 6);
        Vector result = vector1.add(vector2);
        assertEquals(new Vector(5, 7, 9), result);
    }
    @Test
    public void testMultiply() {
        Vector vector = new Vector(1, 2, 3);
        double factor = 2;
        Vector result = vector.multiply(factor);
        assertEquals(new Vector(2, 4, 6), result);
    }
    @Test
    public void testMultiplyZero() {
        Vector vector = new Vector(1, 2, 3);
        double factor = 0;
        Vector result = vector.multiply(factor);
        assertEquals(new Vector(0, 0, 0), result);
    }
    @Test
    public void testMultiplyNegative() {
        Vector vector = new Vector(1, 2, 3);
        double factor = -1;
        Vector result = vector.multiply(factor);
        assertEquals(new Vector(-1, -2, -3), result);
    }
    @Test
    public void testNormalize() {
        Vector vector = new Vector(3, 4, 0);
        Vector normalized = vector.normalize();
        assertTrue(new Vector(0.6, 0.8, 0).eq(normalized));
        assertEquals(1.0, normalized.getLength(), 0.001);
    }
    @Test
    public void testNormalizeZero() {
        Vector vector = new Vector(0, 0, 0);
        assertEquals(new Vector(0, 0, 0), vector.normalize());
    }
    @Test
    public void testEq() {
        Vector v = new Vector(1, 2, 3);
        Vector other = new Vector(1, 2, 3);
        assertTrue(v.eq(other));
        assertTrue(v.eq(v));
        assertTrue(v.eq(new Vector(1.0000001, 2, 3)));
        assertFalse(v.eq(new Vector(1.00001, 2, 3)));
        assertTrue(new Vector(0,0, 0).eq(new Vector(0,0,0)));
        assertFalse(new Vector(0,0, 0).eq(new Vector(0.00000001,0,0)));
    }
}
