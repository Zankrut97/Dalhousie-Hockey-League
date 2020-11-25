package leagueobjectmodel;

import leagueobjectmodel.AgingModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgingModelTest {

    @Test
    void getAverageRetirementAge() {
        AgingModel agingModel = new AgingModel();
        agingModel.setAverageRetirementAge(40);
        assertEquals(40, agingModel.getAverageRetirementAge(), "Failed to get avg retirement age in Aging object");
    }

    @Test
    void setAverageRetirementAge() {
        AgingModel agingModel = new AgingModel();
        agingModel.setAverageRetirementAge(35);
        assertEquals(35, agingModel.getAverageRetirementAge(), "Failed to set avg retirement age in Aging object");
    }

    @Test
    void getMaximumAge() {
        AgingModel agingModel = new AgingModel();
        agingModel.setMaximumAge(50);
        assertEquals(50, agingModel.getMaximumAge(), "Failed to get maximum age retirement age in Aging object");
    }

    @Test
    void setMaximumAge() {
        AgingModel agingModel = new AgingModel();
        agingModel.setMaximumAge(50);
        assertEquals(50, agingModel.getMaximumAge(), "Failed to set maximum age retirement age in Aging object");
    }

    public static AgingModel getAgingModel(int averageRetirementAge, int maximumAge) {
        AgingModel agingModel = new AgingModel();
        agingModel.setAverageRetirementAge(averageRetirementAge);
        agingModel.setMaximumAge(maximumAge);
        return agingModel;
    }
}