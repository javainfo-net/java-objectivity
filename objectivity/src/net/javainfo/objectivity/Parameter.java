package net.javainfo.objectivity;

//Przykład sposobów przekazywania parametrów do metod
public class Parameter {

    public static void main(String[] args){

        double x = 200;

        //metoda nie może zmodyfikować parametru typu podstawowego
        System.out.println("Wartość x przed metodą: " + x);
        raiseValue(x);
        System.out.println("Wartość x po metodzie: " + x);

        //metoda może zmienić stan obiektu przekazanego jako parametr
        Customer2 customer = new Customer2("Asia", 200);
        System.out.println("Customer przed zmianą: " + customer);
        raiseObjectValue(customer);
        System.out.println("Customer po zmianie " + customer);

        //metoda nie może sprawić, aby parametr obiektowy zaczął się odwoływać do nowego obiektu
        Customer2 customer2 = new Customer2("Carol", 300);
        System.out.println("Przed zamianą: " + "Customer1: " + customer + "\nCustomer2: " + customer2);
        swapObject(customer,customer2);
        System.out.println("Po zamianie :" + "Customer1: " + customer + "\nCustomer2: " + customer2);

    }

    public static void raiseValue(double value){
        value *= 2;
    }

    public static void raiseObjectValue(Customer2 customer){
        customer.setAmount(customer.getAmount()*2);
    }

    public static void swapObject(Customer2 customer1, Customer2 customer2){
        Customer2 temp = customer1;
        customer1 = customer2;
        customer2 = temp;
    }
}

class Customer2{

    private String name;
    private double amount;

    Customer2(String name, double amount){
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void raiseAmount(){
        this.amount *= 2;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
