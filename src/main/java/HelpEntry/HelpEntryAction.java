package HelpEntry;

import com.intellij.notification.*;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
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

    @NotNull
    private Notifier notifier = Notifications.Bus::notify;

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        Project currentProject = event.getProject();
        StringBuilder timeMessage = new StringBuilder("The current time is: ");
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        timeMessage.append(dateFormat.format(new Date()));
        Notification helpEntryNotification = new HelpEntryNotification(timeMessage.toString());
        notifier.notify(helpEntryNotification, currentProject);
    }

    public HelpEntryAction() {    }

    public HelpEntryAction(@Nullable String text, @Nullable String description, @Nullable Icon icon) {
        super(text, description, icon);
    }

    public void setNotifier(Notifier notifier){
        this.notifier = notifier;
    }
}