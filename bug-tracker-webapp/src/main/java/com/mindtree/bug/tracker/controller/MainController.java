package com.mindtree.bug.tracker.controller;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindtree.bug.tracker.entity.Genie;

/**
 * @author M1035940
 *
 */
@Controller
public class MainController {

	/**
	 * static logger instance
	 */
	private static final Logger LOGGER = Logger.getLogger(MainController.class);

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		LOGGER.info("index page entered");
		model.addAttribute("title", "Welcome");
		model.addAttribute("message", "This is welcome page!");
		return "welcomePage";
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {
		return "loginPage";
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		model.addAttribute("title", "Logout");
		return "logoutSuccessfulPage";
	}

	/**
	 * @param model
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String userInfo(Model model, Principal principal) {
		model.addAttribute("genieForm", new Genie());
		return "userInfoPage";
	}

	/**
	 * @param model
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			model.addAttribute("message",
					"Hi " + principal.getName() + "<br> You do not have permission to access this page!");
		} else {
			model.addAttribute("msg", "You do not have permission to access this page!");
		}
		return "403Page";
	}

}
