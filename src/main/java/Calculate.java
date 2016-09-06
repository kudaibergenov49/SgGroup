import static java.lang.Math.sqrt;

/**
 * Created by Storm on 06.09.2016.
 * @author Kudaibergen Kuanysh
 * Методы класса Calculate есть в классе Handler
 * Класс Calculate описывает методы вычисления
 * площади для различных фигур.
 * Для класса Calculate записан JUnit-test(модульное тестирование): CalculateTest.java
 */
public class Calculate {
    static double triangle(double a,double b, double c) // вычислим площадь треугольгика
    {
        double p = (a+b+c)/2;
        return sqrt(p*(p-a)*(p-b)*(p-c));
    }

    static double circle(double a) // круга
    {
        return Math.PI*a*a/8;
    }

    static double square(double a)
    {
        return a*a;
    } //квадрата

    static double rectangle(double a,double b)
    {
        return a*b;
    } //четырехугольника
}
