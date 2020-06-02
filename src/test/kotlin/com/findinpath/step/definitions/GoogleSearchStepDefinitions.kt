package com.findinpath.step.definitions

import com.codeborne.selenide.CollectionCondition
import com.codeborne.selenide.Condition
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.WebDriverRunner
import com.codeborne.selenide.WebDriverRunner.getSelenideProxy
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.openqa.selenium.By
import kotlin.test.assertTrue


class GoogleSearchStepDefinitions {
    @Given("an open browser with google.com")
    fun `open google search`() {
        Configuration.reportsFolder = "target/surefire-reports"
        open("https://google.com/ncr")
    }

    @When("a keyword {string} is entered in input field")
    fun `enter keyword`(keyword: String) {
        `$`(By.name("q")).`val`(keyword).pressEnter()
    }

    @Then("at least top {int} matches should be shown")
    fun `top matches should be shown`(resultsCount: Int) {
        `$$`("#res .g").shouldHave(CollectionCondition.sizeGreaterThanOrEqual(resultsCount))
    }

    @Then("the first one should contain {string}")
    fun `the first one should contain specified keyword`(expectedText: String) {
        `$`("#res .g").shouldHave(Condition.text(expectedText))
    }

    @Then("{int} request(s) containing {string} query field should be triggered")
    fun `X search request(s) containing {string} query field should be triggered`(count: Int, keyword: String){
        val requestsContainingTheKeyword = getSelenideProxy().proxy.har.log.entries.filter{entry -> entry.request.url.startsWith("https://www.google.com/complete/search?q=$keyword")}

        assertTrue { requestsContainingTheKeyword.count() == count }
    }
}