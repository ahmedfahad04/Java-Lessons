package Previos_Practice;// shows how to impose type restrictions while using generics.(Bounded Type)
// ==> <T extends Number>

public class part3<T extends Number> {
    T[] nums;

    public part3(T[] x){
        nums = x;
    }

    double avg(){
        double sum = 0.0;

        for(T a: nums){
            sum += a.doubleValue();
            System.out.println(a);
        }

        return (sum/nums.length);
    }

}
