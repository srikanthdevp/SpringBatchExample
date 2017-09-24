package com.spring.batch.api.processor;

import com.spring.batch.api.model.ExamResult;

/**
 * @author BASANTA
 *
 */
public class ItemProcessor implements
		org.springframework.batch.item.ItemProcessor<ExamResult, ExamResult> {

	/**
	 * ItemProcessor is Optional, and called after item read but before item
	 * write. It gives us the opportunity to perform a business logic on each
	 * item. In our case, for example, we will filter out all the items whose
	 * percentage is less than 60. So final result will only have records with
	 * percentage >= 60.
	 */

	@Override
	public ExamResult process(ExamResult result) throws Exception {
		System.out.println("Processing result :" + result);
		/*
		 * Only return results which are more than 60%
		 */
		  if(result.getPercentage() < 60){
	            return null;
	        }
	         
	        return result;

	}
}
