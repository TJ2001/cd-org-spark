import org.junit.*;
import static org.junit.Assert.*;

public class OrganizerTest {
  @Test
  public void Organizer_instantiatesCorrectly_true() {
    Organizer myCD = new Organizer("", "", "");
    assertEquals(true, myCD instanceof Organizer);
  }
}
