package hu.bme.msc.onlab.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController extends BaseController{
	
	@RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
	public String getUsersView() {
		final String view;
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) {
			LOGGER.info("Forwarding to the dashboard");
			view = new String("forward:/dashboard");
		} else {
			LOGGER.info("Generating welcome page");
			view = new String("/welcome");
		}
		return view;
	}
}