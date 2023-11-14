package uitests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.upload.DownloadFilePage;
import utils.MyFilesUtils;

import java.io.File;
import java.io.IOException;

public class DownloadTests extends BaseTests {

    @BeforeMethod
    public void beforeMethod() {
        goToUrl();
    }

    @Test
    public void successfullDownloadFile() throws IOException, InterruptedException {
        File file = MyFilesUtils.generateLoremFile();
        String text = MyFilesUtils.readFile(file.getAbsolutePath());
        DownloadFilePage downloadFilePage= new DownloadFilePage()
        .downloadFile(file);

        File file1 = MyFilesUtils.waitTillFileIsLoaded(new File("/Users/nats/Downloads", "easyinfo.txt"));
        String text2 = MyFilesUtils.readFile(file1.getAbsolutePath());

        Assert.assertEquals(text, text2);
        file1.deleteOnExit();
        file.deleteOnExit();
    }
}
