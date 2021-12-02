package de.whohm.spring.rest01;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("airport")
public class DemoController {

	Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@RequestMapping(path = "/alive", method = RequestMethod.GET)
	public String alive() {
		return "alive " + LocalDateTime.now();
	}

	@RequestMapping(path = "/data", method = RequestMethod.POST)
	public String alive(@RequestBody String jsonString) {
		ObjectMapper mapper = new ObjectMapper();
		Airport airport = new Airport();
		try {
			airport = mapper.readValue(jsonString, Airport.class);
		} catch (Exception e) {
			logger.error("Error while processing json: ", e);
			throw new RuntimeException(e);
		}
		
		return airport.toString();
	}
}
