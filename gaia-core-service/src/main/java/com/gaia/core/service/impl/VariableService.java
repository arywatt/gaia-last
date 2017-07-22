package com.gaia.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gaia.core.dao.IVariableDAO;
import com.gaia.core.entities.Variable;
import com.gaia.core.service.IVariableService;
import com.gaia.entity.service.impl.CRUDService;

/**
 *
 * @author komilo
 */
@Service("variableService")
public class VariableService extends CRUDService<Variable, String> implements IVariableService {

//    @Autowired
//    private ISemesterService semesterService;

    @Autowired(required = true)
    public VariableService(IVariableDAO dao) {
        super(dao);
    }

    private IVariableDAO getDAO() {
        return (IVariableDAO) dao;
    }

    @Override
    public String getValue(String name) {
        return this.getDAO().getValue(name);
    }

//    public Semester getActiveSemester() {        
//        return semesterService.getOne(Long.parseLong(this.getDAO().getValue("active_semester")));
//    }
}
