package statemachine.states.statemachine.states;

public interface ITransition {
    void entry() throws Exception;

    void task() throws Exception;

    void exit() throws Exception;
}
