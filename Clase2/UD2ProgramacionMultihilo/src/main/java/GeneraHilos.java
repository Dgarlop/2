public class GeneraHilos {
	public static void main(String[] args) {
		HiloPR hilo1 = new HiloPR("Hilo1");
		hilo1.start();
		
		HiloPR hilo2 = new HiloPR("Hilo2");
		hilo2.start();
}
}
 