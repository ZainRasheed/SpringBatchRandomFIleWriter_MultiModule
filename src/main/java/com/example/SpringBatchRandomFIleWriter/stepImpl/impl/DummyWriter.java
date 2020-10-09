package com.example.SpringBatchRandomFIleWriter.stepImpl.impl;

import com.example.SpringBatchRandomFIleWriter.stepImpl.IDummyWriter;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

@Service
public class DummyWriter implements IDummyWriter<String> {

    @Override
    public void write(List<? extends String> items) throws IOException {
        System.out.println("=====");
        System.out.println(items);
        System.out.println("=====");
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File("src/main/resources/OutputFile.txt"), "rwd");
        long pos = items.contains("HEADER")? 0 : randomAccessFile.length();
        randomAccessFile.seek(pos);
        randomAccessFile.writeBytes("\r\n"+items);
        randomAccessFile.seek(0);
        String line;
        while ((line = randomAccessFile.readLine()) != null){
            System.out.println(">>> int >>>"+ line);
        }
/*        randomAccessFile.seek(0);
        System.out.println(">>> UTF >>>"+ randomAccessFile.readUTF());*/
        randomAccessFile.close();
    }
}
