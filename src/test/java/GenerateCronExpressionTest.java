import org.junit.Test;
import so.dev.practice.extra.model.GenerateCronExpression;

import static org.junit.Assert.assertEquals;

/**
 * Created by melvin on 2016. 5. 10..
 */
public class GenerateCronExpressionTest {

    /**
     * Generate a CRON expression is a string comprising 6 or 7 fields separated by white space.
     *
     * @param seconds    mandatory = yes. allowed values = {@code  0-59    * / , -}
     * @param minutes    mandatory = yes. allowed values = {@code  0-59    * / , -}
     * @param hours      mandatory = yes. allowed values = {@code 0-23   * / , -}
     * @param dayOfMonth mandatory = yes. allowed values = {@code 1-31  * / , - ? L W}
     * @param month      mandatory = yes. allowed values = {@code 1-12 or JAN-DEC    * / , -}
     * @param dayOfWeek  mandatory = yes. allowed values = {@code 0-6 or SUN-SAT * / , - ? L #}
     * @param year       mandatory = no. allowed values = {@code 1970–2099    * / , -}
     * @return a CRON Formatted String.
     */

    @Test
    public void test() throws Exception {

        String cronFormat = GenerateCronExpression.generateCronExpression("0","0","0","0","0","0","0");
        System.out.println(cronFormat);

        assertEquals("0 0 0 0 0 0 0",cronFormat);
    }

    @Test
    public void cronTest() throws Exception {
        String cronFormat = GenerateCronExpression.generateCronExpression("50","30","4","12","1","3","1988");
        System.out.println(cronFormat);
    }

}
