import java.util.Arrays;
import java.util.List;

public class SacCalculator {


    public void calculate(List<String> aFunctions) {

        double[] sacValues = new double[8]; //Sac values for every function
        int arrayCounter = 0; // counter for every function, used only with sacValues array
        for (String function : aFunctions) {
            int result = 0; // how many times bits are different
            for (int i = 0; i < 256; i++) { // every function has 256 possible values

                for (int k = 0; k < 8; k++) // bit negation,
                {
                    int negation = i ^ (1 << k); // i with negate k bit
                    if (function.charAt(i) != function.charAt(negation)) // dumb XOR
                    {
                        result++;
                    }

                }

            }
            sacValues[arrayCounter++] =  100.00 * result / (256.0 * 8); // 100% * number of different bits / (number of possible values * number of arguments)
        }
        for(int i = 0;i<8;i++)
        {
            System.out.println("Sac of function " + i + ": " + sacValues[i]);
        }
        double sacAvg = Arrays.stream(sacValues)
                .average()
                .getAsDouble();

        System.out.println("Average SAC: " + sacAvg);
    }


}
