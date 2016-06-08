package com.mindtree.bug.tracker.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.bug.tracker.entity.Genie;
import com.mindtree.bug.tracker.entity.User;
import com.mindtree.bug.tracker.exception.ServiceException;
import com.mindtree.bug.tracker.service.GenieService;

/**
 * @author M1035940
 *
 */
@Controller
public class AdminController {

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
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminPage(Model model) {
		LOGGER.info("index page entered");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("adminPage");
		List<Genie> genielist = null;
		List<User> associateList = null;
		try {
			genielist = genieService.getAllGenie();
			associateList = genieService.getAllAssociate();
		} catch (ServiceException serviceException) {
			LOGGER.error("service Exception " + serviceException);
			modelAndView.setViewName("error");
			modelAndView.addObject("errormsg", serviceException);
			return modelAndView;
		}
		modelAndView.addObject("genies", genielist);
		modelAndView.addObject("associateList", associateList);
		return modelAndView;
	}

	/**
	 * @param slno
	 * @param associateName
	 * @return
	 */
	@RequestMapping(value = "/assign", method = RequestMethod.GET)
	public ModelAndView assignAssociate(@RequestParam("slno") int slno,
			@RequestParam("associate") String associateName) {
		ModelAndView modelAndView = new ModelAndView("adminPage");

		String message = null;
		List<Genie> genielist = null;
		List<User> associateList = null;
		try {
			message = genieService.assignAssociate(slno, associateName);
			genielist = genieService.getAllGenie();
			associateList = genieService.getAllAssociate();
			if ("success".equals(message))
				modelAndView.addObject("msg", "genie got closed");
			modelAndView.addObject("genies", genielist);
			modelAndView.addObject("associateList", associateList);
		} catch (ServiceException serviceException) {
			LOGGER.error("service Exception " + serviceException);
			modelAndView.setViewName("error");
			modelAndView.addObject("errormsg", serviceException);
			return modelAndView;
		}

		return modelAndView;
	}
}
