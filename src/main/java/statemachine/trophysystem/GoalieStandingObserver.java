package statemachine.trophysystem;

import cli.ICli;
import leagueobjectmodel.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.*;
import java.util.stream.Collectors;

public class GoalieStandingObserver implements IObserver{

    private HashMap<Integer, PlayerModel> goalieWinners = new HashMap<>();

    @Override
    public void update(ILeagueModel leagueModel, int year) {
        List<PlayerModel> bestGoalieOfEachTeam = new ArrayList<>();
        for(ConferenceModel conference : leagueModel.getConferences()){
            for(DivisonModel division : conference.getDivisions()) {
                for (TeamsModel team : division.getTeams()) {
                    bestGoalieOfEachTeam.add(Collections.max(team.getPlayers().stream()
                            .filter(l -> l.getPosition().equals(PlayerPosition.GOALIE.toString()))
                            .collect(Collectors.toList()), Comparator.comparing(PlayerModel::getSaveForGoalie)));
                }
            }
        }
        goalieWinners.put(year, Collections.max(bestGoalieOfEachTeam,Comparator
                .comparing(PlayerModel::getSaveForGoalie)));
    }

    @Override
    public void getHistoryOfWinners(ICli display){
        SortedSet<Integer> years = new TreeSet<>(goalieWinners.keySet()).descendingSet();
        display.printOutput(TrophySystemConstants.LineSeperator.getValue() + TrophySystemConstants.LineSpace.getValue() +
                TrophySystemConstants.GoalieTrophy.getValue() + TrophySystemConstants.LineSpace.getValue()
                + TrophySystemConstants.LineSeperator.getValue());
        for(Integer currentYear: years){
            display.printOutput(TrophySystemConstants.Year.getValue() + currentYear
                    + TrophySystemConstants.Winner.getValue() +goalieWinners.get(currentYear).getPlayerName()
                    + TrophySystemConstants.LineSpace.getValue());
        }
    }
}
