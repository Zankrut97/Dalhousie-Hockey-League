package leagueobjectmodel;

import java.util.List;

public interface ITeamsModel {
    int getLossPointForTrading();

    void setLossPointForTrading(int lossPointForTrading);

    boolean isUserCreatedTeam();

    void setUserCreatedTeam(boolean userCreatedTeam);

    String getTeamName();

    void setTeamName(String teamName);

    HeadCoachModel getHeadCoach();

    void setHeadCoach(HeadCoachModel headCoach);

    void setTeamStrength(float teamStrength);

    List<PlayerModel> getPlayers();

    void setPlayers(List<PlayerModel> players);

    float getTeamStrength();

    GeneralManagersModel getGeneralManager();

    void setGeneralManager(GeneralManagersModel generalManager);

    abstract void calculateTeamStrength(ITeamsModel teamsModel);

    int getWinPoint();

    void setWinPoint(int winPoint);

    int getLossPoint();

    void setLossPoint(int lossPoint);
}