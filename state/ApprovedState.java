package state;

import workflow.Document;

public class ApprovedState implements State {

    @Override
    public void edit(Document document) {
        System.out.println("Cannot edit. Document is already approved.");
    }

    @Override
    public void submit(Document document) {
        System.out.println("Cannot submit. Document is already approved.");
    }

    @Override
    public void approve(Document document) {
        System.out.println("Document is already approved.");
    }

    @Override
    public void reject(Document document) {
        System.out.println("Cannot reject. Approved document is final.");
    }

    @Override
    public String getStateName() {
        return "APPROVED";
    }
}

