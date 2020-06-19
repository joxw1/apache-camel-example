import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

  public static final String SOURCE_FOLDER = "D:\\Temp\\source";
  public static final String TARGET_FOLDER = "D:\\Temp\\target";

  /**
   * Essentially, a Route is an instruction to Camel on how messages should move from one point to another.
   * In this example, we create a SimpleRouteBuilder class that can move files from SOURCE_FOLDER to TARGET_FOLDER
   */
  @Override
  public void configure() throws Exception {
    from("file:" + SOURCE_FOLDER).to("file:" + TARGET_FOLDER);
  }
}
