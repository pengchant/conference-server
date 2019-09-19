package com.justcs.controller;

import com.justcs.utils.JSONResult;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * 文件上传下载控制类
 */
@ApiIgnore
@Api(value = "文件上传下载控制类")
@Controller
@RequestMapping("/file")
public class MongoDBGFSController {

    private static final Logger logger = LoggerFactory.getLogger(MongoDBGFSController.class);

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFSBucket gridFSBucket;


//    /**
//     * 上传文件
//     *
//     * @param file
//     * @return
//     * @throws IOException
//     * @throws ServletException
//     */
//    @ApiOperation(value = "上传文件测试", notes = "上传文件测试demo")
//    @PostMapping("upload")
//    @ResponseBody
//    public JSONResult uploadFile(@RequestParam("file") MultipartFile file) throws IOException, ServletException {
//        // 获得提交的文件名
//        String fileName = file.getOriginalFilename();
//        // 获取文件输入流
//        InputStream ins = file.getInputStream();
//        // 获取文件类型
//        String contentType = file.getContentType();
//        // 将文件存储到mongodb中
//        ObjectId objectId = gridFsTemplate.store(ins, fileName, contentType);
//        logger.info("保存成功，objectId:" + objectId);
//        return JSONResult.ok(objectId);
//    }
//
//    /**
//     * 下载文件
//     *
//     * @param fileId
//     * @param request
//     * @param response
//     * @throws IOException
//     */
//    @ApiOperation(value = "下载文件测试", notes = "下载文件测试demo")
//    @RequestMapping(value = "/download", method = {RequestMethod.GET, RequestMethod.POST})
//    public void downloadFile(@RequestParam(name = "file_id") String fileId,
//                             HttpServletRequest request,
//                             HttpServletResponse response) throws IOException {
//        logger.info("准备下载文件....");
//        Query query = Query.query(Criteria.where("_id").is(fileId));
//        // 查询单个文件
//        GridFSFile gridFSFile = gridFsTemplate.findOne(query);
//        if (gridFSFile == null) {
//            return;
//        }
//
//        String fileName = gridFSFile.getFilename().replace(",", "");
//        String contentType = gridFSFile.getMetadata().get("_contentType").toString();
//
//        // 通知浏览器进行文件下载
//        response.setContentType(contentType);
//        response.setHeader("Content-Disposition", "attachment;filename=\"" + URLEncoder.encode(fileName, "UTF-8") + "\"");
//        GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
//        GridFsResource resource = new GridFsResource(gridFSFile, gridFSDownloadStream);
//
//        OutputStream outputStream = response.getOutputStream();
//        InputStream inputStream = resource.getInputStream();
//        IOUtils.copy(inputStream, outputStream);
//        outputStream.flush();
//        outputStream.close();
//        inputStream.close();
//    }

}
















