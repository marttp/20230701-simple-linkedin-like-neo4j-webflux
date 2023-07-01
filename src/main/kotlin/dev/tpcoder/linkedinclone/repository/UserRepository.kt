package dev.tpcoder.linkedinclone.repository

import dev.tpcoder.linkedinclone.model.User
import dev.tpcoder.linkedinclone.projection.UserIndustryProjection
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository
import org.springframework.data.neo4j.repository.query.Query
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface UserRepository : ReactiveNeo4jRepository<User, String> {

    fun findByName(name: String): Mono<User>
}