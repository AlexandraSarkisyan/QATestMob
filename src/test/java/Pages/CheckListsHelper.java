package Pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckListsHelper extends PageBase{

    public CheckListsHelper(WebDriver driver) {
        super(driver);
    }
@FindBy(className = "android.widget.TextView")
    WebElement headerText;
    @FindBy(id="com.flt.checklist:id/add_shopping_list")
    WebElement plusButton;
    @FindBy(className = "android.widget.EditText")
    WebElement nameField;
    @FindBy(id= "android:id/button1")
    WebElement submitButton;
    @FindBy(className = "android.widget.ImageButton")
    WebElement returnButton;
    @FindBy(id="com.flt.checklist:id/list_title")
    List<WebElement> checkLists;
    @FindBy(id="com.flt.checklist:id/list_delete")
    WebElement buttonDeleteList;
    @FindBy(id="com.flt.checklist:id/add_item_edit")
    WebElement addItemField;
    @FindBy(id="com.flt.checklist:id/add_item")
    WebElement addItemPlus;


    public void waitUntilPageIsLoaded() {
        waitUntilElementIsVisible(headerText,10);
        waitUntilElementIsClickable(plusButton,10);
    }

    public String getHeaderText() {
       return  headerText.getText();
    }

    public void createCheckList(String name) {
        waitUntilElementIsClickable(plusButton,30);
        plusButton.click();
        waitUntilElementIsClickable(submitButton,10);
        waitUntilElementIsClickable(nameField,20);
        editField(nameField,name);
        submitButton.click();
        waitUntilElementIsClickable(returnButton,10);
    }
    public void createCheckListLandscape(String name) {
        //driver.switchTo().frame(driver.findElement(By.id("android:id/content")));
        waitUntilElementIsClickable(plusButton,30);
        plusButton.click();
        waitUntilElementIsClickable(submitButton,10);
        waitUntilElementIsClickable(nameField,20);
        editField(nameField,name);
        submitButton.click();
        waitUntilElementIsClickable(returnButton,10);
    }

    public void returnFromChecklist() {
        waitUntilElementIsClickable(returnButton,10);
        returnButton.click();
        this.waitUntilPageIsLoaded();
    }

    public int getListQuantity() {
        return checkLists.size();

    }

 
    public void deleteFirstList() {
        waitUntilElementIsClickable(buttonDeleteList,10);
        buttonDeleteList.click();
    }

    public void fillCheckList(String name) {
        waitUntilElementIsClickable(addItemField,10);
        editField(addItemField,name);
        waitUntilElementIsClickable(addItemPlus,10);
        addItemPlus.click();
    }
}
