## Config

There is an `.env` file in the root of the directory, for easy setting of the file paths, used for json storage

---

## StaffManager

Map user's commands to the corresponding methods

**List employees**
List all employees

**Add Employee**
**ID, name, department, role, salary**
**{id}, {name}, {department}, {role}, {salary}**
Add a new employee

**Edit {id}**
**{name}, {department}, {role}, {salary}**
Edit an employee by id

**Search Id {id}**
Search an employee by id

**Search Name {name}**
Search an employee by name

**Search Department {department}**
Search an employee by department

**Fire {id}**
Set employee's end date field

**Save & Exit**
Store current data in file and exit

---

## StaffService

### CRUD

- listAll();
- add();
- searchById(int id);
- searchByName();
- searchByDepartment();

## Employee

At the top of the hierarchy there is an abstract **Employee** class

```
int id;
String name;
Department department;
String role;
double salary;
```

---

### Derived classes

Derived classes are based on other existing department's in the company:

#### ITEmployee
#### HREmployee
#### MarketingEmployee
#### FinanceEmployee
#### SalesEmployee

Changing employee's **internal state** happens from within the corresponding employee instance, using **setters**.
**Interfaces** are used to define the behaviors, which the employee's must adhere to.

---

### EmployeeFactory

`EmployeeFactory` is used to handle the instantiating of the proper employee class, based on the department.

---

## Reader/writer

`JsonReader` is used to load all the data from the `db/employees/all.json` file into memory on app start.
`JsonWriter` stores all the data to the same file on app exit.
