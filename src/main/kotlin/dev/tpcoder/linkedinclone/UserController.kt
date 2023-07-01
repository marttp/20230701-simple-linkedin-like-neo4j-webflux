package dev.tpcoder.linkedinclone

import dev.tpcoder.linkedinclone.model.User
import dev.tpcoder.linkedinclone.projection.UserIndustryProjection
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class UserController(private val userService: UserService) {

    @GetMapping("/users")
    fun getUsersBySkill(@RequestParam skillName: String): Flux<UserIndustryProjection> =
        userService.findUsersBySkill(skillName)

    @GetMapping("/users/{name}")
    fun getUserByName(@PathVariable name: String): Mono<User> = userService.findUsersByName(name)
}