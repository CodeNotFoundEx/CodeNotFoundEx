package c.prog;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TheaterChairsProblemTest {
    @Test
    public void testMaxSequence() {
        int[] prices = {10, 20, 30, 40, 50};
        int budget = 60;
        TheaterChairsProblem.Response result = TheaterChairsProblem.maxSequence(prices, budget);
        assertEquals(3, result.max()); // 10, 20, 30
        assertEquals(0, result.left());
        assertEquals(2, result.right());
        assertEquals(60, result.sum());

        budget = 100;
        result = TheaterChairsProblem.maxSequence(prices, budget);
        assertEquals(4, result.max()); // 10, 20, 30, 40
        assertEquals(0, result.left());
        assertEquals(3, result.right());
        assertEquals(100, result.sum());
        
        int[] prices2 = {50, 10, 10, 10, 50};
        budget = 35;
        result = TheaterChairsProblem.maxSequence(prices2, budget);
        assertEquals(3, result.max()); // 10, 10, 10
        assertEquals(1, result.left());
        assertEquals(3, result.right());
        assertEquals(30, result.sum());
    }

    @Test
    public void testEmptyPrices() {
        int[] prices = {};
        int budget = 100;
        TheaterChairsProblem.Response result = TheaterChairsProblem.maxSequence(prices, budget);
        assertEquals(0, result.max());
        assertEquals(0, result.sum());
    }

    @Test
    public void testBudgetTooSmall() {
        int[] prices = {10, 20, 30};
        int budget = 5;
        TheaterChairsProblem.Response result = TheaterChairsProblem.maxSequence(prices, budget);
        assertEquals(0, result.max());
        assertEquals(0, result.sum());
    }
}
