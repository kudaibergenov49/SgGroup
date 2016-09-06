import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by Storm on 06.09.2016.
 * @author Kudaibergen Kuanysh
 */
public class SgGroup {
    public static void main(String[] args) {
        SAXParserFactory parser = SAXParserFactory.newInstance();
        Handler handler = new Handler();

        /*
        //Вводим название xml-файла
        */
        String fileName = args[0];//"2.xml";

        File file = new File(fileName);



        try {
            SAXParser saxparser = parser.newSAXParser();
            try {
                saxparser.parse(file, handler);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }


    }

}
