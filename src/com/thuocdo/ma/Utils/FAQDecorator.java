package com.thuocdo.ma.Utils;

import org.displaytag.decorator.TableDecorator;

import com.thuocdo.ma.Bean.FAQ;

public class FAQDecorator extends TableDecorator {

	public String getActive() {
		FAQ faq = (FAQ) getCurrentRowObject();
		if (faq.getIsActive() == true)
			return "Active";
		else
			return "Non-active";
	}
}
