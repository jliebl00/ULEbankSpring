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

import es.unileon.ulebank.domain.handler.DNIHandler;
import es.unileon.ulebank.domain.handler.Handler;
import es.unileon.ulebank.domain.handler.OfficeHandler;
import es.unileon.ulebank.service.ChangeOffice;
import es.unileon.ulebank.service.SimpleOfficeManager;

@Controller
@RequestMapping(value="/reallocateEmployee.htm")
public class ReallocateEmployeeFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    private String employeeID; 
    @Autowired
    private SimpleOfficeManager simpleOfficeOperations;

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid ChangeOffice changeOffice, BindingResult result) 
    {
        if (result.hasErrors()) {
            return "reallocateEmployee";
        }
        String officeID = changeOffice.getOfficeID();
        
        Handler officeIDHandler = new OfficeHandler(officeID);
        Handler employeeIDHandler = new DNIHandler(employeeID);
        logger.info("Change "+employeeID+" to the office " + officeID);
        
        simpleOfficeOperations.reallocate(employeeIDHandler.toString(), officeIDHandler.toString());
        
        return "redirect:/showAllEmployees.htm";
    }

    @RequestMapping(method = RequestMethod.GET)
    protected ChangeOffice formBackingObject(HttpServletRequest request) throws ServletException {
    	ChangeOffice changeOffice = new ChangeOffice();
        String officeID = request.getParameter("id2");
        employeeID = request.getParameter("id1");

        changeOffice.setOfficeID(officeID);
        changeOffice.setEmployeeID(employeeID);;
        return changeOffice;
    }

    public void setOfficeOperations(SimpleOfficeManager simpleOfficeOperations) {
        this.simpleOfficeOperations = simpleOfficeOperations;
    }

    public SimpleOfficeManager getOfficeOperations() {
        return simpleOfficeOperations;
    }

}

