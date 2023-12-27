/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone;

import de.vw.mib.asl.api.phone.services.contact.ContactDetailsResponse;
import de.vw.mib.asl.api.phone.services.contact.ContactDetailsService;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.phone.HsmPhoneGetEntryHelper$GetEntriesTask;
import de.vw.mib.asl.internal.phone.HsmPhoneGetEntryHelper$GetEntryTask;
import de.vw.mib.asl.internal.phone.HsmPhoneGetEntryHelper$ServiceTask;
import de.vw.mib.asl.internal.phone.HsmPhoneGetEntryHelper$Task;
import de.vw.mib.asl.internal.phone.targets.abstracts.AbstractASLPhoneTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import edu.emory.mathcs.backport.java.util.LinkedList;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DSIAdbEdit;

public class HsmPhoneGetEntryHelper
extends AbstractASLPhoneTarget
implements ContactDetailsService {
    private DSIAdbEdit dsiAdbEditTelephone;
    private DSIListener dsiAdbEditTelephoneListener;
    private HsmPhoneGetEntryHelper$Task pendingTask;
    private final LinkedList eventQueue = new LinkedList();
    private boolean alreadyRegistered = false;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEdit;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEditListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$phone$services$contact$ContactDetailsService;

    public HsmPhoneGetEntryHelper(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 5270;
    }

    private void init() {
        if (!this.alreadyRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiAdbEditTelephone = (DSIAdbEdit)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = HsmPhoneGetEntryHelper.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit, 0);
            this.dsiAdbEditTelephoneListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = HsmPhoneGetEntryHelper.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = HsmPhoneGetEntryHelper.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener, 0, this.dsiAdbEditTelephoneListener);
            ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().registerAPI(class$de$vw$mib$asl$api$phone$services$contact$ContactDetailsService == null ? (class$de$vw$mib$asl$api$phone$services$contact$ContactDetailsService = HsmPhoneGetEntryHelper.class$("de.vw.mib.asl.api.phone.services.contact.ContactDetailsService")) : class$de$vw$mib$asl$api$phone$services$contact$ContactDetailsService, this);
        }
        this.alreadyRegistered = true;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.init();
                break;
            }
            case 100001: {
                eventGeneric.setBlocked(true);
                long[] lArray = (long[])eventGeneric.getObject(0);
                int n = eventGeneric.getInt(1);
                int n2 = eventGeneric.getInt(2);
                HsmPhoneGetEntryHelper$GetEntriesTask hsmPhoneGetEntryHelper$GetEntriesTask = new HsmPhoneGetEntryHelper$GetEntriesTask(this, n, n2, lArray, eventGeneric);
                this.addTask(hsmPhoneGetEntryHelper$GetEntriesTask);
                break;
            }
            case 100000: {
                eventGeneric.setBlocked(true);
                long l = eventGeneric.getLong(0);
                HsmPhoneGetEntryHelper$GetEntryTask hsmPhoneGetEntryHelper$GetEntryTask = new HsmPhoneGetEntryHelper$GetEntryTask(this, 1, 0, new long[]{l}, eventGeneric);
                this.addTask(hsmPhoneGetEntryHelper$GetEntryTask);
                break;
            }
        }
    }

    private void addTask(HsmPhoneGetEntryHelper$Task hsmPhoneGetEntryHelper$Task) {
        this.eventQueue.add(hsmPhoneGetEntryHelper$Task);
        this.checkQueue();
    }

    public void dsiAdbEditGetEntriesResult(int n, AdbEntry[] adbEntryArray) {
        try {
            this.pendingTask.callback(n == 0, adbEntryArray);
        }
        catch (Exception exception) {
            this.error().append("HsmPhoneGetEntryHelper.dsiAdbEditGetEntriesResult callback failed").attachThrowable(exception).log();
        }
        this.pendingTask = null;
        this.checkQueue();
    }

    public void dsiAdbEditAsyncException(int n, String string, int n2) {
        if (n2 == 1001) {
            this.dsiAdbEditGetEntriesResult(1, null);
        }
    }

    private void checkQueue() {
        if (this.pendingTask != null) {
            return;
        }
        if (this.eventQueue.isEmpty()) {
            return;
        }
        this.pendingTask = (HsmPhoneGetEntryHelper$Task)this.eventQueue.pollFirst();
        this.dsiAdbEditTelephone.getEntries(this.pendingTask.adbID, this.pendingTask.viewType, this.pendingTask.listMode);
    }

    @Override
    public void requestAdditionalData(ContactDetailsResponse contactDetailsResponse, long l) {
        this.addTask(new HsmPhoneGetEntryHelper$ServiceTask(contactDetailsResponse, 0, 0, new long[]{l}));
    }

    @Override
    public void requestAdditionalData(ContactDetailsResponse contactDetailsResponse, long[] lArray) {
        this.addTask(new HsmPhoneGetEntryHelper$ServiceTask(contactDetailsResponse, 0, 0, lArray));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

