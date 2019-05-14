import java.util.ArrayList;

public class TanKodeWarsDemo
{
   final String SERVER_IP = "127.0.0.1";

   public static void main(String args)
   {
      Tank tank = new Tank(); 
      List<Tank> allTanks = new ArrayList<Tank>();
      TanKodeHandler tankode = new TanKodeHandler(SERVER_IP); 
      
      
      while(!tank.isDead())
      {
         tankode.send(tank.getOrders());
         tank.update(tankode.getTanks());
      }
      
   }
}  

public class Tank
{
   private int hp;
   
   public Tank()
   {
      
   }
   
   public boolean isDead()
   {
      return this.hp == 0; 
   }
      
}

public class MyTank extends Tank
{
   public MyTank()
   {
   
   }

   public String getOrders()
   {
      return "";
   }

}

public class TanKodeHandler
{
   private String server;
   private String tanks;

   public TanKodeHandler(serverIP)
   {
      this.server = serverIP;
   }
   
   public boolean send(String data)
   {
      return true;
   }
   
   public String receive()
   {
      return "";
   }
   
   public String getTanks()
   {
      return this.tanks;
   }
}