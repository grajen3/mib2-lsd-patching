/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.filebrowser;

import de.vw.mib.asl.api.devicehandling.ASLDeviceHandlingFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.filebrowser.HsmTargetFileBrowser;
import de.vw.mib.asl.internal.filebrowser.sessions.Session;
import de.vw.mib.asl.internal.list.impl.ASLListItemSoftCacheImpl;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;

public final class StateTop
extends AbstractHsmState {
    private int transactionId;
    private final HsmTargetFileBrowser target;
    private Session vcardCountPending = null;
    private Session vcardCountQueue = null;
    private final int VCARD_COUNT_LOADING;

    StateTop(HsmTargetFileBrowser hsmTargetFileBrowser, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.VCARD_COUNT_LOADING = 0;
        this.target = hsmTargetFileBrowser;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 2: {
                this.target.register();
                this.target.getDsiFileBrowser().setFileTypeActive(true);
                ASLDeviceHandlingFactory.getDeviceHandlingApi().register(this.target.filebrowserSourcesV2);
                ListManager.getGenericASLList(424).enableWindowing(new ASLListItemSoftCacheImpl(), this.target, 10, 0);
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(1083965440);
                eventGeneric2.setInt(0, this.target.getTargetId());
                eventGeneric2.setInt(1, 11);
                eventGeneric2.setString(2, "NO_LANGUAGE");
                eventGeneric2.setString(3, "HsmFilebrowser");
                this.target.sendSafe(eventGeneric2);
                this.target.addObserver(1134297088);
                break;
            }
            case 40003: {
                this.transactionId = eventGeneric.getInt(0);
                String string = eventGeneric.getString(1);
                this.target.getDsiFileBrowser().setLanguage(string);
                break;
            }
            case 3: {
                this.trans(this.target.idleState);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void updateNumberOfVCards(Session session) {
        ServiceManager.aslPropertyManager.valueChangedInteger(3822, 0);
        if (this.vcardCountPending == null) {
            this.vcardCountPending = session;
            if (session.getDsiHandle() != -1) {
                this.target.getDsiFileBrowser().getFileCountWithFileTypeFilter(session.getDsiHandle(), 32);
                session.addRequest(1019);
            } else {
                this.dsiFileBrowserGetFileCountWithFileTypeFilterResult(-1, 0, 32, 0);
            }
        } else {
            this.vcardCountQueue = session;
        }
    }

    public void dsiFileBrowserSetFileTypeActiveResult(int n) {
        boolean bl = this.target.fileTypeActive = n == 0;
        if (!this.target.fileTypeActive) {
            this.target.warn("failure on initial dsiFileBrowserSetFileTypeActiveResult, errorcode", n);
        }
    }

    public void dsiFileBrowserGetFileCountWithFileTypeFilterResult(int n, int n2, int n3, int n4) {
        Session session = this.target.sessions.getDsiSession(n);
        if (session != null) {
            session.removeRequest(1019);
        }
        if (this.vcardCountPending == null) {
            this.target.warn("Received an answer StateTop.dsiGetFileCountWithFileTypeFilterResult() without request!", n);
        } else if (n != this.vcardCountPending.getDsiHandle()) {
            this.target.warn("Received an answer StateTop.dsiGetFileCountWithFileTypeFilterResult() different dsiSessionHandle than the request", n);
        }
        this.vcardCountPending = null;
        if (this.vcardCountQueue != null) {
            this.updateNumberOfVCards(this.vcardCountQueue);
            this.vcardCountQueue = null;
            return;
        }
        if (n2 == 0) {
            ServiceManager.aslPropertyManager.valueChangedInteger(3822, n4);
        }
    }

    public void dsiFileBrowserSetLanguageResult(int n, String string) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1151074304);
        eventGeneric.setInt(0, this.transactionId);
        eventGeneric.setBoolean(1, n == 0);
        eventGeneric.setString(2, string);
        this.target.sendSafe(eventGeneric);
        this.target.trace(new StringBuffer().append("DSIFileBrowserListener.setLanguageResult (").append(string).toString());
    }
}

