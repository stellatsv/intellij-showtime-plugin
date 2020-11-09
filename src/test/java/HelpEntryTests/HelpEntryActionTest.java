package HelpEntryTests;

import HelpEntry.HelpEntryAction;
import HelpEntry.HelpEntryNotification;
import HelpEntry.Notifier;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class HelpEntryActionTest {

    AnActionEvent event;
    HelpEntryAction action;
    Project currentProject;
    Notifier notifier;

    @Before
    public void setUp(){
        currentProject = mock(Project.class);
        event = mock(AnActionEvent.class);
        doReturn(currentProject).when(event).getProject();
        action = new HelpEntryAction();
        notifier = mock(Notifier.class);
        action.setNotifier(notifier);
    }
    @Test
    public void testHelpEntryAction() {
        action.actionPerformed(event);
        ArgumentCaptor<HelpEntryNotification> notificationArg
                = ArgumentCaptor.forClass(HelpEntryNotification.class);
        verify(notifier).notify(notificationArg.capture(), eq(currentProject));
        HelpEntryNotification notification = notificationArg.getValue();
        assertEquals("Current Time", notification.getTitle());
        assertTrue(notification.getContent().matches("The current time is: [0-9][0-9]:[0-9][0-9]:[0-9][0-9]"));
    }
}
