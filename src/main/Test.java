package main;

import cliente.CreacionConductorVehiculo;

public class Test {

	public static void main(String[] args) {

		CreacionConductorVehiculo ccv = new CreacionConductorVehiculo();
		int placa = 111188;
		int dui = 123456789;
		int telefono = 77777777;

		for (int i = 0; i < 10; i++) {
			placa = placa + 1;
			dui = dui + 1;
			telefono = telefono + 1;
			String telefono1 = String.valueOf(telefono);
			String placa1 = String.valueOf(placa);
			String dui1 = String.valueOf(dui);

			System.out.println(i + "" + ccv.guardarConductorVehiculo(telefono1, dui1, placa1));
		}
	}

}
