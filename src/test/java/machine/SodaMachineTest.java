package machine;
import exceptions.MyException;
import exceptions.NotEnoughMoneyException;
import jdk.nashorn.internal.codegen.types.Type;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.data.Offset;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import prime.PrimeNumberUtilis;
import primeNumbers.PrimeNumbersTest;
import sodaMachine.DrinkStatus;
import sodaMachine.SodaMachine;
import sodaMachine.SodaNames;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;

@RunWith(JUnitParamsRunner.class)
public class SodaMachineTest {
    private static Logger log = LoggerFactory.getLogger(PrimeNumbersTest.class);

    @Test
    @Parameters({"3.99, 5.0",
                "4.99, 5.00",
                "0.99, 4.0",
                "99.98, 99.99" })
    public void shouldSellSodaWhenBalanceIsMoreThanPrice(double price, double balance) throws Exception{
        //given
        SodaMachine sodaMachine = new SodaMachine();

        //when
        //todo logika
        double isSold = sodaMachine.sell(price, balance);

        //then
        assertThat(isSold).isLessThan(balance);
    }

    @Test
    @Parameters({"10.00, 5.0",
             })
    public void shouldAskForMoneyWhenBalanceIsLessThanPrice(double price, double balance) throws Exception{
        //given
        SodaMachine sodaMachine = new SodaMachine();

        //when
        //todo logika
        double restOfMoney = sodaMachine.sell(price, balance);

        //then
        assertThat(restOfMoney).isEqualTo(balance);
    }

    @Test
    @Parameters({"1, 5.0, Coke",
            "2, 5.0, Sprite",
            "3, 5.0, Beer",
            "4, 5.0, Water"
    })
    public void shouldReturnSoda(double price, double balance, String sodaName) {
        //given
        SodaMachine sodaMachine = new SodaMachine();

        //when
        String nameOfSoda = sodaMachine.payAndGetSoda(price, balance);

        //then
        assertThat(nameOfSoda).isEqualTo(sodaName);
    }

    @Test
    public void shouldSellCokeIfEnoughMoney() {
        //given
        double balance = 5.00;
        String drinkToBuy = "COKE";
        SodaMachine sodaMachine = new SodaMachine();

        //when
        DrinkStatus drinkStatus = sodaMachine.sell(drinkToBuy, balance);

        //then
        assertThat(drinkStatus.getBalanceAfterDrink()).isEqualTo(4.0);
        assertThat(drinkStatus.getBoughtDrink()).isEqualTo(SodaNames.COKE);
    }

    @Test
    @Parameters({"5.90,Coke,4.90",

            "1.00,Coke,0.00",

            "5.90,Beer,2.90",

            "5.99,Water,1.99",

            "5.10,Sprite,3.10"})

    public void shouldSellCokeIfEnoughMoney(double balance, String drinkToBuy, double change) {

        //given
        drinkToBuy = drinkToBuy.toUpperCase();
        SodaMachine sodaMachine = new SodaMachine();
        //when

        DrinkStatus drinkStatus = sodaMachine
                .sell(drinkToBuy, balance);

        //then

        assertThat(drinkStatus
                .getBalanceAfterDrink()).isCloseTo(change, Offset.offset(0.1));
        assertThat(drinkStatus
                .getBoughtDrink().getSodaName()).isEqualTo(drinkToBuy);

    }

//    @Test
//
//    @Parameters({"5.90,Coke,4.90",
//
//            "1.00,Coke,0.00",
//
//            "5.90,Beer,3.90",
//
//            "5.99,Water,3.40",
//
//            "5.10,Sprite,3.10"})

//    public void shouldSellCokeIfEnoughMoney(double balance, Player drinkToBuy, double change) {
//
//        //given
//
//        SodaMachine sodaMachine = new SodaMachine();
//        //when
//
//        DrinkStatus drinkStatus = sodaMachine
//
//                .sell(drinkToBuy, balance);
//
//        //then
//
//        assertThat(drinkStatus
//
//                .getBalanceAfterDrink()).isEqualTo(change);
//
//        assertThat(drinkStatus
//
//                .getBoughtDrink().getValue()).isEqualTo(drinkToBuy);
//
//    }    //docelowy dzialajacy test w pelni dzialajacej uslugi przypadki jak brakuje pieniedzy
//
//    @Test
//
//    @Parameters({"0.90,Coke",
//
//            "0.00,Coke",
//
//            "1.90,Beer",
//
//            "0.99,Water",
//
//            "1.10,Sprite"})
//
//    public void shouldNotSellCokeIfNotEnoughMoney(double balance, Player drinkToBuy) {
//
//        //given
//
//        SodaMachine sodaMachine = new SodaMachine();
//        //when
//
//        DrinkStatus drinkStatus = sodaMachine
//
//                .sell(drinkToBuy, balance);
//
//        //then
//
//        assertThat(drinkStatus
//
//                .getBalanceAfterDrink()).isEqualTo(balance);
//
//        assertThat(drinkStatus
//
//                .getBoughtDrink()).isNull();
//
//    }

}
