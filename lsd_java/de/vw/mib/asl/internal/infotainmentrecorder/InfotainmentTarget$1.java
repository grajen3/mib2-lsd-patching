/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.infotainmentrecorder;

import de.vw.mib.asl.internal.infotainmentrecorder.InfotainmentTarget;
import de.vw.mib.desktop.DesktopDiagnosticsNotificationReceiver;
import de.vw.mib.desktop.DesktopDiagnosticsProviderService;
import de.vw.mib.genericevents.EventGeneric;

class InfotainmentTarget$1
implements DesktopDiagnosticsNotificationReceiver {
    private final /* synthetic */ DesktopDiagnosticsProviderService val$desktopDiagnosticsProviderService;
    private final /* synthetic */ InfotainmentTarget this$0;

    InfotainmentTarget$1(InfotainmentTarget infotainmentTarget, DesktopDiagnosticsProviderService desktopDiagnosticsProviderService) {
        this.this$0 = infotainmentTarget;
        this.val$desktopDiagnosticsProviderService = desktopDiagnosticsProviderService;
    }

    @Override
    public void receiveDesktopDiagnosticsNotification(int n) {
        if (n == 1) {
            EventGeneric eventGeneric = this.this$0.getEventFactory().newEvent(this.this$0.getTargetId(), this.this$0.getTargetId(), -1601830656);
            eventGeneric.setString(0, this.val$desktopDiagnosticsProviderService.getViewTreeAsShortString());
            this.this$0.sendSafe(eventGeneric);
        }
    }
}

