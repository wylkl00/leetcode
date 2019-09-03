package question;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;
import it.sauronsoftware.jave.VideoInfo;


import java.io.File;

/**
 * Description: TODO
 *
 * @author wangyang
 * @since 2019/2/20
 */

public class Video {

    public static long getVideoLength(String src){
        File file=new File(src);
        MultimediaInfo multimediaInfo;
        Encoder encoder=new Encoder();
        try{
            multimediaInfo=encoder.getInfo(file);

            VideoInfo videoInfo= multimediaInfo.getVideo();
            videoInfo.getDecoder();
            multimediaInfo.getFormat();

            return multimediaInfo.getDuration();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(getVideoLength("http://e-file.huawei.com/-/media/947384F66AFE455FADDC0D27C03912C7.mp4"));
    }
}
