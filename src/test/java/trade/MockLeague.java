package trade;

import conference.ConferenceModel;
import divison.DivisonModel;
import gameplayconfig.GamePlayConfigModel;
import gameplayconfig.TradingModel;
import league.LeagueModel;
import players.PlayerModel;
import teams.HeadCoachModel;
import teams.TeamsModel;
import teams.TeamsModelTest;

import java.util.ArrayList;
import java.util.List;


public class MockLeague {

    public LeagueModel getLeagueObject() {
        LeagueModel leagueModel = new LeagueModel ();
        GamePlayConfigModel gamePLayModel = new GamePlayConfigModel ();
        TradingModel tradingModel = new TradingModel ();
        tradingModel.setLossPoint (8);
        tradingModel.setMaxPlayersPerTrade (1);
        tradingModel.setRandomAcceptanceChance (0.05f);
        tradingModel.setRandomTradeOfferChance (0.05f);

        leagueModel.setLeagueName ("Dalhousie Hockey League");
        java.util.List<ConferenceModel> conferenceModelObjectList = new ArrayList<> ();
        for (int i = 0; i < 1; i++) {
            ConferenceModel conferenceModel = getConferenceObject ();
            conferenceModelObjectList.add (conferenceModel);
        }
        leagueModel.setConferences (conferenceModelObjectList);
        leagueModel.setGameplayConfig (gamePLayModel);
        gamePLayModel.setTrading (tradingModel);
        return leagueModel;
    }

    public static ConferenceModel getConferenceObject() {
        ConferenceModel conferenceModel = new ConferenceModel ();
        conferenceModel.setConferenceName ("Eastern Conference");
        List<DivisonModel> divisionModelObjectList = new ArrayList<> ();
        for (int i = 0; i < 1; i++) {
            DivisonModel divisonModel = getDivisionObject ();
            divisionModelObjectList.add (divisonModel);
        }
        conferenceModel.setDivisions (divisionModelObjectList);
        return conferenceModel;
    }

    public static DivisonModel getDivisionObject() {
        DivisonModel divisonModel = new DivisonModel ();
        divisonModel.setDivisionName ("Atlantic");
        TeamsModelTest teamsModelTest = new TeamsModelTest ();
        List<TeamsModel> teamModelObjectList = new ArrayList<> ();

        for (int i = 0; i < 1; i++) {
            TeamsModel teamsModel = getTeamsObject1 ();
            TeamsModel teamsModel1 = getTeamsObject2 ();
            teamModelObjectList.add (teamsModel);
            teamModelObjectList.add (teamsModel1);
        }

        divisonModel.setTeams (teamModelObjectList);
        return divisonModel;
    }

    public static TeamsModel getTeamsObject1() {
        TeamsModel teamsModel = new TeamsModel ();
        HeadCoachModel headCoachModel = new HeadCoachModel ();
        headCoachModel.setName ("Mary Smith");
        headCoachModel.setSkating (0.5f);
        headCoachModel.setShooting (0.8f);
        headCoachModel.setChecking (0.3f);
        headCoachModel.setSaving (0.5f);
        teamsModel.setHeadCoach (headCoachModel);
        teamsModel.setGeneralManager ("Mister Fred");
        teamsModel.setTeamName ("Boston");
        teamsModel.setUserCreatedTeam (true);
        boolean isCaptain = true;
        String playerName = "A";
        List<PlayerModel> playerModelObjectList = new ArrayList<> ();
        for (int i = 0; i < 1; i++) {

            playerName = playerName + i;
            PlayerModel playerModel = getPlayerModel (playerName, "forward", isCaptain, 20, 10, 10, 10, 10);
            PlayerModel playerModel1 = getPlayerModel (playerName, "defense", isCaptain, 20, 13, 16, 17, 11);
            isCaptain = false;
            playerModelObjectList.add (playerModel);
            playerModelObjectList.add (playerModel1);
        }
        teamsModel.setPlayers (playerModelObjectList);
        return teamsModel;
    }

    public static TeamsModel getTeamsObject2() {
        TeamsModel teamsModel = new TeamsModel ();
        HeadCoachModel headCoachModel = new HeadCoachModel ();
        headCoachModel.setName ("Mary Smith");
        headCoachModel.setSkating (0.5f);
        headCoachModel.setShooting (0.8f);
        headCoachModel.setChecking (0.3f);
        headCoachModel.setSaving (0.5f);
        teamsModel.setHeadCoach (headCoachModel);
        teamsModel.setGeneralManager ("Mister Fred");
        teamsModel.setTeamName ("Halifax");
        teamsModel.setUserCreatedTeam (true);
        boolean isCaptain = true;
        String playerName = "C";
        List<PlayerModel> playerModelObjectList = new ArrayList<> ();
        for (int i = 0; i < 1; i++) {

            playerName = playerName + i;
            PlayerModel playerModel = getPlayerModel (playerName, "forward", isCaptain, 20, 12, 10, 11, 10);
            PlayerModel playerModel1 = getPlayerModel (playerName, "defense", isCaptain, 20, 13, 19, 7, 11);
            isCaptain = false;
            playerModelObjectList.add (playerModel);
            playerModelObjectList.add (playerModel1);
        }
        teamsModel.setPlayers (playerModelObjectList);
        return teamsModel;
    }


    public static PlayerModel getPlayerModel(String playerName, String position, boolean iscaptain, int age, float skating, float shooting, float checking, float saving) {
        PlayerModel playerModel = new PlayerModel ();
        playerModel.setCaptain (iscaptain);
        playerModel.setPlayerName (playerName);
        playerModel.setPosition (position);
        playerModel.setAge (age);
        playerModel.setSkating (skating);
        playerModel.setChecking (checking);
        playerModel.setSaving (saving);
        playerModel.calculatePlayerStrength (playerModel);
        return playerModel;
    }
}
