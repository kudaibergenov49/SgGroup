import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.equalsAnyIgnoreCase;
import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;


@AllArgsConstructor
@NoArgsConstructor
class Reader implements Runnable {

    private String fileName;

    @SneakyThrows
    public void run() {
        try (InputStream inputStream = new FileInputStream(fileName)) {
            XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(fileName, inputStream);
            List<Double> sides = new ArrayList<>();
            StringBuilder color = new StringBuilder();
            boolean readColor = false;
            int number = 0;

            while (reader.hasNext()) {
                reader.next();
                if (reader.isStartElement()) {
                    if (equalsIgnoreCase(reader.getLocalName(), COLOR)) {
                        readColor = true;
                        color.setLength(0);
                    } else {
                        readColor = false;
                    }
                } else if (reader.isEndElement()) {
                    if (equalsAnyIgnoreCase(reader.getLocalName(), Calculate.TRIANGLE, Calculate.RECTANGLE, Calculate.SQUARE, Calculate.CIRCLE)) {
                        Calculate.calculate(number, reader.getLocalName(), color.toString(), sides);
                        number++;
                    }
                } else if (reader.hasText() && reader.getText().trim().length() > 0) {
                    if (readColor) {
                        color.append(reader.getText());
                    } else {
                        sides.add(Double.valueOf(reader.getText()));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Не найден файл " + fileName);
        }
    }

    private static final String COLOR = "color";
}