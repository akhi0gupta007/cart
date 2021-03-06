package com.akhi.store.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.apache.log4j.Logger;

import com.akhi.store.dao.ProductDao;
import com.akhi.store.general.Order;
import com.akhi.store.general.Products;
import com.akhi.store.general.User;
import com.akhi.store.service.UserService;
import com.akhi.store.validator.UserValidator;

/**
 * Handles requests for the application home page.
 * 
 * @author akhilesh
 * 
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

	@RequestMapping(value = { "/", "/home/login" }, method = RequestMethod.GET)
	public String home(ModelMap model) {
		log.info("HomeController home");
		User user = new User();
		model.addAttribute("customer", user);
		return "customer";
	}

	@RequestMapping(value = { "/home/logout" }, method = RequestMethod.GET)
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

	@RequestMapping(value = { "/home/catalog" }, method = RequestMethod.GET)
	public String dashboard(ModelMap model,
			@RequestParam(value = "cat", defaultValue = "NAP") String cat) {
		String result = "customer";
		List<Products> products = null;
		if (model.containsKey("customer")) {
			User user = (User) model.get("customer");
			if (user.getUserId() != null) {
				log.warn("Dash board , session is present for " + user);
				result = "success";

				if (cat.equalsIgnoreCase("NAP") || cat == null) {
					products = productDao.getProducts(0, 10);
					if (products != null)
						log.info("Recieved Products Listings without any cat"
								+ products.size());
				} else if (!cat.equalsIgnoreCase("NAP")) {
					products = productDao.getByCat(cat, 0, 10);

					if (products != null)
						log.info("Recieved Products Listings with cat " + cat
								+ " size : " + products.size());
				} else {
					log.error("Can not get product listing :(");
				}

				Map<String, String> cats = productDao.getCats();
				log.info("Recieved Products Cats " + cats);

				if (products != null && products.size() > 0)
					model.put("products", products);
				else
					log.error("Could Not get listing");

				if (cats != null && cats.size() > 0)
					model.put("cats", cats);
				else
					log.error("Could Not get cats");
			}
		}

		return result;
	}

	@RequestMapping(value = { "/home/details/{id}" }, method = RequestMethod.GET)
	public String details(@PathVariable("id") String id, ModelMap model) {
		String result = "customer";
		log.info("details: Details for id " + id);
		if (model.containsKey("customer")) {
			User user = (User) model.get("customer");
			if (user.getUserId() != null) {
				log.warn("details: , session is present for " + user);
				result = "details";
				Products product = productDao.getById(id);
				log.info("Recieved Products Listings " + product);

				Map<String, String> cats = productDao.getCats();

				if (cats != null && cats.size() > 0)
					model.put("cats", cats);
				else
					log.error("Could Not get cats");

				if (product != null)
					model.put("products", product);
				else
					log.error("Could Not get listing");
			}
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/home/remoteCart/{id}" })
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
	@RequestMapping(value = { "/home/cartHelper" }, method = RequestMethod.GET)
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

	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/home/updateQuantity/{id}" }, method = RequestMethod.POST)
	public @ResponseBody
	List<String> updateQuantity(@PathVariable("id") String id,
			@RequestParam(value = "quan", defaultValue = "1") String quan,
			ModelMap model) {

		log.info("updateQuantity, id = " + id + " quan " + quan);
		List<String> parent = new ArrayList<String>();

		if (model.containsKey("customer") && model.containsKey("cart")) {
			User user = (User) model.get("customer");
			Map<String, Integer> cart = (Map<String, Integer>) model
					.get("cart");

			if (user.getUserId() != null && cart.size() > 0 && there(cart, id)) {
				log.warn("cartHelper, session is present for " + user
						+ " and cart is " + cart);

				cart.put(id, Integer.parseInt(quan));
				model.remove("cart");
				model.addAttribute("cart", cart);
				log.info("updateQuantity: Now the cart becomes" + cart);
				parent.add("true");

			} else {
				parent.add("false");
			}
		}
		log.info("updateQuantity , parent " + parent);
		return parent;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/home/delete/{id}" }, method = RequestMethod.POST)
	public @ResponseBody
	List<String> delete(@PathVariable("id") String id, ModelMap model) {

		log.info("delete from cart, id = " + id);
		List<String> parent = new ArrayList<String>();

		if (model.containsKey("customer") && model.containsKey("cart")) {
			User user = (User) model.get("customer");
			Map<String, Integer> cart = (Map<String, Integer>) model
					.get("cart");

			if (user.getUserId() != null && cart.size() > 0 && there(cart, id)) {
				log.warn("cartHelper, session is present for " + user
						+ " and cart is " + cart);

				cart.remove(id);
				model.remove("cart");
				model.addAttribute("cart", cart);
				log.info("updateQuantity: Now the cart becomes" + cart);
				parent.add("true");

			} else {
				parent.add("false");
			}
		}
		log.info("updateQuantity , parent " + parent);
		return parent;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/home/review" }, method = RequestMethod.POST)
	public String review(ModelMap model) {
		String result = "customer";

		if (model.containsKey("customer") && model.containsKey("cart")) {
			User user = (User) model.get("customer");
			Map<String, Integer> cart = (Map<String, Integer>) model
					.get("cart");

			if (user.getUserId() != null && cart.size() > 0) {
				log.warn("cartHelper, session is present for " + user
						+ " and cart is " + cart);
				Order order = makeOrder(cart);
				log.info("Order success : " + order);
				model.addAttribute("order", order);
				result = "review";

			} else {
				log.error("Could not prepare order:(");
			}

			Map<String, String> cats = productDao.getCats();

			if (cats != null && cats.size() > 0)
				model.put("cats", cats);
			else
				log.error("Could Not get cats");

		}

		return result;
	}

	private Order makeOrder(Map<String, Integer> set) {
		Map<Products, TreeSet<Double>> bag = new HashMap<Products, TreeSet<Double>>();
		double gross_total = 0;
		for (String x : set.keySet()) {
			Products product = productDao.getById(x);
			if (product == null)
				continue;
			Integer quan = set.get(x);
			Double total = quan * product.getPrice();
			TreeSet<Double> value = new TreeSet<Double>();
			value.add(new Double(quan));
			value.add(total);
			bag.put(product, value);
			gross_total = gross_total + total;
		}
		Order order = new Order(bag, gross_total);
		return order;
	}

	public static boolean there(Map<String, Integer> set, Object obj) {
		for (String x : set.keySet()) {
			if (x.toString().equals(obj.toString())) {
				return true;

			}
		}
		return false;
	}

	public UserValidator getValidator() {
		return validator;
	}

	public void setValidator(UserValidator validator) {
		this.validator = validator;
	}

}