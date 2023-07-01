package dev.tpcoder.linkedinclone.repository

import dev.tpcoder.linkedinclone.model.Company
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository

interface CompanyRepository: ReactiveNeo4jRepository<Company, String>