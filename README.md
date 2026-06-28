# State-Driven Workflow Engine

A Java implementation of the State design pattern for approval workflows. The project models a document approval pipeline where behavior changes based on the document's current state: `DRAFT`, `REVIEW`, `REJECTED`, or `APPROVED`.

The goal is to keep workflow rules encapsulated inside state classes instead of scattering conditional logic throughout the application.

## Overview

Approval workflows often need to enforce rules such as:

- Draft documents can be edited and submitted for review.
- Documents under review cannot be edited.
- Rejected documents can be revised and resubmitted.
- Approved documents are final and cannot be changed.

This project demonstrates how those rules can be implemented cleanly with object-oriented design. The `Document` class delegates each action to the active state object, and each state decides whether the action is allowed, blocked, or should trigger a transition.

## Features

- State-driven workflow behavior using the State pattern
- Clear separation between workflow context and state-specific rules
- Prevention of invalid transitions
- Audit logging with timestamps in `workflow.log`
- Console-based demonstration scenario
- Lightweight transition regression test

## Workflow

```text
DRAFT -> REVIEW -> APPROVED
           |
           v
        REJECTED -> REVIEW
```

## Project Structure

```text
state-driven-workflow-engine/
├── Main.java
├── README.md
├── scenario.txt
├── state/
│   ├── ApprovedState.java
│   ├── DraftState.java
│   ├── RejectedState.java
│   ├── ReviewState.java
│   └── State.java
├── tests/
│   └── WorkflowTest.java
├── util/
│   └── LoggerUtil.java
└── workflow/
    └── Document.java
```

## Design

The implementation uses four main concepts:

| Concept | Implementation |
| --- | --- |
| Abstraction | `State` interface defines supported workflow actions |
| Polymorphism | Each state implements actions differently |
| Encapsulation | State-specific rules stay inside state classes |
| Delegation | `Document` delegates behavior to its current state |

## How It Works

The `Document` starts in `DraftState`. Public actions such as `edit()`, `submit()`, `approve()`, and `reject()` are delegated to the current state.

When an action causes a valid transition, the state returns the next state. The `Document` applies the transition internally, keeping direct state changes hidden from external callers.

## Run the Project

Compile the source files:

```bash
javac Main.java workflow/*.java state/*.java util/*.java
```

Run the demo workflow:

```bash
java Main
```

## Run Tests

Compile the application and test classes into an output directory:

```bash
javac -d out Main.java workflow/*.java state/*.java util/*.java tests/*.java
```

Run the transition test:

```bash
java -cp out tests.WorkflowTest
```

## Example Scenario

The included demo models a company policy approval flow:

1. An employee creates a policy document.
2. The employee edits the draft.
3. The employee submits it for review.
4. The manager rejects it.
5. The employee revises and resubmits it.
6. The manager approves it.
7. Further edits are blocked after approval.

## Logging

Workflow activity is written to `workflow.log` with timestamps. Logged events include document creation, successful state transitions, approvals, rejections, edits, resubmissions, and blocked actions.

Example:

```text
[2026-06-28 23:32:33] Document approved from REVIEW state.
```

## Future Enhancements

- Add a formal build tool such as Maven or Gradle
- Add JUnit-based automated tests
- Support role-based access control
- Persist workflow history in a database
- Add a web or desktop interface

## Author

Archita Thakur  
Computer Science & AI Student
