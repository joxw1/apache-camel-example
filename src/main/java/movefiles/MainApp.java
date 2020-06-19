package movefiles;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class MainApp {

  public static final int MINUTE = 60 * 1000;

  /**
   * When Camel is started, it uses this to create a CamelContext object that contains the definition of the Route to be started.
   */
  public static void main(final String[] args) {
    final SimpleRouteBuilder routeBuilder = new SimpleRouteBuilder();
    final CamelContext context = new DefaultCamelContext();
    try {
      context.addRoutes(routeBuilder);
      context.start();
      Thread.sleep(10 * MINUTE);
      context.stop();
    } catch (final InterruptedException e) {
      e.printStackTrace();
    } catch (final Exception e) {
      e.printStackTrace();
    }
  }
}
