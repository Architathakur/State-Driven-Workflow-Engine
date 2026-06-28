package state;

import util.LoggerUtil;


public class DraftState implements State {

    @Override
    public State edit() {
        System.out.println("Editing the document in Draft state.");
        LoggerUtil.log("Edited document in DRAFT state.");
        return this;
    }

    @Override
    public State submit() {
        System.out.println("Submitting document for review...");
        LoggerUtil.log("Document submitted from DRAFT to REVIEW.");
        return new ReviewState();
    }

    @Override
    public State approve() {
        System.out.println("Cannot approve a document in Draft state.");
        LoggerUtil.log("Blocked approval attempt while document was in DRAFT state.");
        return this;
    }

    @Override
    public State reject() {
        System.out.println("Cannot reject a document in Draft state.");
        LoggerUtil.log("Blocked rejection attempt while document was in DRAFT state.");
        return this;
    }

    @Override
    public String getStateName() {
        return "DRAFT";
    }
}
