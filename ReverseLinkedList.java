import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.*;

public class ReverseLinkedList {

    private static LinkedList<String> Words = new LinkedList<String>();
    private static LinkedList<String> RWords = new LinkedList<String>();
    private static Random rand = new Random();
    private static int size_of_dict = 69903;
    private static Scanner scan = new Scanner(System.in);
     
    private static void getlist(int leng)
     {
        int place = 0;
        String foo = "";
        for(int i = 0; i < leng; i++)
        {
            place = rand.nextInt(size_of_dict);
            try {
                foo = Files.readAllLines(Paths.get("dict.txt")).get(place);
                Words.addLast(foo + " ");
            } catch (IOException e) {
                System.out.print("File not found!");
            }
        }
     }

     private static void print(LinkedList<String> what)
     {
        for(int i = 0; i < what.size(); i++)
            System.out.print(what.get(i) + "");
        System.out.println();
     }

     private static LinkedList<String> reverse_list(LinkedList<String> what)
     {
        LinkedList<String> here = new LinkedList<String>();
        for (int i = what.size() - 1; i >= 0; i--)
            here.add(what.get(i));
        return here;
     }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String foo = "";
        int leng = 0;
        while(true)
        {
            System.out.println("Program is running.\nProgram will take random words from dictinary print them in oreder then in reverse order.");
            System.out.println("How many words do you want list to have ?\nNumber must be positive and not larger than 69903");
            try {
                leng = scan.nextInt();
                if(leng <= 0 || leng > size_of_dict)
                    throw new IllegalArgumentException();
            } catch (Exception e) {
                System.out.println("ERROR! Wrong number entered!");
                continue;
            }
            ReverseLinkedList.getlist(leng);
            ReverseLinkedList.print(Words);
            RWords = ReverseLinkedList.reverse_list(Words);
            ReverseLinkedList.print(RWords);

            System.out.println("Do you want to terminate the program y/Y ?");
            foo = read.nextLine();
            if(foo.equals("y") || foo.equals("Y"))
                break;
        }
        System.out.println("Program was terminated");
        read.close();
        scan.close();
    }
}
