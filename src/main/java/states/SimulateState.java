package states;

import statemachine.NestedSimulator;
import statemachine.StateMachine;
import states.ITransition;

public class SimulateState implements ITransition {
    StateMachine stateMachine;
    NestedSimulator nestedSimulator;

    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public NestedSimulator getNestedSimulator() {
        return nestedSimulator;
    }

    public void setNestedSimulator(NestedSimulator nestedSimulator) {
        this.nestedSimulator = nestedSimulator;
    }

    public SimulateState(StateMachine newStateMachine){
        stateMachine = newStateMachine;
    }

    @Override
    public void entry() {

        nestedSimulator = new NestedSimulator();
    }

    @Override
    public void task() {

    }

    @Override
    public void exit() {

    }
}