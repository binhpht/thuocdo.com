package com.thuocdo.ma.DAO;

import java.util.List;

import com.thuocdo.ma.Bean.Job;

public interface IJobDAO {
	public Job saveAndUpdateJob(Job job);
	public Job deleteJob(int jobID);
	public List<Job> getJobList();
	public List<Job> getJobList(String keywords);
	public Job getJob(int jobID);
}
