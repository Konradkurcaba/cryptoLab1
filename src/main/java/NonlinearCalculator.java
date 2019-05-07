import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NonlinearCalculator {

    public void calcuate(List<String> aFunctionsFromFile) {

        int[][] values = new int[8][256]; // [function From File][linear function number] - how many times value of linear function == value of function from file
        for (int b = 0;b<256;b++) {  // all arguments
            String arguments = createBinaryString(b);
            for (int i = 0; i < 256; i++) { // all linear functions
                int result = 0; // result of i function
                String function = createBinaryString(i); // which arguments are considered
                for (int k = 0; k < 8; k++) {
                    if (function.charAt(k) == '1') { //if it is considered argument
                        int functionValueOnKBit = Integer.parseInt(Character.toString(arguments.charAt(k)));  // argument on this bit
                        if (result != functionValueOnKBit) // dumb XOR
                        {
                            result = 1;
                        }else result = 0;
                    }
                }
                for(int k = 0;k<8;k++)
                {
                    if(Integer.parseInt(Character.toString(aFunctionsFromFile.get(k).charAt(i))) == result) // if k function from file has the same result as i linear function
                    {
                        values[k][b]++;
                    }
                }

            }
        }
        for(int i = 0;i<8;i++) {
            int min = Arrays.stream(values[i])
                    .min()
                    .getAsInt();
            System.out.println("Nonlinear of function " + i +": " + min);
        }

    }


    /**
     * @param aIntToConversion
     * @return String converted from int. It always has 8 digits
     */
    private String createBinaryString(int aIntToConversion)
    {
        StringBuilder builder = new StringBuilder();
        int numberOfzeroes = 8 - Integer.toBinaryString(aIntToConversion).length();
        for(int i = 0;i<numberOfzeroes;i++)
        {
            builder.append("0");
        }
        builder.append(Integer.toBinaryString(aIntToConversion));

        return builder.toString();
    }

}
