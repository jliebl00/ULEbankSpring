package es.unileon.ulebank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.unileon.ulebank.service.AddressChange;
import es.unileon.ulebank.service.OfficeManager;

@Controller
@RequestMapping(value="/addressChange.htm")
public class AddressChangeFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private OfficeManager productManager;

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid AddressChange addressChange, BindingResult result)
    {
        if (result.hasErrors()) {
            return "adressChange";
        }
		
        String address = addressChange.getAddress();
        logger.info("Address changed to  " + address);

        productManager.addressChange(address);

        return "redirect:/index.htm";
    }

    @RequestMapping(method = RequestMethod.GET)
    protected AddressChange formBackingObject(HttpServletRequest request) throws ServletException {
        AddressChange addressChange = new AddressChange();
        
        return addressChange;
    }

    public void setOfficeManager(OfficeManager productManager) {
        this.productManager = productManager;
    }

    public OfficeManager getOfficeManager() {
        return productManager;
    }

}