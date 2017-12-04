package com.niit.ClubChatBackEnd.Dao;

import java.util.ArrayList;

import com.niit.ClubChatBackEnd.Models.Job;

public interface JobDAO
{
	public boolean addjob(Job job);
	public boolean updatejob(Job job);
	public boolean deletejob(Job job);
	public Job getjob(int jobId);
	public ArrayList<Job> getAlljobs();

}
