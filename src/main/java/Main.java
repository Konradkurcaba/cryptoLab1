import java.io.File;
import java.util.List;

public class Main {

    public static void main(String... args)
    {
        try {
            String fileName = args[0];

            File file = new File(fileName);
            FileReader reader = new FileReader();
            List<String> readedFile = reader.readBinayFile(file);

            FunctionsCreator functionsCreator = new FunctionsCreator();
            List<String> functions = functionsCreator.createFunctions(readedFile);

            BalanceChecker balanceChecker = new BalanceChecker();
            balanceChecker.checkBalance(functions);

            NonlinearCalculator calculator = new NonlinearCalculator();
            calculator.calcuate(functions);

            SacCalculator sacCalculator = new SacCalculator();
            sacCalculator.calculate(functions);

        }catch (Exception aEx)
        {
            System.out.println("Error during processing file");
        }

    }

}
