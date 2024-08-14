package model.services;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {

    DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

    public List<Department> findAll(){
        return departmentDao.findAll();
    }

}
