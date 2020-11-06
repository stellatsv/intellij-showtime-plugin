package HelpEntry;

import com.intellij.notification.*;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelpEntryAction extends AnAction {
    private static final Logger logger = LoggerFactory.getLogger(HelpEntryAction.class);
    public static final NotificationGroup GROUP_DISPLAY_ID_INFO =
            new NotificationGroup("Show current time group",
                    NotificationDisplayType.BALLOON, true);
    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        Project currentProject = event.getProject();
        StringBuilder timeMessage = new StringBuilder("The current time is: ");
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        timeMessage.append(dateFormat.format(new Date()));
        Notification notification = GROUP_DISPLAY_ID_INFO.createNotification(timeMessage.toString(), NotificationType.INFORMATION);
        Notifications.Bus.notify(notification, currentProject);
        //if there is already one such window, close it/update it!
    }

    public HelpEntryAction() {
    }

    public HelpEntryAction(@Nullable String text, @Nullable String description, @Nullable Icon icon) {
        super(text, description, icon);
    }
}