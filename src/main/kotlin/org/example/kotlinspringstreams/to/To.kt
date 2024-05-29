package org.example.kotlinspringstreams.to

import org.apache.kafka.streams.StreamsBuilder

private val sampleName = "to"
private val sourceName = "$sampleName-source"
private val sinkName = "$sampleName-sink"

fun toSample(streamsBuilder: StreamsBuilder) {
    streamsBuilder
        .stream<String, String>(sourceName)
        .to(sinkName)
}
