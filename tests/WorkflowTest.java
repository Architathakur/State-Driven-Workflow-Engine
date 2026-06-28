package tests;

import workflow.Document;

public class WorkflowTest {

    public static void main(String[] args) {
        Document document = new Document();

        assertState(document, "DRAFT");

        document.approve();
        assertState(document, "DRAFT");

        document.submit();
        assertState(document, "REVIEW");

        document.edit();
        assertState(document, "REVIEW");

        document.reject();
        assertState(document, "REJECTED");

        document.approve();
        assertState(document, "REJECTED");

        document.submit();
        assertState(document, "REVIEW");

        document.approve();
        assertState(document, "APPROVED");

        document.edit();
        assertState(document, "APPROVED");
    }

    private static void assertState(Document document, String expectedState) {
        String actualState = document.getStateName();
        if (!expectedState.equals(actualState)) {
            throw new AssertionError("Expected " + expectedState + " but got " + actualState);
        }
    }
}
