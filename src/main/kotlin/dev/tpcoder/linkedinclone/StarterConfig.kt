package dev.tpcoder.linkedinclone

import dev.tpcoder.linkedinclone.model.Company
import dev.tpcoder.linkedinclone.model.Industry
import dev.tpcoder.linkedinclone.model.Skill
import dev.tpcoder.linkedinclone.model.User
import dev.tpcoder.linkedinclone.repository.CompanyRepository
import dev.tpcoder.linkedinclone.repository.IndustryRepository
import dev.tpcoder.linkedinclone.repository.SkillRepository
import dev.tpcoder.linkedinclone.repository.UserRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.ReactiveTransactionManager
import org.springframework.transaction.reactive.AbstractReactiveTransactionManager

@Configuration
class StarterConfig(
    private val userRepository: UserRepository,
    private val skillRepository: SkillRepository,
    private val industryRepository: IndustryRepository,
    private val companyRepository: CompanyRepository
) : ApplicationRunner {

    override fun run(args: ApplicationArguments) {
        val skills = listOf(
            Skill("Java"),
            Skill("Spring Boot"),
            Skill("Rust"),
            Skill("SQL"),
            Skill("AWS"),
            Skill("Kotlin")
        )

        val industries = listOf(
            Industry("Finance"),
            Industry("E-commerce"),
            Industry("Telecommunications")
        )

        val companies = listOf(
            Company("Company AA", industries[0]),
            Company("Company BB", industries[1]),
            Company("Company CC", industries[0]),
            Company("Company DD", industries[2]),
            Company("Company EE", industries[1])
        )

        val users = mutableListOf<User>()

        // Generate 10 users with separate skills and industries
        for (i in 1..10) {
            val userSkills = mutableSetOf<Skill>()
            val userIndustries = mutableListOf<Industry>()

            // Assign three random skills to each user
            while (userSkills.size < 3) {
                val randomSkill = skills.random()
                userSkills.add(randomSkill)
            }

            // Assign one random industry to each user
            val randomIndustry = industries.random()
            userIndustries.add(randomIndustry)

            // Assign one random company to each user
            val userCompany = companies[i % companies.size]

            val user = User("user$i", "User $i", userSkills, setOf(), userCompany, setOf())

            println("user: $user")

            users.add(user)
        }

        skillRepository.deleteAll()
            .thenMany(skillRepository.saveAll(skills))
            .then(industryRepository.deleteAll())
            .thenMany(industryRepository.saveAll(industries))
            .then(companyRepository.deleteAll())
            .thenMany(companyRepository.saveAll(companies))
            .then(userRepository.deleteAll())
            .thenMany(userRepository.saveAll(users))
            .subscribe()
    }
}