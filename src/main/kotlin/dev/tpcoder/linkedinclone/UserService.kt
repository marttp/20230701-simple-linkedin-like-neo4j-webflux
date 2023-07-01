package dev.tpcoder.linkedinclone

import dev.tpcoder.linkedinclone.model.User
import dev.tpcoder.linkedinclone.projection.UserIndustryProjection
import dev.tpcoder.linkedinclone.repository.UserRepository
import org.springframework.data.neo4j.core.ReactiveNeo4jClient
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserService(
    private val userRepository: UserRepository,
    private val reactiveNeo4jClient: ReactiveNeo4jClient
) {

    fun findUsersBySkill(skill: String): Flux<UserIndustryProjection> {
        val query = "MATCH (u:User)-[:HAS_SKILL]->(s:Skill) " +
                ",(u)-[:WORKS_AT]->(c:Company) " +
                ",(c)-[:HAS_INDUSTRY]->(i:Industry) " +
                "WHERE s.name = \$skillName " +
                "RETURN u.name as name, c.name as company, i.name as industry"
        return reactiveNeo4jClient.query(query)
            .bind(skill).to("skillName")
            .fetchAs(UserIndustryProjection::class.java)
            .mappedBy { _, record ->
                UserIndustryProjection(
                    record["name"].asString(),
                    record["company"].asString(),
                    record["industry"].asString()
                )
            }
            .all()
    }

    fun findUsersByName(name: String): Mono<User> {
        return userRepository.findByName(name)
    }
}