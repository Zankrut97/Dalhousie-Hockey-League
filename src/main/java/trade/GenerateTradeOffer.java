package trade;

import conference.ConferenceModel;
import divison.DivisonModel;
import gameplayconfig.GamePlayConfigModel;
import gameplayconfig.TradingModel;
import league.LeagueModel;
import teams.TeamsModel;


public class GenerateTradeOffer implements IGenerateTradeOffer {
    ITradeTeamPojo tradingTeamDetails = new TradeTeamPojo ();
    IFindPlayerToSwap tradePlayers = new FindPlayerToSwap ();

    public boolean calculateLossPoint(float lossMatches, TradingModel tradeModel) {
        float lossPoint = tradeModel.getLossPoint ();
        if (lossMatches >= lossPoint) {
            return true;
        } else {
            return false;
        }
    }


    public boolean makeTradeOffer(TradingModel tradeModel) {
        float tradeChance = tradeModel.getRandomTradeOfferChance ();
        //if (Math.random () < tradeChance) {
        if (0.01f < tradeChance) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public LeagueModel checkTrading(LeagueModel leagueModel) {
        GamePlayConfigModel gameConfig = leagueModel.getGameplayConfig ();
        TradingModel tradeModel = gameConfig.getTrading ();
        if (leagueModel == null) {
            System.out.println ("League Model is null");
            return leagueModel;
        } else {
            for (ConferenceModel conference : leagueModel.getConferences ()) {
                String conferenceName = conference.getConferenceName ();
                for (DivisonModel division : conference.getDivisions ()) {
                    String divisionName = division.getDivisionName ();
                    for (TeamsModel team : division.getTeams ()) {
                        String teamName = team.getTeamName ();
                        if (team.isUserCreatedTeam () == false) {
                            //Uncomment the below statement
                            //float lossPoint = team.getLossPoint ();
                            float lossPoint = 9;
                            if (calculateLossPoint (lossPoint, tradeModel)) {
                                if (makeTradeOffer (tradeModel)) {
                                    //set the tradeloss point to zero here
                                    System.out.println ("Trade initiated by team:" + " " + teamName);
                                    tradingTeamDetails.setConferenceName (conferenceName);
                                    tradingTeamDetails.setDivisionName (divisionName);
                                    tradingTeamDetails.setTeamName (teamName);
                                    tradingTeamDetails.setUserCreated (false);
                                    tradePlayers.findPlayersToSwap (leagueModel, team, tradingTeamDetails);
                                }
                            }
                        }
                    }
                }
            }
            return leagueModel;
        }
    }

}



