import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;
import java.io.*;

public class Principal {
  public static void mostrarMenu()throws IOException{
      {
        Scanner Scan = new Scanner(System.in);

        System.out.println("Cual es la cantidad de espacios en el parqueadero?");
        int cantidad = Scan.nextInt();
       
        new Vehiculo(cantidad);
        new Sensor(cantidad,false);
        
        System.out.println("¿Cual es el precio por hora para los carros?");
        int precioCarro = Scan.nextInt();

        System.out.println("¿Cual es el precio por hora para los motos?");
        int precioMoto = Scan.nextInt();

        System.out.println("Ingrese un numero del 0 al 11 para seguir:");
        System.out.println("Ingrese 1 para imprimir los sensores desocupados");
        System.out.println("Ingrese 2 para solicitar el espacio donde se quiera parquear (no recuerda valor comercial)");
        System.out.println("Ingrese 3 para solicitar el espacio donde se quiera parquear");
        System.out.println("Ingrese 4 para mostrar la informacion de todos los vehiculos almacenados");
        System.out.println("Ingrese 5 para mostrar el historial de la cantidad de vehiculos creados hasta el momento");
        System.out.println("Ingrese 6 para verificar el estado de un espacio");
        System.out.println("Ingrese 7 para mostrar el estado de todos los sensores");
        System.out.println("Ingrese 8 para buscar carros por color");
        System.out.println("Ingrese 9 para ordenar los carros por precio");
        System.out.println("Ingrese 10 para desactivar un sensor");
        System.out.println("Ingrese 11 para imprimir los resultados a un txt");
        System.out.println("Ingrese 0 para terminar la ejecucion");

        int i = 1;
        while(i!=0){
          int num = Scan.nextInt();
          i=num;
          switch(num){
            case 0 :
              System.out.println("Fin del programa");
            break;
            case 1 :
              System.out.println(Sensor.sensorLibre());
                
            break;
            case 2 :
              System.out.println("Espacio que desea ocupar");
              int espacio = Scan.nextInt() - 1;
              if(Sensor.sensores[espacio] == null  || Sensor.sensores[espacio].getEstado() == 0 )
              {
                  System.out.println("Ingrese el tipo de vehiculo:");
                  String tipo = Scan.next();
                  System.out.println("Ingrese la placa:");
                  String placa = Scan.next();
                  System.out.println("Ingrese la marca:");
                  String marca = Scan.next();
                  System.out.println("Ingrese el color:");
                  String color = Scan.next();
                  
                  Vehiculo.vehiculos[espacio] = new Vehiculo(tipo,placa,marca,color); 
                  Vehiculo.vehiculos[espacio].actualizarFecha();
                  Sensor.sensores[espacio] = new Sensor(1);
                  System.out.println(Vehiculo.vehiculos[espacio].toString());
                  Vehiculo.vehiculos[espacio].setHora(makeHora());

                  
                }else{
                    System.out.println("No se puede realizar esta accion");
                }  
                
              
            break;
            case 3 :
            System.out.println("Espacio que desea ocupar");
               espacio = Scan.nextInt() - 1;
              if(Sensor.sensores[espacio] == null || Sensor.sensores[espacio].getEstado() == 0)
              {
                 System.out.println("Ingrese el tipo de vehiculo:");
                 String tipo = Scan.next();
                 System.out.println("Ingrese la placa:");
                 String placa = Scan.next();
                 System.out.println("Ingrese la marca:");
                 String marca = Scan.next();
                 System.out.println("Ingrese el color:");
                 String color = Scan.next();
                 System.out.println("Ingrese el valor:");
                 int valor = Scan.nextInt();
                    
                 Vehiculo.vehiculos[espacio] = new Vehiculo(tipo,placa,marca,color,valor) ;
                 Vehiculo.vehiculos[espacio].actualizarFecha();
                 Sensor.sensores[espacio] = new Sensor(1);
                 System.out.println(Vehiculo.vehiculos[espacio].toString());

                 Vehiculo.vehiculos[espacio].setHora(makeHora());
              }else{
                    System.out.println("No se puede realizar esta accion");
              }
                
            break;
            case 4 :
                System.out.println(Vehiculo.toStringVehiculos());        
            break;
            case 5 :
              System.out.println(Vehiculo.cantidadVehiculos());
            break;
            case 6 :
              System.out.println("Espacio que desea ocupar");
              int espacioSensor = Scan.nextInt();
              if(Sensor.sensores[espacioSensor] == null || Sensor.sensores[espacioSensor].getEstado() == 0)
              {
                      System.out.println("Esta libre");
               }else{
                      System.out.println("Esta ocupado");
               }
              
            break;
            case 7 :
             System.out.println(Sensor.sensoresEstado());
            break;
            case 8 :
              System.out.println("ingrese un color");
              String elColor = Scan.next();
             if(Vehiculo.Color(elColor) == null)
             {
              System.out.println("No hay carros de ese color");
             }else{
                 System.out.println(Vehiculo.Color(elColor));
                }
                 
            break;
            case 9 :
              System.out.println(Vehiculo.ordenValor());
            break;
            case 10 :
            System.out.println("Ingrese el sensor que quiere desactivar");
            int targetSensor = (Scan.nextInt()-1);
            Sensor.sensores[targetSensor].setEstado(0);
            
            double horaProp = makeHora();
            double horaDeIngreso = Vehiculo.vehiculos[targetSensor].getHora();
            double tiempoTranscurrido = horaProp - horaDeIngreso;
            int precio;
            if(Vehiculo.vehiculos[targetSensor].getTipo().equalsIgnoreCase("carro"))
            {
              precio = precioCarro;
            }else{
              precio = precioMoto;
            }
            double cobro = precio*tiempoTranscurrido;
            System.out.println(cobro);

            break;
            case 11:
            
            File file = new File("registro.txt");
            FileWriter fw = new FileWriter(file,true);
            PrintWriter salida = new PrintWriter(fw);
            
            salida.println(Vehiculo.toStringVehiculos());
            salida.close();
            System.out.println("Su archivo ha sido escrito en un txt exitosamente!");
            break;
            default:
              System.out.println("Comando Incorrecto");
            break;
        }
      }
    }
  }
  private static double makeHora() {
    int hora = LocalTime.now().getHour();
    int minute = LocalTime.now().getMinute();
    double horaProporcional = hora + (minute / 60);
    return horaProporcional;
  }
}
