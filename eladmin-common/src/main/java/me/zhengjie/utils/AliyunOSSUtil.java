package me.zhengjie.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import me.zhengjie.config.ConstantConfig;
import me.zhengjie.config.FileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class AliyunOSSUtil {
    @Autowired
    private ConstantConfig constantConfig;

    /** 上传文件*/
    public FileDTO upLoad(File file){
        String endpoint = constantConfig.getEndpoint();
        String accessKeyId = constantConfig.getAccessKeyId();
        String accessKeySecret = constantConfig.getAccessKeySecret();
        String bucketName = constantConfig.getBucketName();
        String fileHost = constantConfig.getFolder();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String dateStr=format.format(new Date());
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String suffix = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        // 判断文件
        if(file==null){
            return null;
        }
        OSSClient client=new OSSClient(endpoint, accessKeyId, accessKeySecret);
        try {
            // 判断容器是否存在,不存在就创建
            if (!client.doesBucketExist(bucketName)) {
                client.createBucket(bucketName);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                client.createBucket(createBucketRequest);
            }
            // 设置文件路径和名称
            String fileUrl = fileHost + "/" + (dateStr + "/" + uuid ) + "-" + file.getName();
            // 设置权限(公开读)
            client.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
            // 上传文件
            PutObjectResult result = client.putObject(new PutObjectRequest(bucketName, fileUrl, file));
            if (result != null) {
                String[] split = fileUrl.split("/");
                return new FileDTO(
                        file.length(),//文件大小
                        fileUrl,//文件的绝对路径
                        constantConfig.getWebUrl() +"/"+ fileUrl,//文件的web访问地址
                        suffix,//文件后缀
                        bucketName,//存储的bucket
                        split[3],//原文件名
                        fileHost//存储的文件夹
                );

            }
        }catch (OSSException oe){

        }catch (ClientException ce){

        }finally{
            if(client!=null){
                client.shutdown();
            }
        }
        return null;
    }


    /**
     * 删除图片
     * @return
     */
    public HttpStatus deleteImage(String imageName){
        String endpoint = constantConfig.getEndpoint();
        String accessKeyId = constantConfig.getAccessKeyId();
        String accessKeySecret = constantConfig.getAccessKeySecret();
        try {
            OSSClient client=new OSSClient(endpoint, accessKeyId, accessKeySecret);
            client.deleteObject(constantConfig.getBucketName(),imageName);
            client.shutdown();
            System.out.println("成功");
            return HttpStatus.OK;
        }catch (Exception e){
            System.out.println("失败");
            return HttpStatus.CONTINUE;
        }

    }
}
