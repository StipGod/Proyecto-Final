public class Carro extends Vehiculo
{
  public Carro()
  {

  }
  
  public Carro(String p, String m,String c,String t)
  {
    super(p,m,c,"Carro");
  }

  public Carro(String p, String m, String c, int v )
  {
    super(p,m,c,"Carro",v);
  }
}