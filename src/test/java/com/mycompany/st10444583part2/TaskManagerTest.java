
package com.mycompany.st10444583part2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TaskManagerTest {

    private int[] taskduration;
    private int numTasks;

    public int returnTotalHours(int taskIndex) {
        return taskduration[taskIndex];
    }

    public boolean checkTaskDescription(String description) {
        return description.length() <= 50;
    }

    public String createTaskID(String taskName, int taskNumber, String developerDetails) {
        String taskNames = taskName.length() >= 2 ? taskName.substring(taskName.length() - 2).toUpperCase() : taskName.toUpperCase();
        String details = developerDetails.length() >= 3 ? developerDetails.substring(developerDetails.length() - 3).toUpperCase() : developerDetails.toUpperCase();
        return taskNames + ":" + taskNumber + ":" + details;
    }

    public String taskStatus(int choice) {
        String[] choices = {"TO DO", "DOING", "DONE"};
        if (choice >= 1 && choice <= 3) {
            return choices[choice - 1];
        } else {
            return "incorrect answer";
        }
    }

    @Test
    public void testTaskDescription_Success_Robyn() {
        String validDescription = "Create Login to authenticate users";
        boolean result = checkTaskDescription(validDescription);
        assertTrue(result);
    }

    @Test
    public void testTaskDescription_Failure_Robyn() {
        String invalidDescription = "This is a very long description that exceeds the maximum allowed length of 50 characters.";
        boolean result = checkTaskDescription(invalidDescription);
        assertFalse(result);
    }

    @Test
    public void testTaskDescription_Success_Mike() {
        String validDescription = "Create Add Task feature to add task users";
        boolean result = checkTaskDescription(validDescription);
        assertTrue(result);
    }

    @Test
    public void testTaskDescription_Failure_Mike() {
        String invalidDescription = "This is a very long description that exceeds the maximum allowed length of 50 characters.";
        boolean result = checkTaskDescription(invalidDescription);
        assertFalse(result);
    }

    @Test
    public void testCreateTaskID_Robyn() {
        String Name = "Login Feature";
        int Number = 0;
        String lastName = "Harrison";
        String expectedTaskID = "LO:0:SON";
        String actualTaskID = createTaskID(Name, Number, lastName);
        assertEquals(expectedTaskID, actualTaskID);
    }

    @Test
    public void testCreateTaskID_Mike() {
        String Name = "Add Task Feature";
        int Number = 1;
        String lastName = "Smith";
        String expectedTaskID = "AD:1:ITH";
        String actualTaskID = createTaskID(Name, Number, lastName);
        assertEquals(expectedTaskID, actualTaskID);
    }

    @Test
    public void testReturnTotalHours() {
        // Set up test data
        taskduration[0] = 10; // given values
        taskduration[1] = 12;
        taskduration[2] = 55;
        taskduration[3] = 11;
        taskduration[4] = 1;

        numTasks = 5;

        // Calculate the expected total hours
        int expectedTotalHours = taskduration[0] + taskduration[1] + taskduration[2] + taskduration[3] + taskduration[4];

        // Call the method under test
        int actualTotalHours = returnTotalHours(numTasks - 1);

        // Assert the result
        assertEquals(expectedTotalHours, actualTotalHours);
    }
}
