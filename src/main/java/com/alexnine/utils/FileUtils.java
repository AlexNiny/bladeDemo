package com.alexnine.utils;

import com.blade.mvc.WebContext;
import com.blade.mvc.multipart.FileItem;
import com.mysql.cj.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author AlexNine
 * Date 2019/6/3 14:31
 */
@Slf4j
public class FileUtils {
    /**
     * 保存文件到默认的地址
     * @param file 文件
     * @return
     */
    public static String save2DefaultPath(FileItem file) {
        String configPath = WebContext.blade().environment().toMap().get("app.savePath");
        if (StringUtils.isNullOrEmpty(configPath)) {
            log.warn("没有配置默认保存路径，使用jar所在路径：{}", WebContext.contextPath());
            configPath = WebContext.contextPath();
        }
        String fileName = DigestUtils.md5Hex(file.getData()) + "." + file.getFileName().split("\\.")[1];
        File savePath = new File(configPath + File.separator + fileName);
        try {
            if (!savePath.getParentFile().exists()) {
                boolean f = savePath.getParentFile().mkdir();
                if (f) {
                    log.info("成功创建父级文件夹");
                } else {
                    log.warn("创建父级文件夹失败");
                }
            }else {
                if (!savePath.getParentFile().isDirectory()){
                    boolean f = savePath.getParentFile().mkdir();
                    if (f) {
                        log.info("成功创建父级文件夹");
                    } else {
                        log.warn("创建父级文件夹失败");
                    }
                }
            }
            if (savePath.exists()) {
                return savePath.getAbsolutePath();
            } else {
                boolean f= savePath.createNewFile();
                if (f) {
                    log.info("成功创建文件");
                } else {
                    log.warn("创建文件失败");
                }
            }
            FileOutputStream out = new FileOutputStream(savePath);
            out.write(file.getData());
            return savePath.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
