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

    // Method to change the state of the document
    public void setState(State state) {
        this.currentState = state;
        System.out.println("Document state changed to: " + state.getStateName());
        LoggerUtil.log("Document state changed to: " + state.getStateName());
    }

    // Delegate actions to the current state
    public void edit() {
        currentState.edit(this);
    }

    public void submit() {
        currentState.submit(this);
    }

    public void approve() {
        currentState.approve(this);
    }

    public void reject() {
        currentState.reject(this);
    }
}

