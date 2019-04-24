import java.util.List;

public class BalanceChecker {

    public void checkBalance(List<String> aFunctions)
    {
        for(int i = 0;i<aFunctions.size();i++)
        {
            System.out.println("Function " + i +":");
            System.out.println(aFunctions.get(i));
            int length = aFunctions.get(i).length();
            int amountOfOnes = aFunctions.get(i).replace("0","").length();
            int amountOfZeroes = length - amountOfOnes;

            if(amountOfZeroes == amountOfOnes)
            {
                System.out.println("Function " + i +" is balanced. Amount of 0 is " + amountOfZeroes
                        + " and amount of 1 is " + amountOfOnes + "\n");
            }else
            {
                System.out.println("Function " + i +" isn't balanced. Amount of 0 is " + amountOfZeroes
                        + " and amount of 1 is " + amountOfOnes + "\n");
            }

        }
    }

}
