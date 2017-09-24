package com.spring.batch.api.processor;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * @author BASANTA
 *
 */
public class JobListener implements JobExecutionListener {

	private DateTime startTime;
	private DateTime stopTime;

	/**
	 * Job listener is Optional and provide the opportunity to execute some
	 * business logic before job start and after job completed.For example
	 * setting up environment can be done before job and cleanup can be done
	 * after job completed.
	 */
	@Override
	public void afterJob(JobExecution job) {
		startTime = new DateTime();
		System.out.println("ExamResult Job ends at :" + startTime);

	}

	@Override
	public void beforeJob(JobExecution job) {
		stopTime = new DateTime();
		System.out.println("ExamResult Job starts at :" + stopTime);
		if (job.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("ExamResult job completed successfully");
			// Here you can perform some other business logic like cleanup
		} else if (job.getStatus() == BatchStatus.FAILED) {
			System.out
					.println("ExamResult job failed with following exceptions ");
			List<Throwable> exceptionList = job.getAllFailureExceptions();
			for (Throwable th : exceptionList) {
				System.err.println("exception :" + th.getLocalizedMessage());
			}
		}
	}

}
