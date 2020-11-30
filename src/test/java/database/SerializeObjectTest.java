package database;

import LeagueMockObject.MockLeagueAbstractFactory;
import leagueobjectmodel.ILeagueModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SerializeObjectTest {
    @Test
    void serializeLeagueObjectTest() {
        ILeagueModel leagueModel = MockLeagueAbstractFactory.getMockInstance().createLeague();
        ISerializeObject serializeObject = SerializeObjectAbstractFactory.instance().createSerializeObject();
        assertTrue(serializeObject.serializeLeagueObject(leagueModel,"testedteam"));
    }
}
