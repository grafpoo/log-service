package services.log.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import services.log.service.LogService;

/*
create table logs (
  ts DATETIME,
  fn VARCHAR(255),
  log TEXT
);
 */
@RestController
//@RequestMapping("/match")
public class LogController {
	
	public static final String MATCH_URL = "/match/{whatToMatch}";
	
	@Autowired
	LogService logService;
	
//	@RequestMapping(method = RequestMethod.GET, value = "/match/{whatToMatch}")
	@GetMapping(MATCH_URL)
	public List<String> getMatchThing(@PathVariable String whatToMatch) {
		return logService.matches(whatToMatch);
	}

	@PostMapping("/upload")
    public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file) {
		return "STUB";
    }
}
