package com.pack.my.projs.hrs.dao;

import com.pack.my.projs.hrs.vo.Dept;
import java.util.*;

public interface IDeptDAO {
    public boolean doCreate(Dept deptno) throws Exception;
    public List<Dept> findAll(String keyWord) throws Exception;
    public Dept findById(int deptno) throws Exception;
}
