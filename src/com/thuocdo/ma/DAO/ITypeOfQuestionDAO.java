package com.thuocdo.ma.DAO;

import java.util.List;

import com.thuocdo.ma.Bean.TypeOfQuestion;

public interface ITypeOfQuestionDAO {
	public TypeOfQuestion addTypeOfQuestion(TypeOfQuestion typeofquestion);
	public TypeOfQuestion updateTypeOfQuestion(TypeOfQuestion typeOfQuestion);
	public boolean deleteTypeOfQuestion(int typeOfQuestionID);
	public TypeOfQuestion getTypeOfQuestion(int typeOfQuestionID);
	public List<TypeOfQuestion> getTypeOfQuestion();
}
