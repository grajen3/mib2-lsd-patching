/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.presets;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.speller.ASLAPISpellerBinding;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.presets.StatePresetHandling;
import de.vw.mib.asl.internal.phone.presets.StatePresetInit;
import de.vw.mib.asl.internal.phone.targets.abstracts.AbstractASLHsmPhoneTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DSIAdbEdit;
import org.dsi.ifc.organizer.DSIAdbList;
import org.dsi.ifc.organizer.DSIAdbSetup;
import org.dsi.ifc.organizer.DSIAdbUserProfile;

public class HsmPhonePresetsHandling
extends AbstractASLHsmPhoneTarget {
    DSIAdbSetup dsiAdbSetup;
    DSIAdbList dsiAdbListTelephone;
    DSIAdbEdit dsiAdbEditTelephone;
    DSIAdbUserProfile dsiAdbUserProfile;
    DSIListener dsiAdbSetupListener;
    DSIListener dsiAdbListTelephoneListener;
    DSIListener dsiAdbEditTelephoneListener;
    DSIListener dsiAdbUserProfileListener;
    protected final HsmState stateInit;
    protected final HsmState statePresetHandling;
    protected static final int EV_ASL_INT_RESP_GET_ENTRY;
    protected static final int EV_ASL_INT_RESP_GET_ENTRIES;
    protected boolean singleNumberSelectedContact;
    protected int selectedPresetKey;
    protected ASLAPISpellerBinding spellerPresetNumber;
    private boolean alreadyRegistered = false;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetup;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfile;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbList;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEdit;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetupListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbListListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEditListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfileListener;

    public HsmPhonePresetsHandling(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.stateInit = new StatePresetInit(this, genericEvents, this.hsm, "PhonePresetHandlingTop", this.getWorkStateParent());
        this.statePresetHandling = new StatePresetHandling(this, genericEvents, this.hsm, "PhonePresetHandling", this.stateInit);
    }

    @Override
    public int getDefaultTargetId() {
        return 5264;
    }

    protected void init() {
        if (!this.alreadyRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiAdbSetup = (DSIAdbSetup)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = HsmPhonePresetsHandling.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup);
            this.dsiAdbUserProfile = (DSIAdbUserProfile)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = HsmPhonePresetsHandling.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile);
            this.dsiAdbListTelephone = (DSIAdbList)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = HsmPhonePresetsHandling.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList, 0);
            this.dsiAdbEditTelephone = (DSIAdbEdit)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = HsmPhonePresetsHandling.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit, 0);
            this.dsiAdbSetupListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$organizer$DSIAdbSetupListener == null ? (class$org$dsi$ifc$organizer$DSIAdbSetupListener = HsmPhonePresetsHandling.class$("org.dsi.ifc.organizer.DSIAdbSetupListener")) : class$org$dsi$ifc$organizer$DSIAdbSetupListener);
            this.dsiAdbListTelephoneListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = HsmPhonePresetsHandling.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener);
            this.dsiAdbEditTelephoneListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = HsmPhonePresetsHandling.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener);
            this.dsiAdbUserProfileListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$organizer$DSIAdbUserProfileListener == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfileListener = HsmPhonePresetsHandling.class$("org.dsi.ifc.organizer.DSIAdbUserProfileListener")) : class$org$dsi$ifc$organizer$DSIAdbUserProfileListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = HsmPhonePresetsHandling.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener, 0, this.dsiAdbListTelephoneListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = HsmPhonePresetsHandling.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener, 0, this.dsiAdbEditTelephoneListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbUserProfileListener == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfileListener = HsmPhonePresetsHandling.class$("org.dsi.ifc.organizer.DSIAdbUserProfileListener")) : class$org$dsi$ifc$organizer$DSIAdbUserProfileListener, this.dsiAdbUserProfileListener);
            this.spellerPresetNumber = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAPISpellerFactory().createSimpleCursor(4056, -698608320, 1108017216, 1175126080);
            HsmPhonePresetsHandling.writeBooleanToDatapool(226759936, true);
            HsmPhonePresetsHandling.writeBooleanToDatapool(-110991872, true);
        }
        this.alreadyRegistered = true;
    }

    void getSpeedDials() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(5264, 5270, -1585053440);
        eventGeneric.setSenderEventId(-830013184);
        eventGeneric.setObject(0, new long[0]);
        eventGeneric.setInt(1, 4);
        eventGeneric.setInt(2, 1);
        this.send(eventGeneric);
    }

    void setSpeedDial(AdbEntry adbEntry) {
        this.dsiAdbEditTelephone.setSpeedDial(adbEntry);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
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

