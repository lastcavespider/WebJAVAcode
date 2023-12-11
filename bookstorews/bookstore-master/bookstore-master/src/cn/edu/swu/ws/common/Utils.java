package cn.edu.swu.ws.common;

import java.io.File;

public class Utils {

    public static String getFileSuffix(File file) {
        if (file == null) return "";
        String name = file.getName();
        if (name.indexOf(".") > 0) {
            return name.substring(name.lastIndexOf("."));
        } else {
            return "";
        }
    }

}
