package com.eagle.mongodb;

import com.eagle.common.result.R;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author eagle2020
 */
//(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
@ServletComponentScan("com.eagle")
public class ServiceMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceMongodbApplication.class, args);
    }

}

@RestController
@RequestMapping("/mongodb")
class HealthController {

    @Resource
    private MongoTemplate mongoTemplate;

    @Data
    static
    class Student {
        public String name;
    }

    @GetMapping("/health")
    public R getHealth() {
        Criteria gt = Criteria
                .where("name").is("eagle");
        Query query = new Query(gt);
        Student one = mongoTemplate.findOne(query, Student.class);
        return R.ok().data("health", one);
    }
}