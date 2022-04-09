package ui;

import java.util.Scanner;
import model.Controller;


public class Main {

	
	private Scanner sc;

	private Controller cont;

	public Main() {
		sc= new Scanner(System.in);
		cont = new Controller();
		
	}

	public static void main(String [] a) {
		
		Main ppal = new Main();
		
		ppal.initProgram();

		int option = 0;
		
		do {
		    option =ppal.showMenu();
		    ppal.answerOption(option);
		}while (option !=0);

	}

	public void answerOption(int userOption) {
		switch(userOption) {
		case 0: 
			System.out.println("Cerrando el programa");
			break;
		case 1:
			addWetland();
			break;
		case 2:
			addSpecie();
			break;
		case 3: 
			addEvent();
			break;
		case 4: 
			showMaintenance();
			break;
		case 5: 
			showFlora();
			break;
		case 6:
			searchSpecie();
			break;
		case 7:
			showWetlands();
			break;
		case 8:
			showFauna();
			break;
		
		}
		
		
	}

	public int showMenu() {
		int input;
		System.out.println("\n\nMenu de la Tienda, digite una opciOn\n"+ 
		                    "(1) Registrar un humedal\n" +
		                    "(2) Registrar una nueva especie en el humedal\n" +
		                    "(3) Registrar en evento en el humedal\n"+
		                    "(4) Informacion sobre la cantidad de mantenimientos\n"+
		                    "(5) Humedal con menos especies de flora\n"+
							"(6) Buscar una especie\n"+
							"(7) Informacion sobre humedales\n"+
							"(8) Humedal con mayor cantidad de animales\n"+
		                    "(0) Para salir");

		input = sc.nextInt();
		sc.nextLine();
		return input;
	}

	public void initProgram() {
		System.out.println("Manager of wetlands");
		
	}


	public void addWetland() {

		System.out.println("Ingrese el nombre del nuevo humedal");
		String name = sc.nextLine();

		System.out.println("Ingrese la ubicacion 1. Urbana o 2. Rural");
		int ubicationOpion = sc.nextInt();
		sc.nextLine();
		String ubication = "";
		String zone = "";
		if(ubicationOpion == 1) {

			ubication = "Urbana";

			System.out.println("Ingrese el nombre del barrio");
			zone = sc.nextLine();
		}else {
			ubication = "rural";

			System.out.println("Ingrese el nombre del corregimientos");
			zone = sc.nextLine();
		}

		System.out.println("Ingrese el tipo de humedal 1.Publico o 2.Privado");
		int typeOption = sc.nextInt();
		sc.nextLine();
		String type = "";

		if(typeOption == 1) {

			type = "publico";
		}else {
			type = "privado";
		}

		System.out.println("Ingrese el url de la imagen del humedal");
		String url = sc.nextLine();

		System.out.println("Ingrese si es area protegida 1.Si o 2.No");
		int protectedAreaOption = sc.nextInt();
		String protectedArea = "";

		if(protectedAreaOption == 1) {

			protectedArea = "Protegido";
		}else {
			protectedArea = "No protegido";
		}

		System.out.println("Ingrese la cantidad de km2");
		double km2 = sc.nextDouble();
		sc.nextLine();

		System.out.println("Ingresar la cantidad de mantenimientos");
		int maintance = sc.nextInt();
		


		System.out.println(cont.addWetland(name, ubication, type, url, protectedArea, km2, maintance, zone ));
	}

	public void addSpecie() {

		System.out.println("Ingrese el nombre de la especie");
		String name = sc.nextLine();

		System.out.println("Ingrese el nombre cientifico de la especie");
		String cientificName = sc.nextLine();

		System.out.println("Ingrese si la especie es 1.Migratoria o 2.No es migratoria");
		int migratoryOption = sc.nextInt();
		String migratory = "";

		if(migratoryOption == 1) {

			migratory = "Migratoria";
		}else {
			migratory = "No migratoria";
		}

		System.out.println("Ingrese el tipo de la especie 1.Flora terrestre  2.Flora acuática  3.Ave  4.Mamífero  5.Acuático");
		int specieOption = sc.nextInt();
		sc.nextLine();

		System.out.println("Ingrese el humedal en el que va a registrar la nueva especie");
		String wetlandName = sc.nextLine();

		cont.findWetland(wetlandName);
		System.out.println(cont.addSpecie(name, cientificName, migratory, specieOption, wetlandName));


	}

	public void addEvent() {

		System.out.println("Ingrese la fecha en la que se realizara el evento");
		String dateEvent = sc.nextLine();

		System.out.println("Ingrese quien realizara este evento");
		String eventManager = sc.nextLine();

		System.out.println("Ingrese el tipo de evento 1.Mantenimiento 2.v Visita de colegio 3. Actividades de mejoramiento 4. Celebracione");
		int typeOption = sc.nextInt();

		System.out.println("Ingrese el precio del evento");
		double price = sc.nextDouble();
		sc.nextLine();

		System.out.println("Ingrese una descripcion");
		String description = sc.nextLine();

		System.out.println("Ingrese el humedal en el que va a registrar la nueva especie");
		String wetlandName = sc.nextLine();

		cont.addEvent(typeOption, dateEvent, eventManager, price, description, wetlandName);
	}

	public void showMaintenance() {

		cont.getMaintenance();
	}


	public void searchSpecie() {

		System.out.println("Ingrese el nombre de la especie que esta buscando");
		String name = sc.nextLine();

		cont.getSpecie(name);
		
	}

	public void showWetlands() {

		cont.getWetland();
	}

	public void showFlora() {

		System.out.println(cont.getFlora());
	}
	
	public void showFauna() {

		System.out.println(cont.getFauna());
	}
}