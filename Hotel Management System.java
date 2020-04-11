import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


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
      writes.write("\n\tG-mail: \t\t"+hotel_gmail);
      
      writes.close();
      
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
      writes.write("\t\t\tRoom Details");
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
  int roomno, days, total,ac,roomprice;
  void bookRoom()
  {
    System.out.println("Do you want to book single bed or double bed room?(1 for Single and 2 for Double)");
    roomno=get.nextInt();
    System.out.println("\nA/C or Non A/C(1 for AC & 2 for Non A/C)");
    ac=get.nextInt();
    System.out.println("For how many Days you want to book?");
    days=get.nextInt();
  }
  void total_room()
  {
    room_details obj = new room_details();
    
    if(roomno==1) roomprice = obj.price_Single_Room;
    else roomprice = obj.price_Double_Room;
    
    if(ac==1) roomprice = roomprice+obj.ac;
    
    total=roomprice*days;
    System.out.println(total);
  }  
  //class Food_Bill
  //{
   
  //}
}
 class Hotel
{
  public static void main(String[] args)
  {
    Room_Bill obj = new Room_Bill();
    obj.bookRoom();
    obj.total_room();
    /*
    room_details objOfRoom = new room_details();
    objOfRoom.hotel_details_fun();
    objOfRoom.room_details_fun(); 
    */
  }
}