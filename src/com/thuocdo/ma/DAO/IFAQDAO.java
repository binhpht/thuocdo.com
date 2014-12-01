package com.thuocdo.ma.DAO;

import java.util.List;

import com.thuocdo.ma.Bean.FAQ;;

public interface IFAQDAO {
	public FAQ saveAndUpdateFAQ(FAQ faq);
	public FAQ deleteFAQ(int faqid);
	public List<FAQ> getFAQList();
	public List<FAQ> getFAQList(boolean active);
	public List<FAQ> getFAQList(String keywords);
	public FAQ getFAQ(int faqid);
}
