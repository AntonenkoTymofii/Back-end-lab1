package org.example.backendlab1.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/healthcheck")
public class HealthCheckController {

    @GetMapping
    public Map<String, Object> healthCheck() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("timestamp", LocalDateTime.now().toString());
        ZonedDateTime dateTimeWithOffset = ZonedDateTime.now(ZoneId.of("UTC+3"));
        String formattedDateTime = dateTimeWithOffset.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        response.put("ukraine-time", formattedDateTime);

        return response;
    }
}
