import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RecruitmentSystem extends JFrame implements ActionListener {
    private ArrayList<StaffHire> staffList;

    
    private JTextField txtVacancyNumber;
    private JTextField txtDesignation;
    private JTextField txtJobType;
    private JTextField txtStaffName;
    private JTextField txtJoiningDate;
    private JTextField txtQualification;
    private JTextField txtAppointedBy;
    private JTextField txtSalary;
    private JTextField txtWeeklyHours;
    private JTextField txtWorkingHour;
    private JTextField txtWagesPerHour;
    private JTextField txtShifts;
    private JTextField txtDisplayNumber;
    private JTextField txtSearchName; 
    private JCheckBox chkJoined;

    
    private JButton btnAddFullTime;
    private JButton btnAddPartTime;
    private JButton btnSetSalary;
    private JButton btnSetShifts;
    private JButton btnTerminate;
    private JButton btnDisplay;
    private JButton btnClear;
    private JButton btnSearch; 

    private JLabel lblStaffCount; 

    
    public RecruitmentSystem() {
        staffList = new ArrayList<StaffHire>();

        
        setTitle("Staff Recruitment System");
        setSize(800, 700); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        
        JPanel inputPanel = createInputPanel();
        mainPanel.add(inputPanel, BorderLayout.CENTER);

        
        JPanel buttonPanel = createButtonPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        
        add(mainPanel);

        
        setLocationRelativeTo(null);
        setVisible(true);

        updateStaffCountLabel(); 
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Input Fields"));

        
        txtVacancyNumber = new JTextField(20);
        txtDesignation = new JTextField(20);
        txtJobType = new JTextField(20);
        txtStaffName = new JTextField(20);
        txtJoiningDate = new JTextField(20);
        txtQualification = new JTextField(20);
        txtAppointedBy = new JTextField(20);
        txtSalary = new JTextField(20);
        txtWeeklyHours = new JTextField(20);
        txtWorkingHour = new JTextField(20);
        txtWagesPerHour = new JTextField(20);
        txtShifts = new JTextField(20);
        txtDisplayNumber = new JTextField(20);
        txtSearchName = new JTextField(20); 
        chkJoined = new JCheckBox();

        
        panel.add(new JLabel("Vacancy Number:"));
        panel.add(txtVacancyNumber);
        panel.add(new JLabel("Designation:"));
        panel.add(txtDesignation);
        panel.add(new JLabel("Job Type:"));
        panel.add(txtJobType);
        panel.add(new JLabel("Staff Name:"));
        panel.add(txtStaffName);
        panel.add(new JLabel("Joining Date:"));
        panel.add(txtJoiningDate);
        panel.add(new JLabel("Qualification:"));
        panel.add(txtQualification);
        panel.add(new JLabel("Appointed By:"));
        panel.add(txtAppointedBy);
        panel.add(new JLabel("Joined:"));
        panel.add(chkJoined);
        panel.add(new JLabel("Salary:"));
        panel.add(txtSalary);
        panel.add(new JLabel("Weekly Hours:"));
        panel.add(txtWeeklyHours);
        panel.add(new JLabel("Working Hour:"));
        panel.add(txtWorkingHour);
        panel.add(new JLabel("Wages Per Hour:"));
        panel.add(txtWagesPerHour);
        panel.add(new JLabel("Shifts:"));
        panel.add(txtShifts);
        panel.add(new JLabel("Display Number:"));
        panel.add(txtDisplayNumber);
        panel.add(new JLabel("Search Staff Name:")); 
        panel.add(txtSearchName);

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Actions"));

        
        btnAddFullTime = new JButton("Add Full Time Staff");
        btnAddPartTime = new JButton("Add Part Time Staff");
        btnSetSalary = new JButton("Set Salary");
        btnSetShifts = new JButton("Set Shifts");
        btnTerminate = new JButton("Terminate Staff");
        btnDisplay = new JButton("Display");
        btnClear = new JButton("Clear");
        btnSearch = new JButton("Search"); 

        
        btnAddFullTime.addActionListener(this);
        btnAddPartTime.addActionListener(this);
        btnSetSalary.addActionListener(this);
        btnSetShifts.addActionListener(this);
        btnTerminate.addActionListener(this);
        btnDisplay.addActionListener(this);
        btnClear.addActionListener(this);
        btnSearch.addActionListener(this); 

        
        panel.add(btnAddFullTime);
        panel.add(btnAddPartTime);
        panel.add(btnSetSalary);
        panel.add(btnSetShifts);
        panel.add(btnTerminate);
        panel.add(btnDisplay);
        panel.add(btnClear);
        panel.add(btnSearch); 

        
        lblStaffCount = new JLabel("Total Staff: 0");
        panel.add(lblStaffCount);

        return panel;
    }

    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddFullTime) {
            addFullTimeStaff();
        } else if (e.getSource() == btnAddPartTime) {
            addPartTimeStaff();
        } else if (e.getSource() == btnSetSalary) {
            setSalary();
        } else if (e.getSource() == btnSetShifts) {
            setShifts();
        } else if (e.getSource() == btnTerminate) {
            terminateStaff();
        } else if (e.getSource() == btnDisplay) {
            displayStaff();
        } else if (e.getSource() == btnClear) {
            clearFields();
        } else if (e.getSource() == btnSearch) {
            searchStaff(); 
        }
    }

    private void addFullTimeStaff() {
        try {
            int vacancyNumber = Integer.parseInt(txtVacancyNumber.getText());
            double salary = Double.parseDouble(txtSalary.getText());
            int weeklyHours = Integer.parseInt(txtWeeklyHours.getText());

            FullTimeStaffHire staff = new FullTimeStaffHire(
                    vacancyNumber,
                    txtDesignation.getText(),
                    txtJobType.getText(),
                    txtStaffName.getText(),
                    txtJoiningDate.getText(),
                    txtQualification.getText(),
                    txtAppointedBy.getText(),
                    chkJoined.isSelected(),
                    salary,
                    weeklyHours
            );

            staffList.add(staff);
            JOptionPane.showMessageDialog(this, "Full Time Staff Added Successfully!");
            clearFields();
            updateStaffCountLabel(); 
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addPartTimeStaff() {
        try {
            int vacancyNumber = Integer.parseInt(txtVacancyNumber.getText());
            int workingHour = Integer.parseInt(txtWorkingHour.getText());
            double wagesPerHour = Double.parseDouble(txtWagesPerHour.getText());

            PartTimeStaffHire staff = new PartTimeStaffHire(
                    vacancyNumber,
                    txtDesignation.getText(),
                    txtJobType.getText(),
                    txtStaffName.getText(),
                    txtJoiningDate.getText(),
                    txtQualification.getText(),
                    txtAppointedBy.getText(),
                    chkJoined.isSelected(),
                    workingHour,
                    wagesPerHour,
                    txtShifts.getText()
            );

            staffList.add(staff);
            JOptionPane.showMessageDialog(this, "Part Time Staff Added Successfully!");
            clearFields();
            updateStaffCountLabel(); 
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setSalary() {
        try {
            int vacancyNumber = Integer.parseInt(txtVacancyNumber.getText());
            double newSalary = Double.parseDouble(txtSalary.getText());

            for (StaffHire staff : staffList) {
                if (staff.getVacancyNumber() == vacancyNumber && staff instanceof FullTimeStaffHire) {
                    FullTimeStaffHire fullTimeStaff = (FullTimeStaffHire) staff;
                    fullTimeStaff.setSalary(newSalary);
                    JOptionPane.showMessageDialog(this, "Salary Updated Successfully!");
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Full Time Staff not found!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setShifts() {
        try {
            int vacancyNumber = Integer.parseInt(txtVacancyNumber.getText());
            String newShifts = txtShifts.getText();

            for (StaffHire staff : staffList) {
                if (staff.getVacancyNumber() == vacancyNumber && staff instanceof PartTimeStaffHire) {
                    PartTimeStaffHire partTimeStaff = (PartTimeStaffHire) staff;
                    partTimeStaff.setShifts(newShifts);
                    JOptionPane.showMessageDialog(this, "Shifts Updated Successfully!");
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Part Time Staff not found!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid vacancy number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void terminateStaff() {
        try {
            int vacancyNumber = Integer.parseInt(txtVacancyNumber.getText());

            for (StaffHire staff : staffList) {
                if (staff.getVacancyNumber() == vacancyNumber && staff instanceof FullTimeStaffHire) {
                    FullTimeStaffHire fullTimeStaff = (FullTimeStaffHire) staff;
                    fullTimeStaff:terminateStaff();
                    staffList.remove(staff); 
                    JOptionPane.showMessageDialog(this, "Staff Terminated Successfully!");
                    updateStaffCountLabel(); 
                    return;
                }
            }
            for (StaffHire staff : staffList) {
                if (staff.getVacancyNumber() == vacancyNumber && staff instanceof PartTimeStaffHire) {
                    PartTimeStaffHire partTimeStaff = (PartTimeStaffHire) staff;
                    partTimeStaff.terminateStaff();
                    staffList.remove(staff); 
                    JOptionPane.showMessageDialog(this, "Staff Terminated Successfully!");
                    updateStaffCountLabel(); 
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Part Time Staff not found!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid vacancy number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayStaff() {
        try {
            int displayNumber = Integer.parseInt(txtDisplayNumber.getText());
            if (displayNumber >= 0 && displayNumber < staffList.size()) {
                staffList.get(displayNumber).display();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid display number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid display number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        txtVacancyNumber.setText("");
        txtDesignation.setText("");
        txtJobType.setText("");
        txtStaffName.setText("");
        txtJoiningDate.setText("");
        txtQualification.setText("");
        txtAppointedBy.setText("");
        txtSalary.setText("");
        txtWeeklyHours.setText("");
        txtWorkingHour.setText("");
        txtWagesPerHour.setText("");
        txtShifts.setText("");
        txtDisplayNumber.setText("");
        txtSearchName.setText(""); 
        chkJoined.setSelected(false);
    }

    
    private void searchStaff() {
        String searchName = txtSearchName.getText().trim();
        if (searchName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a staff name to search.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (StaffHire staff : staffList) {
            if (staff.getStaffName().equalsIgnoreCase(searchName)) {
                staff.display();
                return; 
            }
        }

        JOptionPane.showMessageDialog(this, "Staff member not found.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    
    private void updateStaffCountLabel() {
        lblStaffCount.setText("Total Staff: " + staffList.size());
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RecruitmentSystem();
            }
        });
    }
}
