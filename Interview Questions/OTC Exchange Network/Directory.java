/**
 * Shell 'cd' Command implementation
 * 
 * This is a java class that implements the 'cd' command in the Bash shell.
 * 'cd' : change directory
 * 
 * Assumptions:
 * 1. All the directories needed are present.
 * 2. Commands such as mkdir, rm etc. are already implemented.
 * 3. There are no folder name checks, as such checks are assumed to be implemented in
 * 'mkdir'.
 * 4. None of the folder names have spaces in them.
 * 
 * @author Rishabh Ananthan
 * @version 1.0
 * 
 */

import java.util.Stack;
import java.lang.StringBuilder;

class Shell {
    // String to keep track of the current directory
    String currentDirectory;

    // Initializes a shell object with a directory of the user's choosing
    public Shell(String directory) {
        this.currentDirectory = directory;
    }

    /**
     * This is a function to move into the specified path. 
     * @param path The path that the user wants to go to.
     * @return Shell object whose path attribute is updated as per the 'cd' command rules.
     */
    Shell cd(final String path) {

        /*
         * If the specified path starts with a '/' it means we want to look for the
         * folder in the root directory. Hence, set the current directory to the root
         * directory. 
         */
        if(path.charAt(0) == '/') {
            currentDirectory = "/";
        }

        /*
         * Split the current directory into constituent folders, which are all separated
         * by '/'s. Then push each folder into a stack. 
         */
        Stack<String> commandStack = new Stack<String>();
        String[] cmdContents = currentDirectory.split("/");
        for(String str : cmdContents) {
            commandStack.push(str);
        }

        /*
         * Split the path into constituent folders. If the path contains '..' then we have
         * to pop the top of the stack since we would want the path to reflect that we're on the
         * higher folder. If the path contains '.' then don't push the '.' onto the stack. 
         */
        String[] pathContents = path.split("/");
        for(String str : pathContents) {
            if("..".equals(str)) {
                if(!commandStack.isEmpty()) {
                    commandStack.pop();
                }
            } else if(!".".equals(str)) {
                commandStack.push(str);
            }
        }

        StringBuilder pathBuilder = new StringBuilder();
        // If stack is empty then set the current directory to root
        if(commandStack.isEmpty()) {
            currentDirectory = "/";
        } else {
            while(!commandStack.isEmpty()) {
                String str = commandStack.pop();
                // If empty strings get pushed onto the stack don't add the '/'s to the path
                if(!str.isEmpty()) {
                    pathBuilder.insert(0, str);
                    pathBuilder.insert(0, "/");
                }
            }
            currentDirectory = pathBuilder.toString();
        }

        return this;
    }

    /**
     * This is a function to return the path that the user is on.
     * @return String containing the user path
     */
    public String path() {
        return this.currentDirectory;
    }
}

/**
 * Main class
 */
public class Directory {
    /**
     * This is the main function. It consists of 6 test cases to verify that the
     * program runs fine.
     */
    public static void main(String[] args) {
        final Shell shell = new Shell("/");

        System.out.println("TEST 1");
        System.out.println("Expected path: /, Actual path: " + shell.path());
        assert shell.path().equals("/");
        System.out.println("Test success!");
        System.out.println(" ");

        System.out.println("TEST 2");
        shell.cd("/");
        System.out.println("Expected path: /, Actual path: " + shell.path());
        assert shell.path().equals("/");
        System.out.println("Test success!");
        System.out.println(" ");

        System.out.println("TEST 3");
        shell.cd("usr/..");
        System.out.println("Expected path: /, Actual path: " + shell.path());
        assert shell.path().equals("/");
        System.out.println("Test success!");
        System.out.println(" ");

        System.out.println("TEST 4");
        shell.cd("usr").cd("local");
        shell.cd("../local").cd("./");
        System.out.println("Expected path: /usr/local, Actual path: " + shell.path());
        assert shell.path().equals("/usr/local");
        System.out.println("Test success!");
        System.out.println(" ");

        System.out.println("TEST 5");
        shell.cd("..");
        System.out.println("Expected path: /usr, Actual path: " + shell.path());
        assert shell.path().equals("/usr");
        System.out.println("Test success!");
        System.out.println(" ");

        System.out.println("TEST 6");
        shell.cd("//lib///");
        System.out.println("Expected path: /lib, Actual path: " + shell.path());
        assert shell.path().equals("/lib");
        System.out.println("Test success!");
        System.out.println(" ");
    }
} 
