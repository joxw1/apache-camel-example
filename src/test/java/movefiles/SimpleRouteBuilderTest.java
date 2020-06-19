package movefiles;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.io.Files;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class SimpleRouteBuilderTest {

  public static final int SECOND = 1000;

  @Rule
  public TemporaryFolder folder = new TemporaryFolder();
  private File sourceFolder;
  private File targetFolder;

  @Before
  public void setUp() throws IOException {
    sourceFolder = folder.newFolder();
    targetFolder = folder.newFolder();
  }

  @Test
  public void moveFileFromSourceToTarget() throws Exception {
    final SimpleRouteBuilder routeBuilder = new SimpleRouteBuilder();
    routeBuilder.setSourceFolder(sourceFolder.getAbsolutePath());
    final File fileOne = new File(sourceFolder, "one.dat");
    Files.asCharSink(fileOne, StandardCharsets.UTF_8).write("fileOne");
    routeBuilder.setTargetFolder(targetFolder.getAbsolutePath());
    startContext(routeBuilder);
    assertThat(targetFolder.list()).hasSize(1);
    assertThat(targetFolder.list()).contains("one.dat");
    assertThat(Objects.requireNonNull(targetFolder.listFiles())[0]).hasContent("fileOne");
  }

  /**
   * When Camel is started, it uses this to create a CamelContext object
   * that contains the definition of the Route to be started.
   */
  private void startContext(final SimpleRouteBuilder routeBuilder) throws Exception {
    final CamelContext context = new DefaultCamelContext();
    context.addRoutes(routeBuilder);
    context.start();
    Thread.sleep(2 * SECOND);
    context.stop();
  }
}