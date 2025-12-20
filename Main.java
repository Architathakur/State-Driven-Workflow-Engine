import workflow.Document;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Company Policy Approval Workflow ===\n");

        // Step 1: Employee creates a new policy document
        System.out.println("Employee creates a new policy document.");
        Document policyDocument = new Document();

        // Step 2: Employee edits the draft
        System.out.println("\nEmployee edits the policy draft.");
        policyDocument.edit();

        // Step 3: Employee submits the policy for manager review
        System.out.println("\nEmployee submits the policy for review.");
        policyDocument.submit();

        // Step 4: Manager tries to edit (should not be allowed)
        System.out.println("\nManager tries to edit the policy during review.");
        policyDocument.edit();

        // Step 5: Manager rejects the policy due to issues
        System.out.println("\nManager rejects the policy.");
        policyDocument.reject();

        // Step 6: Employee revises the rejected policy
        System.out.println("\nEmployee revises the rejected policy.");
        policyDocument.edit();

        // Step 7: Employee resubmits the revised policy
        System.out.println("\nEmployee resubmits the policy for review.");
        policyDocument.submit();

        // Step 8: Manager approves the policy
        System.out.println("\nManager approves the policy.");
        policyDocument.approve();

        // Step 9: Any further edits should be blocked
        System.out.println("\nAttempting to edit approved policy.");
        policyDocument.edit();

        System.out.println("\n=== Workflow Completed ===");
    }
}

// The main class simulates a real-world approval pipeline where a document is drafted, reviewed, rejected, revised, and finally approved. It demonstrates how state-dependent behavior is enforced without conditional logic.

