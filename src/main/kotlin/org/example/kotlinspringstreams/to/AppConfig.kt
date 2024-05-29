package org.example.kotlinspringstreams.to

import org.apache.kafka.clients.admin.NewTopic
import org.apache.kafka.streams.StreamsBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class AppConfig {
    private val sampleName = "to"
    private val sourceName = "$sampleName-source"
    private val sinkName = "$sampleName-sink"

    @Bean
    fun inputTopic(): NewTopic = TopicBuilder.name(sourceName)
        .partitions(3)
        .replicas(2)
        .build()

    @Bean
    fun outTopic(): NewTopic = TopicBuilder.name(sinkName)
        .partitions(3)
        .replicas(2)
        .build()

    @Autowired
    fun buildPipeline(streamsBuilder: StreamsBuilder) = toSample(streamsBuilder)
}