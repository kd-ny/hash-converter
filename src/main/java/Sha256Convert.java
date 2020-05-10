import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import hash.SHA2;

import java.security.MessageDigest;

/**
 * SHA-256 Convert
 */
public class Sha256Convert extends AnAction {

    /**
     * @param e AnActionEvent
     */
    @Override
    public void actionPerformed(AnActionEvent e) {
        Editor editor = e.getData(PlatformDataKeys.EDITOR);
        String selectedText = editor.getSelectionModel().getSelectedText();

        String sb = SHA2.getSHA256(selectedText);

        Notifications.Bus.notify(
                new Notification("hash converter", "convert sha256", sb, NotificationType.INFORMATION)
        );
    }
}
