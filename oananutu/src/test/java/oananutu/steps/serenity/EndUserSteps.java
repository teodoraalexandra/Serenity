package oananutu.steps.serenity;

import oananutu.pages.EmagPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    private EmagPage emagPage;

    @Step
    public void is_the_home_page() {
        emagPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
    }

    @Step
    private void enters(String keyword) {
        emagPage.enter_keywords(keyword);
    }

    @Step
    public void should_see_articles(String articleTitle) {
        assertThat(emagPage.getArticles(), hasItem(containsString(articleTitle)));
    }

    @Step
    public void click_filter(String maxNumber) {
        emagPage.click_filter(maxNumber);
    }
}
