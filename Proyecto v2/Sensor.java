public class Sensor
{
  public static Sensor[] sensores;
  private int estado = 0;
  
  public Sensor()
  {
    
  }
  
  public Sensor(int cant, boolean a)
  {
    this.sensores = new Sensor[cant];
  }
  
  public Sensor(int e)
  {
    this.estado = e;
  }

  public int getEstado()
  {
    return this.estado;
  }

  public void setEstado(int e)
  {
    this.estado = e;
  }
  
  public String toString()
  {
    String info = "";
    if(this.estado == 1)
    {
      info = "Ocupado";
    }
    else{
      if(this.estado == 0)
      {
        info = "Libre";
      }
    }
    return info;
  }
  
  public static String sensorLibre()
  { 
      String espaciosLibres = "";
    for (int i = 0; i<sensores.length; i++)
    {
      if(sensores[i] == null || sensores[i].getEstado() == 0){
          
              espaciosLibres += "Este espacio está libre "+(i+1)+"\n";
            
        }
    }
    return espaciosLibres;
  }

  public static String sensoresEstado()
  {
     String libreSensorEstado = "";
        for(int j = 0; j < sensores.length; j++)
        {
          if(sensores[j] != null)
          {
            if(sensores[j].getEstado() == 0)
            {
              libreSensorEstado += "El espacio "+(j+1)+" esta libre\n";
              
            }else{
              libreSensorEstado += "El espacio " + (j+1) + " esta ocupado\n" ;
            }
          }else{
              libreSensorEstado += "El espacio "+ (j+1) +" esta libre\n";
        }
    }
    return libreSensorEstado;
}

}