import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class equiposAlquiler {
    
    public static void main (String[] args) {

        // Clase scanner

        Scanner leerT = new Scanner(System.in);

        // Clase fecha

        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

        // Clase math - random

        Random random = new Random();


        // Inicio sesión

        String[] userArray = new String[10]; // Unicamente se puede ingresar 10 usuario
        String[] passArray = new String[10]; // 

        // Ingreso credenciales empleado a userArray y pasArray

        userArray[1] = "Sandra";
        passArray[1] = "contra123";

        // Variable usuario

        String user = "";
        String pass = "";

        // Variables cliente
        
        String nombreCliente = ""; 
        String tipoCliente = ""; 
        String nombreEmpresa = ""; 
        int idCliente = random.nextInt(888); 
        int idFactura = random.nextInt(888); 

        // Variables facturación

        int numAlquilados = 0; 
        String fechaHoy = formato.format(fecha); 
        int diasAlquilados = 0; 
        int diasExtrasAlquilados = 0; 
        int valorAlquiler = 35000; 
        String tipoAlquiler = ""; 
        String sitioAlquiler = ""; 
        float sobreCargoFC = 0.05f; 
        float descuentoDC = 0.02f; 
        float descuentoDA = 0.02F; 
        String mailCliente = ""; 

        // Valor facturación
        float valorFacturacionBase = 0; 
        float valorFacturacionDiasExtras = 0; 

        // Reglas de negocio
        int numEquiposEmpresa = 130; 
        int maxDiasAlquiler = 183; 
        float maxDescuentoAlquilerDiasExtra = 0.2f; 

        // Variables de control

        int InicioSistema = 1; 
        int inicioSesion = 1; 
        int opcionMenu = 0; 
        int operacion = 1; 
        int pregunta = 1; 

       //////////////////////////////////////////////////////

        
        System.out.println("Bienvendio a ALQUIPC");
        System.out.println("--------------------------------------------------");
    

        while (InicioSistema == 1 ) {

            // Ingreso credenciales
            System.out.print("Ingrese su usuario: "); 
            user = leerT.next();
            System.out.print("Ingrese su contraseña: ");
            pass = leerT.next();

            // Reinicio de variables
            inicioSesion = 1; // Para que el ciclo vuelva a iniciar
            operacion = 1; 
            
           

            if (user.equals("Sandra") && pass.equals("contra123")) { 

                System.out.println(" ");
                System.out.println("Bienvenido " + user);
                System.out.println(" ");

                while (inicioSesion == 1) {

                // Menu de opciones
                
                System.out.println("");
                System.out.println("¿Qué desea consultar?");
                System.out.println("1. Realizar facturación");
                System.out.println("2. Salir");
                System.out.print("Respuesta: ");
                System.out.println("");
                opcionMenu = leerT.nextInt();

                if (opcionMenu == 1) {

                    //Condiciones de alquielr
                    System.out.println("----- Condiciones para el Alquiler -----");
                    System.out.println("----- POR FAVOR TENGA EN CUENTA ------");
                    System.out.println();
                    System.out.println("Dias de Alquiler min.2 y maximo 365 dias");
                    System.out.println("");
                    System.out.println("Tres Opciones de Alquiler en: ");
                    System.out.println("1. Dentro de la Ciudad: Bogotá");
                    System.out.println("2. Fuera de la Ciudad: Escriba su Ciudad");
                    System.out.println("3. Dentro del Establecimiento: ALQUIPIC Bogota Calle 98C Sur 1B 16 Sur");
                    System.out.println("");
                    System.out.println("Se manejan los siguientes equipos --> PC escritorio y laptop");
                    System.out.println("Maximo de Equipos al Alquilar: 70");
                    System.out.println("Metodo de Pago: Efectivo o Tarjeta");
                    System.out.println();
                    System.out.println("----------- DESCUENTOS QUE SE MANEJAN ---------------");
                    System.out.println("-----------------------------------------------------");
                    System.out.println("Dentro en el Local: 5%");
                    System.out.println("Dentro de la Ciudad: Sin cambios en el costo Base");
                    System.out.println("Fuera de la Ciudad: Incremento de 5%");
                    System.out.println();
                    System.out.println("-----------------------------------------------------");
                    System.out.println("-----------------------------------------------------");

                    System.out.println("");
                    System.out.println("---------------FACTURACION--------------");

                    // Nombre del cliente
                    System.out.print("Nombre del cliente: ");
                    nombreCliente = leerT.next(); 
                    System.out.println(" ");  
                    
                    while (operacion == 1) {

                        // Tipo cliente
                        System.out.print("Tipo cliente (Juridico o Natural): ");                        
                        tipoCliente = leerT.next();

                        if (tipoCliente.equals("Juridico") || tipoCliente.equals("juridico") || tipoCliente.equals("Natural") || tipoCliente.equals("natural") ) {

                            operacion = 2;
                            System.out.println(" "); 

                        }

                        else {

                            System.out.println(" ");
                            System.out.println("Asegurate de haber ingresado el dato correctamente");
                            System.out.println(" ");

                        }

                    }

                    // Ingresar numero de equipos alquilados
                    while (operacion == 1) {
  
                        // Numero de equipos alquilados
                        System.out.println(" ");
                        System.out.println("¿Cuantos equipos alquilo el cliente? (Min: 2 y Max: " + numEquiposEmpresa +")" );
                        System.out.print("Num. equipos alquilados: ");
                        numAlquilados = leerT.nextInt();
                        
                        if (numAlquilados < 2 || numAlquilados > numEquiposEmpresa) {

                            System.out.println(" ");
                            System.out.println("No se puede alquilar menos de dos equipos ni mas de " + numEquiposEmpresa );
                            System.out.println(" ");

                        } else {

                            operacion = 2;
                            System.out.println(" ");

                        }
                    
                    }

                    // Dias alquilados

                    while (operacion == 2) {

                        System.out.println("Reglas de alquiler");
                        System.out.println(" ");
                        System.out.println("Minimo numero dias de alquiler -> 2 | Maximo numero de alquiler -> " + maxDiasAlquiler );
                        System.out.println(" ");
                        System.out.println("Cada alquiler de equipo tiene un precio de " + valorAlquiler + " pesos por dia");
                        System.out.println("");
                        System.out.println("¿Cuantos dias se alquilo? ");
                        System.out.print("Respuesta: ");
                        diasAlquilados = leerT.nextInt();

                        if (diasAlquilados <= 0 || diasAlquilados > maxDiasAlquiler) { // Si dias alquilados es menor o igual a 0 o dialalquilados es mayor a 183
                            System.out.println(" ");
                            System.out.println("1. El numero de dias alquilados no puede ser menor a 2 o igual a 0");
                            System.out.println("2. El numero de dias alquilados no puede ser mayor a " + maxDiasAlquiler + "dias");
                            System.out.println(" ");
                        }

                        else if (diasAlquilados >= 2 || diasAlquilados <= maxDiasAlquiler) {
                            operacion = 1;
                            System.out.println("El alquiler se realizo por " + diasAlquilados + " dias");
                            System.out.println("Tendra un valor de " + (diasAlquilados*valorAlquiler) + " pesos");
                            System.out.println(" ");
                        }

                    }

                    // Tipo alquiler

                    while (operacion == 1) {

                        System.out.println("Ingrese el tipo de alquiler: ");
                        System.out.println(" ");
                        System.out.println("Dentro de la ciudad (Bogotá D.C) = escriba 1 ");
                        System.out.println("Fuera de la ciudad  = 2");
                        System.out.println("Alquiler en el local Calle 98C Sur 1B 16 = 3");
                        System.out.print("Respuesta: ");
                        tipoAlquiler = leerT.next(); 
                        System.out.println(" ");
                        
                        if (tipoAlquiler.equals("1")) {

                            System.out.println("Tipo de alquiler -> Dentro de la ciudad");
                            System.out.println("El alquiler se realizo en Bogota D.C");
                            tipoAlquiler = "Dentro de la ciudad";
                            sitioAlquiler = "Bogota D.C";

                            //Cerrar ciclo
                            operacion = 2;

                        } 

                        else if (tipoAlquiler.equals("2")) {

                            System.out.println("Tipo de alquiler -> Fuera de la ciudad");
                            System.out.println("Sobre cargo añadido por alquiler fuera de la ciudad -> " + (sobreCargoFC*100) + "%");
                            tipoAlquiler = "Fuera de la ciudad";
                            System.out.println("");
                            System.out.print("Ingrese el sitio donde se realizo el alquiler: ");
                            sitioAlquiler = leerT.next();

                            //Cerrar ciclo
                            operacion = 2;
                        }

                        else if (tipoAlquiler.equals("3")) {

                            System.out.println("Tipo de alquiler -> Alquiler en el local");
                            System.out.println("Descuento añadido por alquiler en el local -> " + (descuentoDC*100) + "%");
                            tipoAlquiler = "Alquiler en el local";
                            System.out.println("");
                            sitioAlquiler = "Local - Cr 115 # 70 - 50";

                            //Cerrar ciclo
                            operacion = 2;
                        }

                        else {

                            System.out.println("Error");

                        }

                    }

                    // Recordatorio precio actual del alquiler por dia y descuento o sobrecargo

                    System.out.println(" ");

                    if (tipoAlquiler.equals("Dentro de la ciudad")) {

                        System.out.println("El valor actual del alquiler es de " + valorAlquiler + " pesos");
                        System.out.println("El descuento por alquiler en el local es de " + (descuentoDC*100) + "%");
                        valorFacturacionBase = valorAlquiler * diasAlquilados;
                        System.out.println("El valor actual del alquiler es de " + (valorFacturacionBase + " pesos"));

                    }

                    else if (tipoAlquiler.equals("Fuera de la ciudad")) {

                        System.out.println("El valor actual del alquiler es de " + valorAlquiler + " pesos");
                        System.out.println("El sobrecargo por alquiler fuera de la ciudad es de " + (sobreCargoFC*100) + "%");
                        valorFacturacionBase = (valorAlquiler * diasAlquilados) + ((valorAlquiler * diasAlquilados) * sobreCargoFC);
                        System.out.println("El valor actual del alquiler con sobrecargo es de " + (valorAlquiler + (valorAlquiler * sobreCargoFC)) + " pesos");

                    }

                    else if (tipoAlquiler.equals("Alquiler en el local")) {

                        System.out.println("El valor actual del alquiler es de " + valorAlquiler + " pesos");
                        System.out.println("El descuento por alquiler en el local es de " + (descuentoDC*100) + "%");
                        valorFacturacionBase = (valorAlquiler * diasAlquilados) - ((valorAlquiler * diasAlquilados) * descuentoDC);
                        System.out.println("El valor actual del alquiler con descuento es de " + (valorAlquiler - (valorAlquiler*descuentoDC)) + " pesos");

                    }

                    System.out.println("El valor actual del alquiler con sobrecargo o descuento es de " + valorFacturacionBase + " pesos");

                    // Dias extra

                    while (operacion == 2) {

                        while (operacion == 2) {

                            System.out.println(" ");
                            System.out.println("¿Se realizaron dias extras de alquileres? Si = 1 y No = 2");
                            System.out.print("Respuesta: ");
                            pregunta = leerT.nextInt();
                            System.out.println(" ");

                            if (pregunta != 1) {

                                System.out.println("No se realizaron dias extras");
                                diasExtrasAlquilados = 0;
                                operacion = 1;

                            }

                            else {

                                System.out.println(" ");
                                System.out.print("Dias extras alquilados: ");
                                diasExtrasAlquilados = leerT.nextInt();
                                System.out.println(" ");
                                
                                if (diasExtrasAlquilados == 0) {

                                    operacion = 1;

                                }

                                else if (diasAlquilados < 0) {

                                    System.out.println("No se puede ingresar un valor menor a 0");

                                }

                                else if (diasExtrasAlquilados > (maxDiasAlquiler - diasAlquilados)) {

                                    System.out.println("No puede ser mayor a " + (maxDiasAlquiler-diasAlquilados));

                                }

                                else if (diasAlquilados <= (maxDiasAlquiler - diasAlquilados)) {

                                    System.out.println("El numero extras de alquiler es: " + diasExtrasAlquilados);
                                    operacion = 1;

                                }

                            }

                        }

                    }

                    // Condicional - Dias extras

                    if (diasExtrasAlquilados == 0) {

                        valorFacturacionDiasExtras = 0;

                    }

                    else if (diasExtrasAlquilados >= 10) {

                        valorFacturacionDiasExtras = (valorAlquiler * diasExtrasAlquilados) - ((valorAlquiler * diasExtrasAlquilados) * maxDescuentoAlquilerDiasExtra);
                        System.out.println("El valor actual del alquiler por dias extras es de " + valorFacturacionDiasExtras + " pesos");

                    }

                    else if (diasExtrasAlquilados < 10) {

                        valorFacturacionDiasExtras = (valorAlquiler * diasExtrasAlquilados) - ((valorAlquiler * diasExtrasAlquilados) * descuentoDA);
                        System.out.println("El valor actual del alquiler por dias extras es de " + valorFacturacionDiasExtras + " pesos");

                    }


                    // Correo

                    while (operacion == 2) {

                        System.out.println("Ingrese el correo del cliente (debe finalizar con @gmail.com no se permite otro dominio): ");
                        System.out.print("Correo: ");
                        mailCliente = leerT.next();
                        System.out.println(" ");
                        
                        // validar que unicamente no es @gmail.com
                        if (mailCliente.equals("@gmail.com")) {
                            
                            System.out.println("No se puede ingresar unicamente @gmail.com, no es una opción correcta");


                        } else {

                            System.out.println("El correo ingresado no es valido");

                        } 
                        
                    }

                    // Facturación

                    
                    System.out.println("------ FACTURA -------- ");
                    System.out.println("|Fecha de facturación: " + fechaHoy);
                    System.out.println("Factura de alquiler No. " + idFactura);
                    System.out.println("Nombre del cliente: " + nombreCliente);
                    System.out.println("Id cliente: " + idCliente);
                    System.out.println("Tipo de cliente: " + tipoCliente);
                    System.out.println("");
                    System.out.println("|Detalles del alquiler:");
                    System.out.println("|Numero de equipos alquilados: " + numAlquilados);
                    System.out.println("|Dias de alquiler: " + diasAlquilados);
                    System.out.println("|Tipo de alquiler: " + tipoAlquiler);
                    System.out.println("|Sitio de alquiler: " + sitioAlquiler);
                    System.out.println("|Dias extras de alquiler: " + diasExtrasAlquilados);
                    System.out.println("");
                    System.out.println("|Detalles de facturación:");
                    System.out.println("|Valor de alquiler por día: " + valorAlquiler);
                    System.out.println("|Valor de alquiler por días extras: " + valorFacturacionDiasExtras);
                    System.out.println("| Valor de alquiler total: " + (valorFacturacionBase + valorFacturacionDiasExtras));
                    System.out.println("");
                    System.out.println("Factura Enviada a");
                    System.out.println("Correo del cliente: " + mailCliente);
                    System.out.println("");
 
                    

                    // Salir o Seguir en la sesión

                    System.out.println(" ");
                    System.out.println("¿Quiere realizar otra facturación? Si = 1   No = 2");
                    System.out.print("Respuesta: ");
                    inicioSesion = leerT.nextInt();
                    System.out.println(" ");

                } 

                else if (opcionMenu == 2) { 
                    
                    System.out.println(" ");


                }

                else { 
                    
                    System.out.println(" ");
                    System.out.println("Ingresaste un valor no definido");
                    System.out.println(" ");

                }



                
                }

            }
        
        leerT.close();

    }


    }}
