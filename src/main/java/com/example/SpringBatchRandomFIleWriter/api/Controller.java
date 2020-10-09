package com.example.SpringBatchRandomFIleWriter.api;


import com.example.SpringBatchRandomFIleWriter.FileWritterJobConfig;
import com.sun.deploy.xml.CustomParser;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.UUID;

/**
 * Check the CORE got get the elaborated version of Multi Module Controller
 *
 */

@RestController
public class Controller {

    @Autowired
    public JobLauncher jobLauncher;

    /**
     * For Single Job
     */
    /*@Autowired
    private Job job;*/

    /**
     * For Multiple Jobs
     */
    @Autowired
    private FileWritterJobConfig fileWritterJobConfig;

    @GetMapping("/GetIt")
    public BatchStatus RunJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        JobParameters param = new JobParametersBuilder()
                .addString("UserDefinedId", String.valueOf(Math.random()))
                .addParameter("UserDefinedKeyName_LikeStepParam", new CustomJobParameter("DummySingleParameter"))
                .toJobParameters();
        JobExecution jobExecution;
        jobExecution = jobLauncher.run(fileWritterJobConfig.jobForRandomFileWrite(), param);

        return jobExecution.getStatus();
    }
}

/**
 * to add our parameters... which are accessable within a JOB, like stepParams, or ScheduleInfo.
 * @param <T>
 */
class CustomJobParameter<T extends Serializable> extends JobParameter {

    private T customParam;

    public CustomJobParameter(T customParam) {
        super(UUID.randomUUID().toString());
        this.customParam=customParam;
    }

    @Override
    public T getValue() {
        return customParam;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}