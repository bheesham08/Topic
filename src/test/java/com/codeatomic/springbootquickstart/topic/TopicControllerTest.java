package com.codeatomic.springbootquickstart.topic;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TopicControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    TopicController topicController;

    @Mock
    TopicService topicService;

    Topic t1=new Topic("dummyId","dummyName","dummyDesc");
    Topic t2=new Topic("dummyId","dummyName","dummyDesc");

    List<Topic> topics=new ArrayList<Topic>(Arrays.asList(new Topic("dummyId","dummyName","dummyDesc")));

    @Test
    public void getTopicTest()
    {
        when(topicService.getTopic("dummyId")).thenReturn(t1);
        Topic t=topicController.getTopic("dummyId");
        Assert.assertEquals(t.getName(),t1.getName());
        Assert.assertEquals(t.getDescription(),t1.getDescription());
    }

    @Test
    public void getAllTopicsTest()
    {
        when(topicService.getAllTopics()).thenReturn(topics);
        Assert.assertEquals(topics.get(0).getId(),topicController.getAllTopics().get(0).getId());
        Assert.assertEquals(topics.get(0).getName(),topicController.getAllTopics().get(0).getName());
        Assert.assertEquals(topics.get(0).getDescription(),topicController.getAllTopics().get(0).getDescription());
    }

    @Test
    public void addTopicTest() throws Exception {
       String res=topicController.addTopic(t1);
       Mockito.verify(topicService).addTopic(t1);
       Assert.assertNotNull(res);
    }

    @Test
    public void updateTopicTest()
    {
        String res=topicController.updateTopic(t2,t1.getId());
        Mockito.verify(topicService).updateTopic(t1.getId(),t2);
        Assert.assertNotNull(res);
    }

    @Test
    public void deleteTopicTest()
    {
        //when(topicService.addTopic(any(Topic.class))).thenReturn()
        String res=topicController.deleteTopic(t1.getId());
        Mockito.verify(topicService).deleteTopic(t1.getId());
        Assert.assertNotNull(res);
    }

}
