package com.findinpath.step.definitions

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import io.cucumber.java.After
import io.cucumber.java.Before

class CommonBrowserStepDefinitions {

    @Before("@Proxy")
    fun setupProxy(){
        Configuration.proxyEnabled = true
    }

    @After(order = 1)
    fun tearDownWebDriver(){
        Selenide.closeWebDriver()
    }

    @After("@Proxy", order = 0)
    fun tearDownProxy(){
        Configuration.proxyEnabled = false
    }

}