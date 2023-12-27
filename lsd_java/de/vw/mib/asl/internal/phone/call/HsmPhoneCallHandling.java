/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.call;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.call.StateCallHandlingCallHandling;
import de.vw.mib.asl.internal.phone.call.StateCallHandlingInit;
import de.vw.mib.asl.internal.phone.call.StateCallHandlingReinitializeSpeller;
import de.vw.mib.asl.internal.phone.call.StateCallHandlingWaitForAdb;
import de.vw.mib.asl.internal.phone.targets.abstracts.AbstractASLHsmPhoneTarget;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbList;
import org.dsi.ifc.organizer.DSIAdbSetup;
import org.dsi.ifc.organizer.DataSet;

public final class HsmPhoneCallHandling
extends AbstractASLHsmPhoneTarget
implements ASLListElementFetcher {
    public static final String[] NEEDED_PHONE_DSIS = new String[]{RuntimeGeneratedConstants.SERVICE_TS_NS[8]};
    DSIAdbList dsiAdbListTelephone;
    DSIAdbSetup dsiAdbSetup;
    DSIListener dsiAdbListTelephoneListener;
    DSIListener dsiAdbSetupListener;
    protected final HsmState stateInit;
    protected final HsmState stateCallHandlingWaitForAdb;
    protected final StateCallHandlingCallHandling stateCallHandling;
    protected final HsmState stateCallHandlingReinitializeSpeller;
    protected DataSet[] spellerResultDataSets = null;
    ArrayList spellerBlocks = new ArrayList();
    protected int spellerHandle = -1;
    protected boolean isMatchingAvailable = false;
    protected boolean isMatchingAvailableLastSetByModel = false;
    static boolean selectNumberHappenedBeforeDial = false;
    protected int currentHangupID = 0;
    protected int spellerSelectionStart = 0;
    protected int spellerSelectionEnd = 0;
    private boolean alreadyRegistered = false;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbList;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetup;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbListListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetupListener;

    public HsmPhoneCallHandling(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.stateCallHandlingWaitForAdb = new StateCallHandlingWaitForAdb(this, genericEvents, this.hsm, "PhoneCallHandlingWaitForAdb", this.getWorkStateParent());
        this.stateInit = new StateCallHandlingInit(this, genericEvents, this.hsm, "PhoneCallHandlingTop", this.stateCallHandlingWaitForAdb);
        this.stateCallHandling = new StateCallHandlingCallHandling(this, genericEvents, this.hsm, "PhoneCallHandling", this.stateInit);
        this.stateCallHandlingReinitializeSpeller = new StateCallHandlingReinitializeSpeller(this, genericEvents, this.hsm, "PhoneCallHandlingReinitializeSpeller", this.stateCallHandling);
    }

    @Override
    public int getDefaultTargetId() {
        return 5254;
    }

    protected void init() {
        if (!this.alreadyRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiAdbListTelephone = (DSIAdbList)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = HsmPhoneCallHandling.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList, 0);
            this.dsiAdbSetup = (DSIAdbSetup)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = HsmPhoneCallHandling.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup);
            this.dsiAdbListTelephoneListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = HsmPhoneCallHandling.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener);
            this.dsiAdbSetupListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$organizer$DSIAdbSetupListener == null ? (class$org$dsi$ifc$organizer$DSIAdbSetupListener = HsmPhoneCallHandling.class$("org.dsi.ifc.organizer.DSIAdbSetupListener")) : class$org$dsi$ifc$organizer$DSIAdbSetupListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = HsmPhoneCallHandling.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener, 0, this.dsiAdbListTelephoneListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbSetupListener == null ? (class$org$dsi$ifc$organizer$DSIAdbSetupListener = HsmPhoneCallHandling.class$("org.dsi.ifc.organizer.DSIAdbSetupListener")) : class$org$dsi$ifc$organizer$DSIAdbSetupListener, this.dsiAdbSetupListener);
            AbstractASLHsmTarget.writeIntegerToDatapool(1179, ASLPhoneData.MAX_PROFILE_CONTACTS);
            AbstractASLHsmTarget.writeIntegerToDatapool(-1293808384, ASLPhoneData.MAX_PROFILE_CONTACTS);
        }
        this.alreadyRegistered = true;
    }

    protected void clearNotification() {
        this.dsiAdbSetup.clearNotification(1, this.dsiAdbSetupListener);
    }

    protected void setNotification() {
        this.dsiAdbSetup.setNotification(1, this.dsiAdbSetupListener);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateCallHandlingWaitForAdb;
    }

    @Override
    public void fetchItems(ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
        if (n == 0) {
            if (this.spellerHandle > -1) {
                if (this.spellerResultDataSets != null) {
                    ListManager.getGenericASLList(1169).updateListItems(0, this.spellerResultDataSets);
                    this.spellerResultDataSets = null;
                } else {
                    this.dsiAdbListTelephone.getSpellerViewWindow(this.spellerHandle, 0L, 4, 1, n2);
                }
            } else {
                this.error("Short Dial List: Speller Handle not initialized!");
            }
        } else if (this.spellerHandle > -1) {
            this.dsiAdbListTelephone.getSpellerViewWindow(this.spellerHandle, n, 6, 1, n2);
        } else {
            this.error("Short Dial List: Speller Handle not initialized!");
        }
    }

    @Override
    public void fetchNextPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        DataSet dataSet = (DataSet)object;
        if (this.spellerHandle > -1) {
            this.dsiAdbListTelephone.getSpellerViewWindow(this.spellerHandle, dataSet.entryId, 1, 1, n2);
        } else {
            this.error("Short Dial List: Speller Handle not initialized!");
        }
    }

    @Override
    public void fetchPreviousPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        DataSet dataSet = (DataSet)object;
        if (this.spellerHandle > -1) {
            this.dsiAdbListTelephone.getSpellerViewWindow(this.spellerHandle, dataSet.entryId, 2, 1, n2);
        } else {
            this.error("Short Dial List: Speller Handle not initialized!");
        }
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

