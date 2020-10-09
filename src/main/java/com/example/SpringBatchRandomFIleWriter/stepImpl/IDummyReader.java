package com.example.SpringBatchRandomFIleWriter.stepImpl;

import org.springframework.batch.item.ItemReader;

public interface IDummyReader<I> extends ItemReader<I> {

    // This class is created so that, other modules should be able to use this with Implementation, out side this module scope with help of dependency
}
