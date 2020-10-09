package com.example.SpringBatchRandomFIleWriter.stepImpl.impl;

import com.example.SpringBatchRandomFIleWriter.stepImpl.IDummyProcessor;
import org.springframework.stereotype.Service;

@Service
public class DummyProcessor implements IDummyProcessor<String, String> {
    @Override
    public String process(String items) throws Exception {
        return items.toUpperCase();
    }
}
