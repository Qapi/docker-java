package com.huya.dockerjava.controller;

import com.huya.dockerjava.utils.HdfsUtil;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.hadoop.fs.FsShell;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;

@RestController
public class HdfsController {

    @Autowired
    private FsShell fsShell;

    @Value("${spring.hadoop.fs-uri}")
    private String HDFS_FS;

    @GetMapping("hdfs/info")
    public ResponseEntity<String> info() throws IOException, InterruptedException {
        System.out.println("=========run start============");
        for (FileStatus fileStatus : fsShell.lsr("/project_dir/2")) {
            System.out.println(">" + fileStatus.getPath());
        }
        FsShell fsShell2 = HdfsUtil.getFsShellByUser(HDFS_FS, "zhengjiarun");
//        fsShell2.rm(true, "/project_dir/5/zhengjiarun/2");
        fsShell2.copyFromLocal("C:\\Users\\70477\\Desktop\\test.txt","/project_dir/5/zhengjiarun/test.txt");
        System.out.println("===========run end===========");
        return new ResponseEntity<String>("h", HttpStatus.OK);
    }


}
