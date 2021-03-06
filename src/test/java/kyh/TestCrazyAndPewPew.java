package kyh;
import static org.junit.Assert.assertTrue;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import robocode.BattleResults;
import robocode.control.events.BattleCompletedEvent;
import robocode.control.testing.RobotTestBed;

/**
 * Test class for the {@link PewPew} class for robocode.
 * 
 * @author Keone Hiraide
 *
 */
@RunWith(JUnit4.class)
public class TestCrazyAndPewPew extends RobotTestBed {
  /**
   * The names of the robots that want battling is specified.
   * @return The names of the robots we want battling.
   */
  @Override
  public String getRobotNames() {
    return "sample.Crazy, kyh.PewPew";
  }
  
  /**
   * Pick the amount of rounds that we want our robots to battle for.
   * 
   * @return Amount of rounds we want to battle for.
   */
  @Override
  public int getNumRounds() {
    return 10;
  }
  
  /**
   * Tests to see if our robot won all rounds.
   * @param event Holds information about the battle has been completed.
   */
  @Override
  public void onBattleCompleted(BattleCompletedEvent event) {
    // Return the results in order of getRobotNames.
    BattleResults[] battleResults = event.getIndexedResults();
    // Sanity check that results[0] is PewPew.
    BattleResults pewpewResults = battleResults[0];
    // Check to make sure PewPew won at least won over half the rounds.
    assertTrue("Check PewPew winner", getNumRounds() / 5 < pewpewResults.getFirsts());
  }
}
