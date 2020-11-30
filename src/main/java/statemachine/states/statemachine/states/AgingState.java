package statemachine.states.statemachine.states;


import leagueobjectmodel.ConferenceModel;
import leagueobjectmodel.DivisonModel;
import leagueobjectmodel.GamePlayConfigModel;
import statemachine.states.statemachine.states.matchSchedules.IDeadlines;
import leagueobjectmodel.IPlayerModel;
import leagueobjectmodel.PlayerModel;
import statemachine.states.statemachine.StateMachine;
import leagueobjectmodel.TeamsModel;
import statemachine.states.statemachine.states.matchSchedules.MatchScheduleAbstractFactory;
import leagueobjectmodel.*;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class AgingState implements ITransition {

    IDeadlines iDeadlines;
    StateMachine stateMachine;
    ILeagueModel leagueModel;
    LocalDate currentDate;
    IPlayerModel iPlayerModel;
   IFreeAgentModel iFreeAgentModel;
    private int daysToAge;
    private final int DAYS_TO_AGE_AFTER_SEASON_ENDS=183;


    public AgingState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }
//
//    public AgingState(StateMachine stateMachine, LeagueModel leagueModel) {
//        this.stateMachine = stateMachine;
//        this.leagueModel = leagueModel;
//        iDeadlines = new Deadlines();
//    }

     public void updateAgingStateValue(StateMachine stateMachine, ILeagueModel leagueModel){
         this.stateMachine = stateMachine;
         this.leagueModel = leagueModel;
         iDeadlines = MatchScheduleAbstractFactory.getMatchScheduleInstance().getDeadline();
    }

    @Override
    public void entry() {
        task();
    }

    @Override
    public void task() {
        ISortTeams sortTeams = new SortTeams();
        iPlayerModel = LeagueObjectModelAbstractFactory.getInstance().getPlayer();
        iFreeAgentModel = LeagueObjectModelAbstractFactory.getInstance().getFreeAgentModel();
        daysToAge = 1;
        currentDate = stateMachine.getCurrentDate();
        int currentYear = currentDate.getYear();
        long tempDays = DAYS.between(currentDate, iDeadlines.getEndOfRegularSeasonDate(currentYear));
        System.out.println(tempDays);
        if (tempDays == 1) {
            daysToAge = DAYS_TO_AGE_AFTER_SEASON_ENDS;
        }
        GamePlayConfigModel gamePlayConfigModel = leagueModel.getGameplayConfig();
        System.out.println(gamePlayConfigModel.getAging().getMaximumAge());
        iPlayerModel.setAgingModel(gamePlayConfigModel.getAging());
        iPlayerModel.setFreeAgentsList(leagueModel.getFreeAgents());
        System.out.println(gamePlayConfigModel.getAging());
        System.out.println(iFreeAgentModel);
        iFreeAgentModel.setAgingModel(gamePlayConfigModel.getAging());
        System.out.println(gamePlayConfigModel.getAging());
        for(IFreeAgentModel freeAgent : leagueModel.getFreeAgents()){
            iFreeAgentModel.aging(freeAgent,currentDate,daysToAge);
        }
        for (ConferenceModel conferenceModel : leagueModel.getConferences()) {
            for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
                for (TeamsModel teamsModel : divisonModel.getTeams()) {
                    for (PlayerModel playerModelTemp : teamsModel.getPlayers()) {
                        iPlayerModel.aging(playerModelTemp, daysToAge, currentDate);
                    }
                    sortTeams.sortActiveRoasters(teamsModel.getPlayers());
                }
            }
        }
    }

    @Override
    public void exit() {

    }

}
