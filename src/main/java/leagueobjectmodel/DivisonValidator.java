package leagueobjectmodel;

public class DivisonValidator implements IDivisonValidator {

    private static final ITeamsValidator teamsValidator = new TeamsValidator();

    @Override
    public boolean validateDivisionObject(IDivisonModel divisonModel) {
        if (divisonModel.getDivisionName() == "" || divisonModel.getDivisionName() == null) {
            return false;
        } else {
            for (TeamsModel teamsModel : divisonModel.getTeams()) {
                if (teamsValidator.validateTeamObject(teamsModel)) {
                    continue;
                } else {
                    System.out.println("Encountered Problem While validating Teams in Division ==> " + divisonModel.getDivisionName());
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isDivisionExist(ILeagueModel leagueModel, String divisionName) {
        for (ConferenceModel conferenceModel : leagueModel.getConferences()) {
            for (DivisonModel divisonModel : conferenceModel.getDivisions()) {
                if (divisonModel.getDivisionName().equalsIgnoreCase(divisionName)) {
                    return true;
                }
            }
        }

        return false;
    }
}