package ertanAppiumDemo;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import driver.Driver;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;


public class StepImplementation extends Driver {

    @Step("Username alanına tıklanır")
    public void clickSearch() {
        MobileElement elementUserName = (MobileElement) appiumDriver.findElementById("usernameEditText");
        elementUserName.click();
    }

    @Step("Username alanına <key> değeri girilir.")
    public void Search(String key) {
        MobileElement sendUserName = (MobileElement) appiumDriver.findElementById("usernameEditText");
        sendUserName.sendKeys(key);
    }

    @Step("Lastname alanına tıklanır.")
    public void clickSearch() {
        MobileElement elementLastName = (MobileElement) appiumDriver.findElementById("passwordEditText");
        elementLastName.click();
    }

    @Step("Lastname alanına <key> değeri girilir.")
    public void Search(String key) {
        MobileElement sendUserName = (MobileElement) appiumDriver.findElementById("passwordEditText");
        sendUserName.sendKeys(key);
    }

    @Step("Login butonuna tıklanır.")
    public void clickSearch() {
        MobileElement elementLogin = MobileElement)appiumDriver.findElementById("loginButton");
        elementLogin.click();
    }

    @Step("Hesap butonuna tıklanır.")
    public void clickSearch() {
        MobileElement elementUser = MobileElement)appiumDriver.findElementById("ga_toolbar_leftIconImageView");
        elementUser.click();
    }

    @Step("Logout butonuna tıklanır.")
    public void clickSearch() {
        MobileElement elementLogOut = MobileElement)appiumDriver.findElementByXPath("/android.widget.TextView");
        elementLogOut.click();
    }

    @Step("Ekran görüntüsü al ve <pictureName> ismiyle kaydet.")
    public void takesScreenshot(String pictureName) throws IOException {
        String fileName = "images/" + (pictureName) + ".png";
        File file = new File("reports/html-report/" + fileName);
        if (file.exists()) {
            file.delete();
        }
        File scrFile = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, file);
        Gauge.writeMessage("<img src='../" + fileName + "' width='800' height='450'");

    }

    @Step("<key> adresine e-posta gönderilir.")
    public void sendEmail(String key) throws EmailException {
        System.out.println("E-posta metodu calismaya basliyor.");
        Email email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(456);
        email.setAuthenticator(new DefaultAuthenticator("getir@gmail.com",'hellogetir1'));
        email.setSSLOnConnect(true);
        email.setFrom("getir@gmail.com");
        email.setSubject("Appium test raporu");
        email.setMsg("merhaba, bu e-posta otomatik gonderilmistir.");
        email.addTo(key);
        email.send();
        System.out.println("E-posta gönderildi.");
    }



}




