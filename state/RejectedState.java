package state;

import util.LoggerUtil;

public class RejectedState implements State {

    @Override
    public State edit() {
        System.out.println("Editing the document after rejection.");
        LoggerUtil.log("Edited document in REJECTED state.");
        return this;
    }

    @Override
    public State submit() {
        System.out.println("Resubmitting document for review...");
        LoggerUtil.log("Document resubmitted from REJECTED to REVIEW.");
        return new ReviewState();
    }

    @Override
    public State approve() {
        System.out.println("Cannot approve. Document must be reviewed again.");
        LoggerUtil.log("Blocked approval attempt while document was in REJECTED state.");
        return this;
    }

    @Override
    public State reject() {
        System.out.println("Document is already rejected.");
        LoggerUtil.log("Blocked rejection attempt while document was already in REJECTED state.");
        return this;
    }

    @Override
    public String getStateName() {
        return "REJECTED";
    }
}
