/**
 * 
 */
package br.com.xoyz.testmongodb.repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import br.com.xoyz.testmongodb.entities.Check;

/**
 * @author lelag
 *
 */
@Repository
public class CheckRepository {

	 
	@Autowired
	private MongoTemplate mongoTemplate;

	/**
	 * Find a check's collection
	 * @param page Page to be search (Pagination. The first index is 0)
	 * @param size Number of results
	 * @return A Check list
	 */
	public List<Check> find(int page, int size) {
		Pageable pagination = new PageRequest(page, size);
		Query query = new Query();
		query.with(pagination);
		return mongoTemplate.find(query, Check.class);

	}

	/**
	 * Update a check with new Latitude and longitude and the venue name 
	 * @param latLng Latitude and longitude
	 * @param venueName Venue name
	 * @param id ID from Check to be updated
	 * @return  The updated Check
	 * 
	 */
	public Check checkin(String latLng, String venueName, String id) {
		Update update = new Update();
		update.set("venueName", venueName);
		update.set("venueLngLat", latLng);
		DateFormat format = new SimpleDateFormat("dd/MM/YYY HH:mm:ss");
		Date now = new Date();
		update.set("arrival", format.format(now));
		mongoTemplate.updateFirst(new Query(Criteria.where("_id").is(id)), update, "check");
		Check check =mongoTemplate.findOne(new Query(Criteria.where("_id").is(id)), Check.class);
		return check;
		

	}

	/**
	 * Update the Check with a new time for departure and duration
	 * @param id ID from Check
	 * @return The Check updated
	 */
	public Check checkout(String id) {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");		
		Check check = mongoTemplate.findOne(new Query(Criteria.where("_id").is(id)), Check.class);

		try {
			Date now = new Date();
			Date arrival = format.parse(check.getArrival());
			long duration = now.getTime() - arrival.getTime();
			long minutes = TimeUnit.MILLISECONDS.toMinutes(duration);

			Update update = new Update();
			update.set("departure", format.format(now));
			update.set("venueTotalTime", minutes);

			mongoTemplate.updateFirst(new Query(Criteria.where("_id").is(id)), update, "check");
			check = mongoTemplate.findOne(new Query(Criteria.where("_id").is(id)), Check.class);

		} catch (ParseException e) {			
			e.printStackTrace();
		}
		
		return check;
	}

	/** 
	 * Find the venues names registered in MongoDB
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<String> findVenuesNames() {
		return mongoTemplate.getCollection("check").distinct("venueName");
	}

	/**
	 * Find a Check by euid
	 * @param euid euid to be searched
	 * @return The Check selected
	 */
	public Check findByEuid(String euid) {
		return mongoTemplate.findOne(new Query(Criteria.where("euid").is(euid)), Check.class);
	}

}
