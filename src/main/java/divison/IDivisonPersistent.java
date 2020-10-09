package divison;

public interface IDivisonPersistent {

    public int addDivisionInformation(String divisionName, int conferenceId);

    boolean isDivisionAlreadyExist(String divisionName, int conferenceId);

    int getDivisionInformation(String divisionName, int conferenceId);
}
