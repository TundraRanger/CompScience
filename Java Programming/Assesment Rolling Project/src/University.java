
/** 
 * Description: University Class acts as the Main Program for Rolling Project Part 2
 * @author Tristan Sim
 * @version 1.00
 */

import java.util.ArrayList;
import java.util.stream.IntStream; 

public class University
{
    // Fields
    ArrayList<Enrollment> enrollments;

    /**
     * Default Constructor
     */
    public University() {
        enrollments = new ArrayList<Enrollment>(); 
    }

    /**
     * Non-Defualt Constructor
     * @param enrollment The New Enrollment Information as an Array List of Objects of the Enrollment Class
     */
    public University(ArrayList<Enrollment> enrollments) {
        this.enrollments = enrollments; 
    }

    /**
     * Display Method: Display the University Information
     * @return A String Output of the Array List of Enrollment of Ojects
     */
    public String displayUniversity() 
    {
        StringBuffer enrollmentText = new StringBuffer(); 
        for (Enrollment enrollment:this.enrollments)
        {
            if (enrollment != null) {
                enrollmentText.append(enrollments); 
            }
        }
        return enrollmentText.toString(); 
    }
    
    /** 
     * Custom Method: Add a New Enrollment into the Array List
     * @param enrollment The new Enrollment Information to be added as an Object of te Enrollment Class
     */
    public void addEnrollment(Enrollment enrollment)
    {
        this.enrollments.add(enrollment); 
    }

    /** 
     * Accessor Method: Get the Enrollment Details
     * @return The Enrollment Information as a Array List of Objects of the Enrollment Class
     */
    public ArrayList<Enrollment> getEnrollment() 
    {
        return this.enrollments; 
    }

    /** 
     * Accessor Method: Get the Enrollment Size
     * @return The size of the the Enrollment Arraylist as an Integer
     */
    public int getEnrollmentSize()
    {
        return this.enrollments.size(); 
    }

    /** 
     * Accesor Method: Get the Specific Enrollment Details
     * @param index The Index of th Enrollment Object in the Arrray List as an Integer
     * @return The Enrollment as an Object information at the Index of the Array List
     * @throw IndexOutOfBoundsException The Index Input out ouf Bounds of the Array List Size
     */
    public Enrollment getSpecificEnrollment(int index)
    {
        if (index < 0 || index >= this.enrollments.size()) {
            throw new IndexOutOfBoundsException("The Index is out of bound of the Enrollment Array List");
        }
        return this.enrollments.get(index); 
    }

   /** 
    * Custom Method: Method to get User Input for the Student Details
    * @param enrollment A Enrollment Details to be Set by the Method as an object of the Enrollment Class
    */
    public void inputStudentDetails(Enrollment enrollment) 
    {   
        // Get the Student information from the Enrollment Class
        Student student = enrollment.getStudent(); 
        Input inputFromUser = new Input(); 
        Validation validateInput = new Validation(); 

        String[] inputFields = {"Name", "Address", "Phone No", "E-mail"}; 
        String[] userResponse = new String[inputFields.length]; 
        
        // Get User Input & Validate Input if it is Not Blank 
        for (int iterI = 0; iterI < inputFields.length; iterI++)
        {   
            Boolean validInput = false; 
            while (!validInput) {
                userResponse[iterI] = inputFromUser.acceptStringInput("Input " + inputFields[iterI] + ":");       
                if (validateInput.isBlank(userResponse[iterI])) {
                    System.out.println("Validation Failed: " + inputFields[iterI] + " cannot be Blank");
                    userResponse[iterI] = ""; // Write a Default Value in (Assignment Did Not specify Value)
                } else {
                    validInput = true; 
                }
            }

        }

        // Set the Student Object in the 
        student.setName(userResponse[0]);
        student.setAddress(userResponse[1]);
        student.setPhoneNo(userResponse[2]);
        student.setEmail(userResponse[3]);
    }

    /**
     * Custom Method: Get User to Input to Enrol Student
     * @param enrollments The Enrollments Array Lists to be updated for Inputs by the User
     */
    public void inputUnitDetails(ArrayList<Enrollment> enrollments)
    {   
        // Check if enrollment has values 
        if (enrollments == null || enrollments.isEmpty()) {
            System.out.print("The Enrollment ArrayList is Empty"); 
        }

        // Integer Stream: Sequence of Numbers | From a Range of 0 to ArraListSize - For each element excute process) 
        IntStream.range(0, enrollments.size()).forEach(index -> inputUnitDetailsOnce(index, enrollments.get(index)));
    }

    /** 
     * Custom Method: Get User to Input the Unit Details Once
     * @param enrollment The Enrollment Object to be Updated by th User; Passed as an Object of the Enrollment Class
     * @throw IndexOutOfBoundsException The index is out of bounds of the Array List
     */
    public void inputUnitDetailsOnce(int index, Enrollment enrollment)
    {   
        // Get the Unit Object from the Enrollment Class
        Unit[] units = enrollment.getUnits(); 
        Input inputFromUser = new Input(); 
        Validation validateInput = new Validation(); 
        
        String[] inputFields = {"Unit Code", "Unit Desecription", "Credit Score"}; 
        String userResponse; 

        // May need to verify if the Index is within Bounds
        if (index < 0 || index >= this.enrollments.size()) {
            throw new IndexOutOfBoundsException("The index is out of bounds of the Array List"); 
        }
        
        // Get User Input and Validate the Input 
        for (int iterI = 0; iterI < inputFields.length; iterI++)
        {   
            Boolean validInput = false; 

            while (!validInput) {
                switch (iterI) 
                {
                    case 0: // Unit Code cannot be blank and must be exactly 7 characters long.  
                    userResponse = inputFromUser.acceptStringInput("Input " + inputFields[iterI] + ":"); 
                    if (validateInput.isBlank(userResponse) || userResponse.length() != 7){     
                        System.out.println("Validation Failed: Unit Code cannot be Blank and must be Exactly 7 Characeters Long");
                    } else {
                        units[index].setUnitCode(userResponse);
                        validInput = true; 
                    }
                    break; 
                    
                    case 1: // Unit Description Must not be Blank and must be less than 25 Characters in Length
                    userResponse = inputFromUser.acceptStringInput("Input " + inputFields[iterI] + ":"); 
                    if (validateInput.isBlank(userResponse) || userResponse.length() > 25) { 
                        System.out.println("Validation Failed: Unit Desecription must not be Blank and be less than 25 Characters in Length"); 
                    } else {
                        units[index].setUnitDescription(userResponse);
                        validInput = true; 
                    }
                    break; 
                    
                    case 2: // Credit Point Must not be smaller than 0 
                    int userResponseInteger = inputFromUser.acceptIntegerInput("Input " + inputFields[iterI] + ":"); 
                    if (userResponseInteger < 0) { 
                        System.out.println("Validation Failed: The Credit Score must not be lesser than the value 0 "); 
                    } else {
                        units[index].setCreditPoints(userResponseInteger);
                        validInput = true; 
                    }
                    break; 

                    default: 
                    System.out.println("No Case for Iteration " + iterI);
                    validInput = true; 
                }
            }
        }
    }
    
    /** 
     * Custom Method: Removes an Enrollment Object from Array List
     * @param index The Index of the Enrollment Objec to be Removed from the Array List
     * @throw IndexOutOfBoundsException The Index is out of bounds of the Array List 
     */
    public void removeEnrollment(int index)
    {
        if (index < 0 || index >= this.enrollments.size())
        {
            throw new IndexOutOfBoundsException("The Index is out of bounds of the Array List"); 
        }
        this.enrollments.remove(index); 
    }

    /** Mutator Method: Set Enrolment Details
     * @param enrollments An ArrayList of Enrollment Objects of the Enrollment Class
     */
    public void setEnrollment(ArrayList<Enrollment> enrollments)
    {
        this.enrollments = enrollments; 
    }

    /**
     * Mutator Method: Set Specific Enrollment Details
     * @param index The Index of the Enrollment Object to be Set in the Array List
     * @param enrollment The new Enrollment object to be Updated at the Index
     * @throw The Index is out of bounds for the Enrollment ArrayList
     */
    public void setSpecificEnrollment(int index, Enrollment enrollment)
    {
        if (index < 0 || index >= this.enrollments.size()) {
            throw new IndexOutOfBoundsException("The Index is out of bounds for the Enrollment ArrayList"); 
        }
        this.enrollments.set(index, enrollment);
    }

    /*
     * Lastly, write the main() method in the University class.
     * If the user selects Option 1, ask the user for the enrolment date, which should not be blank. 
     * If blank, print an error message and assign the default date value specified in the default constructor.
     * Next call the inputStudentDetails() and inputUnitDetails() methods.
     * Then display the university object state on the screen.For now, you should have one student enrolled in one unit only.
     */
    
    /**
     * Main Method of the Unviersity Class
     * Offer the user the option to select between 2 choices: 1) Enrols a student 2) Exits the program
     */
    public static void main(String[] args)
    {   
        Input userInput = new Input(); 
        ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>(); 
        University university = new University(enrollments); 

        System.out.println("\nThis is the University Enrollment Program."); 
        String userSelection = userInput.acceptStringInput("Please Enter:\n1 - To Enroll a Student\n2 - To Exit the Program"); 
        
        if (userSelection.equals("1")) {

            // Enter Enrollment Date 
            String newEnrollmentDate = userInput.acceptStringInput("\nPlease Enter the Enrollment Date:");
            if (newEnrollmentDate == null || newEnrollmentDate.isEmpty()) {
                newEnrollmentDate = ""; // Default Value of String in Default Constructor is also Null
                System.out.println("The Enrollment Date should not be Blank"); 
            }
            enrollments.setDate(newEnrollmentDate);
            
            // Get user to Input the Student and Unit Details
            university.inputStudentDetails(enrollments);
            university.inputUnitDetails(enrollments);

            // Display the University Object Information
            System.out.println(university.displayUniversity());
      
        } else {
            System.out.println("Program Execution has terminated.\n"); 
        }
    }
}