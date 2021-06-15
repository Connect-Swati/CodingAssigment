package design.feature;

import javax.script.ScriptException;
import org.junit.jupiter.api.Test;

class StartProgramTest {

    @Test
    void mainTest() throws ScriptException {
        String[] args = {};
        StartProgram.main(args);
    }

    @Test
    void createUserAttributeTableTest() {
        StartProgram sp = new StartProgram();
        sp.createUserAttributeTable();
    }

    @Test
    void takenUserInputTest() {
        StartProgram sp = new StartProgram();
        sp.takenUserInput();
    }
}