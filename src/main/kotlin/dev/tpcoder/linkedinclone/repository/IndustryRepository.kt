package dev.tpcoder.linkedinclone.repository

import dev.tpcoder.linkedinclone.model.Industry
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository

interface IndustryRepository: ReactiveNeo4jRepository<Industry, String>