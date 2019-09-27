package com.justcs.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class EncodingUtil {

    public static String base64Encode(String workerid, String usrname) {
        try {
            String result = Base64.getEncoder().encodeToString(
                    (workerid+"|" + System.currentTimeMillis() + "|" + usrname).getBytes("utf-8"));
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
