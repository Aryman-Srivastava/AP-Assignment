package sem2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
class Vaccine{
    private final String name;
    private final int nOd;
    private final int gBD;
    Vaccine(String name,int nOd,int gBD) {
        this.name = name;
        this.nOd = nOd;
        this.gBD = gBD;
    }
    public String getName() {
        return name;
    }
    public int getgBD() {
        return gBD;
    }
    public int getnOd() {
        return nOd;
    }
}
class Citizen{
    private final String name;
    private final int age;
    private final long ID;
    private String status;
    private String vaccine;
    private int doses;
    private int nod;
    Citizen(String name,int age,long ID){
        this.name = name;
        this.age = age;
        this.ID = ID;
        this.status = "REGISTERED";
        this.vaccine = "none";
        this.doses = 0;
    }
    public long getID() {
        return this.ID;
    }
    public String getName() {
        return name;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }
    public String getVaccine() {
        return vaccine;
    }
    public int getDoses() {
        return doses;
    }
    public void setDoses(int doses) {
        this.doses = doses;
    }
    public int getNod() {
        return nod;
    }
    public void setNod(int nod) {
        this.nod = nod;
    }
}
public class AP_Assignment {
    public static String ID() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }
    public static String addID(String name,String PinCode){
        String s = ID();
        int i = 0;
        while(i<hospital.size()){
            String [] temp = hospital.get(i);
            if(temp[1].equals(s)){
                s = ID();
                i = 0;
            }
            i++;
        }
        String[] a = {name,s,PinCode};
        hospital.add(a);
        return s;
    }
    static HashMap<Integer, ArrayList<String[]>> hMap = new HashMap<>();
    static ArrayList<String[]> slots = new ArrayList<>();
    static ArrayList<String[]> hospital = new ArrayList<>();
    static ArrayList<Citizen> citizens = new ArrayList<>();
    static ArrayList<Vaccine> vaccines = new ArrayList<>();
    public static void main(String[] args) {
        String s1 = "CoWin Portal initialized....";
        String s2 = "---------------------------------";
        String menu = "1. Add Vaccine \n2. Register Hospital\n3. Register Citizen\n4. Add Slot for Vaccination\n5. Book Slot for Vaccination\n6. List all slots for a hospital\n7. Check Vaccination Status\n8. Exit";
        System.out.println(s1 + "\n" + s2);
        while(true){
        System.out.println(menu + "\n" + s2);
        Scanner sc = new Scanner(System.in);
        String choice = sc.next();

        switch (choice) {
            case "1": {
                System.out.print("Vaccine Name: ");
                String vName = sc.next();
                System.out.print("Number of Doses: ");
                int no_of_doses = sc.nextInt();
                int Gap_between_doses;
                if (no_of_doses == 1) {
                    Gap_between_doses = 0;
                } else {
                    System.out.print("Gap between Doses: ");
                    Gap_between_doses = sc.nextInt();
                }
                Vaccine v = new Vaccine(vName,no_of_doses,Gap_between_doses);
                vaccines.add(v);
                System.out.println("Vaccine Name: " + vName + ", Number of Doses: " + no_of_doses + ", Gap Between Doses: " + Gap_between_doses);
            }
            break;
            case "2": {
                System.out.print("Hospital Name: ");
                String hName = sc.next();
                System.out.print("PinCode: ");
                String PinCode = sc.next();
                String ID = addID(hName, PinCode);
                System.out.println("Hospital Name: " + hName + ", PinCode: " + PinCode + ", Unique ID: " + ID);
            }
            break;
            case "3": {
                System.out.print("Citizen Name: ");
                String cName = sc.next();
                System.out.print("Age: ");
                int age = sc.nextInt();
                System.out.print("Unique ID: ");
                long ID = sc.nextLong();
                System.out.println("Citizen Name: " + cName + ", Age: " + age + ", Unique ID: " + ID);
                if (age < 18) {
                    System.out. println("Only above 18 are allowed");
                }
                else{
                    Citizen c = new Citizen(cName,age,ID);
                    citizens.add(c);
                }
            }
            break;
            case "4": {
                System.out.print("Enter Hospital ID: ");
                int ID = sc.nextInt();
                System.out.print("Enter number of Slots to be added: ");
                int no_of_slots = sc.nextInt();
                for (int i = 0; i < no_of_slots; i++) {
                    System.out.print("Enter Day Number: ");
                    int day = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();
                    System.out.println("Select Vaccine: ");
                    for(int j = 0;j<vaccines.size();j++){
                        Vaccine v = vaccines.get(j);
                        System.out.println(j + ". "+ v.getName());
                    }
                    int vac = sc.nextInt();
                    String[] slot = {Integer.toString(day), Integer.toString(quantity), vaccines.get(vac).getName()};
                    boolean flag = false;
                    for(int j = 0;j< hospital.size();j++) {
                        flag = true;
                        if (hospital.get(j)[1].equals(Integer.toString(ID))) {
                            if (hMap.containsKey(ID)) {
                                slots = hMap.get(ID);
                                slots.add(slot);
                                hMap.put(ID, slots);
                                System.out.println("Slot added by Hospital " + ID + " for Day: " + day + ", Available Quantity: " + quantity + " of Vaccine " + vaccines.get(vac).getName());
                                break;
                            } else {
                                slots.add(slot);
                                hMap.put(ID, slots);
                                System.out.println("Slot added by Hospital " + ID + " for Day: " + day + ", Available Quantity: " + quantity + " of Vaccine " + vaccines.get(vac).getName());
                                break;
                            }
                        }
                    }
                    if(!flag){
                       System.out.println("No such hospital exist");
                    }
                }
            }
            break;
            case "5": {
                if(citizens.size() == 0){
                    System.out.println("No citizen registered");
                    break;
                }
                else{
                    Citizen c = citizens.get(0);
                    System.out.print("Enter patient Unique ID: ");
                    long ID = sc.nextLong();
                    for(int i = 0;i< citizens.size() ;i++) {
                        c = citizens.get(i);
                        if (c.getID() == ID) {
                            break;
                        }
                    }
                    System.out.println("1. Search by area");
                    System.out.println("2. Search by Vaccine");
                    System.out.println("3. Exit");
                    System.out.print("Enter Option: ");
                    String op = sc.next();
                    switch (op) {
                        case "1": {
                            System.out.print("Enter PinCode: ");
                            String PinCode = sc.next();
                            for(int i=0;i< hospital.size();i++){
                                String[] h = hospital.get(i);
                                if(h[2].equals(PinCode)){
                                    System.out.println(h[1] + " " + h[0]);
                                }
                            }
                            System.out.print("Enter Hospital Id: ");
                            int hId = sc.nextInt();
                            slots = hMap.get(hId);
                            if(slots.size() == 0){
                                System.out.println("No Slots Available");
                            }
                            else{
                                for(int i = 0;i<slots.size();i++){
                                    if(!slots.get(i)[1].equals("0")) {
                                        System.out.println(i + "-> Day: " + slots.get(i)[0] + " Available Qty:" + slots.get(i)[1] + " Vaccine:" + slots.get(i)[2]);
                                    }
                                }
                            }
                            System.out.print("Choose Slot: ");
                            int slot = sc.nextInt();
                            String[] s = slots.get(slot);
                            Vaccine v = null;
                            boolean flag = false;
                            if(Integer.parseInt(s[0])<c.getDoses())
                            {
                                System.out.println("no slot available");
                            }
                            else{
                                for(int i = 0;i< vaccines.size();i++){
                                v = vaccines.get(i);
                                if(v.getName().equals(s[2])){
                                    flag = true;
                                    s[1]=Integer.toString(Integer.parseInt(s[1])-1);
                                    slots.set(slot,s);
                                    break;
                                }
                            }
                            if(flag) {
                                System.out.println(c.getName() + " vaccinated with " + v.getName());
                                c.setNod(Integer.parseInt(s[0]) + v.getgBD());
                            }
                            else {
                                System.out.println("no such slot available");
                            }
                            if (c.getStatus().equals("REGISTERED")&& v.getnOd() > 1) {
                                c.setStatus("PARTIALLY VACCINATED");
                                c.setDoses(c.getDoses() + 1);
                              c.setVaccine(v.getName());
                              }
                            else if(c.getStatus().equals("REGISTERED") && v.getnOd() == 1){
                                c.setStatus("FULLY VACCINATED");
                                c.setDoses(c.getDoses() + 1);
                                c.setVaccine(v.getName());
                            } else if (c.getStatus().equals("PARTIALLY VACCINATED")&& c.getDoses()+1 == v.getnOd()) {
                                c.setStatus("FULLY VACCINATED");
                                c.setDoses(c.getDoses() + 1);
                              c.setVaccine(v.getName());
                            }
                            else if(c.getStatus().equals("PARTIALLY VACCINATED") && c.getDoses()+1 < v.getnOd()) {
                                c.setStatus("PARTIALLY VACCINATED");
                                c.setDoses(c.getDoses() + 1);
                                c.setVaccine(v.getName());
                            }
                            else {
                                System.out.println("Already FULLY VACCINATED");
                            }
                        }
                        }
                        break;
                        case "2": {
                            System.out.print("Enter Vaccine name: ");
                            String vName = sc.next();
                            for(int i = 0;i< hospital.size();i++){
                                slots = hMap.get(Integer.parseInt(hospital.get(i)[1]));
                                for(int j = 0;j< slots.size();j++) {
                                    String[] s = slots.get(j);
                                    if(s[2].equals(vName)){
                                        System.out.println(hospital.get(j)[1] + " " +hospital.get(j)[0]);
                                    }
                                }
                            }
                            System.out.print("Enter hospital id: ");
                            int hId = sc.nextInt();
                            slots = hMap.get(hId);
                            if(slots.size() == 0){
                                System.out.println("no slots available");
                            }
                            else {
                                for (int i = 0; i < slots.size(); i++) {
                                    if(!slots.get(i)[1].equals("0")){
                                        System.out.println(i + "-> Day: " + slots.get(i)[0] + " Available Qty:" + slots.get(i)[1] + " Vaccine:" + slots.get(i)[2]);
                                    }
                                }
                            }
                            System.out.print("Choose Slot: ");
                            int slot = sc.nextInt();
                            String[] s = slots.get(slot);
                            Vaccine v = null;
                            boolean flag = false;
                            if(Integer.parseInt(s[0])<c.getDoses())
                            {
                                System.out.println("no slot available");
                            }
                            else{
                                for(int i = 0;i< vaccines.size();i++){
                                    v = vaccines.get(i);
                                    if(v.getName().equals(s[2])){
                                        flag = true;
                                        s[1]=Integer.toString(Integer.parseInt(s[1])-1);
                                        slots.set(slot,s);
                                        break;
                                    }
                                }
                                if(flag) {
                                    System.out.println(c.getName() + " vaccinated with " + v.getName());
                                    c.setNod(Integer.parseInt(s[0]) + v.getgBD());
                                }
                                else{
                                    System.out.println("no such slot available");
                                }
                                if (c.getStatus().equals("REGISTERED")&& v.getnOd() > 1) {
                                    c.setStatus("PARTIALLY VACCINATED");
                                    c.setDoses(c.getDoses() + 1);
                                    c.setVaccine(v.getName());
                                }
                                else if(c.getStatus().equals("REGISTERED") && v.getnOd() == 1){
                                    c.setStatus("FULLY VACCINATED");
                                    c.setDoses(c.getDoses() + 1);
                                    c.setVaccine(v.getName());
                                } else if (c.getStatus().equals("PARTIALLY VACCINATED")&& c.getDoses()+1 == v.getnOd()) {
                                    c.setStatus("FULLY VACCINATED");
                                    c.setDoses(c.getDoses() + 1);
                                    c.setVaccine(v.getName());
                                }
                                else if(c.getStatus().equals("PARTIALLY VACCINATED") && c.getDoses()+1 < v.getnOd()) {
                                    c.setStatus("PARTIALLY VACCINATED");
                                    c.setDoses(c.getDoses() + 1);
                                    c.setVaccine(v.getName());
                                }
                                else {
                                    System.out.println("Already FULLY VACCINATED");
                                }
                            }
                        }
                        break;
                        case "3":
                            break;
                    }
                }
            }
            break;
            case "6": {
                System.out.print("Enter Hospital Id: ");
                int ID = sc.nextInt();
                slots = hMap.get(ID);
                for(int i = 0;i< slots.size();i++){
                    System.out.println("Day: " + slots.get(i)[0] + " Vaccine: " + slots.get(i)[2] + " Available Qty: " + slots.get(i)[1]);
                }
            }
            break;
            case "7": {
                System.out.print("Enter Patient ID: ");
                long ID = sc.nextLong();
                boolean flag = false;
                Citizen c = new Citizen("new",0,0);
                for(int i = 0;i < citizens.size();i++){
                    c = citizens.get(i);
                    if(c.getID() == ID){
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    System.out.println("No Such Citizen Registered");
                }
                else{
                    if(c.getStatus().equals("REGISTERED")){
                        System.out.println("Citizen REGISTERED");
                    }
                    else if(c.getStatus().equals("FULLY VACCINATED")) {
                        System.out.println(c.getStatus());
                        System.out.println("Vaccine Given: " + c.getVaccine());
                        System.out.println("Number of Doses given: " + c.getDoses());
                    }
                    else{
                        System.out.println(c.getStatus());
                        System.out.println("Vaccine Given: " + c.getVaccine());
                        System.out.println("Number of Doses given: " + c.getDoses());
                        System.out.println("Next Dose due date: " + c.getNod());
                    }
                }
            }
            break;
            case "8":
                System.exit(0);
        }
            System.out.println(s2);
    }
    }
}