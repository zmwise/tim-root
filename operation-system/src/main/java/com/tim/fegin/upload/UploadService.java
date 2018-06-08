package com.tim.fegin.upload;

import com.baomidou.mybatisplus.plugins.Page;
import com.tim.config.fegin.FeignMultipartSupportConfig;
import com.tim.config.fegin.FeignSimpleEncoderConfig;
import com.tim.entity.sys.resource.SysResource;
import com.tim.entity.sys.user.SysUser;
import com.tim.fegin.user.SysUserFallBack;
import com.tim.request.JwtAuthenticationRequest;
import com.tim.sys.user.SysUserDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@FeignClient(name = "service-user",configuration = FeignMultipartSupportConfig.class)
public interface UploadService {
    @PostMapping(value = "/sysUser/uploadFile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String fileUpload(@RequestPart(value = "file") MultipartFile file);
}
