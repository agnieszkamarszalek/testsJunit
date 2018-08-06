package primeNumbers;

import exceptions.MyException;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import prime.PrimeNumberUtilis;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;

@RunWith(JUnitParamsRunner.class)
public class PrimeNumbersTest {
    private static Logger log = LoggerFactory.getLogger(PrimeNumbersTest.class);
    @Test
    void shouldCheckIf5IsPrimeNumber() {
        //given
        int number = 5;
        PrimeNumberUtilis primeNumberUtilis = new PrimeNumberUtilis();

        //when
        boolean isPrime = primeNumberUtilis.isPrime(number);

        //then
        assertThat(isPrime).isTrue();
    }

    @Test
    void shouldCheckIf2IsPrimeNumber() {
        //given
        int number = 2;
        PrimeNumberUtilis primeNumberUtilis = new PrimeNumberUtilis();

        //when
        boolean isPrime = primeNumberUtilis.isPrime(number);

        //then
        assertThat(isPrime).isTrue();
    }

    @Test
    void shouldCheckIf1IsPrimeNumber() {
        //given
        int number = 1;
        PrimeNumberUtilis primeNumberUtilis = new PrimeNumberUtilis();

        //when
        boolean isPrime = primeNumberUtilis.isPrime(number);

        //then
        assertThat(isPrime).isFalse();
    }

    @Test
    void shouldCheckIf4IsPrimeNumber() {
        //given
        int number = 4;
        PrimeNumberUtilis primeNumberUtilis = new PrimeNumberUtilis();

        //when
        boolean isPrime = primeNumberUtilis.isPrime(number);

        //then
        assertThat(isPrime).isFalse();
    }

    @Test
    void shouldCheckIf3IsPrimeNumber() {
        //given
        int number = 3;
        PrimeNumberUtilis primeNumberUtilis = new PrimeNumberUtilis();

        //when
        boolean isPrime = primeNumberUtilis.isPrime(number);

        //then
        assertThat(isPrime).isTrue();
    }

    @Test
    @Parameters({"1, false",
                    "2, true",
                    "3, true",
                    "4, false",
                    "5, true"})
    public void shouldCheckIfNumberIsPrime(int number, boolean valid){
        PrimeNumberUtilis primeNumberUtilis = new PrimeNumberUtilis();
        boolean prime = primeNumberUtilis.isPrime(number);
        assertThat(prime).isEqualTo(valid);
    }

    @Test//(expected = MyException.class)-> other example
    public void shouldThrowsExceptionIfNumberIsLessThan2() throws MyException{
        //given
        final PrimeNumberUtilis primeNumberUtilis = new PrimeNumberUtilis();

        //when
        //boolean prime = primeNumberUtilis.isPrimeWithException(-3);

        //then
        assertThatThrownBy(()-> primeNumberUtilis.isPrimeWithException(-10))
                .isInstanceOf(MyException.class)
                .hasMessage("Number can't be less than 2");


        //assertThat(prime).isTrue();

    }

}
