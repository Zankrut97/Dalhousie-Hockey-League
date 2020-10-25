package statemachine;

import states.*;

public class StateMachine {
    ITransition importJson;
    ITransition playerTeamChoice;
    ITransition loadTeam;
    ITransition createTeam;
    ITransition playerSeasonsChoice;
    ITransition currentState;
    ITransition persistLeagueState;
    ITransition trainingState;
    ITransition simulateGameState;
    ITransition initlailizeSeasonState;

    public StateMachine() {

        System.out.println("Object of state machine is created " + this);
        importJson = new ImportJsonState(this);
        System.out.println("Object of ImportJsonState is created " + importJson);
        playerTeamChoice = new PlayerTeamChoiceState(this);
        System.out.println("Object of PlayerTeamChoiceState is created " + playerTeamChoice);
        loadTeam = new LoadTeamState(this);
        System.out.println("Object of LoadTeamState is created " + loadTeam);
        createTeam = new CreateTeamState(this);
        System.out.println("Object of CreateTeamState is created " + createTeam);
        playerSeasonsChoice = new PlayerSeasonsChoiceState(this);
        System.out.println("Object of PlayerSeasonsChoiceState id created " + playerSeasonsChoice);
        persistLeagueState = new PersistLeagueState(this);
        initlailizeSeasonState = new InitializeSeasonState(this);
        trainingState = new TrainingState(this);
        simulateGameState = new SimulateGameState(this);
    }

    //List of Getters and setters
    public ITransition getPersistLeagueState() {
        return persistLeagueState;
    }

    public void setPersistLeagueState(ITransition persistLeagueState) {
        this.persistLeagueState = persistLeagueState;
    }

    public ITransition getTrainingState() {
        return trainingState;
    }

    public void setTrainingState(ITransition trainingState) {
        this.trainingState = trainingState;
    }

    public ITransition getSimulateGameState() {
        return simulateGameState;
    }

    public void setSimulateGameState(ITransition simulateGameState) {
        this.simulateGameState = simulateGameState;
    }

    public ITransition getImportJson() {
        return importJson;
    }

    public void setImportJson(ITransition importJson) {
        this.importJson = importJson;
    }

    public ITransition getPlayerTeamChoice() {
        return playerTeamChoice;
    }

    public void setPlayerTeamChoice(ITransition playerTeamChoice) {
        this.playerTeamChoice = playerTeamChoice;
    }

    public ITransition getLoadTeam() {
        return loadTeam;
    }

    public void setLoadTeam(ITransition loadTeam) {
        this.loadTeam = loadTeam;
    }

    public ITransition getCreateTeam() {
        return createTeam;
    }

    public void setCreateTeam(ITransition createTeam) {
        this.createTeam = createTeam;
    }


    public ITransition getPersistLeagueStae() {
        return persistLeagueState;
    }

    public void setPersistLeagueStae(ITransition persistLeagueStae) {
        this.persistLeagueState = persistLeagueStae;
    }

    public ITransition getPlayerSeasonsChoice() {
        return playerSeasonsChoice;
    }

    public void setPlayerSeasonsChoice(ITransition playerSeasonsChoice) {
        this.playerSeasonsChoice = playerSeasonsChoice;
    }
//
//    public ITransition getSimulate() {
//        return simulate;
//    }
//
//    public void setSimulate(ITransition simulate) {
//        this.simulate = simulate;
//    }

    public ITransition getCurrentState() {
        return currentState;
    }

    public void setCurrentState(ITransition newState) {
        currentState = newState;
    }

    public void entry() {
        currentState.entry();
    }

    public void task() {
        currentState.task();
    }

    public void exit() {
        currentState.exit();
    }

    public ITransition fileImported() {
        return playerTeamChoice;
    }

    public ITransition playerChoiceLoadTeam() {
        return loadTeam;
    }

    public ITransition playerChoiceCreateTeam() {
        return createTeam;
    }

    public ITransition teamLoaded() {
        return playerSeasonsChoice;
    }

    public ITransition newTeamCreated() {
        return playerSeasonsChoice;
    }


    public void setInitlailizeSeasonState(ITransition initlailizeSeasonState) {
        this.initlailizeSeasonState = initlailizeSeasonState;
    }

    public ITransition getInitlailizeSeasonState() {
        return initlailizeSeasonState;
    }

}
