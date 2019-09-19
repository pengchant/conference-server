package com.justcs.utils;

import com.baidu.aip.speech.AipSpeech;
import org.json.JSONObject;

public class Sample {

    public static final String APP_ID = "16330629";

    public static final String API_KEY = "Gro0MPyF8uoG2s9guZofSfc9";

    public static final String SECRET_KEY = "nit7b572IPPFbKLNZippdodVpU4qO9jT";

    public static void main(String[] args) {
        // 初始化一个Apispeech
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        // 设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 调用接口
        JSONObject res = client.asr("C:\\Users\\chenpeng\\Desktop\\123.wav", "wav", 16000, null);
        System.out.println(res.toString());
    }
}
