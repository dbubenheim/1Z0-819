package de.dbubenheim.learning;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomTest {

    @Test
    public void testDoubles() {
        Random random = new Random();
        long count = random.doubles().limit(10).count();
        assertThat(count).isEqualTo(10);
    }

    @Test
    public void testInts() {
        Random random = new Random();
        long count = random.ints(116).count();
        assertThat(count).isEqualTo(116);
    }

    @Test
    public void testLongs() {
        Random random = new Random();
        long count = random.longs(321).count();
        assertThat(count).isEqualTo(321);
    }

    @Test
    public void testNextBoolean() {
        Random random = new Random();
        boolean nextBoolean = random.nextBoolean();
        assertThat(nextBoolean).isInstanceOf(Boolean.class);
    }

    @Test
    public void testNextFloat() {
        Random random = new Random();
        float nextFloat = random.nextFloat();
        assertThat(nextFloat).isInstanceOf(Float.class);
    }

    @Test
    public void testNextInt() {
        Random random = new Random();
        int nextInt = random.nextInt();
        assertThat(nextInt).isInstanceOf(Integer.class);
    }

    @Test
    public void testNextDouble() {
        Random random = new Random();
        double nextDouble = random.nextDouble();
        assertThat(nextDouble).isInstanceOf(Double.class);
    }
}
