package com.example.SpringBatchRandomFIleWriter.stepImpl;

import org.springframework.batch.item.ItemProcessor;

public interface IDummyProcessor<I, O> extends ItemProcessor<I, O> {

    // This class is created so that, other modules should be able to use this with Implementation, out side this module scope with help of dependency
}
