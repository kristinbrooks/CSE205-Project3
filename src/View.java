//**************************************************************************************************
// CLASS: View
//
// AUTHOR
// Kevin R. Burger (burgerk@asu.edu)
// Computer Science & Engineering Program
// Fulton Schools of Engineering
// Arizona State University, Tempe, AZ 85287-8809
//**************************************************************************************************

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The View class implements the GUI. It is a subclass of JFrame and implements the ActionListener
 * interface so that we can respond to user-initiated GUI events.
 */
??? {

    /**
     * The width of the View.
     */
    public static final int FRAME_WIDTH  = 500;

    /**
     * The height of the View.
     */
    public static final int FRAME_HEIGHT = 250;

    /**
     * When the View() ctor is called from Main.run() to create the View, run() passes a reference
     * to the Main object as the argument to View(). We save that reference into mMain and then
     * later we can use mMain to communicate with the Main class.
     *
     * mMain is made accessible within this class via accessor/mutator methods getMain() and
     * setMain().
     */
    private Main mMain;

    /*
     * Declare GUI related instance variables for the buttons and text fields.
     */
    ???
    
    /**
     * mStudent is a reference to the Student object which we are currently displaying data for
     * in the View. mStudent is made accessible within the View using accessor and mutator methods
     * getStudent() and setStudent().
     */
    private Student mStudent;

    /**
     * View()
     *
     * The View constructor creates the GUI interface and makes the frame visible at the end.
     *
     * @param pMain is an instance of the Main class. This links the View to the Main class so
     * they may communicate with each other.
     */
    public View(Main pMain) {

        /**
         * Save a reference to the Main object pMain into instance var mMain by calling setMain().
         */
        setMain(pMain);

        // PSEUDOCODE:
        // Create a JPanel named panelSearch which uses the FlowLayout
        // Add a JLabel "Student Name: " to panelSearch
        // Create mSearchText and make the field 25 cols wide
        // Add mSearchText to the panel
        // Create mSearchButton with the label "Search"
        // Make this View the action listener for the button
        // Add the button to the panel
        ???

        // PSEUDOCODE:
        // Create a JPanel named panelHomework which uses the FlowLayout
        // Add a JLabel "Homework: " to the panel
        // Create mHomeworkText which is an array of CourseConstants.NUM_HOMEWORKS JTextFields
        // For i = 0 to CourseConstants.NUM_HOMEWORKS - 1 Do
        //     Create a textfield mHomeworkText[i] displaying 5 cols
        //     Add mHomeworkText[i] to the panel
        // End For
        ???

        // Create the exam panel which contains the "Exam: " label and the two exam text fields.
        // The pseudocode is omitted because this code is very similar to the code that creates the
        // panelHomework panel above.
        ???

        // PSEUDOCODE:
        // Create a JPanel named panelButtons using FlowLayout
        // Create the Clear button mClearButton labeled "Clear"
        // Make this View the action listener for mClearButton
        // Add the  Clear button to the panel
        // Repeat the three above statements for the Save button
        // Repeat the three above statements for the Exit button
        ???

        // PSEUDOCODE:
        // Create a JPanel named panelMain using a vertical BoxLayout
        // Add panelSearch to panelMain.
        // Add panelHomework to panelMain
        // Add panelExam to panelMain
        // Add panelButtons to panelMain
        ???

        // Set the title of the View to whatever you want by calling setTitle()
        ???
        
        // Set the size of the View to FRAME_WIDTH x FRAME_HEIGHT
        ???
        
        // Make the View non-resizable
        ???
        
        // Set the default close operation to JFrame.EXIT_ON_CLOSE. What this does is if the user
        // clicks on the button in the View's titlebar to close the View, then the View will
        // be closed (as opposed to making the View dance around on the screen).
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Add panelMain to the View.
        ???
        
        // *** If you are a Mac user, call pack() now to pack the View. I'm not exactly sure what
        // *** this does but if you do not do it, your View window may be too small for the
        // *** contents.
        
        // Now display the View by calling setVisible().
        ???
    }

    /**
     * actionPerformed()
     *
     * Called when one of the JButtons is clicked. Detects which button was clicked and handles it.
     *
     * Make sure to write the @Override annotation to prevent accidental overloading because we are
     * overriding JFrame.actionPerformed().
     *
     * PSEUDOCOODE:
     * method actionPerformed(pEvent : ActionEvent) : void
     * If the source of the event was the Search button Then
     *     lastName = retrieve the text from the mSearchText text field
     *     If lastName is the empty string Then
     *         Call messageBox() to display "Please enter the student's last name."
     *     Else
     *         -- Main contains a method named search() which given the last name of a student
     *         -- will search the Roster for the student. search() either returns the Student
     *         -- object if found, or if there is no student with that last name in the Roster,
     *         -- then search() returns null.
     *         student = Call getMain().search(lastName)
     *         If student is null Then
     *             Call messageBox() to display "Student not found. Try again."
     *         Else
     *             Call setStudent(student) to save the Student reference into instance var mStudent
     *             Call displayStudent(student)  -- display the student's scores
     *         End if
     *     End If
     * Else if the source of the event was the Save button Then
     *     If getStudent() is not null Then Call saveStudent(getStudent())
     * Else if the source of the event was the Clear button Then
     *     Call clear()
     * Else if the source of the event was the Exit button Then
     *     If getStudent() is not null Then Call saveStudent(getStudent())
     *     Call getMain().exit() to terminate the application
     * End If
     * end actionPerformed
     */
    ???

    /**
     * clear()
     *
     * Called when the Clear button is clicked. Clears all of the text fields by setting the
     * contents of each to the empty string.
     *
     * After clear() returns, no student information is being edited or displayed and mStudent
     * has been set to null.
     *
     * PSEUDOCODE:
     * method clear() : void
     *     Set the mSearchText text field to ""
     *     Set each of the homework text fields to "" -- note use a for loop
     *     Set each of the exam text fields to "" -- using a for loop
     *     call setStudent(null) to set the mStudent reference to null
     * end clear
     */
    ???

    /**
     * displayStudent()
     *
     * Displays the homework and exam scores for a student in the mHomeworkText and mExamText text
     * fields.
     *
     * @param pStudent is the Student who's scores we are going to use to populate the text fields.
     *
     * PSEUDOCODE:
     * method displayStudent(pStudent : Student) : void
     *     For i = 0 to CourseConstants.NUM_HOMEWORKS - 1 Do
     *         int hw = pStudent.getHomework(i)
     *         String hwstr = convert hw to a String (Hint: Integer.toString())
     *         mHomeworkText[i].setText(hwstr)
     *     End For
     *     Write a similar for loop to place the student's exams scores into the text fields
     * end displayStudent
     */
    ???

    /**
     * Accessor method for mMain.
     */ 
    private Main getMain() {
        return mMain;
    }    

    /**
     * Accessor method for mStudent.
     */ 
    private Student getStudent() {
        return mStudent;
    }

    /**
     * messageBox()
     *
     * Displays a message box containing some text. Note: pass 'this' as the first argument to
     * JOptionPane.showMessageDialog() to make the View the parent window of the message dialog.
     * This will cause the message dialog to be centered in the View. If you pass null as the
     * first argument, then the message dialog will not have a parent window and it will be
     * displayed in the center of the screen.
     *
     * PSEUDOCODE:
     * method messageBox(pMessage : String) : void
     *     Call JOptionPane.showMessageDialog() to display pMessage.
     * end messageBox
     */
    public void messageBox(String pMessage) {
        JOptionPane.showMessageDialog(this, pMessage, "Message", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * saveStudent()
     *
     * Retrieves the homework and exam scores for pStudent from the text fields and writes the
     * results to the Student record in the Roster.
     *
     * PSEUDOCODE:
     * method saveStudent(pStudent : Student) : void
     *     For i = 0 to CourseConstants.NUM_HOMEWORKS - 1 Do
     *         String hwstr = mHomeworkText[i].getText()
     *         int hw = convert hwstr to an int (Hint: Integer.parseInt())
     *         Call pStudent.setHomework(i, hw)
     *     End For
     *     Write a similar for loop to save the exam scores in pStudent
     * end method saveStudent
     */
    ???
    
    /**
     * Mutator method for mMain.
     */ 
    private void setMain(Main pMain) {
        mMain = pMain;
    }    

    /**
     * Mutator method for mStudent.
     */ 
    private void setStudent(Student pStudent) {
        mStudent = pStudent;
    }

}
