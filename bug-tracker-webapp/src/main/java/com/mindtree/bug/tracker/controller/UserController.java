package com.mindtree.bug.tracker.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.bug.tracker.entity.Genie;
import com.mindtree.bug.tracker.exception.ServiceException;
import com.mindtree.bug.tracker.service.GenieService;

/**
 * @author M1035940
 *
 */
@Controller
public class UserController {

	/**
	 * static logger instance
	 */
	private static final Logger LOGGER = Logger.getLogger(UserController.class);

	/**
	 * GenieService autowired by spring's dependency injection
	 */
	@Autowired
	private GenieService genieService;

	/**
	 * @param genieForm
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = "/addGenie", method = RequestMethod.POST)
	public ModelAndView addGenie(@ModelAttribute Genie genieForm, Principal principal) {

		ModelAndView modelAndView = new ModelAndView("userInfoPage", "genieForm", new Genie());
		boolean message = false;
		try {
			message = genieService.saveGenie(genieForm);
		} catch (ServiceException serviceException) {
			LOGGER.error("service Exception " + serviceException);
			modelAndView.setViewName("error");
			modelAndView.addObject("errormsg", serviceException);
			return modelAndView;
		}
		if (message == true)
			modelAndView.addObject("msg", "data recorded");
		else
			modelAndView.addObject("msg", "cannot raise the request");
		return modelAndView;

	}

	/**
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}
