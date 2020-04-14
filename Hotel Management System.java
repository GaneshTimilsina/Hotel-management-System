import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.String;



class hotel_details
{
  void hotel_details_fun()
  {
    String hotel_name="Syangja 5 Star Hotel Ltd.";
    String hotel_address="Setidobhan-5, Syangja, Nepal";
    String hotel_contact="063-653748, +9779816653748";
    String hotel_gmail="syangjahotel@gmail.com";
    try
    {
      File hotel_saver = new File("HotelDetails.txt");
      if(!(hotel_saver.exists()))
      {
        hotel_saver.createNewFile();
      }
      
      FileWriter writes = new FileWriter("HotelDetails.txt");
      writes.write("\t\t===============================================\n");
      writes.write("\t\t\t"+hotel_name);
      writes.write("\n\t\t===============================================\n");
      writes.write("\n\tAddress: \t"+hotel_address);
      writes.write("\n\tContact: \t"+hotel_contact);
      writes.write("\n\tG-mail: \t"+hotel_gmail);
      
      writes.close();
      
      File file_hotel_saver1 = new File("HotelDetails.txt");
      Scanner reader = new Scanner(file_hotel_saver1);
      while(reader.hasNextLine())
      {
        String data = reader.nextLine();
        System.out.println(data);
      }
      
    }  
    catch(IOException e)
    {
      System.out.println("An Error Occured!!");
      e.printStackTrace();
    }
  }

}
class room_details extends hotel_details
{
  static int total_Room, price_Single_Room, price_Double_Room, ac;
  room_details()
  {
    total_Room=50;
    price_Single_Room=1500;
    price_Double_Room=2000;
    ac=500;  
  }
  void room_details_fun()
  {
    try
    {
      File room_saver = new File("RoomDetails.txt");
      if(!(room_saver.exists()))
      {
        room_saver.createNewFile();
      }
      
            
      FileWriter writes = new FileWriter("RoomDetails.txt");
      writes.write("\t\t===============================================\n");
      writes.write("\t\t\t\tRoom Details");
      writes.write("\n\t\t===============================================\n");
      writes.write("\n\t\tTotal Rooms:\t"+total_Room);      
      writes.write("\n\n\t1. Single Bed Room:        "+price_Single_Room);
      writes.write("\n\t2. Double bed Room:        "+price_Double_Room);
      writes.write("\n\t3. Single Bed Room(A/C):   "+(price_Single_Room+ac));
      writes.write("\n\t4. Double bed Room(A/C):   "+(price_Double_Room)+ac);
      writes.write("\n\t5. 32\" Smart TV");
      writes.write("\n\t6. Attached Bathroom");
      writes.write("\n\t7. 24/7 Power Supply");
      writes.close();
      
      
      File file_room_saver1 = new File("RoomDetails.txt");
      Scanner reader = new Scanner(file_room_saver1);
      while(reader.hasNextLine())
      {
        String data = reader.nextLine();
        System.out.println(data);
      }
      
    }  
    catch(IOException e)
    {
      System.out.println("An Error Occured!!");
      e.printStackTrace();
    }
    
  
  }

}
class Room_Bill
{
  Scanner get = new Scanner(System.in);
  String roomno,ac;
  public int rm=0;
  int roomprice_dec=0;
  int days, total,roomprice;
  void bookRoom()
  {
    rm=rm+1;
    System.out.println(rm);
    do
    {
      System.out.println("Do you want to book single bed or double bed room?(S/s: for Single and D/d: for Double)");
      roomno=get.next();
      roomno=roomno.toUpperCase();
    }while((roomno.charAt(0))!='S' && (roomno.charAt(0))!='D');
    
    do
    {
      System.out.println("\nA/C or Non A/C(1 for AC & 2 for Non A/C)");
      ac=get.next();
      ac=ac.toUpperCase();
    }while((ac.charAt(0))!='A' && (ac.charAt(0))!='N');
     System.out.println("For how many Days you want to book?");
     days=get.nextInt();
  }
  int total_room()
  {
    room_details obj = new room_details();
    
    if((roomno.charAt(0))=='S') roomprice = obj.price_Single_Room;
    else roomprice = obj.price_Double_Room;
    
    if((ac.charAt(0))=='A') roomprice = roomprice+obj.ac;
    
    
    
    System.out.println("\n\n   *************************************************************");
    System.out.println("\t\t\tBill Summary");
    System.out.println("   *************************************************************");
      System.out.println("\n\n   Room Details");
      System.out.println("   =====================================================================\n");
      System.out.println("\tDescription \t\t\tPrice");
      if(rm!=0)
      {
        roomprice_dec=roomprice*days;
        if(((roomno.charAt(0)))=='S')
        {
          System.out.println("\tSingle Bed Room: \t\t1500");         
        }
        else
        {
          System.out.println("\tDoubel Bed Room: \t\t2000");
        }
        if((ac.charAt(0))=='A')
        {
          System.out.println("\tA/C Room: \t\t\t500");
        }
        else
        {
          System.out.println("\tNon A/C Room: \t\t0");
        }
        System.out.println("\tRoom Booked:    "+days+" (Days) ");
        System.out.println("\n\n\t\t\tTotal: "+days+" * " +roomprice+" = "+roomprice_dec);
      }
      else
      System.out.println("\n\t\tYou havent Booked Any Room Yet!!!");
      return roomprice_dec;   
    
  } 

  class Food_Bill
  {
    String your_Food;
    int fd_bill=0;
    int decf=0;
    Room_Bill obj = new Room_Bill();
    
    Scanner get = new Scanner(System.in);
    void choose_food()
    {
      decf=decf+1;
      System.out.println("\n\n    ================================================================");
      System.out.println("\tS.N\t\tFood \t\t\t Price(per plate)\n");
      System.out.println("\t1. \t\tDal Bhat Tarkari\t Rs. 200");
      System.out.println("\t2. \t\tChicken thali\t\t Rs. 350");
      System.out.println("\t3. \t\tKhaja set(Veg)\t\t Rs. 250");
      System.out.println("\t4. \t\tKhaja set(Chicken)\t Rs. 350");
      System.out.println("\t5. \t\tMO:MO(Veb)\t\t Rs. 80");
      System.out.println("\t6. \t\tMO:MO(Chicken)\t\t Rs. 120");
      System.out.println("\t7. \t\tChaumin\t\t\t Rs. 100");
      System.out.println("    ================================================================");
      System.out.print("\n\tOrder Your Food: eg(1,2,4): ");      
      your_Food = get.nextLine();    
    }
    
    void total_bill(int ttl)
    {      
      System.out.println("\n\n   Food Bill");
      System.out.println("   =====================================================================\n");
      System.out.println("\tS.N\t\tFood \t\t\t Price(per plate)\n");
      if(decf!=0)
      {
        String [] arr_food = your_Food.split(",");
        String food;
      
      
        for(int i = 0; i<arr_food.length; i++)
        {
          if((arr_food[i].charAt(0))=='1') System.out.println("\t1. \t\tDal Bhat Tarkari\t Rs. 200");
          if((arr_food[i].charAt(0))=='2') System.out.println("\t2. \t\tChicken thali\t\t Rs. 350");
          if((arr_food[i].charAt(0))=='3') System.out.println("\t3. \t\tKhaja set(Veg)\t\t Rs. 250");
          if((arr_food[i].charAt(0))=='4') System.out.println("\t4. \t\tKhaja set(Chicken)\t Rs. 350");
          if((arr_food[i].charAt(0))=='5') System.out.println("\t5. \t\tMO:MO(Veb)\t\t Rs. 80");
          if((arr_food[i].charAt(0))=='6') System.out.println("\t6. \t\tMO:MO(Chicken)\t\t Rs. 120");
          if((arr_food[i].charAt(0))=='7') System.out.println("\t7. \t\tChaumin\t\t\t Rs. 100");
   
        }
        for(int i = 0; i<arr_food.length; i++)
        {
          if((arr_food[i].charAt(0))=='1') fd_bill=fd_bill+200;
          if((arr_food[i].charAt(0))=='2') fd_bill=fd_bill+350;
          if((arr_food[i].charAt(0))=='3') fd_bill=fd_bill+250;
          if((arr_food[i].charAt(0))=='4') fd_bill=fd_bill+350;
          if((arr_food[i].charAt(0))=='5') fd_bill=fd_bill+80;
          if((arr_food[i].charAt(0))=='6') fd_bill=fd_bill+120;
          if((arr_food[i].charAt(0))=='7') fd_bill=fd_bill+100;
   
        }
      }
      else
      {
        System.out.println("\n\t\tYou havent Ordered Any Food Yet!!!");
      }
      System.out.println("\n  *****************************************************************");
      fd_bill=fd_bill+ttl;
      System.out.println("\t\t\tGrand Total:\t\t\t "+fd_bill);
      System.out.println("  *****************************************************************");
      
     
   
    }
  } 
}
 class Hotel
{
  public static void main(String[] args)
  {
    int main_choice;
    String dec;
    Room_Bill roomBill_obj = new Room_Bill();
    Room_Bill.Food_Bill foodBill_obj = roomBill_obj.new Food_Bill();
    
    room_details inherit_obj = new room_details();
    
    
    Scanner get = new Scanner(System.in);
    do
    {
      System.out.println("\n\n    ================================================================");
      System.out.println("\t\t\tSyangja 5 Star Hotel Ltd.");
      System.out.println("    ================================================================");
      System.out.println("\t\t1. Book Room");
      System.out.println("\t\t2. Order Food");
      System.out.println("\t\t3. Pay Bill");
      System.out.println("\t\t4. About Hotels");
      System.out.println("\t\t5. About Hotel's Room");
      System.out.print("    ================================================================\n\t\t");
      main_choice = get.nextInt();
      switch(main_choice)
      {
        case 1:
        {
          roomBill_obj.bookRoom();
          
          get.nextLine();
          System.out.println("Do you want to order Food along with Room?");
          String o = get.nextLine();
          o = o.toUpperCase();
          if((o.charAt(0))=='Y')
          {
            foodBill_obj.choose_food();          
          }
          break;
        }
        case 2:
        {
          foodBill_obj.total_bill(0);
          break;
        }
        case 3:
        {
          int ttl = roomBill_obj.total_room();
          foodBill_obj.total_bill(ttl);
          break;
        }
        case 4:
        {
          System.out.println("\n\n");
          inherit_obj.hotel_details_fun();
          System.out.println("\n\n");
          break;
        }
        case 5:
        {
          System.out.println("\n\n");
          inherit_obj.room_details_fun();
          System.out.println("\n\n");
          break;
        }
        default:
        {
          System.out.println("Invalid Input");
        }
    
      }
      get.nextLine();
      System.out.println("Do you want to exit?(Y/N)");
      dec = get.nextLine();
      dec = dec.toUpperCase();
      System.out.println();
    }while((dec.charAt(0)=='N'));
      

    
  }
  
}