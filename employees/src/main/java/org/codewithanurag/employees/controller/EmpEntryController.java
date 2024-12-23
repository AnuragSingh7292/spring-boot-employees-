package org.codewithanurag.employees.controller;

import org.codewithanurag.employees.entity.EmployeeEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emp")
public class EmpEntryController {

    private Map<Integer, EmployeeEntry> Eentry = new HashMap<>();

    @GetMapping
    public List<EmployeeEntry> getAllEmployees() {
        return new ArrayList<>(Eentry.values());
    }

    @PostMapping
    public String createEmployees(@RequestBody EmployeeEntry myEntry) {
        Eentry.put(myEntry.getEmpId(),myEntry);
        return "saved successfully";
    }

    @GetMapping("/id/{empId}")
    public EmployeeEntry getEmployeeById(@PathVariable int empId) {
        return Eentry.get(empId);
    }
    @DeleteMapping("/id/{empId}")
    public boolean deleteEmployeeById(@PathVariable int empId) {
        return Eentry.remove(empId) != null;
    }
    @PutMapping("/id/{empId}")
    public EmployeeEntry updateEmployeeById(@PathVariable int empId, @RequestBody EmployeeEntry myEntry) {
        return Eentry.put(empId, myEntry);
    }
}
