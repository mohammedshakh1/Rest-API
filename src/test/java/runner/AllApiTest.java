package runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import post.CreateIssueTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        CreateIssueTest.class/*,
        CreateIssueTest2.class,*/
})
public class AllApiTest {
}
