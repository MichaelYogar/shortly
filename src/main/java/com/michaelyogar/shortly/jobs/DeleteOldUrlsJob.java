package com.michaelyogar.shortly.jobs;

import com.michaelyogar.shortly.ShortlyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DeleteOldUrlsJob {
    private static final Logger log = LoggerFactory.getLogger(DeleteOldUrlsJob.class);

    private final ShortlyService service;

    @Autowired
    public DeleteOldUrlsJob(ShortlyService service) {
        this.service = service;
    }

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(initialDelay = 20 * 1000, fixedRate = 60 * 1000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        service.deleteExpiredLinks(5);
    }
}
