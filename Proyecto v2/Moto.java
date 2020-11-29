public class Moto extends Vehiculo
{
  public Moto()
  {

  }
  
  public Moto(String p, String m,String c,String t)
  {
    super(p,m,c,"Moto");
  }

  public Moto(String p, String m, String c, int v )
  {
    super(p,m,c,"Moto",v);
  }
}