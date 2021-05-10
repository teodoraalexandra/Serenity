package oananutu.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Qualifier;

import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import oananutu.steps.serenity.EndUserSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/data.csv")
public class SearchByKeywordStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    private EndUserSteps anna;

    private String title;
    private String name;

    @Qualifier
    public String getQualifier() {
        return title;
    }

    @Test
    public void search_laptop() {
        anna.is_the_home_page();
        anna.looks_for(getTitle());
        anna.should_see_articles(getName());
    }

    @Test
    public void filter_laptops() {
        anna.is_the_home_page();
        anna.looks_for(getTitle());
        anna.click_filter("100");
        anna.should_see_articles(getName());
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }
}
