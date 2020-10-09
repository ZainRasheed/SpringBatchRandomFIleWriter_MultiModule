package com.example.SpringBatchRandomFIleWriter.listners;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Component
public class StepListener extends StepExecutionListenerSupport {
    @Override
    public void beforeStep(StepExecution stepExecution) {
        super.beforeStep(stepExecution);
        //For Multi Module call an interface here
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return super.afterStep(stepExecution);
        //For Multi Module call an interface here
    }
}


/*
* EXAMPLE
*
*
@Component
public class JobCompletionListener extends JobExecutionListenerSupport {

    private final IJobCompletionService jobCompletionService;

    @Autowired
    JobCompletionListener(final IJobCompletionService jobCompletionService) {
        this.jobCompletionService = jobCompletionService;
    }

    @Override
    public void beforeJob(JobExecution jobExecution) {
        jobCompletionService.beforeJob(jobExecution);
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        jobCompletionService.afterJob(jobExecution);
    }

}
*
*
*
*== Call this in different Modules
public interface IJobCompletionService {

    void beforeJob(final JobExecution jobExecution);

    void afterJob(final JobExecution jobExecution);

}
*
*
*
*
* */
