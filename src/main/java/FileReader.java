import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public List<String> readBinayFile(File aInputFile) throws IOException
    {

        byte[] bytesFromFile = Files.readAllBytes(aInputFile.toPath());
        List<String> readedFile = new ArrayList<>();

        for(int i = 0;i<bytesFromFile.length;i++)
        {
            if(i % 2 == 0)
            {
                readedFile.add(String.format("%8s",Integer.toBinaryString(bytesFromFile[i] & 0xFF )).replace(" ","0"));
            }
        }
        return readedFile;
    }


}
