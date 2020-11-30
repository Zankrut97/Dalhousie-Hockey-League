package statemachine.states.playerdraft;

import leagueobjectmodel.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DraftSelectionOrder implements IDraftSelectionOrder {
    private final int NO_DRAFTS_ROUNDS = 7;
    List<ITeamsModel> teamList = new ArrayList<>();
    Comparator<ITeamsModel> teamModelComparator = new Comparator<ITeamsModel>() {
        @Override
        public int compare(ITeamsModel o1, ITeamsModel o2) {
            int teamOneWinPoint = o1.getWinPoint();
            int teamTwoWinPoint = o2.getWinPoint();
            return teamOneWinPoint - teamTwoWinPoint;
        }
    };
    private List<ITeamsModel> selectionOrderList;
    private IPlayerDraft playerDraft = PlayerDraftAbstractFactory.getInstance().createPlayerDraft();
    private ITeamsModel iTeamsModel = LeagueObjectModelAbstractFactory.getInstance().getTeams();

    @Override
    public List<ITeamsModel> getSelectionOrderList() {
        return selectionOrderList;
    }

    @Override
    public void setSelectionOrderList(List<ITeamsModel> selectionOrderList) {
        this.selectionOrderList = selectionOrderList;
    }

    @Override
    public List<ITeamsModel> getTeamStandingList(ILeagueModel leagueModel) {
        System.out.println("INSIDE TEAM STANDING LIST" + leagueModel);
        if (leagueModel == null) {
            throw new NullPointerException("Argument null in getTeamStandingList");
        }
        System.out.println("Inside Team Standing List method");
        for (IConferenceModel conferenceModel : leagueModel.getConferences()) {
            for (IDivisonModel divisionModel : conferenceModel.getDivisions()) {
                List<ITeamsModel> teams = divisionModel.getTeams();
                Collections.sort(teams, teamModelComparator);
                for (int i = 0; i < teams.size(); i++) {
                    teamList.add(teams.get(i));
                }
            }
        }
        return teamList;
    }

    @Override
    public void draftingRounds(List<IPlayerModel> newDraftedPlayers) {
        for (int i = 0; i < newDraftedPlayers.size(); i++) {
            System.out.println(newDraftedPlayers.get(i).getPlayerName() + " --  " + newDraftedPlayers.get(i).getPlayerStrength());
        }
        for (int i = 1; i <= NO_DRAFTS_ROUNDS; i++) {
            System.out.println("Drafting Round -- " + i);
            for (int j = 0; j < teamList.size(); j++) {
                System.out.println("Inside Team drafting rounds -- " + teamList.get(j).getTeamName());
                IPlayerModel bestPlayer = Collections.max(newDraftedPlayers, Comparator.comparing(f -> f.getPlayerStrength()));
                System.out.println("Best Player" + bestPlayer.getPlayerName());
                teamList.get(j).addDrafterPlayerToTeam(bestPlayer);
                newDraftedPlayers.remove(bestPlayer);
            }
        }
        for (int i = 0; i < teamList.size(); i++) {
            teamList.get(i).resolveRoostersToThirty();
        }
    }


}
