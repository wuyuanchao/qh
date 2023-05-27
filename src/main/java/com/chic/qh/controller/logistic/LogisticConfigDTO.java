package com.chic.qh.controller.logistic;

import lombok.Data;

import java.util.List;

@Data
public class LogisticConfigDTO {

    public static final String JSON_MOCK_DATA = "[\n" +
            "    {\n" +
            "        \"id\":624748501,\n" +
            "        \"country\":\"英国\",\n" +
            "        \"shippingTime\":\"5-8工作日\",\n" +
            "        \"items\":[\n" +
            "            {\n" +
            "                \"id\":1,\n" +
            "                \"left\":0,\n" +
            "                \"right\":2,\n" +
            "                \"shippingFee\":81,\n" +
            "                \"extraFee\":16\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\":2,\n" +
            "                \"left\":2,\n" +
            "                \"right\":20,\n" +
            "                \"shippingFee\":81,\n" +
            "                \"extraFee\":16\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"id\":624691223,\n" +
            "        \"country\":\"美国\",\n" +
            "        \"shippingTime\":\"6-10工作日\",\n" +
            "        \"items\":[\n" +
            "            {\n" +
            "                \"id\":1,\n" +
            "                \"left\":0,\n" +
            "                \"right\":0.1,\n" +
            "                \"shippingFee\":123,\n" +
            "                \"extraFee\":20\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\":2,\n" +
            "                \"left\":0.1,\n" +
            "                \"right\":0.2,\n" +
            "                \"shippingFee\":113,\n" +
            "                \"extraFee\":18\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\":3,\n" +
            "                \"left\":0.2,\n" +
            "                \"right\":0.45,\n" +
            "                \"shippingFee\":110,\n" +
            "                \"extraFee\":18\n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "]";

    private Integer id;
    private String country;
    private String shippingTime;
    private List<Item> items;

    @Data
    public static class Item {
        private Integer id;
        private String left;
        private String right;
        private String shippingFee;
        private String extraFee;
    }

}
