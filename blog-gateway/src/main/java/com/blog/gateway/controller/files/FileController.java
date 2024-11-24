package com.blog.gateway.controller.files;

import com.blog.gateway.grpc.client.file.FileGrpcClientService;
import com.blog.gateway.grpc.convertor.ErrorConvertor;
import com.blog.gateway.payload.response.Response;
import com.blog.gateway.payload.response.file.UploadFileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author daile
 * @since 28/08/2024
 */
@RestController
@RequestMapping("files")
@RequiredArgsConstructor
public class FileController {
  private final FileGrpcClientService fileGrpcClientService;

  @PostMapping
  public Response<UploadFileResponse> uploadFile(@RequestParam("file") MultipartFile file) {
    var grpcRes = fileGrpcClientService.uploadFile(file);
    if (grpcRes.getSuccess()) {
      return Response.<UploadFileResponse>newBuilder()
          .setSuccess(true)
          .setData(UploadFileResponse.builder().path(grpcRes.getData().getPath()).build())
          .build();
    }
    return ErrorConvertor.asErrorResponse(grpcRes.getError());
  }
}
