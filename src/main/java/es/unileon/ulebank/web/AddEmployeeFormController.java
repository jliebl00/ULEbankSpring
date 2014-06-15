package es.unileon.ulebank.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.unileon.ulebank.domain.employee.Employee;
import es.unileon.ulebank.domain.exceptions.OfficeNotFoundException;
import es.unileon.ulebank.service.AddEmployee;
import es.unileon.ulebank.service.OfficeManager;

@Controller
@RequestMapping(value="/addemployee.htm")
public class AddEmployeeFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private OfficeManager officeManager;

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid AddEmployee addEmployee, BindingResult result) throws OfficeNotFoundException
    {
        if (result.hasErrors()) {
            return "addemployee";
        }
		
        String name = addEmployee.getName();
        String surname = addEmployee.getSurname();
        String address = addEmployee.getSurname();
        float salary = addEmployee.getSalary();
        String employeeID = addEmployee.getEmployeeID();
        String officeID = addEmployee.getOfficeID();
        Employee employee = new Employee(name, surname, address, salary, officeID, employeeID);
        officeManager.addEmployee(employee);
        logger.info("Adding employee " + employeeID + ".");
        
        return "redirect:/startpage.htm";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    protected AddEmployee formBackingObject(HttpServletRequest request) throws ServletException {
    	AddEmployee addEmployee = new AddEmployee();
        return addEmployee;
    }

    public void setProductManager(OfficeManager officeManager) {
        this.officeManager = officeManager;
    }

    public OfficeManager getProductManager() {
        return officeManager;
    }

}