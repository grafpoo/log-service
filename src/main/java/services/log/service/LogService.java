package services.log.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import services.log.MatchThing;

@Service
public class LogService {
	
	private static final String INSERT_SQL =
			"INSERT INTO logs VALUES (?,?,?)";

	@Autowired
	JdbcTemplate template;

	public List<String> matches(final String whatToMatch) {
		MatchThing mt = new MatchThing();
		mt.addMatch("tess "+whatToMatch);
		return mt.asList();
	}
	
	public String uploadLog(final String fileName, final String fileContent) {
        if (fileContent.length() > 0) {
            try {
                template.update(INSERT_SQL, new Object[] {new Date(), fileName, fileContent});
                return "success";
            } catch (Exception e) {
                return "You failed to upload " + fileName + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + fileName + " because the file was empty.";
        }
	}

}
