package com.cc1500.web.enums;
/**
 * 用户状态
 *
 * @author xingcloud
 */
public enum VideoRatio {

        LOW("0", "720x480"), MIDDLE("1", "1280x720"), HIGH("2", "1920x1080"),LOWER("4","480x360");

        private final String code;
        private final String value;

    VideoRatio(String code, String value)
        {
            this.code = code;
            this.value = value;
        }

        public String getCode()
        {
            return code;
        }

        public String getValue()
        {
            return value;
        }
}
