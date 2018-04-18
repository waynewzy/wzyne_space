package com.wayne.kafka;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * @author Wayne
 * @date 2018/3/10
 * <p>
 * desc:kafka消息
 */
public class KafkaMessage implements Serializable {

    private String tag;
    private Object data;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public KafkaMessage() {
    }

    public KafkaMessage(String tag, Object data) {
        this.tag = tag;
        this.data = data;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
