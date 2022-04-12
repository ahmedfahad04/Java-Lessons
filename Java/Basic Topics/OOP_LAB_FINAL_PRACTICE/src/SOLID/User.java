package SOLID;

public class User extends Calculator{

    public static void main(String[] args) {

        Calculator casio = new Calculator();
        AdvanceCalc advc = new Calculator();
        advc.differentialSolve();   // simple interface example or can be said as interface segregated principal followed

        // these lines of code maintain dependency inversion principal
        NormalCalc casio570 = new Calculator();
        NormalCalc xiaomiAge = new AgeCalculator();
        casio570.finalResult();
        xiaomiAge.finalResult();


    }

}
