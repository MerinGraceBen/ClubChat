package com.niit.ClubChatBackEnd;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ClubChatBackEnd.Dao.ForumDAO;
import com.niit.ClubChatBackEnd.Models.Blog;
import com.niit.ClubChatBackEnd.Models.Forum;

public class ForumDAOTest 
{
	@Autowired
	public static ForumDAO forumDAO;
	@BeforeClass
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.CLubChatBackEnd");
		context.refresh();
		
		forumDAO=(ForumDAO)context.getBean("forumDao");
	}

	
	@Test
	public void addForumTest()
	{
		Forum forum=new Forum();
		forum.setForumId(2);
		forum.setForumName("Abc");
		forum.setForumContent("qwert");
		forum.setUserId(3);
		forum.setCreatedDate(new Date());
		forum.setStatus("happy");
		assertTrue("Problem in Inserting Forum",forumDAO.addForum(forum));
	}
	
	
	
	@Ignore
	@Test
	public void getforumTest()
	{
		
		
		Forum forum=forumDAO.getForum(1);
		System.out.println(forum.getForumContent());
		System.out.println(forum.getForumName());
	}
	
	
	
	@Ignore
	@Test
	public void updateForumTest()
	{
		Forum forum=forumDAO.getForum(1);
		forum.setForumContent("it is hibernate based");
		forum.setForumName("hibernate core");
		assertTrue("Problem in Updating  Forum",forumDAO.updateForum(forum));
	}
	
	
	
	@Ignore
	@Test
	public void deleteForumTest()
	{
		Forum forum=forumDAO.getForum(1);
		assertTrue("Problem in Updating  Forum",forumDAO.deleteForum(forum));
	}
	
	
	
	@Ignore
	@Test
	public void getAllForumsTest()
	{
		ArrayList<Forum> forum=(ArrayList<Forum>)forumDAO.getAllForums();
		for(Forum f:forum)
		{
			System.out.println(f.getForumName());
		}
	}
	
	
	@Ignore
	@Test
	public void approveForumTest()
	{
		Forum forum=(Forum)forumDAO.getAllForums();
		forum.setStatus("Y");
		assertTrue("Problem in Approving   Forum",forumDAO.approveForum(forum));
		
	}
}
