package frontend;

import frontend.action.ImportAction;
import frontend.action.LoginAction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class ImportTest extends BaseTest {


    @Test
    public void importTransactions(){
        loginAction.auth();
        importAction
                .open()
                .selectFile()
                .setColumnType()
                .deleteRecord(3)
                .deleteRecord(2)
                .setBudget(0, "Income", "Dividends")
                .submitData()
                .checkResult("Success");
    }





    @Autowired private LoginAction loginAction;
    @Autowired private ImportAction importAction;
}
