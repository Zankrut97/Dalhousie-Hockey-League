package statemachine.states.statemachine.states;


import leagueobjectmodel.IPlayerModel;
import leagueobjectmodel.PlayerModel;
import org.apache.log4j.Logger;
import statemachine.states.statemachine.StateMachine;
import leagueobjectmodel.*;
import java.time.LocalDate;

public class InjuryCheckState implements ITransition {
    StateMachine stateMachine;
    ILeagueModel leagueModel;
    ITeamsModel teamsModel;
    LocalDate currentDate;
    IPlayerModel playerModel;
    final static Logger logger = Logger.getLogger(InjuryCheckState.class);
    public InjuryCheckState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public void updateInjuryCheckStateValue(StateMachine stateMachine, ILeagueModel leagueModel, ITeamsModel teamsModel){
        if(stateMachine==null || leagueModel==null || teamsModel==null){
            logger.error("Variables not intialized properly in the injury check state");
            throw new NullPointerException("Variables not intialized properly in the injury check state");
        }
        else {
            this.stateMachine = stateMachine;
            this.leagueModel = leagueModel;
            this.teamsModel = teamsModel;
            currentDate = stateMachine.getCurrentDate();
        }

    }

    @Override
    public void entry() {
        task();
    }

    @Override
    public void task() {
        playerModel =LeagueObjectModelAbstractFactory.getInstance().getPlayer();
        playerModel.setInjuriesModel(leagueModel.getGameplayConfig().getInjuries());
        for (PlayerModel playerModel : teamsModel.getPlayers()) {
            playerModel.setInjuriesModel(leagueModel.getGameplayConfig().getInjuries());
            playerModel.checkPlayerInjury(playerModel, currentDate);
            teamsModel.roasterReplacement(playerModel);
        }
    }

    @Override
    public void exit() {
        LeagueObjectModelAbstractFactory.getInstance().setPlayer(null);
    }
}
