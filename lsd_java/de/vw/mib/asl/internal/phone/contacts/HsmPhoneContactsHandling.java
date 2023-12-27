/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.contacts;

import de.vw.mib.asl.api.phone.callback.ContactlistUpdates;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.api.impl.PhoneServiceImpl;
import de.vw.mib.asl.internal.phone.contacts.StateContactsHandlingContactHandling;
import de.vw.mib.asl.internal.phone.contacts.StateContactsHandlingInit;
import de.vw.mib.asl.internal.phone.contacts.StateContactsHandlingInitList;
import de.vw.mib.asl.internal.phone.targets.abstracts.AbstractASLHsmPhoneTarget;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbEdit;
import org.dsi.ifc.organizer.DSIAdbList;
import org.dsi.ifc.organizer.DSIAdbSetup;
import org.dsi.ifc.organizer.DSIAdbUserProfile;
import org.dsi.ifc.organizer.DataSet;

public class HsmPhoneContactsHandling
extends AbstractASLHsmPhoneTarget {
    public static final int EV_CONTACTLISTUPDATES;
    DSIAdbList dsiAdbList;
    DSIAdbEdit dsiAdbEdit;
    DSIAdbSetup dsiAdbSetup;
    DSIAdbUserProfile dsiAdbUserProfile;
    DSIListener dsiAdbListListener;
    DSIListener dsiAdbEditListener;
    DSIListener dsiAdbSetupListener;
    DSIListener dsiAdbUserProfileListener;
    final HsmState stateInit;
    final HsmState stateInitList;
    final HsmState stateContactHandling;
    protected long selectedContactEntryId = 0L;
    protected boolean singleNumberSelectedContact;
    protected int filterType = 0;
    private boolean alreadyRegistered = false;
    private final ArrayList contactlistUpdateListeners = new ArrayList();
    private int contactlistDownloadStatus = -1;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbList;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEdit;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetup;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfile;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbListListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEditListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetupListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfileListener;

    public HsmPhoneContactsHandling(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.stateInit = new StateContactsHandlingInit(this, genericEvents, this.hsm, "PhoneContactsHandlingTop", this.getWorkStateParent());
        this.stateInitList = new StateContactsHandlingInitList(this, genericEvents, this.hsm, "PhoneContactsHandlingInitList", this.stateInit);
        this.stateContactHandling = new StateContactsHandlingContactHandling(this, genericEvents, this.hsm, "PhoneContactsHandling", this.stateInit);
    }

    @Override
    public int getDefaultTargetId() {
        return 5261;
    }

    protected void init() {
        if (!this.alreadyRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiAdbList = (DSIAdbList)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = HsmPhoneContactsHandling.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList, 1);
            this.dsiAdbEdit = (DSIAdbEdit)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = HsmPhoneContactsHandling.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit, 1);
            this.dsiAdbSetup = (DSIAdbSetup)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = HsmPhoneContactsHandling.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup);
            this.dsiAdbUserProfile = (DSIAdbUserProfile)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = HsmPhoneContactsHandling.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile);
            this.dsiAdbListListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = HsmPhoneContactsHandling.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener);
            this.dsiAdbEditListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = HsmPhoneContactsHandling.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener);
            this.dsiAdbSetupListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$organizer$DSIAdbSetupListener == null ? (class$org$dsi$ifc$organizer$DSIAdbSetupListener = HsmPhoneContactsHandling.class$("org.dsi.ifc.organizer.DSIAdbSetupListener")) : class$org$dsi$ifc$organizer$DSIAdbSetupListener);
            this.dsiAdbUserProfileListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$organizer$DSIAdbUserProfileListener == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfileListener = HsmPhoneContactsHandling.class$("org.dsi.ifc.organizer.DSIAdbUserProfileListener")) : class$org$dsi$ifc$organizer$DSIAdbUserProfileListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = HsmPhoneContactsHandling.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener, 1, this.dsiAdbListListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = HsmPhoneContactsHandling.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener, 1, this.dsiAdbEditListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbUserProfileListener == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfileListener = HsmPhoneContactsHandling.class$("org.dsi.ifc.organizer.DSIAdbUserProfileListener")) : class$org$dsi$ifc$organizer$DSIAdbUserProfileListener, this.dsiAdbUserProfileListener);
            AbstractASLHsmTarget.writeIntegerToDatapool(1179, ASLPhoneData.MAX_PROFILE_CONTACTS);
            AbstractASLHsmTarget.writeIntegerToDatapool(-1293808384, ASLPhoneData.MAX_PROFILE_CONTACTS);
            int n = ServiceManager.configManagerDiag.getNaviCommonOptionDefault(1);
            this.trace("HsmPhoneContactsHandling.init(): Set FixFormatter naming rule variant offset to ", n);
            ServiceManager.aslPropertyManager.valueChangedInteger(-377285376, n);
        }
        this.alreadyRegistered = true;
        PhoneServiceImpl.getInstance().targetReady(this.getDefaultTargetId());
    }

    protected void setNotification() {
        this.dsiAdbSetup.setNotification(1, this.dsiAdbSetupListener);
        this.dsiAdbUserProfile.setNotification(8, this.dsiAdbUserProfileListener);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    protected void setSelectedContactInformation(DataSet dataSet) {
        ListManager.getGenericASLList(1190).updateListItem(dataSet.getEntryPosition(), dataSet);
        AbstractASLHsmTarget.writeIntegerToDatapool(1181, dataSet.getEntryPosition());
        if (this.isTraceEnabled()) {
            this.trace().append(new StringBuffer().append("PHONE_CONTACTS_SELECTED_CONTACT_INDEX_INTEGER set to ").append(dataSet.getEntryPosition()).toString()).log();
        }
        if (this.singleNumberSelectedContact) {
            ASLPhoneData.getInstance().dataSetContactsCached = dataSet;
            String string = dataSet.generalDescription2;
            AbstractASLHsmTarget.writeStringToDatapool(1151, string);
        }
    }

    public void addContactlistUpdates(ContactlistUpdates contactlistUpdates) {
        if (this.contactlistDownloadStatus != -1) {
            contactlistUpdates.onDownloadStatus(this.contactlistDownloadStatus);
        }
        this.contactlistUpdateListeners.add(contactlistUpdates);
    }

    public void updateDownloadStatus(int n) {
        if (this.isTraceEnabled()) {
            this.trace("ContactlistUpdates.onDownloadStatus(): ", n);
        }
        if (n != this.contactlistDownloadStatus) {
            this.contactlistDownloadStatus = n;
            Iterator iterator = this.contactlistUpdateListeners.iterator();
            while (iterator.hasNext()) {
                ContactlistUpdates contactlistUpdates = (ContactlistUpdates)iterator.next();
                contactlistUpdates.onDownloadStatus(n);
            }
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

