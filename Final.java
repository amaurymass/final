import java.util.*;
import java.util.Arrays; 

public class Final{

	public static void imprimirFila(String fila[])
	{
		for (int i=0;i<fila.length;i++) {
			
	 		if(fila[i].equals("1"))
	 		{
	 			System.out.print(ConsoleColors.RED_BACKGROUND+"  ");
	 		}
	 		if(fila[i].equals("2"))
	 		{
	 			System.out.print(ConsoleColors.BLUE_BACKGROUND+"  ");
	 		}
	 		if(fila[i].equals("3"))
	 		{
	 			System.out.print(ConsoleColors.WHITE_BACKGROUND+"  ");
	 		}
	 		if(fila[i].equals("4"))
	 		{
	 			System.out.print(ConsoleColors.YELLOW_BACKGROUND+"  ");
	 		}		 		
		}
		System.out.println(ConsoleColors.RESET);
	}

	public static int subMenuSeleccionBandera(int[] indices)
	{
		int opc = 0;

		do{
			System.out.println("Ingrese un valor entre 1 y "+indices.length);
			opc = ConsoleInput.getInt();
		}while(opc<0 || opc==0 || opc>indices.length);

		return opc-1;
	}

	public static void imprimirGraficoBandera(String[] banderas, int indice)
	{
		for (int i=indice;i<indice+20;i++ ) {
			imprimirFila(banderas[i].split(";"));
		}
			
	}


	public static int[] desordenarArreglo(int[] array){
		Random rgen = new Random();  // Random number generator			
 
		for (int i=0; i<array.length; i++) {
		    int randomPosition = rgen.nextInt(array.length);
		    int temp = array[i];
		    array[i] = array[randomPosition];
		    array[randomPosition] = temp;
		}
 
		return array;
	}

	public static int[] crearIndices(int total)
	{
		int indices[] = new int[total];
		int contador = 0;
		for (int i=0;i<indices.length;i++) {
			indices[i] = contador;
			contador+=20;		
		}
		return indices;
	}

	public static void menu()
	{
		int centinela = 0, opcion_bandera = 0;
		String banderas[] = ConsoleFile.read("recursos/info_banderas.csv");
		int indices[] = crearIndices(banderas.length/20);
		//System.out.println(Arrays.toString(indices));
		indices = desordenarArreglo(indices);
		//System.out.println(Arrays.toString(indices));

		do{
			System.out.println();
			System.out.println("Ingrese una opcion asi:");
			System.out.println("1. Imprimir grafico bandera");
			System.out.println("2. salir");
			centinela = ConsoleInput.getInt();

			switch(centinela)
			{
				case 1: System.out.println();
						opcion_bandera = subMenuSeleccionBandera(indices);
						imprimirGraficoBandera(banderas,indices[opcion_bandera]);
						break;
				case 2: System.out.println("Hasta luego ;)");
						System.exit(0);
						break;

				default: System.out.println("Opcion no disponible");
			}

		}while(centinela!=7);
	}

	public static void main(String[] args) {

		menu();
	}
}