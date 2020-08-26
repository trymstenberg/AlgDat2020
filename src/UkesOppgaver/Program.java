package UkesOppgaver;

public class Program {


    static long fak(int n){
        int sum = 1;
        for (int i = n; i>0; i--){
            sum *= i;
        }
        return sum;
    }

}
