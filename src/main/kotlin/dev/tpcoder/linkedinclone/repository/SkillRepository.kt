package dev.tpcoder.linkedinclone.repository

import dev.tpcoder.linkedinclone.model.Skill
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository

interface SkillRepository : ReactiveNeo4jRepository<Skill, String>