package zplayground;

import org.junit.Test;

import core.domain.step.Step;
import core.stepcreator.StepCreator;
import zplayground.repository.json.Database;

/**
 * Created by AMBER on 25.12.2016.
 */
public class Yard {

    @Test
    public void test() {
        StepCreator stepCreator = new StepCreator(Database.get());
        System.out.println("");
        System.out.println("");
        Step step = stepCreator.createStep("Mark+AA1+Page");
        step.perform();
        System.out.println("");
        Step step1 = stepCreator.createStep("Mark+CA2");
        step1.perform();
        System.out.println("");
        Step step2 = stepCreator.createStep("Mark+CA3");
        step2.perform();
    }
}
