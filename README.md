# Tasks Management Application

## Project Overview
A Java desktop application for managing tasks with persistence in Apache Derby database, implementing multiple design patterns and MVVM architecture.

## Project Status: 🚧 IN PROGRESS

---

## 📋 What's Already Implemented ✅

### Core Interfaces & Classes
- **`ITask.java`** - Task interface with required methods (getId, getTitle, getDescription, getState, accept)
- **`ITasksDAO.java`** - Data Access Object interface for database operations
- **`Task.java`** - Concrete task implementation with validation, State pattern, and Visitor pattern support
- **`TasksDAO.java`** - Concrete DAO implementation using Singleton pattern with Derby database
- **`TaskState.java`** - Enum for task states (TO_DO, IN_PROGRESS, COMPLETED) - State pattern
- **`TaskManagerException.java`** - Custom exception class for error handling

### Design Patterns Implemented
1. **✅ State Pattern** - TaskState enum for task lifecycle
2. **✅ Singleton Pattern** - TasksDAO ensures single database connection


### Database Layer
- **Derby embedded database** connection established
- **Automatic table creation** (tasks table with id, title, description, state columns)
- **Full CRUD operations** (Create, Read, Update, Delete tasks)
- **Proper exception handling** with custom TaskManagerException

---

## 🚧 What Still Needs to Be Implemented

### Required Design Patterns (6 Total)
- [ ] **Combinator Pattern** - For flexible task filtering (MANDATORY)
- [ ] **Visitor Pattern** - For report generation with Records & Pattern Matching (MANDATORY)
- [ ] **State Pattern** - For task lifecycle management (✅ COMPLETED)
- [ ] **Singleton Pattern** - For DAO implementation (✅ COMPLETED)
- [ ] **Observer Pattern** - For MVVM (UI updates when model changes)
- [ ] **Strategy Pattern** - For sorting and task prioritization

### Architecture Components
- [ ] **MVVM Structure** - Model-View-ViewModel separation
- [ ] **Swing GUI** - User interface with Swing components
- [ ] **Observer System** - Notification mechanism for UI updates
- [ ] **Filtering System** - Combinator pattern implementation
- [ ] **Reporting System** - Visitor pattern with Java Records

### Additional Interfaces to Create
- [ ] **Observer interfaces** (ITaskObserver, ITaskSubject)
- [ ] **Strategy interfaces** (ISortStrategy, different sorting implementations)
- [ ] **Filter interfaces** (ITaskFilter, IFilterCombinator)
- [ ] **Visitor interfaces** (TaskVisitor, concrete visitors)

---

## 🏗️ Project Structure (Current)
```
src/com/oriomri/taskmanager/
├── ITask.java              ← Task interface
├── ITasksDAO.java          ← DAO interface  
├── Task.java               ← Task implementation
├── TasksDAO.java           ← DAO implementation (Singleton)
├── TaskState.java          ← Task states enum
└── TaskManagerException.java ← Custom exception
```

## 🎯 Recommended Next Steps

### Phase 1: Complete Core Patterns
1. **Create Observer interfaces** for MVVM
2. **Implement Strategy pattern** for sorting
3. **Build Combinator pattern** for filtering

### Phase 2: MVVM Architecture
1. **Create ViewModel** with Observer pattern
2. **Implement Swing GUI** (View)
3. **Connect Model-View-ViewModel**

### Phase 3: Advanced Features
1. **Implement Visitor pattern** for reports
2. **Add filtering capabilities**
3. **Create sorting strategies**

---

## 🛠️ How to Work with the Project

### Prerequisites
- **Java 24+** (as required by lecturer)
- **IntelliJ IDEA** (Community or Ultimate)
- **Apache Derby 10.17.1.0** - Compatible with Java 21+ (download from [Apache Derby](https://db.apache.org/derby/derby_downloads.html))

### Installation & Setup

#### Step 1: Import Project
1. **Open IntelliJ IDEA**
2. **File → Open** (or **Import Project**)
3. **Select the project folder** (`Task_manager_app`)
4. **Choose "Open as Project"**

#### Step 2: Configure JDK
1. **File → Project Structure** (or **Ctrl+Alt+Shift+S**)
2. **Project Settings → Project**
3. **Project SDK**: Select **Java 24+**
4. **Project language level**: Select **24** or higher
5. **Click OK**

#### Step 3: Add Derby Libraries
**First, download Derby libraries:**
1. **Go to**: [Apache Derby Downloads](https://db.apache.org/derby/derby_downloads.html)
2. **Download**: **10.17.1.0 (November 10, 2023)** - For Java 21 and Higher
3. **Extract** the downloaded ZIP file
4. **Copy these JAR files** to your project's `lib/` folder:(if there is no lib folder make one)
   - `derby.jar`
   - `derbyshared.jar` 
   - `derbytools.jar`

**Then add to IntelliJ:**
1. **File → Project Structure** (or **Ctrl+Alt+Shift+S**)
2. **Project Settings → Libraries**
3. **Click + → Java**
4. **Navigate to project folder → lib folder**
5. **Select ALL JAR files** from the lib folder
6. **Click OK**
7. **Apply → OK**

#### Step 4: Test Setup
1. **Run Main.java** to test database connection
2. **Check console output** for "Connected to Derby!" message

### Running the Project
1. **Ensure JDK 24+** is configured
2. **Verify Derby libraries** are added
3. **Run Main.java** - Test database connection

### Database
- **Location**: `mydb/` folder (embedded Derby)
- **Connection**: Automatically established by TasksDAO
- **Table**: `tasks` created automatically on first run

### Adding New Features
1. **Follow Java coding standards** from Moodle
2. **Use existing patterns** as examples
3. **Maintain separation of concerns**
4. **Add proper Javadoc** for all public methods

---

## 📚 Design Pattern References

### All 6 Design Patterns

#### ✅ Already Implemented (2/6)
- **State Pattern**: `TaskState.java` - Task lifecycle management
- **Singleton Pattern**: `TasksDAO.java` - Single database connection

#### 🚧 Partially Ready (1/6)
- **Visitor Pattern**: `Task.accept()` method ready, needs concrete visitors

#### ❌ Still Need to Implement (3/6)
- **Observer Pattern**: UI updates when data changes (MVVM)
- **Strategy Pattern**: Different sorting algorithms
- **Combinator Pattern**: Flexible filtering system (MANDATORY)

---

## ⚠️ Important Notes

### Coding Standards (Must Follow)
- **In the requirements file of the project that is in the moodle there is also link to website : javapoints
- ** you should follow these instructions

### Project Requirements
- **Check Moodle for requirements

---

## 🤝 Partner Collaboration

### What You Can Work On
- **Observer pattern** implementation
- **Strategy pattern** for sorting
- **Swing GUI** components
- **MVVM architecture** setup
- **Unit tests** for existing code

### Communication
- **Update this README** as you implement features
- **Mark completed items** with ✅
- **Add notes** about implementation decisions
- **Document any issues** you encounter

---

## 📞 Getting Help

### For Questions
- **Check lecturer's forum** first (as required)
- **Review existing code** for examples
- **Follow Java coding standards** strictly
- **Test incrementally** as you build

### Project Deadline
- **Check Moodle** for exact deadline
- **Submit 30 minutes early** (server time difference)
- **Required files**: ZIP, JAR, PDF with code

---

**Last Updated**: [Current Date]
**Status**: Core classes implemented, ready for MVVM and GUI development
**Next Milestone**: Complete Observer and Strategy patterns
# TASK_MANAGER
