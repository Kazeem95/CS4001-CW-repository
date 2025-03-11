public class PartTimeStaffHire extends StaffHire {
    
    private int workingHour;
    private double wagesPerHour;
    private String shifts;
    private boolean terminated;
    
    
    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType,
                            String staffName, String joiningDate, String qualification,
                            String appointedBy, boolean joined, int workingHour,
                            double wagesPerHour, String shifts) {
        
        super(vacancyNumber, designation, jobType, staffName, joiningDate,
              qualification, appointedBy, joined);
        
        this.workingHour = workingHour;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false;  
    }
    
    
    public int getWorkingHour() {
        return workingHour;
    }
    
    public double getWagesPerHour() {
        return wagesPerHour;
    }
    
    public String getShifts() {
        return shifts;
    }
    
    public boolean isTerminated() {
        return terminated;
    }
    
    
    public void setShifts(String newShifts) {
        if(getJoined() && !terminated) {
            this.shifts = newShifts;
            System.out.println("Shifts updated successfully to " + newShifts);
        } else {
            System.out.println("Cannot update shifts - staff either not joined or terminated");
        }
    }
    
    
    public void terminateStaff() {
        if(terminated) {
            System.out.println("Staff is already terminated");
            return;
        }
        
        
        setStaffName("");
        setJoiningDate("");
        setQualification("");
        setAppointedBy("");
        setJoined(false);
        this.terminated = true;
        System.out.println("Staff has been terminated successfully");
    }
    
    
    @Override
    public void display() {
        
        super.display();
        
        if(getJoined() && !terminated) {
            System.out.println("Working Hours per Day: " + workingHour);
            System.out.println("Wages per Hour: $" + wagesPerHour);
            System.out.println("Shifts: " + shifts);
            System.out.println("Income per Day: $" + (workingHour * wagesPerHour));
            System.out.println("Termination Status: " + terminated);
        }
    }
}