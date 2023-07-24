package hello.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    @GetMapping("/ping")
    public String ping() {
        log.info("run endpoint PING ...");
        return "hello";
    }

}
