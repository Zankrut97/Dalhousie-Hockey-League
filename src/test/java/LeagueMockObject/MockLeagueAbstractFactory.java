package LeagueMockObject;

import leagueobjectmodel.ILeagueModel;
import org.apache.log4j.Logger;
import statemachine.states.statemachine.states.simulateGame.GameSimulationAbstractFactory;
import statemachine.states.statemachine.states.simulateGame.GameSimulationAbstractFactoryConcrete;
import statemachine.states.statemachine.states.simulateGame.ISwapTurn;

public abstract class MockLeagueAbstractFactory  {
    private static MockLeagueAbstractFactoryConcrete instance;

    public static MockLeagueAbstractFactory getMockInstance(){
        if(instance==null){
            instance=new MockLeagueAbstractFactoryConcrete();
        }
        return instance;
    }

    public abstract ILeagueModel createLeague();

    public abstract void setLeague(ILeagueModel league);
}
