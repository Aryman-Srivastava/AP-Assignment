package sem2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
class SortAll{
    private final Books [] b;
    private final int n;
    SortAll(int n){
        this.b = new Books[n];
        this.n = n;
    }
    public Books[] Sorting(){
//        name
        Books temp;
        for(int i = 0;i<this.n;i++){
            Books b_min = this.b[i];
            int index = -1;
            for(int j = i + 1;j<this.n;j++){
                if(b_min.getName().compareTo(this.b[j].getName())>0){
                    b_min = this.b[j];
                    index = j;
                }
            }
            temp = this.b[i];
            this.b[i] = b[index];
            this.b[index] = temp;
        }
//        ISBN
        for(int i = 0;i<this.n-1;i++){
            if(this.b[i].getName().equals(this.b[i+1].getName())){
                if(this.b[i].getISBN() > this.b[i+1].getISBN()){
                    temp = this.b[i];
                    this.b[i] = this.b[i+1];
                    this.b[i+1] = temp;
                }
            }
        }
//        Barcode
        for(int i = 0;i<this.n-1;i++){
            if(this.b[i].getISBN() == this.b[i+1].getISBN()){
                if(this.b[i].getBarcode() > this.b[i+1].getBarcode()){
                    temp = this.b[i];
                    this.b[i] = this.b[i+1];
                    this.b[i+1] = temp;
                }
            }
        }
        return this.b;
    }
}
*/

class BooksName implements Comparator<Books> {
    @Override
    public int compare(Books b1, Books b2) {
        return b1.getName().compareTo(b2.getName());
    }
}
class BooksISBN implements Comparator<Books> {
    @Override
    public int compare(Books b1, Books b2) {
        return Integer.compare(b1.getISBN(),b2.getISBN());
    }
}
class BooksBarcode implements Comparator<Books> {
    @Override
    public int compare(Books b1, Books b2) {
        return Integer.compare(b1.getBarcode(),b2.getBarcode());
    }
}

class Books{
    private final String Name;
    private final int ISBN;
    private final int Barcode;
    Books(String name, int ISBN, int Barcode){
        this.Name = name;
        this.ISBN = ISBN;
        this.Barcode = Barcode;
    }
    public String getName() {
        return this.Name;
    }
    public int getBarcode() {
        return this.Barcode;
    }
    public int getISBN() {
        return this.ISBN;
    }
    @Override
    public String toString(){
        return String.format("%s\t%d\t%d", Name,ISBN,Barcode);
    }
}

class BooksSort implements Comparator<Books> {
    private final List<Comparator<Books>> b;
    @SafeVarargs
    public BooksSort(Comparator<Books>... books) {
        this.b = Arrays.asList(books);
    }
    @Override
    public int compare(Books b1, Books b2) {
        for (int i = 0; i < b.size(); i++){
            int result = b.get(i).compare(b1, b2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}

public class Assignment4_part1 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Scanner sc = new Scanner(System.in);

    Books[][] Arrange(Books[][] BNew,ArrayList<Books> b,int k, int n){
        int q = 0;
        for(int i = 0;i<k;i++){
            for(int j = 0;j<n/k;j++){
                BNew[i][j] = b.get(q);
                q++;
            }
        }
        return BNew;
    }

    static void Display(String name, int ISBN, int Barcode, Books [][] BNew, int n, int k){
        for(int i = 0;i<k;i++){
            for(int j = 0;j<n/k;j++){
                if(BNew[i][i].getName().equals(name) && BNew[i][j].getISBN() == ISBN && BNew[i][j].getBarcode() == Barcode){
                    System.out.println("Slot for the Books is: " + (i+1) + " Row " + (j+1) + " Column");
                    return;
                }
            }
        }
        System.out.println("Book not found");
    }

    Boolean CheckBarcode(ArrayList<Books> b, int Barcode,int n){
        for(int i = 0;i<n;i++){
            if(b.get(i).getBarcode() == Barcode){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Assignment4_part1 ap = new Assignment4_part1();
        ArrayList<Books> listBooks = new ArrayList<>();
        System.out.println("Enter the value of N,K: ");
        int n = sc.nextInt();
        int k = sc.nextInt();
        if(n%k != 0){
            System.out.println("Wrong values");
            System.exit(0);
        }
        System.out.println("Enter the Books Details: ");
        listBooks.add(new Books(reader.readLine(), sc.nextInt(), sc.nextInt()));
        for(int i = 0;i<n-1;i++){
            System.out.println("Enter the Books Details: ");
            Books b = new Books(reader.readLine(), sc.nextInt(), sc.nextInt());
            if(ap.CheckBarcode(listBooks,b.getBarcode(),listBooks.size())) {
                listBooks.add(b);
            }
            else{
                System.out.println("Barcode Already present");
                i--;
            }
        }

/*        System.out.println("*** Before sorting:");
        for(int i = 0;i<listBooks.size();i++) {
            System.out.println(listBooks.get(i));
        }
*/
        listBooks.sort(new BooksSort(new BooksName(), new BooksISBN(), new BooksBarcode()));
        Books [][] BNew = new Books[k+1][(n/k)+1];
        BNew = ap.Arrange(BNew,listBooks,k,n);
        while(true) {
            System.out.println("Enter the Book Name: ");
            String name = reader.readLine();
            System.out.println("Enter ISBN Code: ");
            int ISBN = sc.nextInt();
            System.out.println("Enter the Barcode: ");
            int Barcode = sc.nextInt();
            Display(name, ISBN, Barcode, BNew, n, k);
            System.out.println("Do you want to find another book(y/n): ");
            String s = reader.readLine();
            if(s.equals("n")){
                System.out.println("Thank You");
                break;
            }
        }

/*
System.out.println("\n*** After sorting:");
for(int i = 0;i<k;i++){
            for(int j = 0;j<(n/k);j++){
                System.out.print(BNew[i][j].getName() + " " + BNew[i][j].getISBN() + " " + BNew[i][j].getBarcode() + " ");
            }
            System.out.println();
       }
*/
    }
}
