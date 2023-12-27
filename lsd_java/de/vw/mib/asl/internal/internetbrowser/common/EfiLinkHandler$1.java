/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.internetbrowser.common;

import de.vw.mib.asl.api.online.services.verification.CarNetPinVerificationServiceListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.internetbrowser.common.EfiLinkHandler;
import de.vw.mib.genericevents.EventGeneric;

class EfiLinkHandler$1
implements CarNetPinVerificationServiceListener {
    private final /* synthetic */ EfiLinkHandler this$0;

    EfiLinkHandler$1(EfiLinkHandler efiLinkHandler) {
        this.this$0 = efiLinkHandler;
    }

    @Override
    public void verifyCarNetPinResponse(int n) {
        if (EfiLinkHandler._target.isTraceEnabled()) {
            EfiLinkHandler._target.trace().append(this.this$0._classname).append(new StringBuffer().append("Result = ").append(n).toString()).log();
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(222185728);
        eventGeneric.setInt(1, n);
        EfiLinkHandler._target.sendSafe(eventGeneric);
        if (n == 0) {
            EfiLinkHandler.access$000(this.this$0).getHMINotifier().sendWizardStatus(true);
        }
    }
}

