public class Application {

	public static void main(String[] args) {
		new Reader("example.xml").run();
		new Thread(new Reader("example2.xml")).start();
	}
}
