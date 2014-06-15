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

import es.unileon.ulebank.domain.office.Office;
import es.unileon.ulebank.service.AddOffice;
import es.unileon.ulebank.service.SimpleOfficeManager;


@Controller
@RequestMapping(value="/addoffice.htm")
public class AddOfficeController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private SimpleOfficeManager officeManager;
    private Office newOffice;

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid AddOffice addOffice, BindingResult result)
    {
      
    	
    	if (result.hasErrors()) {
            return "addoffice";
        }
    	
        String officeID = addOffice.getOfficeID();
        String bankID = addOffice.getBankID();
        String address = addOffice.getAddress();
        double balance = addOffice.getBalance();
        double localCost = addOffice.getLocalCost();
        double utilitiesCost = addOffice.getUtilitiesCost();
        double employeeCost = addOffice.getEmployeeCost();
        String city = addOffice.getCity();
        String postCode = addOffice.getPostCode();
        String telephone = addOffice.getTelephone();
        
        newOffice = new Office(officeID, bankID, address, balance, localCost, utilitiesCost, employeeCost, city, postCode, telephone);
        officeManager.addOffice(newOffice);
        return "redirect:/startpage.htm";
    }
    @RequestMapping(method = RequestMethod.GET)
    protected AddOffice formBackingObject(HttpServletRequest request) throws ServletException {
        AddOffice addOffice = new AddOffice();
        return addOffice;
    }

   

  
}