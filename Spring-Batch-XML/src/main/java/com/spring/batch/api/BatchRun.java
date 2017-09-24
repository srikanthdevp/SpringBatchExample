package com.spring.batch.api;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BatchRun 
{ 
	
	@SuppressWarnings("resource")
	public static void main(String[] args){
    
		/*Note: Pass the id here which you mentioned in your configuration file else it will not work*/
   ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-batch.xml");
    
   JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
   Job job = (Job) context.getBean("examResultJob");
 
   try {
       JobExecution execution = jobLauncher.run(job, new JobParameters());
       System.out.println("Job Exit Status : "+ execution.getStatus());
 
   } catch (JobExecutionException e) {
       System.out.println("Job ExamResult failed");
       e.printStackTrace();
   }
}
}
