package pages.download;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.MyFilesUtils;

import java.io.File;
import java.io.IOException;


public class DownloadFilePage extends BasePage {
    @FindBy(id = "textbox")
    private WebElement textBox;

    @FindBy(id = "create")
    private WebElement generateFileButton;

    @FindBy(id = "link-to-download")
    private WebElement downloadButton;

    public DownloadFilePage() {

        super();
    }

    public DownloadFilePage downloadFile(File file) throws IOException {
        textBox.sendKeys(MyFilesUtils.readFile(file.getAbsolutePath()));
        generateFileButton.click();
        downloadButton.click();
        return new DownloadFilePage();
    }

}






