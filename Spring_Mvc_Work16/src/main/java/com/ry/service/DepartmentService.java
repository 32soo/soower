package com.ry.service;

import com.ry.pojo.Department;

import java.util.List;

public interface DepartmentService {
    /**
     * 获取所有部门信息
     *
     * @return
     */
    public List<Department> getAllDepartment();
    /**
     * 获取部门信息
     */
    public Department getDepartmentById(int id);
}
