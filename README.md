# Tasks Management Application

## Project Overview
A Java desktop application for managing tasks with persistence in Apache Derby database, implementing multiple design patterns and MVVM architecture.

## Project Status: 🚧 IN PROGRESS (67% Complete)

---

## 📋 What's Already Implemented ✅

### Design Patterns (4/6 Completed)
1. **✅ State Pattern** - `TaskState.java` for task lifecycle (TO_DO, IN_PROGRESS, COMPLETED)
2. **✅ Singleton Pattern** - `TasksDAO.java` ensures single database connection
3. **✅ Observer Pattern** - `ITaskObserver.java`, `ITaskSubject.java`, `TaskManager.java` for MVVM notifications
4. **✅ Strategy Pattern** - `ISortStrategy.java`, concrete strategies, `TaskSorter.java` for sorting algorithms

### Core Architecture
- **✅ Model Layer** - `ITask.java`, `Task.java`, `TaskState.java` with validation and State pattern
- **✅ DAO Layer** - `ITasksDAO.java`, `TasksDAO.java` with Singleton pattern and Derby database
- **✅ ViewModel Layer** - `TaskManager.java` with Observer pattern for MVVM
- **✅ Exception Handling** - `TaskManagerException.java` for proper error management

### Database Layer
- **Derby embedded database** with automatic table creation
- **Full CRUD operations** (Create, Read, Update, Delete tasks)
- **Proper exception handling** with custom TaskManagerException

---

## 🚧 What Still Needs to Be Implemented

### Required Design Patterns (2/6 Remaining)
- [ ] **Combinator Pattern** - For flexible task filtering (MANDATORY)
- [ ] **Visitor Pattern** - For report generation with Records & Pattern Matching (MANDATORY)

### Architecture Components
- [ ] **Swing GUI** - User interface with Swing components
- [ ] **Filtering System** - Combinator pattern implementation
- [ ] **Reporting System** - Visitor pattern with Java Records

---

## 🏗️ Project Structure
```
src/com/oriomri/taskmanager/
├── model/
│   ├── ITask.java              ← Task interface
│   ├── Task.java               ← Task implementation with State pattern
│   └── TaskState.java          ← Task states enum
├── dao/
│   ├── ITasksDAO.java          ← DAO interface  
│   └── TasksDAO.java           ← DAO implementation (Singleton)
├── exceptions/
│   └── TaskManagerException.java ← Custom exception
├── observer/
│   ├── ITaskObserver.java      ← Observer interface
│   └── ITaskSubject.java       ← Subject interface
├── viewmodel/
│   └── TaskManager.java        ← Main manager with Observer pattern
└── sortingstrategy/
    ├── ISortStrategy.java      ← Strategy interface
    ├── SortByIdStrategy.java   ← Sort by ID strategy
    ├── SortByTitleStrategy.java ← Sort by title strategy
    ├── SortByStateStrategy.java ← Sort by state strategy
    └── TaskSorter.java         ← Context class using Strategy pattern
```

---

## 🎯 Next Steps

### Phase 1: Complete Core Patterns ✅ COMPLETED
- **✅ Observer interfaces** for MVVM
- **✅ Strategy pattern** for sorting
- **Build Combinator pattern** for filtering (NEXT)

### Phase 2: MVVM Architecture (IN PROGRESS)
- **✅ Create ViewModel** with Observer pattern
- **Implement Swing GUI** (View)
- **Connect Model-View-ViewModel**

### Phase 3: Advanced Features
- **Implement Visitor pattern** for reports
- **Add filtering capabilities** (Combinator pattern)

---

## 🛠️ Installation & Setup

### Prerequisites
- **Java 24+** (as required by lecturer)
- **IntelliJ IDEA** (Community or Ultimate)
- **Apache Derby 10.17.1.0** - Compatible with Java 21+ ([Download here](https://db.apache.org/derby/derby_downloads.html))

### Setup Steps
1. **Import Project** - Open `Task_manager_app` folder in IntelliJ
2. **Configure JDK** - Set Project SDK to Java 24+ in Project Structure
3. **Add Derby Libraries**:
   - Download Derby 10.17.1.0 and extract
   - Copy `derby.jar`, `derbyshared.jar`, `derbytools.jar` to project's `lib/` folder
   - In IntelliJ: Project Structure → Libraries → + → Java → Select all JAR files
4. **Test Setup** - Run `Main.java` to verify database connection

### Database
- **Location**: `mydb/` folder (embedded Derby)
- **Connection**: Automatically established by TasksDAO
- **Table**: `tasks` created automatically on first run

---

## 🤝 Partner Collaboration

### What You Can Work On
- **✅ Observer pattern** implementation (COMPLETED)
- **✅ Strategy pattern** for sorting (COMPLETED)
- **Swing GUI** components (NEXT PRIORITY)
- **✅ MVVM architecture** setup (ViewModel completed)
- **Unit tests** for existing code

### Communication
- **Update this README** as you implement features
- **Mark completed items** with ✅
- **Add notes** about implementation decisions
- **Document any issues** you encounter

---

## ⚠️ Important Notes

### Coding Standards
- **Follow Java coding standards** from Moodle
- **Check project requirements** in Moodle
- **Use existing patterns** as examples for new implementations

### Project Deadline
- **Check Moodle** for exact deadline
- **Submit 30 minutes early** (server time difference)
- **Required files**: ZIP, JAR, PDF with code

---

**Last Updated**: December 19, 2024  
**Status**: 4/6 design patterns completed, MVVM ViewModel ready, ready for GUI development  
**Next Milestone**: Implement Swing GUI and integrate with existing patterns
