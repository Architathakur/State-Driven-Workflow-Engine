package state;

import util.LoggerUtil;

public class ApprovedState implements State {

    @Override
    public State edit() {
        System.out.println("Cannot edit. Document is already approved.");
        LoggerUtil.log("Blocked edit attempt while document was in APPROVED state.");
        return this;
    }

    @Override
    public State submit() {
        System.out.println("Cannot submit. Document is already approved.");
        LoggerUtil.log("Blocked submit attempt while document was in APPROVED state.");
        return this;
    }

    @Override
    public State approve() {
        System.out.println("Document is already approved.");
        LoggerUtil.log("Blocked approval attempt while document was already in APPROVED state.");
        return this;
    }

    @Override
    public State reject() {
        System.out.println("Cannot reject. Approved document is final.");
        LoggerUtil.log("Blocked rejection attempt while document was in APPROVED state.");
        return this;
    }

    @Override
    public String getStateName() {
        return "APPROVED";
    }
}
