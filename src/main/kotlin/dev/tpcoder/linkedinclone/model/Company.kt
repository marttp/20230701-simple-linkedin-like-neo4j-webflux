package dev.tpcoder.linkedinclone.model

import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Relationship

@Node
data class Company(

    @Id val name: String,
    @Relationship(type = "HAS_INDUSTRY") val industry: Industry
)
