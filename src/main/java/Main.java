import cli.InitialCli;
import com.fasterxml.jackson.databind.ObjectMapper;
import database.DatabaseConnection;
import freeagent.FreeAgentPersistent;
import league.LeaguePersistent;
import statemachine.StateMachine;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {
//        obj.initializedCommunication("D:\\JsonRead\\SampleJSON1.json");
        //SampleJSON1
        StateMachine stateMachine = new StateMachine();
        stateMachine.entry();
    }

}
