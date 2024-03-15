package com.ry.mapper;

import com.ry.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    /**
     * 查询所有员工信息
     *
     * @return List集合
     */
    public List<Employee> getAllEmployee();

    /**
     * 根据id查询员工信息
     *
     * @param id
     * @return
     */
    public Employee getEmployeeById(int id);

    /**
     * 添加员工信息
     *
     * @param employee
     * @return
     */
    public int addEmployee(Employee employee);

    /**
     * 修改员工信息
     *
     * @param employee
     * @return
     */
    public int updateEmployee(Employee employee);

    /**
     * 删除员工信息
     *
     * @param id
     * @return
     */
    public int deleteEmployee(int empNo);

    /**
     * 删除多个员工信息
     *
     * @param ids
     * @return
     */
    public void deleteEmployees(List<Integer> empons);
}
