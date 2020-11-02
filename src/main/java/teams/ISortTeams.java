package teams;

import freeagent.FreeAgentModel;
import players.PlayerModel;

import java.util.List;

public interface ISortTeams {
    List<PlayerModel> sortPlayersDescending(List<PlayerModel> players);

    List<PlayerModel> sortPlayersAscending(List<PlayerModel> players);

    List<FreeAgentModel> sortFreeAgentDescending(List<FreeAgentModel> freeagents);
}
