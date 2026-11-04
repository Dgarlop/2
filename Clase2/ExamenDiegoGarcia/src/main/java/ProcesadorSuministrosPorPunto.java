
public class ProcesadorSuministrosPorPunto {
	public static void main(String[] args) {
		ProcesadorSuministrosPorPunto pspp = new ProcesadorSuministrosPorPunto();
		String id = args[0];
		int kWhTotales = 0;
		int contador = 1;
		while(contador < args.length) {
			String kWh = args[contador];
			contador ++;
			kWhTotales = kWhTotales + Integer.parseInt(kWh);
		}
		Double precio = 0.30; //este es constante
		pspp.ProcesadorSuministrosPorPunto(id, kWhTotales, precio);
	}
	public void ProcesadorSuministrosPorPunto(String id, int kWh, Double precio) {
		Double importe = kWh * precio;
		System.out.println(id +";"+ kWh +";"+ importe);
	}

}
