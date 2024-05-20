package com.example.demo

import org.jobrunr.scheduling.JobScheduler
import org.springframework.stereotype.Component
import org.jobrunr.jobs.annotations.Recurring

@Component
class TestScheduler(
    private val jobScheduler: JobScheduler
) {

    @Recurring(id = "my-recurring-job", cron = "0/1 * * * *")
    fun hello() { println("Hello World") }
}