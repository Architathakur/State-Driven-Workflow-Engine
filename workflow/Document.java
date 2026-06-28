package workflow;

import state.State;
import state.DraftState;
import util.LoggerUtil;

public class Document {

    // The current state of the document
    private State currentState;

    // Constructor: when a document is created, it starts in Draft state
    public Document() {
        this.currentState = new DraftState();
        System.out.println("Document created. Initial State: " + currentState.getStateName());
        LoggerUtil.log("Document created. Initial State: " + currentState.getStateName());
    }

    private void applyAction(State nextState) {
        if (nextState != null && nextState != currentState) {
            setState(nextState);
        }
    }

    // Method to change the state of the document
    private void setState(State state) {
        if (state == null) {
            throw new IllegalArgumentException("Document state cannot be null.");
        }
        this.currentState = state;
        System.out.println("Document state changed to: " + state.getStateName());
        LoggerUtil.log("Document state changed to: " + state.getStateName());
    }

    public String getStateName() {
        return currentState.getStateName();
    }

    // Delegate actions to the current state
    public void edit() {
        applyAction(currentState.edit());
    }

    public void submit() {
        applyAction(currentState.submit());
    }

    public void approve() {
        applyAction(currentState.approve());
    }

    public void reject() {
        applyAction(currentState.reject());
    }
}
