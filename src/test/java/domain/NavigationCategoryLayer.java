package domain;


public class NavigationCategoryLayer extends BaseLayer {
    public void extendSubcategory(){
        getHomePage().clickOnListOfCategoriesLink();
        getHomePage().clickOnCategoryFromList();
        getHomePage().clickOnCategoriesListSubcategory();
    }
}
