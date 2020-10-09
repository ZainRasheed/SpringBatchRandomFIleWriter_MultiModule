package com.example.SpringBatchRandomFIleWriter;

import com.example.SpringBatchRandomFIleWriter.listners.JobListener;
import com.example.SpringBatchRandomFIleWriter.listners.StepListener;
import com.example.SpringBatchRandomFIleWriter.stepImpl.impl.DummyProcessor;
import com.example.SpringBatchRandomFIleWriter.stepImpl.impl.DummyReader;
import com.example.SpringBatchRandomFIleWriter.stepImpl.impl.DummyWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileWritterJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private DummyProcessor processor;

    @Autowired
    private DummyReader reader;

    @Autowired
    private DummyWriter writer;

    @Autowired
    private JobListener jobListener;

    @Autowired
    private StepListener stepListener;

    @Bean
    public Job jobForRandomFileWrite(){
      return jobBuilderFactory
              .get("job for random file")
              .incrementer(new RunIdIncrementer())
              .listener(jobListener)
              .flow(stepForJob())
              .end()
              .build();
    }

//    @Bean
    private Step stepForJob(){
        return stepBuilderFactory
                .get("Step for Job")
//                .chunk(5)
                .<String, String>chunk(1)
                .reader(reader)
                .writer(writer)
                .processor(processor)
                .listener(stepListener)
                .build();
    }
}
