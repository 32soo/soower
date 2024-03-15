package com.ry.mapper;

import com.ry.pojo.Department;

import java.util.List;

public interface DepartmentMapper {
    /**
     * 查询所有部门信息
     *
     * @return
     */
    public List<Department> getAllDepartment();
    /**
     * 根据id查询部门信息
     * @param id
     * @return
     */
    public Department getDepartment(int id);
}
