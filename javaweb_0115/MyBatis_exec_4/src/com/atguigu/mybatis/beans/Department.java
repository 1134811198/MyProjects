package com.atguigu.mybatis.beans;

public class Department {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_dept.id
     *
     * @mbggenerated Fri Apr 20 21:21:31 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_dept.department_name
     *
     * @mbggenerated Fri Apr 20 21:21:31 CST 2018
     */
    private String departmentName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_dept.id
     *
     * @return the value of tbl_dept.id
     *
     * @mbggenerated Fri Apr 20 21:21:31 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_dept.id
     *
     * @param id the value for tbl_dept.id
     *
     * @mbggenerated Fri Apr 20 21:21:31 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_dept.department_name
     *
     * @return the value of tbl_dept.department_name
     *
     * @mbggenerated Fri Apr 20 21:21:31 CST 2018
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_dept.department_name
     *
     * @param departmentName the value for tbl_dept.department_name
     *
     * @mbggenerated Fri Apr 20 21:21:31 CST 2018
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }
}