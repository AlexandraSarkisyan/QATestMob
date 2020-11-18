package tests;


import Pages.CheckListsHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CheckListsTest extends TestBase{
    CheckListsHelper checkListPage;
    @BeforeMethod
    public void initTest(){
        checkListPage = PageFactory.initElements(driver,CheckListsHelper.class);
        checkListPage.waitUntilPageIsLoaded();
    }
   @Test
   public void isCorrectScreen(){
       Assert.assertEquals("Check List",checkListPage.getHeaderText());
   }
   @Test
   public void createCheckList(){
        int firstListQuantity= checkListPage.getListQuantity();
       System.out.println("quantity lists: "+firstListQuantity);
       checkListPage.createCheckList("test");
       checkListPage.returnFromChecklist();
       int lastListQuantity= checkListPage.getListQuantity();
       System.out.println("quantity lists: "+lastListQuantity);
    Assert.assertEquals(firstListQuantity+1,lastListQuantity);
 }
    @Test
    public void createCheckListAndRotate() {
        int firstListQuantity = checkListPage.getListQuantity();
       checkListPage.rotateScreenLandScape();
        checkListPage.createCheckList("afterRotation");
        checkListPage.returnFromChecklist();
        int landscapeListQuantity = checkListPage.getListQuantity();
        Assert.assertEquals(firstListQuantity + 1, landscapeListQuantity);
        checkListPage.rotateScreenPortrait();
        int portraitListQuantity = checkListPage.getListQuantity();
        Assert.assertEquals(firstListQuantity + 1, portraitListQuantity);

    }
    @Test
    public void deleteChecklist(){
        int firstListQuantity = checkListPage.getListQuantity();
        if(firstListQuantity<=0){
            checkListPage.createCheckList("beforeDelete");
            checkListPage.returnFromChecklist();
        }
        int afterCreateListQuantity= checkListPage.getListQuantity();
        checkListPage.deleteFirstList();
        int lastListQuantity= checkListPage.getListQuantity();
        Assert.assertEquals(afterCreateListQuantity - 1, lastListQuantity);
    }
    @Test
    public void checkListCreateAndCheck(){
        int firstListQuantity = checkListPage.getListQuantity();
        checkListPage.createCheckList("New");
        checkListPage.fillCheckList("shopping");
        checkListPage.returnFromChecklist();
        int secondListQuantity= checkListPage.getListQuantity();
        Assert.assertEquals(firstListQuantity+1,secondListQuantity);
        checkListPage.rotateScreenLandScape();
        checkListPage.createCheckList("New2");
        checkListPage.fillCheckList("something");
        checkListPage.returnFromChecklist();
        int thirdListQuantity = checkListPage.getListQuantity();
        checkListPage.rotateScreenPortrait();
        int fourthListQuantity = checkListPage.getListQuantity();
        Assert.assertEquals(thirdListQuantity+1,fourthListQuantity);
    }
}
