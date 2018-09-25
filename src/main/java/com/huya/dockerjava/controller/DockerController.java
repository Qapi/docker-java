package com.huya.dockerjava.controller;

import com.alibaba.fastjson.JSON;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.command.DockerCmdExecFactory;
import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.jaxrs.JerseyDockerCmdExecFactory;
import com.spotify.docker.client.DefaultDockerClient;
//import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.DockerException;
import com.spotify.docker.client.ProgressHandler;
import com.spotify.docker.client.messages.Container;
import com.spotify.docker.client.messages.Image;
import com.spotify.docker.client.messages.ProgressMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

//import com.github.dockerjava.api.DockerClient;

@Slf4j
@RestController
public class DockerController {

    @Value("${docker.server.url}")
    private String DOCKER_SERVER_URL;

    @GetMapping("/docker/info")
    public String info() {
//        DockerClient dockerClient = DockerClientBuilder.getInstance(DOCKER_SERVER_URL).build();
//        Info info = dockerClient.infoCmd().exec();
//        System.out.println(info);
//        return JSON.toJSONString(info);

        DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder().withDockerTlsVerify(true)

                .withDockerCertPath("D:\\docker\\certs").withDockerHost(DOCKER_SERVER_URL)

                .withDockerConfig("D:\\docker\\certs").withApiVersion("1.38").withRegistryUrl("https://index.docker.io/v1/")

                .withRegistryUsername("dockeruser").withRegistryPassword("ilovedocker")

                .withRegistryEmail("Qapi@github.com").build();

        DockerCmdExecFactory dockerCmdExecFactory = new JerseyDockerCmdExecFactory()
                .withReadTimeout(1000)
                .withConnectTimeout(1000)
                .withMaxTotalConnections(100);


        DockerClient dockerClient = DockerClientBuilder.getInstance(config)

                .withDockerCmdExecFactory(dockerCmdExecFactory).build();

        Info info = dockerClient.infoCmd().exec();


        return info.getHttpsProxy();
    }

//    @GetMapping("/docker/info2")
//    public String info2() throws Exception {
//        final DockerClient docker = DefaultDockerClient.builder()
//                .uri(URI.create("http://132.232.188.238:2376"))
////                .dockerCertificates(new DockerCertificates(Paths.get("/Users/rohan/.docker/boot2docker-vm/")))
//                .build();
//        List<Container> containers = docker.listContainers();
//        List<Image> quxImages = docker.listImages();
//
//        final AtomicReference<String> imageIdFromMessage = new AtomicReference<>();
//
//        final String returnedImageId = docker.build(
//                Paths.get("D:\\test-repository"), "test","Dockerfile", message -> {
//                    final String imageId = message.buildImageId();
//                    if (imageId != null) {
//                        imageIdFromMessage.set(imageId);
//                    }
//                });
//        return returnedImageId;
//    }


}
