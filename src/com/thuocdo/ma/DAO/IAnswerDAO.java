package com.thuocdo.ma.DAO;

import java.util.List;

import com.thuocdo.ma.Bean.Answer;

public interface IAnswerDAO {
	/*
	 * Them mot cau tra loi
	 */
	public Answer addAnswer(Answer answer);
	/*
	 * Cap nhat noi dung cau tra loi
	 */
	public Answer updateAnswer(Answer answer);
	/*
	 * Xoa mot dap an
	 */
	public boolean deleteAnswer(int answerID);
	/*
	 * Lay danh sach cac cau tra loi
	 */
	public List<Answer> getAnswerList();
	/*
	 * Lay danh sach cac cau tra loi ung voi mot cau hoi
	 */
	public List<Answer> getAnswerList(int questionID);
}
