package config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
  "system:properties",
  "classpath:${env}.properties"
})
public interface WebConfig extends Config {

  @Key("browser")
  @DefaultValue("chrome")
  String getBrowser();

  @Key("browserVersion")
  @DefaultValue("${latest.browser.version}")
  String getBrowserVersion();

  @Key("browserSize")
  @DefaultValue("1920x1080")
  String getBrowserSize();

  @Key("baseUrl")
  @DefaultValue("https://portal-da.ru/")
  String getBaseUrl();

  @Key("remoteUrl")
  @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
  URL getRemoteUrl();

  @Key("isRemote")
  @DefaultValue("false")
  boolean isRemote();
}