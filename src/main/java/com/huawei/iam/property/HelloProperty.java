package com.huawei.iam.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by zhouyibin on 2017/12/28.
 */
@Component
@ConfigurationProperties(prefix = "hello")
public class HelloProperty {

    private String name;
    private String to;
    private int times;

    public String getName() {
        return name;
    }

    public String getTo() {
        return to;
    }

    public int getTimes() {
        return times;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setTimes(int times) {
        this.times = times;
    }
}
