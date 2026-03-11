package com.conversor.menu;

import com.conversor.service.ConversionService;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    ConversionService conversionService = new ConversionService();

    public void iniciar() {

        int opcion = -1;

        while (opcion != 0) {

            System.out.println("""
                    
********************************************
Sea bienvenido al Conversor de Monedas

1) USD -> ARS
2) ARS -> USD
3) USD -> BRL
4) BRL -> USD
5) USD -> COP
6) COP -> USD

0) Salir
********************************************
""");

            opcion = scanner.nextInt();

            if (opcion == 0) break;

            System.out.println("Ingrese el valor que desea convertir:");
            double cantidad = scanner.nextDouble();

            switch (opcion) {

                case 1 -> conversionService.convertir("USD","ARS",cantidad);

                case 2 -> conversionService.convertir("ARS","USD",cantidad);

                case 3 -> conversionService.convertir("USD","BRL",cantidad);

                case 4 -> conversionService.convertir("BRL","USD",cantidad);

                case 5 -> conversionService.convertir("USD","COP",cantidad);

                case 6 -> conversionService.convertir("COP","USD",cantidad);

                default -> System.out.println("Opción inválida");

            }

        }

    }

}
