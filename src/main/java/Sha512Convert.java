import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import hash.SHA2;

/**
 * SHA-512 Convert
 */
public class Sha512Convert extends AnAction {

    /**
     * @param e AnActionEvent
     */
    @Override
    public void actionPerformed(AnActionEvent e) {
        Editor editor = e.getData(PlatformDataKeys.EDITOR);
        String selectedText = editor.getSelectionModel().getSelectedText();

        String sb = SHA2.getSHA512(selectedText);

        Notifications.Bus.notify(
                new Notification("hash converter", "convert sha512", sb, NotificationType.INFORMATION)
        );
    }
}
