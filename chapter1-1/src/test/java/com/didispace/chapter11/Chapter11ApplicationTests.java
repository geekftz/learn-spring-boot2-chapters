package com.didispace.chapter11;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

;

@SpringBootTest
public class Chapter11ApplicationTests {

  private MockMvc mvc;

  //	使用MockServletContext来构建一个空的WebApplicationContext，
//	这样我们创建的HelloController就可以在@Before函数中创建并传递到MockMvcBuilders.standaloneSetup()函数中。
  @Before
  public void setUp() {
    mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
  }

  @Test
  public void getHello() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().string(equalTo("Hello World")));
  }
}


//package com.didispace.chapter11;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.hamcrest.Matchers.equalTo;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@SpringBootTest
//public class Chapter11ApplicationTests {
//
//	private MockMvc mvc;
//
//	@Before
//	public void setUp() {
//		mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
//	}
//
//	@Test
//	public void getHello() throws Exception {
//		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(content().string(equalTo("Hello World")));
//	}
//
//}
