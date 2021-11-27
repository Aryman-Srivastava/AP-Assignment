package sem2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
interface Image{
    Image input();
    Image create();
    Image update();
    void display();
    Image NegValues();
}
class GrayScale implements Image{
    Scanner sc = new Scanner(System.in);
    private final int size;
    private final int [][][] img;
    GrayScale(int n){
        this.size = n;
        img = new int[1][size][size];
    }
    public int getSize() {
        return size;
    }

    @Override
    public Image input(){
//        System.out.println("Enter the values: ");
//        for(int i = 0;i<size;i++){
//            for(int j = 0;j<size;j++){
//                this.img[i][j] = sc.nextInt();
//            }
//        }
        System.out.println("Enter the values: ");
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.img[0][i][j] = sc.nextInt();
            }
        }
        return this;
    }
    @Override
    public Image create(){
//        for(int i = 0;i<size;i++){
//            for(int j = 0;j<size;j++){
//                this.img[i][j] = 0;
//            }
//        }
//        display();
        return this;
    }
    @Override
    public Image update() {
        while (true) {
            System.out.println("Where to commit change: ");
            int r = sc.nextInt();
            int c = sc.nextInt();
            System.out.println("Enter the GrayScale value: ");
            this.img[0][r][c] = sc.nextInt();
            System.out.println("Do you want to commit more changes(y/n): ");
            String ch = sc.next();
            if (ch.equals("n")) {
                break;
            }
        }
        return this;
    }
    @Override
    public void display(){
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                System.out.print(this.img[0][i][j] + " ");
            }
            System.out.println();
        }
    }
    @Override
    public Image NegValues(){
        for (int i = 0; i < this.size; i++) {
                for (int j = 0; j < this.size; j++) {
                    this.img[0][i][j] = 255 - this.img[0][i][j];
                }
            }
        return this;
    }
}
class RGB implements Image{
    Scanner sc = new Scanner(System.in);
    private final int size;
    private final int[] [][] img;
    RGB(int n){
        this.size = n;
        img = new int[size][size][];
    }
    @Override
    public Image input(){
//        System.out.println("Enter the values: ");
//        for(int i = 0;i<size;i++){
//            for(int j = 0;j<size;j++){
//                System.out.println("Enter the R, G, B values: ");
//                int [] arr = new int[3];
//                arr[0] = sc.nextInt();
//                arr[1] = sc.nextInt();
//                arr[2] = sc.nextInt();
//                this.img[i][j] = arr;
//            }
//        }
        System.out.println("Enter the values: ");
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                System.out.println("Enter the R, G, B values: ");
                int[] arr = new int[3];
                arr[0] = sc.nextInt();
                arr[1] = sc.nextInt();
                arr[2] = sc.nextInt();
                this.img[i][j] = arr;
            }
        }
        return this;
    }
    @Override
    public Image create(){
//        for(int i = 0;i<size;i++){
//            for(int j = 0;j<size;j++){
//                int [] arr = new int[3];
//                this.img[i][j] = arr;
//            }
//        }
//        display();
        return this;
    }
    @Override
    public Image update(){
        while (true) {
                System.out.println("Where to commit change: ");
                int r = sc.nextInt();
                int c = sc.nextInt();
                System.out.println("Enter the R, G, B value: ");
                int[] arr = new int[3];
                arr[0] = sc.nextInt();
                arr[1] = sc.nextInt();
                arr[2] = sc.nextInt();
                this.img[r][c] = arr;
                System.out.println("Do you want to commit more changes(y/n): ");
                String ch = sc.next();
                if (ch.equals("n")) {
                    break;
                }
            }
        return this;
    }
    @Override
    public void display(){
        System.out.println("RED: ");
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                System.out.print(this.img[i][j][0] + " ");
            }
            System.out.println();
        }
        System.out.println("BLUE: ");
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                System.out.print(this.img[i][j][1] + " ");
            }
            System.out.println();
        }
        System.out.println("GREEN: ");
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                System.out.print(this.img[i][j][2] + " ");
            }
            System.out.println();
        }
    }
    @Override
    public Image NegValues(){
        for (int i = 0; i < this.size; i++) {
                for (int j = 0; j < this.size; j++) {
                    for (int k = 0; k < 3; k++) {
                        this.img[i][j][k] = 255 - this.img[i][j][k];
                    }
                }
            }
        return this;
    }
}
class Operations<T extends Image>{
    protected Object input(T image) {
//            System.out.println("Enter the values: ");
//            for (int i = 0; i < ((GrayScale) image).getSize(); i++) {
//                for (int j = 0; j < ((GrayScale) image).getSize(); j++) {
//                    ((GrayScale) image).getImg()[i][j] = sc.nextInt();
//                }
//            }
//            return image;
//        } else {
//            System.out.println("Enter the values: ");
//            for (int i = 0; i < ((RGB) image).getSize(); i++) {
//                for (int j = 0; j < ((RGB) image).getSize(); j++) {
//                    System.out.println("Enter the R, G, B values: ");
//                    int[] arr = new int[3];
//                    arr[0] = sc.nextInt();
//                    arr[1] = sc.nextInt();
//                    arr[2] = sc.nextInt();
//                    ((RGB) image).getImg()[i][j] = arr;
//                }
//            }
//            return image;
//        }
        return image.input();
    }
    protected Object create(T image) {
//        if (image instanceof GrayScale) {
//            for (int i = 0; i < ((GrayScale) image).getSize(); i++) {
//                for (int j = 0; j < ((GrayScale) image).getSize(); j++) {
//                    ((GrayScale) image).getImg()[0][i][j] = 0;
//                }
//            }
//        } else {
//            for (int i = 0; i < ((RGB) image).getSize(); i++) {
//                for (int j = 0; j < ((RGB) image).getSize(); j++) {
//                    int[] arr = new int[3];
//                    ((RGB) image).getImg()[i][j] = arr;
//                }
//            }
//        }
//        display(image);
//        return image;
        return image.create();
    }
    protected Object update(T image) {
//        if (image instanceof GrayScale) {
//            while (true) {
//                System.out.println("Where to commit change: ");
//                int r = sc.nextInt();
//                int c = sc.nextInt();
//                System.out.println("Enter the GrayScale value: ");
//                ((GrayScale) image).getImg()[r][c] = sc.nextInt();
//                System.out.println("Do you want to commit more changes(y/n): ");
//                String ch = sc.next();
//                if (ch.equals("n")) {
//                    break;
//                }
//            }
//        } else {
//            while (true) {
//                System.out.println("Where to commit change: ");
//                int r = sc.nextInt();
//                int c = sc.nextInt();
//                System.out.println("Enter the R, G, B value: ");
//                int[] arr = new int[3];
//                arr[0] = sc.nextInt();
//                arr[1] = sc.nextInt();
//                arr[2] = sc.nextInt();
//                ((RGB) image).getImg()[r][c] = arr;
//                System.out.println("Do you want to commit more changes(y/n): ");
//                String ch = sc.next();
//                if (ch.equals("n")) {
//                    break;
//                }
//            }
//        }
//        return image;
        return image.update();
    }
    protected void display(T image) {
//        if (image instanceof GrayScale) {
//            for (int i = 0; i < ((GrayScale) image).getSize(); i++) {
//                for (int j = 0; j < ((GrayScale) image).getSize(); j++) {
//                    System.out.print(((GrayScale) image).getImg()[i][j] + " ");
//                }
//                System.out.println();
//            }
//        } else {
//            System.out.println("RED: ");
//            for (int i = 0; i < ((RGB) image).getSize(); i++) {
//                for (int j = 0; j < ((RGB) image).getSize(); j++) {
//                    System.out.print(((RGB) image).getImg()[i][j][0] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("BLUE: ");
//            for (int i = 0; i < ((RGB) image).getSize(); i++) {
//                for (int j = 0; j < ((RGB) image).getSize(); j++) {
//                    System.out.print(((RGB) image).getImg()[i][j][1] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("GREEN: ");
//            for (int i = 0; i < ((RGB) image).getSize(); i++) {
//                for (int j = 0; j < ((RGB) image).getSize(); j++) {
//                    System.out.print(((RGB) image).getImg()[i][j][2] + " ");
//                }
//                System.out.println();
//            }
//        }
        image.display();
    }
    protected Object NegValues(T image) {
//        if (image instanceof GrayScale) {
//            for (int i = 0; i < ((GrayScale) image).getSize(); i++) {
//                for (int j = 0; j < ((GrayScale) image).getSize(); j++) {
//                    ((GrayScale) image).getImg()[i][j] = 255 - ((GrayScale) image).getImg()[i][j];
//                }
//            }
//        } else {
//            for (int i = 0; i < ((RGB) image).getSize(); i++) {
//                for (int j = 0; j < ((RGB) image).getSize(); j++) {
//                    for (int k = 0; k < 3; k++) {
//                        ((RGB) image).getImg()[i][j][k] = 255 - ((RGB) image).getImg()[i][j][k];
//                    }
//                }
//            }
//        }
//        display(image);
//        return image;
        return image.NegValues();
    }
}
public class Assignment4_part2 {
    private final ArrayList<Image> g = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int menu(){
        System.out.println("""
                ENTER YOUR OPERATION:
                
                1. INPUT THE MATRIX
                2. CREATE A MATRIX
                3. UPDATE THE MATRIX
                4. DISPLAY THE MATRIX
                5. NEGATIVE VALUES
                """);
        return sc.nextInt();
    }
    public Image Set(String type, int n){
        Image img;
        if(type.equals("grayscale")){
            img = new GrayScale(n);
        }
        else{
            img = new RGB(n);
        }
        return img;
    }
    public static void main(String[] args) throws IOException {
        Assignment4_part2 ap = new Assignment4_part2();
        System.out.println("Enter the Type of Image: ");
        String type = reader.readLine();
        System.out.println("Enter the size of the image: ");
        int n = sc.nextInt();
        Operations<Image> op = new Operations<>();
        Image img = ap.Set(type,n);
        while(true){
            int choice = menu();
            if(choice  == 1 || choice  == 2 || choice  == 3 || choice  == 4 || choice  == 5) {
                switch (choice) {
                    case 1: {
                        img = (Image) op.input(img);
                        ap.g.add(img);
                    }
                    break;
                    case 2: {
                        img = ap.Set(type,n);
                        img = (Image) op.create(img);
                        ap.g.add(img);
                    }
                    break;
                    case 3: {
                        for(int i = 0;i<ap.g.size();i++){
                            System.out.println(i + ": ");
                            op.display(ap.g.get(i));
                            System.out.println();
                        }
                        System.out.println("Enter the ID of the Matrix to be updated: ");
                        int q = sc.nextInt();
                        img = (Image)  op.update(ap.g.get(q));
                        ap.g.set(q,img);
                    }
                    break;
                    case 4: {
                        for(int i = 0;i<ap.g.size();i++){
                            System.out.println(i + ": ");
                            op.display(ap.g.get(i));
                        }
                    }
                    break;
                    case 5: {
                        for(int i = 0;i<ap.g.size();i++){
                            System.out.println(i + ": ");
                            op.display(ap.g.get(i));
                            System.out.println();
                        }
                        System.out.println("Enter the ID of the Matrix: ");
                        int q = sc.nextInt();
                        img = (Image)  op.NegValues(ap.g.get(q));
                        ap.g.set(q,img);
                    }
                    break;
                    default: break;
                }
            }
            else{
                System.out.println("Thank You");
                break;
            }
        }
    }
}