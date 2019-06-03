package com.alexnine.controller;

import com.alexnine.utils.FileUtils;
import com.alexnine.utils.Result;
import com.alexnine.utils.ResultUtils;
import com.blade.mvc.annotation.MultipartParam;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.PostRoute;
import com.blade.mvc.http.Request;
import com.blade.mvc.multipart.FileItem;

import java.util.Objects;

/**
 * @author AlexNine
 * Date 2019/6/3 9:26
 */
@Path(value = "/file")
public class FileController {

    @PostRoute("/upload")
    public Result uploadFile(Request request, @MultipartParam FileItem file) {
        if (Objects.nonNull(file)) {
            String path = FileUtils.save2DefaultPath(file);
            if (path != null) {
                return ResultUtils.success("上传成功", path);
            } else {
                return ResultUtils.error("上传失败");
            }
        } else {
            return ResultUtils.error("上传失败");
        }
    }

}
