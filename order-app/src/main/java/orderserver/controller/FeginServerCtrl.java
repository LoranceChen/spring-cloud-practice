package orderserver.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * for my-fegin app test.
 */
@RestController
public class FeginServerCtrl {
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

    @PostMapping("/some-data")
    public SomeData getSomeData() {
        SomeData someData = new SomeData("name001", 10, new InnerData("addr001", 1.22f));
        return someData;
    }
}
