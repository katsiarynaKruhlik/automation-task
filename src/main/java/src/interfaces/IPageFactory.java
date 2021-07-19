package src.interfaces;

import src.pages.*;

public interface IPageFactory {
    DynamicTableTaskPage dynamicTablePage = new DynamicTableTaskPage();
    AjaxDataTaskPage ajaxDataPage = new AjaxDataTaskPage();
    DynamicIdTaskPage dynamicIdPage = new DynamicIdTaskPage();
    ScrollbarsTaskPage scrollbarsPage = new ScrollbarsTaskPage();
    VisibilityTaskPage visibilityPage = new VisibilityTaskPage();
    ProgressBarTaskPage progressBarPage = new ProgressBarTaskPage();
    ClickTaskPage clickPage = new ClickTaskPage();
    ClassAttributeTaskPage classAttributePage = new ClassAttributeTaskPage();
}
