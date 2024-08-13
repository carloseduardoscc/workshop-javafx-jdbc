package model.services;

import model.entities.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {

    public List<Department> findAll(){
        //MOCK futura conexão com banco de dados
        List<Department> departmentList = new ArrayList<>();
        departmentList.add(new Department(1, "Books"));
        departmentList.add(new Department(2, "Computers"));
        departmentList.add(new Department(2, "Electronics"));
        return departmentList;
    }

}
