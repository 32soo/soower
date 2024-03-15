package com.ry.pojo;

public class Employee {
    //员工编号
    private int empNo;
    //员工名称
    private String eName;
    //员工职位
    private String job;
    //入职时间
    private String hireDate;
    //薪水
    private float sal;
    //奖金
    private float comm;
    //所属部门
    private Department department;
    //getter setter方法
    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public float getSal() {
        return sal;
    }

    public void setSal(float sal) {
        this.sal = sal;
    }

    public float getComm() {
        return comm;
    }

    public void setComm(float comm) {
        this.comm = comm;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", eName='" + eName + '\'' +
                ", job='" + job + '\'' +
                ", hireDate='" + hireDate + '\'' +
                ", sal=" + sal +
                ", comm=" + comm +
                ", department=" + department +
                '}';
    }
}
