package com.mindtree.bug.tracker.controller;

import java.security.Principal;
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
import com.mindtree.bug.tracker.exception.ServiceException;
import com.mindtree.bug.tracker.service.GenieService;

/**
 * @author M1035940
 *
 */
@Controller
public class AssociateController {

	/**
	 * static logger instance
	 */
	private static final Logger LOGGER = Logger.getLogger(UserController.class);

	/**
	 * GenieService autowired by spring's dependency injection
	 */
	@Autowired
	private GenieService genieService;

	@RequestMapping(value = "/associate", method = RequestMethod.GET)
	public ModelAndView associatePage(Model model, Principal principal) {
		LOGGER.info("associate logged in");
		String userName = principal.getName();
		ModelAndView modelAndView = new ModelAndView();
		List<Genie> geniesAssigned = null;
		try {
			geniesAssigned = genieService.getAllAssignedGenie(userName);
		} catch (ServiceException serviceException) {
			LOGGER.error("service Exception " + serviceException);
			modelAndView.setViewName("error");
			modelAndView.addObject("errormsg", serviceException);
			return modelAndView;
		}
		System.out.println("list " + geniesAssigned);
		modelAndView.addObject("genieList", geniesAssigned);
		modelAndView.setViewName("associatePage");
		return modelAndView;
	}

	/**
	 * @param slno
	 * @return
	 */
	@RequestMapping("/edit")
	public ModelAndView changeStatus(@RequestParam("slno") String slno) {
		ModelAndView modelAndView = new ModelAndView("associatePage");

		boolean message = false;
		try {
			message = genieService.changeGenieStatus(slno);
			if (message == true)
				modelAndView.addObject("msg", "bug got closed");
		} catch (ServiceException serviceException) {
			LOGGER.error("service Exception " + serviceException);
			modelAndView.setViewName("error");
			modelAndView.addObject("errormsg", serviceException);
			return modelAndView;
		}

		return modelAndView;
	}
}
