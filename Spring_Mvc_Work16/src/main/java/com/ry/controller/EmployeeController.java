package com.ry.controller;

import com.ry.pojo.Department;
import com.ry.pojo.Employee;
import com.ry.service.DepartmentService;
import com.ry.service.EmployeeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    /**
     * 主页展示
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAllEmployee(Model model) {
        List<Employee> list = employeeService.getAllEmployee();
        for (Employee emp : list) {
            System.out.println(emp);
        }
        model.addAttribute("list", list);
        return "Emplist";
    }

    @RequestMapping("/toAddEdit")
    public String toAdd(Model model, HttpServletRequest request) throws ParseException {
        String empno = request.getParameter("empNo");
        if (empno != null) {
            model.addAttribute("empno", empno);
            Employee emp = employeeService.getEmployeeById(Integer.parseInt((empno)));
            model.addAttribute("employee", emp);
            System.out.println(emp);
        }
        List<Department> list = departmentService.getAllDepartment();
        model.addAttribute("lists", list);
        return "AddEdit";
    }

    @RequestMapping(value = "/addemp", method = RequestMethod.POST)
    public String addemp(@Param("eName") String eName, @Param("job") String job, @Param("hireDate") String hireDate, @Param("sal") String sal, @Param("comm") String comm, @Param("deptno") String deptno) {
        Employee employee = new Employee();
        employee.seteName(eName);
        employee.setJob(job);
        employee.setHireDate(hireDate);
        employee.setSal(Float.parseFloat(sal));
        employee.setComm(Float.parseFloat(comm));

        Department department = new Department();
        department.setDeptNo(Integer.parseInt(deptno));
        employee.setDepartment(department);

        employeeService.addEmployee(employee);
        return "redirect:/list";
    }

    @RequestMapping(value = "/editemp", method = RequestMethod.POST)
    public String updateEmployee(@Param("eName") String eName, @Param("job") String job, @Param("hireDate") String hireDate, @Param("sal") String sal, @Param("comm") String comm, @Param("deptno") String deptno, HttpServletRequest request) {
        Employee employee = new Employee();
        employee.setEmpNo(Integer.parseInt(request.getParameter("employee")));
        employee.seteName(eName);
        employee.setJob(job);
        employee.setHireDate(hireDate);
        employee.setSal(Float.parseFloat(sal));
        employee.setComm(Float.parseFloat(comm));

        Department department = new Department();
        department.setDeptNo(Integer.parseInt(deptno));
        employee.setDepartment(department);

        employeeService.updateEmployee(employee);
        return "redirect:/list";
    }

    @RequestMapping("/delete")
    public String deleteEmployee(@Param("empNo") int empNo, HttpServletRequest request) {
        employeeService.deleteEmployee(empNo);
        return "redirect:/list";
    }
    @RequestMapping(value = "/deleteEmp",method = RequestMethod.GET)
    public String deleteEmp(@RequestParam("empons[]")List<Integer> empons){
        employeeService.deleteEmployees(empons);
        return "redirect:/list";
    }
}
