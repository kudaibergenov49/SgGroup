import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * Created by Storm on 06.09.2016.
 * @author Kudaibergen Kuanysh
 *
 *Мы описываем класс  Handler, который будет обрабатывать события чтения данных. Выделено 5 событий:
 *старт документ  --  startDocument
 *открытие тега   --  endDocument
 *данные внутри тега  --  characters
 *закрытие тега  --  endElement
 *заканчиваем обработку документа  -- startElement
 * Лучше не трогать этот класс!
 */



public class Handler extends DefaultHandler
{
    //Переменные:


    //Стороны фигур :
    //для круга а - диаметр
    //для квадрата a - сторона
    //для четырехугольника стороны : a,b
    //для треугольника стороны : a,b,c


    double a = 0;
    double b = 0;
    double c = 0;


    //**************
    int Count = 0;//Счетчик фигур

    String thisElement = "";
    String tag = ""; //я использую для фиксирования тэга <color>
    String figure = ""; // фиксирую фигуры




    //Начинаем парсить
    @Override
    public void startDocument() throws SAXException{
        System.out.println("Start parsing...");
    }

    @Override
    //Заканчиваем парсить
    public void endDocument() throws SAXException
    {
        System.out.println("end parsing...");
    }




    /*
    *Открываем текущий тэг и записываем текущий цвет или название фигуры
     */
    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        thisElement = qName;
        if(qName == "color") tag ="color";
        if(qName == "circle" || qName == "square" || qName == "rectangle" || qName == "triangle" ){ figure = qName;}


    }

    /*
    //Закрывем текущий тэг
    //Обнуляем значения цвета ИЛИ названия фигуры
    //ИЛИ Считываем объем фигуры и выводим её
    */
    @Override
    public void endElement(String namespace, String localName, String qName) throws SAXException
    {
        thisElement = "";
        if(qName == "circle" || qName == "square" || qName == "rectangle" || qName =="triangle")
        {
            figure = "";
        }
        if(qName == "color") tag ="";

        //Начинаем считать объемы и обнуляем значения сторон(a,b,c) каждый раз!


        //для треугольника
        if(qName == "triangle" ) {
            System.out.println(Math.round(100.00*Calculate.triangle(a,b,c))/100.00);
            a = 0;
            b = 0;
            c = 0;
        }
        //------------------

        //для круга
        if(qName == "circle" ) {
            System.out.println(Math.round(100.00*Calculate.circle(a))/100.00);
            a = 0;
        }
        //------------------

        //для квадрата
        if(qName == "square" ) {
            System.out.println(Math.round(Calculate.square(a)*100.00)/100.00);
            a = 0;
        }
        //------------------




        //Для четырёхугольника
        if(qName == "rectangle" ) {
            System.out.println(Math.round(100.00*Calculate.rectangle(a, b))/100.00);
            a = 0;
            b = 0;
        }
        //------------------




    }





    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String str = new String(ch, start, length);

        if(thisElement == "color") {

            System.out.print(Count + " - " + str + " - ");
            Count++;
        }
        if(thisElement == "diameter" && figure == "circle")
        {
            a = Double.parseDouble(str);
        }

        if(thisElement == "side" && figure == "square")
        {
            a = Double.parseDouble(str);

        }

        if(thisElement == "side" && figure == "rectangle")
        {
            if (a == 0){ a = Double.parseDouble(str);}
            else {b = Double.parseDouble(str);}
        }

        if(thisElement == "side" && figure == "triangle")
        {
            if (a == 0){ a = Double.parseDouble(str);}
            else {
                if(b == 0) {b = Double.parseDouble(str);}
                else {c = Double.parseDouble(str);}
            }
        }
    }




}
