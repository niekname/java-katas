package fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FizzBuzzTest {
    final FizzBuzz fizzBuzz = new FizzBuzz();


    @Test
    public void givenMultipleOfThree_printFizz() {
        assertEquals("Fizz", fizzBuzz.execute(3));
        assertEquals("Fizz", fizzBuzz.execute(6));
    }

    @Test
    public void givenMultipleOfFive_printBuzz() {
        assertEquals("Buzz", fizzBuzz.execute(5));
        assertEquals("Buzz", fizzBuzz.execute(10));
    }

    @Test
    public void givenMultipleOfFifteen_printFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz.execute(15));
        assertEquals("FizzBuzz", fizzBuzz.execute(30));
    }

    @Test
    public void givenANumberNotDivisableBy3or5_printIt() {
        assertEquals("1", fizzBuzz.execute(1));
        assertEquals("2", fizzBuzz.execute(2));
        assertEquals("4", fizzBuzz.execute(4));
        assertEquals("7", fizzBuzz.execute(7));
        assertEquals("11", fizzBuzz.execute(11));
    }
}