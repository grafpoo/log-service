package services.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.*;

import services.log.controller.LogController;
import services.log.service.LogService;

@RunWith(SpringRunner.class)
@WebMvcTest(LogController.class)
public class LogControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private LogService logService;

	@Test
	public void testMatch() throws Exception {
		String testString = "CHOWDER!";
		
		given(logService.matches(testString)).willReturn(gimmeAList("tess "+testString));
		
		mvc.perform(get(LogController.MATCH_URL, testString).accept(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(status().isOk()).andExpect(content().json("[\"tess CHOWDER!\"]"));
		
		verify(logService, times(1)).matches(testString);
	}
	
	List<String> gimmeAList(String ... strings) {
		List<String> list = new ArrayList<String>();
		for (String string : strings) {
			list.add(string);
		}
		return list;
	}
}
