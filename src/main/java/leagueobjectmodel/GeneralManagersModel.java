package leagueobjectmodel;

public class GeneralManagersModel implements IGeneralManagersModel {
    private String name;
    private String personality;

    public GeneralManagersModel() {
    }

    public GeneralManagersModel(String name, String personality) {
        this.name = name;
        this.personality = personality;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPersonality() {
        return personality;
    }

    @Override
    public void setPersonality(String personality) {
        this.personality = personality;
    }
}
