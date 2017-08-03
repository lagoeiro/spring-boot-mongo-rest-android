/**
 * 
 */
package br.com.xoyz.testmongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.xoyz.testmongodb.entities.Check;
import br.com.xoyz.testmongodb.repository.CheckRepository;

/**
 * @author lelag
 *
 */
@RestController
public class CheckController {

	@Autowired
	private CheckRepository repository;
	
	/**
	 * Find a check's collection
	 * @param page Page to be search (Pagination. The first index is 0)
	 * @param size Number of results
	 * @return A Check list
	 */
	@RequestMapping(value = "/check/find",method = RequestMethod.GET)
	public List<Check> find(@RequestParam("page") int page, @RequestParam("size") int size) {			
		return repository.find(page, size);
	}
	
	/**
	 * Update a check with new Latitude and longitude and the venue name 
	 * @param latLng Latitude and longitude
	 * @param venueName Venue name
	 * @param id ID from Check to be updated
	 * @return  The updated Check
	 * 
	 */
	@RequestMapping(value = "/check/checkin",method = RequestMethod.POST)
	public Check checkin(String latLng, String venueName, String id) {
		return repository.checkin(latLng, venueName, id);
	}
	
	/**
	 * Update the Check with a new time for departure and duration
	 * @param id ID from Check
	 * @return The Check updated
	 */
	@RequestMapping(value = "/check/checkout",method = RequestMethod.POST)
	public void checkout(String id) {
		repository.checkout(id);
	}

	/**
	 * Find a Check by euid
	 * @param euid euid to be searched
	 * @return The Check selected
	 */
	@RequestMapping(value = "/check/findByEuid",method = RequestMethod.GET)
	public Check find(@RequestParam("euid") String euid) {			
		return repository.findByEuid(euid);
	}
	
}
