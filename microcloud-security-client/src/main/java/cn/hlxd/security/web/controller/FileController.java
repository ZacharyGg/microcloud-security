package cn.hlxd.security.web.controller;/**
 * @Author Administrator
 * @Date 2018/7/12 15:29
 */

import cn.hlxd.security.dto.FileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * @Program：microcloud-security
 * @Author：Zachary
 * @Version：1.0
 * @Date： 2018-07-12  15:29
 * @Description：
 **/

@RestController
@RequestMapping("/file")
public class FileController {


    private  String folder = "D:\\SoftProject\\IntelliJProject\\201808Security\\microcloud-security-client\\src\\main\\java\\cn\\hlxd\\security\\web\\controller\\";

    /*
    * 文件上传
    * */
    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        File localFile = new File(folder,new Date().getTime()+".txt");
        file.transferTo(localFile);

        return new FileInfo(localFile.getAbsolutePath());
    }

    /*
    * 文件下载
    * */
    @GetMapping("/{id}")
    private void downLoad(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try(InputStream inputStream =new FileInputStream(new File(folder,id+".txt"));
            OutputStream outputStream =response.getOutputStream();) {
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition","attachment;filename=test.txt");
            IOUtils.copy(inputStream,outputStream);
            outputStream.flush();
        }
    }
}
