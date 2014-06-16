package es.unileon.ulebank.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebank.service.SimpleOfficeManager;

@Controller
public class EmployeeController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private SimpleOfficeManager officeManager;

    @RequestMapping(value="/showAllEmployees.htm")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("Returning showAllEmployees view");

        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("allEmployees", this.officeManager.getAllEmployees());

        return new ModelAndView("showAllEmployees", "model", myModel);
    }


    public void setEmployeeManager(SimpleOfficeManager officeManager) {
        this.officeManager = officeManager;
    }
}