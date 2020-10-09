package com.example.SpringBatchRandomFIleWriter.stepImpl.impl;

import com.example.SpringBatchRandomFIleWriter.stepImpl.IDummyReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DummyReader implements IDummyReader<String> {

    private String[] input = {"First One", "Second one", "Header"};

    private int i = 0;
    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        while (i < input.length){
            String out = input[i];
            i++;
            return out;
        }
        return null;
    }
}
