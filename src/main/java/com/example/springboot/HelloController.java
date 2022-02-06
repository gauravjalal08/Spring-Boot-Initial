package com.example.springboot;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/weather/{city}/{noOfDays}")
	public String index(@PathVariable("city") String city, @PathVariable("noOfDays") Integer noOfDays) {
		try {
			HttpResponse<String> response = Unirest.get("https://weatherapi-com.p.rapidapi.com/forecast.json?q=" +city + "&days=" + noOfDays)
					.header("x-rapidapi-host", "weatherapi-com.p.rapidapi.com")
					.header("x-rapidapi-key", "f9b8f2034cmshb80b214ebe70b8bp1f83bdjsnc65527c6673b")
					.asString();
			return response.getBody();
		} catch (UnirestException e) {
			return e.getMessage();
		}
	}

	@GetMapping("/Translate/{text}/{language}")
	public String index(@PathVariable("text")  String text, @PathVariable("language") String language) throws UnirestException {
		HttpResponse<String> response = Unirest.post("https://google-translate1.p.rapidapi.com/language/translate/v2/")
				.header("content-type", "application/x-www-form-urlencoded")
				.header("accept-encoding", "application/gzip")
				.header("x-rapidapi-host", "google-translate1.p.rapidapi.com")
				.header("x-rapidapi-key", "8a031773d4msh0e99fafaed4a3d9p12673ajsncaffcbd7c6cb")
				.body("q=" + text + "&target=" + language + "&source=en")
				.asString();
		return response.getBody();
		}
		}






