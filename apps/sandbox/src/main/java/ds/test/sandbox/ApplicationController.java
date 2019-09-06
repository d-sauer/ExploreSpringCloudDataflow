package ds.test.sandbox;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@RestController
public class ApplicationController {

    @GetMapping("/time")
    public Object time() {
        class Time {
            String time;

            public Time(String time) {
                this.time = time;
            }

            public String getTime() {
                return time;
            }
        }

        return new Time(LocalDateTime.now(ZoneOffset.UTC).toString());
    }



}
