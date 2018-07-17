package com.tim.fegin.upload;

import com.tim.config.fegin.FeignMultipartSupportConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;


@FeignClient(name = "service-user",configuration = FeignMultipartSupportConfig.class)
public interface UploadService {
    @PostMapping(value = "/sysUser/uploadFile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String fileUpload(@RequestPart(value = "file") MultipartFile file);
}
