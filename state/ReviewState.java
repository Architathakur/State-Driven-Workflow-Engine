package state;

import workflow.Document;

public class ReviewState implements State {

    @Override
    public void edit(Document document) {
        System.out.println("Cannot edit document in Review state.");
    }

    @Override
    public void submit(Document document) {
        System.out.println("Document is already under review.");
    }

    @Override
    public void approve(Document document) {
        System.out.println("Document approved.");
        document.setState(new ApprovedState());
    }

    @Override
    public void reject(Document document) {
        System.out.println("Document rejected.");
        document.setState(new RejectedState());
    }

    @Override
    public String getStateName() {
        return "REVIEW";
    }
}

