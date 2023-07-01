package dev.tpcoder.linkedinclone

import org.neo4j.cypherdsl.core.renderer.Configuration
import org.neo4j.cypherdsl.core.renderer.Dialect
import org.neo4j.driver.Driver
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.neo4j.core.ReactiveDatabaseSelectionProvider
import org.springframework.data.neo4j.core.transaction.ReactiveNeo4jTransactionManager
import org.springframework.data.neo4j.repository.config.ReactiveNeo4jRepositoryConfigurationExtension
import org.springframework.transaction.ReactiveTransactionManager


@SpringBootApplication
class SimpleLinkedinCloneApplication {

    @Bean
    fun cypherDslConfiguration(): Configuration {
        return Configuration.newConfig()
            .withDialect(Dialect.NEO4J_5).build()
    }

    @Bean(ReactiveNeo4jRepositoryConfigurationExtension.DEFAULT_TRANSACTION_MANAGER_BEAN_NAME)
    fun reactiveTransactionManager(
        driver: Driver, databaseNameProvider: ReactiveDatabaseSelectionProvider
    ): ReactiveTransactionManager {
        return ReactiveNeo4jTransactionManager(driver, databaseNameProvider)
    }
}

fun main(args: Array<String>) {
    runApplication<SimpleLinkedinCloneApplication>(*args)
}
