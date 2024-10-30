package com.mycompany.st10444583part2;

import javax.swing.JOptionPane;

public class TaskManager {

    private String[] taskName;
    private String[] taskDescription;
    private String[] developerDetails;
    private String[] taskID;
    private int[] taskDuration;
    private String[] taskStatus;

    /* 
    * Constructor to initialize the arrays with the specified size
     */
    public TaskManager(int capacity) {
        taskName = new String[capacity];
        taskDescription = new String[capacity];
        developerDetails = new String[capacity];
        taskID = new String[capacity];
        taskDuration = new int[capacity];
        taskStatus = new String[capacity];
    }

    /* 
    * Method to validate the task description (length less than 50 characters)
     */
    public boolean checkDescription(String description) {
        if (description.length() <= 50) {
            JOptionPane.showMessageDialog(null, "Task description is successfully captured","Easy Kanban - Task Description",JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Task description should not exceed 50 characters","Easy Kanban - Task Description",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /* 
    * Method to create the Task ID based on task name, task number, and developer details
     */
    public String CreateTaskID(String taskname, int tasknumber, String developerDetails) {
        return taskname.substring(0, 2).toUpperCase() + ":" + tasknumber + ":" + developerDetails.substring(developerDetails.length() - 3).toUpperCase();
    }

    /* 
    * Method to print task details 
     */
    public String printTaskDetails(String taskStatus, String developerDetails, int taskNumber, String taskName, String taskDescription, String taskID, int taskDuration) {
        String details = 
                "Task Status: " + taskStatus + "\n"
                + "Developer Details: " + developerDetails + "\n"
                + "Task Number: " + taskNumber + "\n"
                + "Task Name: " + taskName + "\n"
                + "Task Description: " + taskDescription + "\n"
                + "Task ID: " + taskID + "\n"
                + "Task Duration: " + taskDuration + " hours\n"
                + "*************************\n";
        JOptionPane.showMessageDialog(null, details,"Easy Kanban - Task Details",JOptionPane.INFORMATION_MESSAGE);
        return details;
    }

    /* 
    * Method to return the task duration
    *
     **/
    public int returnTotalHours(int hours) {
        return hours;
    }
}
