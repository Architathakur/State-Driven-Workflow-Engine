package state;

import workflow.Document;

public interface State {

    // Action: edit the document
    void edit(Document document);

    // Action: submit the document for review
    void submit(Document document);

    // Action: approve the document
    void approve(Document document);

    // Action: reject the document
    void reject(Document document);

    // Utility method to identify the state
    String getStateName();
}

