import java.util.ArrayList;
import java.util.List;

public class FunctionsCreator {

    private final static int NUMBER_OF_FUNCTIONS = 8;

    public List<String> createFunctions(List<String> aValuesFromFile)
    {
        List<String> functions = new ArrayList<>();
        StringBuilder[] stringBuilders = new StringBuilder[8];
        for(int i = 0;i<NUMBER_OF_FUNCTIONS;i++)
        {
            stringBuilders[i] = new StringBuilder();
        }
        for(int i = 0;i<aValuesFromFile.size();i++)
        {
            String s = aValuesFromFile.get(i);
            for(int j = 0;j<NUMBER_OF_FUNCTIONS;j++)
            {
                stringBuilders[j].append(s.charAt(j));
            }
        }
        for(int i = NUMBER_OF_FUNCTIONS - 1;i>=0;i--)
        {
            functions.add(stringBuilders[i].toString());
        }

        return functions;

    }


}
