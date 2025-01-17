package chatbot.command;

import chatbot.ChatbotEmptyDescException;
import chatbot.Task;
import chatbot.Todo;

import java.util.ArrayList;

public class FindCommand extends Command {
    public FindCommand(String commandType, String input) {
        super(commandType, input);
    }
    /**
     * Execute the `find` command specified by the user
     *
     * @param   tasks       the current list of tasks
     * @param   isUserInput is the command a user input
     * @author  Jeremy
     * @since   2023-10-06
     */
    public void execute(ArrayList<Task> tasks, boolean isUserInput) throws ChatbotEmptyDescException {
        String searchFor = input.replace("find", "").trim();
        if (searchFor.isEmpty()) {
            throw new ChatbotEmptyDescException(" ☹ OOPS!!! The find command needs a string to search for.");
        }
        System.out.println("____________________________________________________________");
        System.out.println(" Here are the matching tasks in your list:");
        for(Task task : tasks) {
            String desc = task.getDescription();
            if(desc.contains(searchFor)) {
                System.out.println("   " + task);
            }
        }
        System.out.println("____________________________________________________________");
    }
}
