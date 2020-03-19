package com.ysdrzp.easy;

import java.io.InputStream;

/**
 * Resources
 * 读取配置文件
 */
public class Resources {

    /**
     * 用于加载 xml 文件，并且得到一个流对象
     * @param xmlPath
     * @return
     */
    public static InputStream getResourceAsStream(String xmlPath) {
        return Resources.class.getClassLoader().getResourceAsStream(xmlPath);
    }

}
