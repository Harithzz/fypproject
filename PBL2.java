package com.mycompany.pbl2;

import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class PBL2{

    static Scanner input = new Scanner(System.in);
    static ArrayList<Integer> ID = new ArrayList<>();
    static ArrayList<String> Title = new ArrayList<>();
    static ArrayList<String> Author = new ArrayList<>();
    static ArrayList<String> TP = new ArrayList<>();
    static ArrayList<Integer> ISBN = new ArrayList<>();
    static ArrayList<Integer> Tingkat = new ArrayList<>();
    static ArrayList<Integer> Rak = new ArrayList<>();
    static ArrayList<String> NamaPeminjam = new ArrayList<>();
    static ArrayList<LocalDate> Borrow = new ArrayList<LocalDate>();
    static ArrayList<LocalDate> Return = new ArrayList<LocalDate>();
    static ArrayList<String> Bookstatus = new ArrayList<>();
    static LocalDate TarikhPinjam = LocalDate.now();
    static LocalDate TarikhPulang = TarikhPinjam.plusDays(14);

    
    public static void main(String[] args) 
    {

        MainMenu();

    }
    
    
    static void MainMenu()   
    {
        String[] mainmenu= {"Buku \t\t","Carian \t\t","Pinjam \t","pulang buku \t","Display laporan faulty\t","Exit\t"};
        System.out.println("\nSelamat datang ke sistem library XYZ \n");
        System.out.println("Menu utama\n");
        
        
        for(int m=0;m<mainmenu.length;m++)
           
            {
                System.out.println("   "+(m+1)+". "+mainmenu[m] );       
            }
         
         System.out.print("   Pilihan: ");
         int option = input.nextInt();
        
            do{ 
                switch (option) 
                    {
                    case 1:
                    OptBuku();
                    break;
                
                    case 2:
                    OptCarian();
                    break;
                
                    case 3:
                    OptPinjam();
                    break;
                
                    case 4:
                    OptPulangBuku();
                    break;
                
                    case 5:
                    OptDisplayLaporanFaulty();
                    break;
                    
                    case 6:
                    exit(0);
                    break;
                
                    default:
                    System.out.println("The selected choice is unavailable");  
                    break;
                }
           
        }while(option>0 && option<6);  

    }
    
 
   
    
    static void OptBuku()
    {
        String[] Mbuku= {"Tambah Buku \t\t","Delete Buku \t\t","Display Buku \t\t","Return to main menu\t"};
        System.out.println("\nMenu Buku :\n");
        
        for(int n=0;n<Mbuku.length;n++)
           
          {
            System.out.println("   "+(n+1)+". "+Mbuku[n] );       
          }
        
        System.out.print("   Pilihan: ");
        int optionbuku = input.nextInt();
        
       
            switch (optionbuku) 
                {
                    case 1:
                    TambahBuku();
                    break;

                    case 2:
                    DeleteBuku();
                    break;

                    case 3:
                    DisplayBuku();
                    break;

                    case 4:
                    MainMenu();
                    break;

                    default:
                    System.out.println("The input entered is unvalid");
                }

    }
    
    
     static void TambahBuku()
    {
        System.out.println("\nTAMBAH BUKU\n");
        System.out.print("No ID :");
        int id = input.nextInt();
        int index = ID.indexOf(id);
        
        if (index != -1){
            System.out.printf("Buku dengan ID %d sudah wujud",id);
        }
        
        else{
        
        ID.add(id);

        System.out.print("Title :");
        String title = input.nextLine();
        title = input.nextLine();
        Title.add(title);
                
        System.out.print("Author :");
        String author = input.nextLine();
        Author.add(author);

        System.out.print("Tahun Published(00-00-0000) :");
        String tp = input.nextLine();
        TP.add(tp);

        System.out.print("No. ISBN :");
        int isbn = input.nextInt();
        ISBN.add(isbn);
        
        
        System.out.println("\nLokasi");
        System.out.print("Tingkat :");
        int tingkat = input.nextInt();
        Tingkat.add(tingkat);
        
        System.out.print("Rak :");
        int rak = input.nextInt();
        Rak.add(rak);
        
        System.out.println("\nAvailibility");
        System.out.print("Status(y/n) :");
        String available = input.nextLine();
        available =input.nextLine();
        Bookstatus.add(available);
               
        String notAvailable = "n";
        
        if(available.equals(notAvailable))
        {
            System.out.print("\nNama Peminjam : ");
            String Name = input.nextLine();
            NamaPeminjam.add(Name);

            System.out.print("\nTarikh Pinjam(00-00-0000): " + TarikhPinjam);
            Borrow.add(TarikhPinjam);
            
            System.out.print("\nTarikh Pulang(00-00-0000): " + TarikhPulang);
            Return.add(TarikhPulang);
        }
        
        else
        {
            //System.out.println("Nama peminjam :  ( by default  : NULL)\n" +"Tarikh pinjam: (by default : 00-00-0000)\n" +"Tarikh pulang: (by default : 00-00-0000)");
            NamaPeminjam.add(null);
            Borrow.add(null);
            Return.add(null);
        }
        
        System.out.println("\nBUKU TELAH DITAMBAH\n");
        }
        
        OptBuku();
  
    }  
     
    static void DisplayBuku()
    {
        
        System.out.println("\nDisplay buku\n");
        for(int p =0; p<ID.size();p++)
        {
        System.out.println("No ID :" + ID.get(p));         
        System.out.println("Title :" + Title.get(p));
        System.out.println("Author :" + Author.get(p));
        System.out.println("Tahun Published :" + TP.get(p));         
        System.out.println("No. ISBN :" + ISBN.get(p));
        System.out.println("\n");
        }
        
        OptBuku();
        
    }
    
    static void DeleteBuku()
    {
        System.out.println("\nDelete Buku");
        System.out.println("\nNo Id buku untuk di padam :");
        int delete = input.nextInt();
        
        int u = ID.indexOf(delete);
        
        ID.remove(u);
        Title.remove(u);
        Author.remove(u);
        TP.remove(u);
        ISBN.remove(u);
        Tingkat.remove(u);
        Rak.remove(u);
        Bookstatus.remove(u);
        NamaPeminjam.remove(u);
        Borrow.remove(u);
        Return.remove(u);
        
        System.out.println("\nBUKU TELAH DIPADAM OLEH SYSTEM\n");
        
        OptBuku();
        
    }
    
    
    static void OptCarian()
    {
        System.out.println("\nMenu carian\nSila masukkan title untuk di cari :");
        String keyword = input.next();

       
        boolean found = false;
        for (int i = 0; i < Title.size(); i++) 
        {
            if (Title.get(i).toLowerCase().contains(keyword.toLowerCase())) 
            {
                System.out.println("\nNo ID: " + ID.get(i));
                System.out.println("Title: " + Title.get(i));
                System.out.println("Author : " + Author.get(i));
                System.out.println("Tahun Published : " + TP.get(i));
                System.out.println("No.ISBN : " + ISBN.get(i));
                System.out.println("Status: " + Bookstatus.get(i)); 
                found = true;
                
                if(Bookstatus.get(i).equals("y"))
                {
                    System.out.println("\nLokasi");
                    System.out.println("Tingkat :" + Tingkat.get(i));
                    System.out.println("Rak :" + Rak.get(i));   
                }
                
                else
                {
                    System.out.println("\nTarikh pulang:" + Return.get(i));
                }
            }
        }

        if (!found) 
        {
            System.out.println("\ntiada buku yang ada keyword \"" + keyword + "\".");
        }
        
        
        MainMenu();
       
        
        
    }
    
    
    static void OptPinjam()
    {
        System.out.println("\nPinjam buku\n");
        System.out.println("No ID Buku :");
        int id = input.nextInt();
        int u = ID.indexOf(id);
        
        
            if (Bookstatus.get(u).equals("y"))
            {
                System.out.print("Nama Peminjam :");
                String peminjam = input.nextLine();
                peminjam = input.nextLine();
                NamaPeminjam.set(u,peminjam);
        
                Borrow.set(u, TarikhPinjam);
                System.out.print("Tarikh Pinjam : ");
                System.out.println(Borrow.get(u));

                Return.set(u, TarikhPulang);
                System.out.print("Tarikh Pulang : ");
                System.out.println(Return.get(u));
                
                Bookstatus.set(u, "n");
                System.out.println("\nBUKU TELAH DISIMPAN DI DALAM SYSTEM\n");
                
            }
        
            else
            {
                System.out.println("\nThe book is not available\n");   
            }

        MainMenu();  
        }
    
  
    static void OptPulangBuku()
    {
        System.out.println("\nPulang buku :\n");
        System.out.println("No ID Buku :");
        int idbook = input.nextInt();
        int w = ID.indexOf(idbook);
        
        Bookstatus.set(w, "y");
        NamaPeminjam.set(w,null);
        Borrow.set(w,null);
        Return.set(w,null);

        System.out.println("\nBUKU TELAH DIPULANGKAN\n");
        MainMenu();
 
    }
    
    
    static void OptDisplayLaporanFaulty()
    {
        System.out.println("\nDisplay laporan faulty\n");
        System.out.println("Buku yang masih belum dipulangkan\n");
        
        LocalDate current = LocalDate.now();
        
            System.out.println("No|\t title|\t\t date borrowed|\t\t date return|\t\t Overdue|");
            
        for (int r = 0; r < Title.size(); r++)
        {
            System.out.println("\n----------------------------------------------------------------------------------");
            
            if (Bookstatus.get(r).equals("n"))
            {
                
                System.out.print((r+1) + ".\t  " + Title.get(r) + "\t\t  " + Borrow.get(r) + "\t\t  " + Return.get(r) + "\t\t  ");
                
                if (TarikhPulang.isAfter(current))
                {
                    System.out.print("No");
                }
                
                else
                {
                    System.out.print("Yes");
                
                }
                /*System.out.println("Title :" + Title.get(r));
                System.out.println("Nama Peminjam :" + NamaPeminjam.get(r));
                System.out.println("Nama Pulang :" + Borrow.get(r));
                System.out.println("Tarikh Pulang :" + Return.get(r));*/

            }
        }  
        
        MainMenu();
}
}