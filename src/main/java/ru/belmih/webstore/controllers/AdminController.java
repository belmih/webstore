package ru.belmih.webstore.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	AdminController(DataSource dataSource){
		logger.debug("In AdminController(DataSource dataSource)");
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@RequestMapping
	public String root() {
		return "admin";
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "add";
	}
	
	
	/*
	@RequestMapping(method = RequestMethod.POST)
    public String add(@Valid AppointmentForm appointment, BindingResult result) {
        if (result.hasErrors()) {
            return "appointments/new";
        }
        appointmentBook.addAppointment(appointment);
        return "redirect:/appointments";
    }
	*/
	/*
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

    
	@RequestMapping(value = "/test/", method = RequestMethod.GET)
	public String base() {
		logger.info("In base();");
		//jdbcTemplate.execute("CREATE TABLE customers1(id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
		return "base";
	}
	*/
	
}
