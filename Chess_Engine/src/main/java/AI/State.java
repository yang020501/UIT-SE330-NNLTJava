package AI;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class State {

    public State() {
        //create a state
    }

    Collection<State> getActions() {
        List<State> actions = new LinkedList<>();
        //generate actions
        return actions;
    }

    boolean isTerminal() {
        //add some logic
        return false;
    }

    double getUtility() {
        //add some logic
        return 0;
    }
}
