package statemachine.states.statemachine.statesTest;

import leagueobjectmodel.*;
import statemachine.states.statemachine.StateMachine;
import statemachine.states.statemachine.states.AgingState;
import trade.MockLeague;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgingStateTest {


//    @Test
//    void entry() {
//        StateMachine stateMachine = new StateMachine();
//        stateMachine.setCurrentDate(LocalDate.now());
//        LeagueModel leagueModel = MockLeague.getLeagueObject();
//        AgingState agingState = new AgingState(stateMachine, leagueModel);
//        agingState.entry();
//        for (ConferenceModel conferenceModel : leagueModel.getConferences()) {
//            for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
//                for (TeamsModel teamsModel : divisonModel.getTeams()) {
//                    for (PlayerModel playerModel : teamsModel.getPlayers()) {
//                        assertEquals(1, playerModel.getDays());
//                    }
//                }
//            }
//        }
//    }

}