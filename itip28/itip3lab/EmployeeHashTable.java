public class EmployeeHashTable extends HashTable<String, Employee> {
    public EmployeeHashTable(){ super();}

    public void addEmployee(String employeeId, Employee employee) {
        put(employeeId, employee);
    }

    public Employee getEmployee(String employeeId) {
        if (get(employeeId) != null){return get(employeeId);}
        else return null;
    }

    public void removeEmployee(String employeeId) {
        remove(employeeId);
    }
}
