package movefiles;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

  public String sourceFolder = "D:\\Temp\\source";
  public String targetFolder = "D:\\Temp\\target";

  /**
   * Essentially, a Route is an instruction to Camel on how messages should move from one point to another.
   * In this example, we create a movefiles.SimpleRouteBuilder class that can move files from SOURCE_FOLDER to TARGET_FOLDER
   */
  @Override
  public void configure() throws Exception {
    from("file:" + sourceFolder).to("file:" + targetFolder);
  }

  public void setSourceFolder(final String sourceFolder) {
    this.sourceFolder = sourceFolder;
  }

  public void setTargetFolder(final String targetFolder) {
    this.targetFolder = targetFolder;
  }
}
