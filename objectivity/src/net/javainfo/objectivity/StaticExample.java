package net.javainfo.objectivity;

//Przykład zastosowania pola i metody statycznej
public class StaticExample {

    public static void main(String[] args){

        var customers = new Customer[3];
        customers[0] = new Customer("Jan Kowalski", 2300);
        customers[1] = new Customer("Piotr Nowakowski", 400);
        customers[2] = new Customer("Anna Nowicka", 1540);

        for(Customer c : customers){
            System.out.println(c.toString());
        }
    }
}

class Customer{

    private static int nextId = 1; //raz zainicjalizowane pole składowe jako statyczne
    private String name;
    private double amount;
    private int id;

    Customer(String name, double amount){
        this.name = name;
        this.amount = amount;
        id = setId();
    }

    public static int setId(){ //demonstracja działania metody statycznej
        int tmp = nextId;
        nextId++;
        return tmp;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public double getAmount(){
        return this.amount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", id=" + id +
                '}';
    }
}