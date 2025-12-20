# State-Driven Workflow Engine for Approval Pipelines (Java)

## Overview

This project is a State-Driven Workflow Engine implemented in Java to model real-world approval pipelines such as company policy approvals, document reviews, or request validation systems.

Instead of using complex conditional (if-else) logic, the system applies Object-Oriented Programming (OOPS) principles to delegate behavior to individual state objects, making the workflow clean, extensible, and easy to maintain.


## Problem Statement

In real-world systems, entities like documents or requests go through multiple stages (Draft, Review, Approved, Rejected).
Handling such workflows using conditional logic leads to:

a. Hard-to-maintain code
b. Poor extensibility
c. High risk of invalid state transitions

This project solves the problem by modeling state-dependent behavior using OOPS.


## Solution Approach

Each workflow stage is represented as a State object

The Document class delegates actions to its current state

Each state defines:
- Which actions are allowed
- Which actions are blocked
- How transitions happen
- No conditional checks (if-else) are used for state handling

This design follows the State Pattern.


## Project Structure

State-Driven-Workflow-Engine/
│
├── Main.java
├── workflow/
│   └── Document.java
│
├── state/
│   ├── State.java
│   ├── DraftState.java
│   ├── ReviewState.java
│   ├── ApprovedState.java
│   └── RejectedState.java
│
├── util/
│   └── LoggerUtil.java
│
└── README.md


## Workflow Lifecycle
Draft → Review → Approved
          ↓
       Rejected → Review


## OOPS Concepts Used
OOPS Concept  ->	Implementation
Abstraction 	    State interface
Polymorphism    	Different behavior for each state
Encapsulation	    State logic hidden inside classes
Open–Closed Principle	New states can be added without modifying existing code
Delegation	        Document delegates behavior to states
Single Responsibility	Each state handles its own behavior


## Key Features
- State-driven behavior without conditional logic
- Clean and extensible workflow transitions
- Prevention of invalid actions based on state
- File-based logging with timestamps
- Realistic approval pipeline simulation


## File Logging & Timestamps

The project includes audit logging using file handling:
- All major actions are logged to workflow.log
- Each log entry includes a timestamp
- Helps in traceability and debugging

Sample log entry:
[2025-01-20 14:32:10] Document submitted from DRAFT to REVIEW


## How to Run the Project

1. Compile all files
javac Main.java workflow/*.java state/*.java util/*.java

2. Run the program
java Main


## Example Use Case

The Main class simulates a company policy approval workflow:

1. Employee creates a policy (Draft)
2. Submits for review
3. Manager rejects it
4. Employee revises and resubmits
5. Manager approves the document
6. Further edits are blocked after approval


## Future Enhancements
- Custom exception handling
- Persistent storage using a database
- Role-based access control
- GUI or web interface


## Author

Archita Thakur
Computer Science & AI Student
