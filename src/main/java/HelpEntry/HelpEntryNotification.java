package HelpEntry;

import com.intellij.notification.*;
import com.intellij.openapi.project.Project;

public class HelpEntryNotification extends Notification{

    public static final NotificationGroup GROUP_DISPLAY_ID_INFO =
            new NotificationGroup("Show current time group",
                    NotificationDisplayType.BALLOON, true);

    public HelpEntryNotification(Project currentProject, String message){
        super( GROUP_DISPLAY_ID_INFO.getDisplayId(),
                "Current Time",
                message,
                NotificationType.INFORMATION);
    }
}
