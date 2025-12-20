package state;

import workflow.Document;

public class RejectedState implements State {

    @Override
    public void edit(Document document) {
        System.out.println("Editing the document after rejection.");
    }

    @Override
    public void submit(Document document) {
        System.out.println("Resubmitting document for review...");
        document.setState(new ReviewState());
    }

    @Override
    public void approve(Document document) {
        System.out.println("Cannot approve. Document must be reviewed again.");
    }

    @Override
    public void reject(Document document) {
        System.out.println("Document is already rejected.");
    }

    @Override
    public String getStateName() {
        return "REJECTED";
    }
}
