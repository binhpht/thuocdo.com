package com.thuocdo.ma.DAO;

import java.util.List;

import com.thuocdo.ma.Bean.Result;

public interface IResultDAO {
	public Result addResult(Result result);
	public Result updateResult(Result result);
	public boolean deleteResult(int resultID);
	public Result getResult(int resultID);
	public List<Result> getResultList(int joinID);
}
