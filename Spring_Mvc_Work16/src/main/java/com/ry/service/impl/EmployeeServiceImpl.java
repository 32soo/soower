package com.ry.service.impl;

import com.ry.mapper.EmployeeMapper;
import com.ry.pojo.Employee;
import com.ry.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 查询员工所有信息
     *
     * @return
     */
    @Override
    public List<Employee> getAllEmployee() {
        return this.employeeMapper.getAllEmployee();
    }

    /**
     * 根据id查询员工信息
     *
     * @param id
     * @return
     */
    public Employee getEmployeeById(int id) {
        return this.employeeMapper.getEmployeeById(id);
    }

    /**
     * 添加员工信息
     *
     * @param employee
     */
    public int addEmployee(Employee employee) {
        return this.employeeMapper.addEmployee(employee);
    }

    /**
     * 修改员工信息
     *
     * @param employee
     */
    public int updateEmployee(Employee employee) {
        return this.employeeMapper.updateEmployee(employee);
    }

    /**
     * 删除员工信息
     *
     * @param id
     * @return
     */
    public int deleteEmployee(int empNo) {
        return this.employeeMapper.deleteEmployee(empNo);
    }

    @Override
    public void deleteEmployees(List<Integer> empons) {
        employeeMapper.deleteEmployees(empons);
    }

}

