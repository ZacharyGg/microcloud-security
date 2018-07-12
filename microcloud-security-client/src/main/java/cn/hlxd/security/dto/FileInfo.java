package cn.hlxd.security.dto;/**
 * @Author Administrator
 * @Date 2018/7/12 15:38
 */

/**
 * Created with IntelliJ IDEA.
 * @Program：microcloud-security
 * @Author：Zachary
 * @Version：1.o
 * @Date： 2018-07-12  15:38
 * @Description：
 **/

public class FileInfo {
    public FileInfo(String path){
        this.fileName = path;
    }

    private String fileName;
    private String filePath;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
