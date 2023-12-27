/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.androidauto.target;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.androidauto.target.AndroidAutoTarget;
import de.vw.mib.popup.PopupInformationHandler;

public class PopupHandler
implements PopupInformationHandler {
    private AndroidAutoTarget target;

    public PopupHandler(AndroidAutoTarget androidAutoTarget) {
        this.target = androidAutoTarget;
    }

    @Override
    public void onPopupInformationChanged(int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("PopupHandler::onPopupInformationChanged - popupInfo = ").append(n).toString());
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(862399488, n == 2);
    }
}

