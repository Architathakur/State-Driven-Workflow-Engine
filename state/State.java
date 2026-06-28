package state;

public interface State {

    // Action: edit the document
    State edit();

    // Action: submit the document for review
    State submit();

    // Action: approve the document
    State approve();

    // Action: reject the document
    State reject();

    // Utility method to identify the state
    String getStateName();
}
