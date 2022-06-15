package AI;

import java.util.Comparator;

public class Minimax {
    private Minimax() {}

    public static State minimaxDecision(State state) {
        return state.getActions().stream()
                .max(Comparator.comparing(Minimax::minValue)).get();
    }

    private static double maxValue(State state) {
        if(state.isTerminal()){
            return state.getUtility();
        }
        return state.getActions().stream()
                .map(Minimax::minValue)
                .max(Comparator.comparing(Double::valueOf)).get();
    }

    private static double minValue(State state) {
        if(state.isTerminal()){
            return state.getUtility();
        }
        return state.getActions().stream()
                .map(Minimax::maxValue)
                .min(Comparator.comparing(Double::valueOf)).get();
    }

}
