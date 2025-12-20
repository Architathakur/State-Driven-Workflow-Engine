package state;

import workflow.Document;
import util.LoggerUtil;


public class DraftState implements State {

    @Override
    public void edit(Document document) {
        System.out.println("Editing the document in Draft state.");
        LoggerUtil.log("Edited document in DRAFT state.");
    }

    @Override
    public void submit(Document document) {
        System.out.println("Submitting document for review...");
        LoggerUtil.log("Document submitted from DRAFT to REVIEW.");
        document.setState(new ReviewState());
    }

    @Override
    public void approve(Document document) {
        System.out.println("Cannot approve a document in Draft state.");
    }

    @Override
    public void reject(Document document) {
        System.out.println("Cannot reject a document in Draft state.");
    }

    @Override
    public String getStateName() {
        return "DRAFT";
    }
}

