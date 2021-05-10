package oananutu.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("https://www.emag.ro/")
public class EmagPage extends PageObject {

    @FindBy(id="searchboxTrigger")
    private WebElementFacade searchTerms;

    @FindBy(className="js-custom-price-max")
    private WebElementFacade filterInput;

    public void enter_keywords(String keyword) {
        searchTerms.typeAndEnter(keyword);
    }

    public List<String> getArticles() {
        WebElementFacade definitionList = find(By.tagName("h2"));
        return definitionList.findElements(By.tagName("a")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());
    }

    public void click_filter(String maxNumber) {
        filterInput.typeAndEnter(maxNumber);
    }
}
