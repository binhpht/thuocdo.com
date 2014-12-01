package com.thuocdo.ma.Utils;

import org.displaytag.decorator.TableDecorator;


import com.thuocdo.ma.Bean.Survey;

public class SurveyDecorator extends TableDecorator {

	public String getActive() {
		Survey survey = (Survey) getCurrentRowObject();
		if (survey.getIsActive())
			return "Active";
		else
			return "Non-active";
	}

	public String getIllegal() {
		Survey survey = (Survey) getCurrentRowObject();
		if (survey.getIsIllegal())
			return "Illegal";
		else
			return "Legal";
	}
	
}
