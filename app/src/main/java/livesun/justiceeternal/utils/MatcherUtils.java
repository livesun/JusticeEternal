package livesun.justiceeternal.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 29028 on 2017/8/12.
 */

public class MatcherUtils {
    private static Pattern CMMENT_PATTERN = Pattern.compile("<!--[\\s\\S]+?-->");
    private static Pattern IMAGE_SVG_PATTERN = Pattern.compile("(!\\[])((\\(https|\\(http)?:)(.*?)(.svg\\))");
    /**
     * 删除 <!-- xxxx-->
     * @param resouce
     * @return
     */
    public static String deletComment(String resouce){
        Matcher matcher = CMMENT_PATTERN.matcher(resouce);
        while (matcher.find()) {
            String group = matcher.group();
            resouce = resouce.replaceAll(group, "");
        }

        return resouce;
    }

    /**
     * 提取.svg里面的信息 ![](https://img.shields.io/badge/扒谱-@电光火石XIII-ff69b4.svg)
     */

    public static String getInfor(String resouce){
        Matcher matcher2 = IMAGE_SVG_PATTERN.matcher(resouce);
        while (matcher2.find()) {
            String group = matcher2.group();
            String tag="演奏者";
            String value="佚名";
            String[] splits = group.split("-");
            if(splits!=null&&splits.length==3){
                for(int i=0;i<splits.length;i++){
                    if(i==0){
                        int i1 = splits[0].lastIndexOf("/");
                        if(i1>=0){
                            tag= splits[0].substring(i1+1,splits[0].length());
                        }
                    }else if(i==1){
                        value=splits[1];
                    }
                }
                String split=tag+"-"+value;

                resouce = replace(resouce, group, split);
            }
        }
        return resouce;
    }


    public static String replace(String source, String oldString,
                           String newString) {
        StringBuffer output = new StringBuffer();
        int lengthOfSource = source.length();
        int lengthOfOld = oldString.length();
        int posStart = 0;
        int pos; //
        while ( (pos = source.indexOf(oldString, posStart)) >= 0) {
            output.append(source.substring(posStart, pos));
            output.append(newString);
            posStart = pos + lengthOfOld;
        }
        if (posStart < lengthOfSource) {
            output.append(source.substring(posStart));
        }
        return output.toString();
    }
}
