import java.util.List;

import static java.lang.Math.*;

class Calculate {

	static void calculate(int number, String figure, String color, List<Double> params) {
		try {
			switch (figure) {
				case TRIANGLE:
					double aSide = nvl(params.get(0), 0.0);
					double bSide = nvl(params.get(1), 0.0);
					double cSide = nvl(params.get(2), 0.0);
					double p = (aSide + bSide + cSide) / 2;
					System.out.println(number + ": " + color + " - " + sqrt(p * (p - aSide) * (p - bSide) * (p - cSide)));
					break;
				case SQUARE:
					System.out.println(number + ": " + color + " - " + pow(nvl(params.get(0), 0.0), 2));
					break;
				case RECTANGLE:
					System.out.println(number + ": " + color + " - " + nvl(params.get(0), 0.0) * nvl(params.get(1), 0.0));
					break;
				case CIRCLE:
					System.out.println(number + ": " + color + " - " + PI * pow(nvl(params.get(0), 0.0), 2) / 8);
					break;
				default:
					break;
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println(number + ": " + color + " - Не хватает параметров для вычисления площади");
		}
	}

	private static <T> T nvl(T param, T defaultParam) {
		return param == null ? defaultParam : param;
	}

	static final String TRIANGLE = "triangle";
	static final String SQUARE = "square";
	static final String RECTANGLE = "rectangle";
	static final String CIRCLE = "circle";
}
