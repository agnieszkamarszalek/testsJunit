package prime;

import exceptions.MyException;

public class PrimeNumberUtilis {
    public boolean isPrime(int number) {

        if(number==1) {return false;}
        for (int i = 2; i < number ; i++) {
            double modulo = number%i;
            if(modulo==0){
                return false;
            }
        }
        return true;
}

    public boolean isPrimeWithException(int number) throws MyException {

        if(number < 2) {throw new MyException("Number can't be less than 2");}

        for (int i = 2; i < number ; i++) {
            double modulo = number%i;
            if(modulo==0){
                return false;
            }
        }
        return true;
    }
}
