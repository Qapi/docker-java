package com.huya.dockerjava.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.hadoop.fs.FsShell;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;

@Component
public class HdfsUtil {

    public static FsShell getFsShellByUser(String hdfsFsUrl, String user) throws IOException, InterruptedException {
        Configuration configuration = new Configuration();
//        configuration.set("fs.defaultFS", HDFS_FS);
        FileSystem fileSystem = FileSystem.get(URI.create(hdfsFsUrl), configuration, user);
        FsShell fsShell = new FsShell(configuration, fileSystem);
        return fsShell;
    }
}
