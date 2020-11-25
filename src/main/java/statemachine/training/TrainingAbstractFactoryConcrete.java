package statemachine.training;

public class TrainingAbstractFactoryConcrete extends TrainingAbstractFactory{
    private ITraining training;

    @Override
    public ITraining getTraining() {
        if(training == null){
            training = new Training();
        }
        return training;
    }

    @Override
    public void setTraining(ITraining training) {
        this.training = training;
    }
}
