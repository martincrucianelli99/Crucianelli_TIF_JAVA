package com.ejercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainApplication {

    public static void main( String[] args ){
		final int NUM1 = 10;
		int num2 = 5;

		System.out.println("SUMA : " + sumar(NUM1, num2));
		System.out.println("RESTA : " + restar(NUM1, num2));
		System.out.println("DIVISION : " + dividir(NUM1, num2));
		System.out.println("MULTIPLICACION : " + multiplicar(NUM1, num2));

		int lado_cuadrado = 20;
		System.out.println("Perimetro del cuadrado es " + multiplicar(lado_cuadrado, 4) + " cm.");

		System.out.println("Area del cuadrado es " + multiplicar(lado_cuadrado, lado_cuadrado) + " cm.");

		int base_triangulo = 8;
		int altura_triangulo = 5;
		System.out.println("Area del triangulo es " + dividir(multiplicar(base_triangulo, altura_triangulo), 2) + " cm.");

		int lado_pentagono = 12;
		System.out.println("Perimetro del pentagono es " + multiplicar(lado_pentagono, 5) + " cm.");

		int precio_producto = 200;
		int iva_producto = calcularIVA(precio_producto);
		System.out.println("El producto sin IVA sale $" + restar(precio_producto, iva_producto));

		int nota1 = 7;
		int nota2 = 8;
		System.out.println("Nota final : " + sumar(dividir(sumar(nota1, nota2), 2), sumar(nota1, nota2)%2));

		int producto1 = 2500;
		int producto2 = 1800;
		System.out.println("Valor final de los productos : " + sumar(sumarIVA(producto1), sumarIVA(producto2)));

		int monto_cliente = 5500;
		int monto_pagar = sumar(sumarIVA(producto1), sumarIVA(producto2));
		System.out.println("Vuelto del cliente : " + restar(monto_cliente, monto_pagar));

		// Operadores Logicos igual ==  ____  distinto !=  ____
		// mayor > ____  menor <  ____  mayor o igual >=  ____  menor o igual <=
		// and &&  ____  or || 
		int numero1 = 10;
		int numero2 = 20;
		System.out.println("Mayor : " + mayor(numero1, numero2));
		System.out.println("Menor : " + menor(numero1, numero2));
		System.out.println("Igual : " + igual(numero1, numero2));
		boolean pago_exacto = monto_cliente == monto_pagar;
		System.out.println("El cliente pago exacto? " + pago_exacto);

		// Condicionales if(condicion booleana) _________ else ________ else if (condicion booleana)
		int edad = 8;
		if (mayor(edad, 17) && menor(edad, 65)) {
			System.out.println("Es un adulto.");
		} else if (menor(edad, 18)) {
			System.out.println("ES menor de edad.");
		} else {
			System.out.println("Es un jubilado.");
		}

		// input por consola
		Scanner scanner = new Scanner(System.in);

        //System.out.print("Ingrese su nombre: ");
        //String nombre = scanner.nextLine();
		//System.out.println("Hola " + nombre);

		//Ejercicio 20
		int prod1 = 200;
		int prod2 = 20000;
		int prod3 = 2000;
		System.out.println(identificarProductosIgules(prod1, prod2, prod3));

		//Ejercicio 21
		System.out.println(identificarProductosDistintos(prod1, prod2, prod3));

		//Cadena de caracteres
		String cadena1 = "Buen dia";
		String cadena2 = "buenas noches";

		System.out.println("Largo cadena 1: " + cadena1.length());
		System.out.println("Largo cadena 2: " + cadena2.length());
		System.out.println("Concatenacion: " + cadena1.concat(cadena2));
		System.out.println(cadena1 + " " + cadena2);
		System.out.println("Busqueda de caracteres: " + cadena1.indexOf("a"));
		System.out.println("Igualdad entre cadenas: " + cadena1.equals(cadena2));
		System.out.println("Mayusculas: " + cadena1.toUpperCase());
		System.out.println("Minusculas: " + cadena1.toLowerCase());
		System.out.println("Separar una cadena: " + cadena1.split(" ")[1]);

		// iteradores
		for(int iterador = 0; iterador < 10; iterador++){
			System.out.println(iterador);
		}

		int iva_producto_iterador = 2000;
		while (iva_producto_iterador < 10000) {
			iva_producto_iterador+=calcularIVA(iva_producto_iterador);
			System.out.println(iva_producto_iterador);
		}

		//listas
		ArrayList<String> lista = new ArrayList<>();
		lista.add("hola");
		System.out.println(lista.get(0));
		
		int lista_numeros[] = {2, 4, 6, 8};
		//valores  [2, 4, 6, 8]
		//posicion [0, 1, 2, 3]
		System.out.println(lista_numeros[0]);
		// lista_numeros.length largo de la lista
		for(int index = 0; index < lista_numeros.length; index++){
			System.out.println(lista_numeros[index]);
		}

		//ejercicio de listas en clase
		ArrayList<String> muebles = new ArrayList<String>(){{
			add("mesa"); 
			add("comoda");
			add("biblioteca");
			add("escritorio");
			add("cama");
			add("alacena");
		}};

		ArrayList<Integer> precios = new ArrayList<Integer>() {{
			add(200000);
			add(250000);
			add(500000);
			add(550000);
			add(350000);
			add(270000);
		}};

		String mueble_entrada = "Cama";

		String mueble = muebles
		.stream()
		.filter(m -> m.equalsIgnoreCase(mueble_entrada))
		.findFirst()
		.orElse(null);

		if (mueble!=null) {
			int posicion = muebles.indexOf(mueble);
			System.out.println("El producto " + mueble + " esta en stock.");
			System.out.println("Su valor es de " + precios.get(posicion));
		} else {
			System.out.println("El producto no esta disponible.");
		}

		//ejercicio 34
		ArrayList<String> autos = new ArrayList<String>(){{
			add("fiat"); 
			add("ford");
			add("toyota");
			add("ford");
			add("fiat");
			add("fiat");
			add("ford");
			add("toyota");
		}};

		List<String> autosOrdenados = autos.stream().sorted().collect(Collectors.toList());
		int contar_auto = 1;
		
		for(int i=1; i<autosOrdenados.size(); i++){
			if(autosOrdenados.get(i-1).equals(autosOrdenados.get(i))){
				contar_auto++;
			}
			else {
				System.out.println("Hay " + contar_auto + " autos de marca " + autosOrdenados.get(i-1));
				contar_auto = 1;
			}
			if (i == autosOrdenados.size()-1) {
				System.out.println("Hay " + contar_auto + " autos de marca " + autosOrdenados.get(i));
			}
		}

		// Ejercicio 35
		ArrayList<Integer> años_febricacion = new ArrayList<Integer>() {{
			add(1988);
			add(1998);
			add(1970);
			add(1999);
			add(2010);
			add(2004);
			add(1992);
			add(1986);
		}};

		for(int x=0; x<autos.size(); x++){
			System.out.println("Marca: " + autos.get(x) + " Año: " + años_febricacion.get(x));
		}

		//Ejercicio 36
		ArrayList<String> autos_no_paga_patente = new ArrayList<String>();

		for(int y=0; y<autos.size(); y++){
			if(años_febricacion.get(y)<1999){
				autos_no_paga_patente.add(autos.get(y) + " año: " + años_febricacion.get(y));
			}
		}
		System.out.println(autos_no_paga_patente.toString());

		//Maps
		Map<Integer, String> nuevo_map = new HashMap<Integer, String>();
		nuevo_map.put(1, "casa");
		nuevo_map.put(3, "auto");
		nuevo_map.put(2, "mesa");
		nuevo_map.put(4, "camion");

		System.out.println(nuevo_map.get(4));

		nuevo_map.remove(4);

		System.out.println(nuevo_map.containsValue("mesa"));

		System.out.println(nuevo_map.containsKey(1));

		System.out.println(nuevo_map.size());

		System.out.println(nuevo_map.isEmpty());

		System.out.println(nuevo_map.keySet());

		System.out.println(nuevo_map.values());

		System.out.println(nuevo_map.getOrDefault(4, "no existe"));

		nuevo_map.forEach((k, v) -> System.out.println("Clave: " + k + " Value: " + v));

		//Ejercicio 44
		Map<Integer, String> descripcion_productos = new HashMap<Integer, String>();
		descripcion_productos.put(1000, "masa para pizza");
		descripcion_productos.put(1001, "harina 0000");
		descripcion_productos.put(1002, "azucar");
		descripcion_productos.put(1003, "polenta");	

		Map<Integer, Integer> precio_productos = new HashMap<Integer, Integer>();
		precio_productos.put(1000, 2000);
		precio_productos.put(1001, 800);
		precio_productos.put(1002, 100);
		precio_productos.put(1003, 1800);

		int codigo_barras = 1000;

		if (descripcion_productos.containsKey(codigo_barras)) {
			System.out.println(descripcion_productos.get(codigo_barras) + " = $" + precio_productos.get(codigo_barras));
		} else {
			System.out.println("NO ESTA EN STOCK");
		}
	/// EJERCICIO 46
	ArrayList<String> bebidasSinPrecio = new ArrayList<String>(){{
		add("Ron Coco Bongo");
		add("Coca Cola");
		add("Sprite");
		add("Sprite");
		add("Campari");
		add("Campari");
		add("Jugo Citric");
		add("Dr Lemon");
		add("Johnnie Walker");
		add("Vino Santa Julia Chenin");
	}};

	Map<String, Integer> bebidas = new HashMap<String, Integer>();
	
	bebidas.put("Ron Coco Bongo", 2500);
	bebidas.put("Coca Cola", 1800);
	bebidas.put("Sprite", 1400);
	bebidas.put("Campari", 3500);
	bebidas.put("Jugo Citric", 3200);
	bebidas.put("Dr Lemon", 2800);
	bebidas.put("Johnnie Walker", 2400);
	bebidas.put("Vino Santa Julia Chenin", 3800);


	int totalConIva = 0;

	for (String bebida : bebidasSinPrecio) {
		int precio = bebidas.get(bebida);
		totalConIva += precio + calcularIVA(precio);
	}

	System.out.println("El total con iva es: " + totalConIva);

	/// EJERCICIO 47

	
	int contadorCocaCola = 0;
	int contadorJugoCitric = 0;
	boolean ronCocaCola = false;

	for (String bebida : bebidasSinPrecio) {
		int precio = bebidas.get(bebida);
		if (bebida.equals("Coca Cola")) {
			contadorCocaCola++;
			if (contadorCocaCola % 3 != 0) {
				totalConIva += precio;
			}
		}  else if (bebida.equals("Jugo Citric")) {
			contadorJugoCitric++;
			if (contadorJugoCitric % 2 != 0) {
				totalConIva += precio;
			}
		} else if (bebida.equals("Ron Coco Bongo") && bebidasSinPrecio.contains("Coca Cola")) {
			totalConIva += 5000;
			bebidasSinPrecio.remove("Coca Cola");
		} else {
			totalConIva += precio;
		}
	}
	/// Si el cliente es parte del club de descuentos, no se le cobra el IVA
	
	boolean esParteDelClubDeDescuentos = true; // Cambiar a false si el cliente no es parte del club de descuentos
	if (!esParteDelClubDeDescuentos) {
		totalConIva += calcularIVA(totalConIva);
	}
	System.out.println(totalConIva);


}
    


    static boolean identificarProductosDistintos(int prod1, int prod2, int prod3){
		if (calcularIVA(prod1) != calcularIVA(prod2) && calcularIVA(prod2) != calcularIVA(prod3)
		 && calcularIVA(prod1) != calcularIVA(prod3)) { 
			return true; 
		}
		return false;
	}

	static boolean identificarProductosIgules(int prod1, int prod2, int prod3){
		boolean prod_iguales = false;
		if (calcularIVA(prod1) == calcularIVA(prod2)) {
			prod_iguales = true;
		} else if (calcularIVA(prod2) == calcularIVA(prod3)){
			prod_iguales = true;
		} else if (calcularIVA(prod1) == calcularIVA(prod3)) {
			prod_iguales = true;			
		}
		return prod_iguales;
	}

	static boolean mayor(int mayor1, int mayor2){
		return mayor1 > mayor2;
	}

	static boolean menor(int menor1, int menor2){
		return menor1 < menor2;
	}

	static boolean igual (int igual1, int igual2){
		return igual1 == igual2;
	}

	static int sumarIVA(int producto){
		return producto + calcularIVA(producto);
	}

	static int calcularIVA(int valor) {
		final int IVA = 21;
		return dividir(multiplicar(valor, IVA), 100);
	}

	static int sumar(int sum1, int sum2) {
		return sum1+sum2;
	}

	static int restar(int res1, int res2) {
		return res1-res2;
	}

	static int dividir(int div1, int div2) {
		return div1/div2;
	}

	static int multiplicar(int mul1, int mul2) {
		return mul1*mul2;
	}
}
