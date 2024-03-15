package com.ry.service.impl;

import com.ry.mapper.DepartmentMapper;
import com.ry.pojo.Department;
import com.ry.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 获取所有部门信息
     *
     * @return
     */
    public List<Department> getAllDepartment() {
        return departmentMapper.getAllDepartment();
    }

    /**
     * 获取部门信息
     *
     * @param id
     * @return
     */
    public Department getDepartmentById(int id) {
        return departmentMapper.getDepartment(id);
    }
}
