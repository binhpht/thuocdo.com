package com.thuocdo.ma.Utils;

import org.displaytag.decorator.TableDecorator;

import com.thuocdo.ma.Bean.Answer;
import com.thuocdo.ma.Bean.Question;

public class QuestionDecorator extends TableDecorator {
	public String getLstAnswer(){
		String answers= "";
		int i=0;
		Question question = (Question) getCurrentRowObject();
		for (Answer item : question.getAnswers()) {
			i++;
			answers+= i+"/  <span > "+item.getAnswerContent()+"</span><br><br>";
		}
		return answers;
	}
}
