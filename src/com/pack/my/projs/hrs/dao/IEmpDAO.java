package com.pack.my.projs.hrs.dao;

import com.pack.my.projs.hrs.vo.Emp;

import java.util.List;

public interface IEmpDAO {
    public boolean doCreate(Emp emp) throws Exception;
    public List<Emp> findAll(String keyWord) throws Exception;
    public Emp findById(int empno) throws Exception;
}
