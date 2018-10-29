package com.pack.my.projs.hrs.dao.impl;

import com.pack.my.projs.hrs.dao.IDeptDAO;

import com.pack.my.projs.hrs.vo.Dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeptDAOImpl implements IDeptDAO {
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public DeptDAOImpl(Connection conn){
        this.conn = conn;
    }

    @Override
    public boolean doCreate(Dept deptNo) throws Exception {
        boolean flag = false;
        String sql = "INSERT INTO dept(deptno,deptname,loc) VALUES(?,?,?)";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1, deptNo.getDeptNo());
        this.pstmt.setString(2, deptNo.getDeptName());
        this.pstmt.setString(3, deptNo.getLoc());

        if (this.pstmt.executeUpdate() > 0) {
            flag = true;
        }

        this.pstmt.close();
        return flag;
    }

    @Override
    public List<Dept> findAll(String keyWord) throws Exception {
        List<Dept> all = new ArrayList<Dept>();
        String sql = "select deptno,deptname,loc from dept where deptno like ? or deptname like ? or loc like ?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,"%"+keyWord+"%");
        this.pstmt.setString(2,"%"+keyWord+"%");
        this.pstmt.setString(3,"%"+keyWord+"%");
        ResultSet rs = this.pstmt.executeQuery();

        while (rs.next())
        {
            Dept dept = new Dept();
            dept.setDeptNo(rs.getInt(1));
            dept.setDeptName(rs.getString(2));
            dept.setLoc(rs.getString(3));
            all.add(dept);
        }
        this.pstmt.close();
        return all;
    }

    @Override
    public Dept findById(int deptNo) throws Exception {
        Dept dept = null;
        String sql = "select deptno,deptname,loc from dept where deptno = ?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1,deptNo);
        ResultSet rs = this.pstmt.executeQuery();
        if(rs.next()){
            dept = new Dept();
            dept.setDeptNo(deptNo);
            dept.setDeptName(rs.getString(2));
            dept.setLoc(rs.getString(3));
        }

        return  dept;
    }
}
