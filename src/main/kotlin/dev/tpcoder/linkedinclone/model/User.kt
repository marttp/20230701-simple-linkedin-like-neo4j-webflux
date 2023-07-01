package dev.tpcoder.linkedinclone.model

import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Relationship

@Node
data class User(

    @Id val username: String,
    val name: String,
    @Relationship(type = "HAS_SKILL") val skills: Set<Skill> = setOf(),
    @Relationship(type = "HAS_POSITION") val positions: Set<Position> = setOf(),
    @Relationship(type = "WORKS_AT") val company: Company,
    @Relationship(type = "CONNECTED_TO") val connections: Set<User> = setOf()
)