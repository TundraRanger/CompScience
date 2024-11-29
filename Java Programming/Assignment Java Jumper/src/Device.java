/**
 * Desecription: The Device Class handles the Jumper Device for the Java Jumper Game
 * Final Assesment Project for ITO4131 - Java Programming
 * @author Tristan Sim
 * @version 1.00
 */

public class Device {
    
    // Fields
    private static final int MAX_FUEL_RESERVES = 20; 
    private static final int MIN_FUEL_RESERVES = 0;

    int fuelReserves; 
    double fuelReservesPercent; 

    /**
     * Default Constructor
     */
    public Device()
    {
        this.fuelReserves = 10;
        this.fuelReservesPercent = calculateFuelPercentage(this.fuelReserves); 
    }
    
    /**
     * Non-Default Constructor
     * @param fuelReserves int: The Fuel Reserve Levels to be initialize
     */
    public Device(int fuelReserves) 
    {
        this.fuelReserves = Math.min(MAX_FUEL_RESERVES, Math.max(fuelReserves, MIN_FUEL_RESERVES)); 
        this.fuelReservesPercent = calculateFuelPercentage(this.fuelReserves); 
    }
    
    /**
     * Custom Method: Converts the Fuel Reserves 
     * @param fuelReserves
     * @return
     */
    public double calculateFuelPercentage(int fuelReserves)
    {
        return (double)(fuelReserves-MIN_FUEL_RESERVES)/MAX_FUEL_RESERVES*100;
    }
    
    /**
     * Custom Method: Consume Fuel Reserves
     * @param fuel int: Amount of Fuel to be reduced from Fuel Reserves
     * @return
     */
    public void consumeFuelReserves(int fuel)
    {
        this.fuelReserves =  Math.min(MAX_FUEL_RESERVES, Math.max((this.fuelReserves - fuel), MIN_FUEL_RESERVES)); 
        this.fuelReservesPercent = calculateFuelPercentage(this.fuelReserves); 
    }
    
    /**
     * Display Method: Displays the Device Information as a String Output
     * @return String: The Fuel Reserves & Percentage Information
     */
    public String displayDevice()
    {
        return String.format("Fuel Reserves: " + this.fuelReserves + " (" + this.fuelReservesPercent + "% )"); 
    }

    /**
     * Accesor Method: Get Fuel Reserves
     * @return int: Fuel Reserves
     */
    public int getFuelReserves()
    {
        return this.fuelReserves; 
    }

    /**
     * Accesor Method: Get Fuel Reserves In Percentage
     * @return double: Fuel Reserves in Percentage
     */
    public double getFuelReservesPercentage()
    {
        return this.fuelReservesPercent;
    }
    
    /**
     * Custom Method: Replenish Fuel Reserves
     * @param fuel int: Amount of Fuel to be Replenished to the Fuel Reserves
     */
    public void replenishFuelReserves(int fuel)
    {
        this.fuelReserves = Math.min(MAX_FUEL_RESERVES, Math.max(this.fuelReserves + fuel, MIN_FUEL_RESERVES));
        this.fuelReservesPercent = calculateFuelPercentage(this.fuelReserves); 
    }

    /** 
     * Mutator Method: Set the Fuel Reserves Level
     * @param fuelLevel int: The Fuel Reserves Level to be set to the device
     */
    public void setFuelReserves(int fuelLevel)
    {
        this.fuelReserves = fuelLevel; 
    }

    /** 
     * Mutator Method: Set the Fuel Reserves Percentage
     * @param fuelPercent double: The Fuel Reserves Percentage to be set to the device
     */
    public void setFuelReservesPercentage(double fuelPercent)
    {
        this.fuelReservesPercent = fuelPercent; 
    }
    
}