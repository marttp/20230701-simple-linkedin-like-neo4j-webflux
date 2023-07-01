package dev.tpcoder.linkedinclone.model

import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Relationship

@Node
data class Position(

    @Id val title: String,
    @Relationship(type = "BELONGS_TO") val company: Company
)
