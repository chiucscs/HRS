package com.pack.my.projs.hrs.dao.impl;

import com.pack.my.projs.hrs.dao.IEmpDAO;
import com.pack.my.projs.hrs.vo.Emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.util.List;

public class EmpDAOImpl implements IEmpDAO {
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public EmpDAOImpl(Connection conn){
        this.conn = conn;

    }

    @Override
    public boolean doCreate(Emp emp) throws Exception {
        boolean flag = false;

        String sql = "Insert into emp(empno,ename,job,hiredate,sal,comm,mgr,deptno,photo,note) values(?,?,?,?,?,?,?,?,?,?)";
        this.pstmt = conn.prepareStatement(sql);
        this.pstmt.setInt(1,emp.getEmpno());
        this.pstmt.setString(2,emp.getEname());
        this.pstmt.setString(3,emp.getJob());
        this.pstmt.setDate(4,new Date(emp.getHireDate().getTime()));




        return flag;
    }

    @Override
    public List<Emp> findAll(String keyWord) throws Exception {
        return null;
    }

    @Override
    public Emp findById(int empno) throws Exception {
        return null;
    }
}
