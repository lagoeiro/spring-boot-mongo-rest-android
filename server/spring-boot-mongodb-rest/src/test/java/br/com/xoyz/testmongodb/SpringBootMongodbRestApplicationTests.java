package br.com.xoyz.testmongodb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.xoyz.testmongodb.entities.Check;
import br.com.xoyz.testmongodb.repository.CheckRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringBootMongodbRestApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private CheckRepository repository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void findByEuid() {
		Check result = repository.findByEuid("813b190e-09d0-4545-80da-ade4405c8901");
		assertThat(result).isNotNull();
	}

	@Test
	public void shouldQueryEntity() throws Exception {
		mockMvc.perform(get("/check/findByEuid?euid={euid}", "813b190e-09d0-4545-80da-ade4405c8901"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.home").value("-46.5933971 -23.5169625"))
				.andExpect(jsonPath("$.work").value("-46.6576926 -23.5597101"))
				.andExpect(jsonPath("$.deviceModel").value("Motorola Moto X (2nd Gen)"));

	}
	
	
}
