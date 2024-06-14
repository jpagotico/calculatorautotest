package mySamplePackage
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class CommonSteps {

	
	@Given("I access the basic calculator web")
	def access_bc_web() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow(FailureHandling.STOP_ON_FAILURE)
		WebUI.navigateToUrl('https://testsheepnz.github.io/BasicCalculator.html#main-body')
	}

	@When("I selects build as (.*) in the dropdown list")
	def selects_build(String build) {
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Basic Calculator/Build'), build, false)
	}

	@And("I enters (.*) in the first number field")
	def enters_firstnum(String fnum) {
		WebUI.setText(findTestObject('Object Repository/Page_Basic Calculator/fnum'), fnum)
	}

	@And("I enters (.*) in the second number field")
	def enters_secondnum(String snum) {
		WebUI.setText(findTestObject('Object Repository/Page_Basic Calculator/snum'), snum)
	}

	@And("I selects operation (.*) in the dropdown list")
	def selects_operation(String operate) {
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Basic Calculator/operation'), operate, false)
	}

	@And("I click calculate button")
	def click_calculatebutton() {
		WebUI.click(findTestObject('Object Repository/Page_Basic Calculator/calculatebutton'))
	}
	
	@And("I verify the answer")
	def total_answer() {
		
		WebElement element1 = WebUI.findWebElement(findTestObject('Object Repository/Page_Basic Calculator/fnum')) //get the element
		String fnum = element1.getAttribute("value") // get the attribute value and pass to variable
		int intFnum = Integer.parseInt(fnum) // convert string to integer
		
		WebElement element2 = WebUI.findWebElement(findTestObject('Object Repository/Page_Basic Calculator/snum'))
		String snum = element2.getAttribute("value")
		int intSnum = Integer.parseInt(snum)
		
		WebElement element3 = WebUI.findWebElement(findTestObject('Object Repository/Page_Basic Calculator/answer'))
		String answer = element3.getAttribute("value")
		int intAnswer = Integer.parseInt(answer)
		
		WebElement element4 = WebUI.findWebElement(findTestObject('Object Repository/Page_Basic Calculator/operation'))
		String operation = element4.getAttribute("value")

		
		switch(operation) {
			//Add
			case "0":
			int sum = intFnum + intSnum
			println(sum)
			assert intAnswer == sum
			break;
			//Subtract
			case "1":
			int sum = intFnum - intSnum
			println(sum)
			assert intAnswer == sum
			break;
			//Divide
			case "2":
			int sum = intFnum * intSnum
			println(sum)
			assert intAnswer == sum
			break;
			//Multiply
			case "3":
			int sum = intFnum / intSnum
			println(sum)
			assert intAnswer == sum
			break;
			//Concatenate
			case "4":
			String sum = fnum.concat(snum)
			assert answer == sum
			println(sum)
			break;
			
		}
		
		
		
	}
}