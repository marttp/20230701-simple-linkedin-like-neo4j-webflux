package dev.tpcoder.linkedinclone

import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.with

@TestConfiguration(proxyBeanMethods = false)
class TestSimpleLinkedinCloneApplication

fun main(args: Array<String>) {
	fromApplication<SimpleLinkedinCloneApplication>().with(TestSimpleLinkedinCloneApplication::class).run(*args)
}
