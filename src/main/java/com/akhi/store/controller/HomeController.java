package com.akhi.store.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.apache.log4j.Logger;

import com.akhi.store.dao.ProductDao;
import com.akhi.store.general.Products;
import com.akhi.store.general.User;
import com.akhi.store.service.UserService;
import com.akhi.store.validator.UserValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = { "/", "/home" })
@SessionAttributes(value = { "customer", "cart" })
public class HomeController {

	private static org.apache.log4j.Logger log = Logger
			.getLogger(HomeController.class);

	@Autowired(required = true)
	@Qualifier("daopowered")
	private UserService service;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private UserValidator validator;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(ModelMap model) {
		log.info("HomeController home");
		User user = new User();
		model.addAttribute("customer", user);
		return "customer";
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logout(ModelMap model) {
		log.info("logout");

		model.clear();
		log.warn("removed key");

		return "redirect:/";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processLogin(@ModelAttribute("customer") User user,
			BindingResult result, SessionStatus status, ModelMap model) {
		log.info("Process Login " + user);
		validator.validate(user, result);

		if (result.hasErrors()) {
			return "customer";
		} else {
			log.info("Before Service" + user);
			user = service.autheticate(user.getUserId(), user.getPassword());

			if (user != null) {
				model.addAttribute("customer", user);
				Map<String, Integer> map = new HashMap<String, Integer>();
				model.addAttribute("cart", map);
				log.warn("<<<<<<<<<<<Redirecting to home page, Login process complete>>>>>>>>>>>>>>");
				return "redirect:/home/catalog";
			} else {
				model.addAttribute("error", "Wrong username or password");
				return "customer";
			}
		}

	}

	@RequestMapping(value = { "/catalog" }, method = RequestMethod.GET)
	public String dashboard(ModelMap model) {
		String result = "customer";
		if (model.containsKey("customer")) {
			User user = (User) model.get("customer");
			if (user.getUserId() != null) {
				log.warn("Dash board , session is present for " + user);
				result = "success";
				List<Products> products = productDao.getProducts(0, 5);
				log.info("Recieved Products Listings " + products.size());

				if (products != null && products.size() > 0)
					model.put("products", products);
				else
					log.error("Could Not get listing");
			}
		}

		return result;
	}

	@RequestMapping(value = { "/details/{id}" }, method = RequestMethod.GET)
	public String details(@PathVariable("id") String id, ModelMap model) {
		String result = "customer";
		log.info("details: Details for id " + id);
		if (model.containsKey("customer")) {
			User user = (User) model.get("customer");
			if (user.getUserId() != null) {
				log.warn("details: , session is present for " + user);
				result = "details";
				List<Products> products = productDao.getProducts(0, 5);
				log.info("Recieved Products Listings " + products.size());

				if (products != null && products.size() > 0)
					model.put("products", products);
				else
					log.error("Could Not get listing");
			}
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/remoteCart/{id}" })
	public String remoteCart(@PathVariable("id") String id, ModelMap model) {
		log.info("remoteCart for id " + id);
		if (model.containsKey("customer") && model.containsKey("cart")) {
			User user = (User) model.get("customer");
			Map<String, Integer> cart = (Map<String, Integer>) model
					.get("cart");
			if (user.getUserId() != null) {

				log.warn("remoteCart, session is present for " + user
						+ " and cart is " + cart);
				cart.put(id, 1);
				log.warn("remoteCart, cart updated " + user
						+ " and now cart is " + cart);
			}
		} else {
			log.error("remoteCart: Keys are missing for remoteCart: customer > "
					+ model.containsKey("customer")
					+ " and cart"
					+ model.containsKey("cart"));
		}
		String url = "redirect:/home/details/" + id;
		log.warn("RemoteCart: Redirect to " + url);
		return url;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/cartHelper" }, method = RequestMethod.GET)
	public @ResponseBody
	List<List<String>> cartHelper(ModelMap model) {

		List<List<String>> parent = new ArrayList<List<String>>();

		if (model.containsKey("customer") && model.containsKey("cart")) {
			User user = (User) model.get("customer");
			Map<String, Integer> cart = (Map<String, Integer>) model
					.get("cart");

			if (user.getUserId() != null && cart.size() > 0) {
				log.warn("cartHelper, session is present for " + user
						+ " and cart is " + cart);

				for (String key : cart.keySet()) {
					List<String> list = new ArrayList<String>();
					Products product = productDao.getById(key);
					log.info("Carthelpper, product is " + product);
					if (product != null) {
						list.add(product.getProduct_code());
						list.add(product.getProduct_name());
						list.add(product.getImage());
						list.add(product.getDescription());
						list.add(String.valueOf(product.getPrice()));
						list.add(String.valueOf(cart.get(key)));
						Double total = product.getPrice() * cart.get(key);
						list.add(String.valueOf(total));
						parent.add(list);
					}
				}

			}
		}
		log.info("CartHelper , parent " + parent);
		return parent;
	}

	public UserValidator getValidator() {
		return validator;
	}

	public void setValidator(UserValidator validator) {
		this.validator = validator;
	}

}