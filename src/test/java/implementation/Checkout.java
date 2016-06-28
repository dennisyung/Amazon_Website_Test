package test.java.implementation;


public class Checkout {
    int runningTotal = 0;
    
	
    public Checkout(){
    }
	//This will add a certain purchase to the running total 
	public void add(int itemCount, int price) {
		runningTotal += itemCount * price;
		System.out.println("add-debug:" + runningTotal);
	}
	
	public int getTotal() {
		return runningTotal;
	}
	
}
