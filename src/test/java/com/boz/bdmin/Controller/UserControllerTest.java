package com.boz.bdmin.Controller;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 控制器的单元测试
 * @author boz
 * @date 2019/6/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//测试环境使用，用来表示测试环境使用的ApplicationContext将是WebApplicationContext类型的
@WebAppConfiguration
public class UserControllerTest {

    private final Logger logger = LoggerFactory.getLogger(UserControllerTest.class);

//
//    @Autowired
//    private TestUserController testUserController;
//
//    private MockMvc mockMvc;
//
//    @Before
//    public void setup(){
//        mockMvc = MockMvcBuilders.standaloneSetup(testUserController).build();
//    }
//
//
//    //无参数控制器请求
//    @Test
//    public void demo() throws Exception {
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/TestUser/getUserAll")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
//        logger.info(mvcResult.getResponse().getContentAsString());
//    }
//
//
//    //有参控制器请求（GET）
//    @Test
//    public void testControllerByGet() throws Exception {
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/TestUser/getUserById?id=1")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
//        logger.info(mvcResult.getResponse().getContentAsString());
//    }
//
//
//
//    //有参控制器的请求（POST）
//    @Test
//    public void testControllerByPost() throws Exception {
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/TestUser/getUserByIdPost")
//                .accept(MediaType.APPLICATION_JSON).param("id","1"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
//        logger.info(mvcResult.getResponse().getContentAsString());
//    }



}
