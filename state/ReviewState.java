package state;

import util.LoggerUtil;

public class ReviewState implements State {

    @Override
    public State edit() {
        System.out.println("Cannot edit document in Review state.");
        LoggerUtil.log("Blocked edit attempt while document was in REVIEW state.");
        return this;
    }

    @Override
    public State submit() {
        System.out.println("Document is already under review.");
        LoggerUtil.log("Blocked submit attempt while document was already in REVIEW state.");
        return this;
    }

    @Override
    public State approve() {
        System.out.println("Document approved.");
        LoggerUtil.log("Document approved from REVIEW state.");
        return new ApprovedState();
    }

    @Override
    public State reject() {
        System.out.println("Document rejected.");
        LoggerUtil.log("Document rejected from REVIEW state.");
        return new RejectedState();
    }

    @Override
    public String getStateName() {
        return "REVIEW";
    }
}
