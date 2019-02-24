package myfegin.service;

import myfegin.controller.TestController;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("order.app")
public interface FeginClient {
    public static class SomeData {
        String name;
        Integer age;

        InnerData innerData;

        public SomeData(String name, Integer age, InnerData innerData) {
            this.name = name;
            this.age = age;
            this.innerData = innerData;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public InnerData getInnerData() {
            return innerData;
        }

        public void setInnerData(InnerData innerData) {
            this.innerData = innerData;
        }
    }
    public static class QuertData {
        String id;
        String name;
    }
    public static class InnerData {
        String addr;
        Float score;

        public InnerData(String addr, Float score) {
            this.addr = addr;
            this.score = score;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public Float getScore() {
            return score;
        }

        public void setScore(Float score) {
            this.score = score;
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/myname")
    String getOrderAppName();

    @RequestMapping(method = RequestMethod.POST, value = "/some-data")
    SomeData getOrderSomeData();

}


