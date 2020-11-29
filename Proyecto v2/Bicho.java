public class Bicho
{
    private int salud =0;
    public static Bicho [][] arreglo= new Bicho[2][2];
    private String nombre= "    ";
    public Bicho(){
    }

    public Bicho(int salud, String nombre){
        this.salud = salud;
        this.nombre = nombre;
    }

    public void setSalud(int salud){
        this.salud = salud;
    }

    public int getSalud(){
        return  salud;
    }

    public String getNombre(){
        return nombre;
    }

    public static void instanciarBichos(Bicho [][] bichos){
        for(int i = 0; i<arreglo.length;i++){
            for(int j = 0; j<arreglo[0].length;j++){
                arreglo[i][j]= new Bicho();
            }
        }
        double random1 = Math.floor(Math.random()*3+1); 
        int columna=0;
        int fila=0; 
        for(int j = 0; j<random1; j++){
            double random2 = Math.floor(Math.random()*2+1);
            if(random2==2){
                arreglo[columna][fila]= new BichoAliens();
                fila++;
            }else{
                arreglo[columna][fila]= new BichoNormal();
                fila++;
            }
            if(fila ==2){
                columna=1;
                fila=0;
            }            
        }
    }

    public static void mostrarTablero(){
        System.out.print("-------------\n"+
            "|"+arreglo[0][0].getNombre() + arreglo[0][0].getSalud()+"|"+arreglo[0][1].getNombre() + arreglo[0][1].getSalud()+"|\n"+
            "|"+arreglo[1][0].getNombre() + arreglo[1][0].getSalud()+"|"+arreglo[1][1].getNombre() + arreglo[1][1].getSalud()+"|\n"+
            "--------------\n");
    }
   
    public static void disparo(int i, int j){
        arreglo[i][j].setSalud(arreglo[i][j].getSalud()-5);
    }

    public static boolean vivos(){
        boolean ans =true;
        int cont = 0;
        for(int i = 0; i<arreglo.length;i++){
            for(int j = 0; j<arreglo[0].length;j++){
                if(arreglo[i][j].getSalud()<=0){
                    cont++;
                }
            }
        }
        if(cont == 4){
            ans = false;
        }
        return ans;
    }
}