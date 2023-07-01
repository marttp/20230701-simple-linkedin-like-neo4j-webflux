package dev.tpcoder.linkedinclone.model

import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Id

@Node
data class Industry(

    @Id val name: String
)
