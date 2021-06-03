package com.codeatomic.springbootquickstart.topic;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TopicServiceTest {

    @InjectMocks
    TopicService topicService;

    @Mock
    TopicRepository topicRepository;

    List<Topic> topics=new ArrayList<Topic>(Arrays.asList(new Topic("dummyId","dummyName","dummyDesc")));

    Topic t1=new Topic("dummyId","dummyName","dummyDesc");
    Topic t2=new Topic("dummyId2","dummyName2","dummyDesc2");

    @Test
    public void getAllTopicsTest()
    {
        when(topicRepository.findAll()).thenReturn(topics);
        Assert.assertEquals(topics.get(0).getId(),topicService.getAllTopics().get(0).getId());
        Assert.assertEquals(topics.get(0).getName(),topicService.getAllTopics().get(0).getName());
        Assert.assertEquals(topics.get(0).getDescription(),topicService.getAllTopics().get(0).getDescription());
    }

    @Test
    public void getTopicTest()
    {
        when(topicRepository.findOne("dummyId")).thenReturn(t1);
        Topic t=topicService.getTopic("dummyId");
        Assert.assertEquals(t.getName(),t1.getName());
        Assert.assertEquals(t.getDescription(),t1.getDescription());
    }

    @Test
    public void addTopicTest()
    {
        topicService.addTopic(t1);
        Mockito.verify(topicRepository).save(any(Topic.class));
    }

    @Test
    public void updateTopicTest()
    {
        topicService.updateTopic(t1.getId(),t2);
        Mockito.verify(topicRepository).save(t2);
    }

    @Test
    public void deleteTopicTest()
    {
        topicService.deleteTopic(t1.getId());
        Mockito.verify(topicRepository).delete(t1.getId());
    }
}
