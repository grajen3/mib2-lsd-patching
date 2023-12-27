/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.setup;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.speller.ASLAPISpellerBinding;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.setup.TargetASLPhoneSetup$PrimaryListener;
import de.vw.mib.asl.internal.phone.setup.TargetASLPhoneSetup$Reset;
import de.vw.mib.asl.internal.phone.util.TripleMobileEquipment;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.organizer.DSIAdbUserProfile;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentListener;

public class TargetASLPhoneSetup
extends TripleMobileEquipment {
    protected DSIAdbUserProfile dsiAdbUserProfile;
    private ASLAPISpellerBinding spellerHsmPIN;
    private ASLAPISpellerBinding spellerHsmPINName;
    private String tempPin = "";
    private int pinSpellerType = -1;
    boolean isUnlockOtherPINrequested = false;
    private boolean automaticPINActive = false;
    private boolean otherPINAvailable = false;
    private boolean alreadyRegistered = false;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfile;

    public TargetASLPhoneSetup(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 5253;
    }

    protected void init() {
        if (!this.alreadyRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiAdbUserProfile = (DSIAdbUserProfile)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = TargetASLPhoneSetup.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile);
            this.addObserver(0x22040040);
            this.addObserver(0xB040040);
            this.addObserver(0xC040040);
            this.addObserver(269090880);
            this.addObserver(352583744);
            this.addObserver(369360960);
            this.addObserver(402915392);
            this.addObserver(419692608);
            this.addObserver(-614722240);
            this.addObserver(386138176);
            this.addObserver(486801472);
            this.addObserver(436469824);
            this.addObserver(503578688);
            this.addObserver(386531392);
            this.addObserver(0x10040040);
            this.addObserver(0xF040040);
            this.addObserver(0xD040040);
            this.addObserver(0x11040040);
            this.addObserver(302252096);
            this.addObserver(-631499456);
            this.addObserver(0xE040040);
            this.addObserver(0x14040040);
            this.addObserver(369754176);
            this.addObserver(513622272);
            this.spellerHsmPIN = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAPISpellerFactory().createSimpleCursor(1234, -614722240, 386138176, 486801472);
            this.spellerHsmPINName = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAPISpellerFactory().createSimpleCursor(1232, -631499456, 0xE040040, 0x14040040);
            ASLSystemFactory.getSystemApi().getFactoryResetService().addParticipant(new TargetASLPhoneSetup$Reset(this, null), FactoryResetComponents.PHONE);
        }
        this.alreadyRegistered = true;
    }

    @Override
    protected int[] getMobileEquipmentNotification() {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(73)) {
            return new int[]{5, 3, 30, 34, 36};
        }
        return ASLPhoneData.EMPTY_NOTIFICATION;
    }

    @Override
    protected int[] getMobileEquipmentHfpOnlyNotification() {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(73)) {
            return ASLPhoneData.EMPTY_NOTIFICATION;
        }
        return new int[]{36};
    }

    @Override
    protected void powerOn() {
        this.init();
    }

    @Override
    public void handleEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                break;
            }
            case 0x40000411: {
                this.getNad().requestSetSIMAliases(this.spellerHsmPINName.getSpellerData().getEnteredText(), ASLPhoneData.getInstance().alternativePIN);
                break;
            }
            case 1073742866: {
                this.getNad().requestSetSIMAliases(ASLPhoneData.getInstance().currentPIN, this.spellerHsmPINName.getSpellerData().getEnteredText());
                break;
            }
            case 4300062: {
                break;
            }
            case 0x4000040B: {
                boolean bl;
                boolean bl2 = bl = eventGeneric.getBoolean(0);
                if (bl) {
                    this.getNad().requestRemoveOtherSIM();
                }
                boolean bl3 = ASLPhoneData.getInstance().isAutomaticPinEntryCancelled = !bl;
                if (ASLPhoneData.getInstance().lockState == 2) {
                    this.getNad().requestSetAutomaticPinEntryActive(bl);
                    ASLPhoneData.getInstance().isAutomaticPinEntryPending = false;
                    break;
                }
                ASLPhoneData.getInstance().isSimUnlockedByUserAfterInserting = true;
                ASLPhoneData.getInstance().isAutomaticPinEntryPending = true;
                break;
            }
            case 0x4000040C: {
                boolean bl = eventGeneric.getBoolean(0);
                this.getNad().requestSIMPINRequired(this.spellerHsmPIN.getSpellerData().getEnteredText(), bl);
                break;
            }
            case 1073742869: {
                this.getNad().requestCheckSIMPINCode(this.spellerHsmPIN.getSpellerData().getEnteredText());
                break;
            }
            case 0x4000040D: 
            case 1073742870: {
                break;
            }
            case 1073742872: {
                this.spellerHsmPIN.resetSpellerData();
                break;
            }
            case 1073742873: {
                this.pinSpellerType = eventGeneric.getInt(0);
                this.spellerHsmPIN.resetSpellerData();
                TargetASLPhoneSetup.writeBooleanToDatapool(1235, true);
                break;
            }
            case 1073742874: {
                if (ASLPhoneData.getInstance().lockState == 5) break;
                this.getNad().requestChangeSIMCode(0, this.spellerHsmPIN.getSpellerData().getEnteredText(), this.tempPin);
                break;
            }
            case 1073742878: {
                this.tempPin = this.spellerHsmPIN.getSpellerData().getEnteredText();
                break;
            }
            case 0x40000422: {
                ASLPhoneData.getInstance().phoneReminderSetting = eventGeneric.getBoolean(0);
                TargetASLPhoneSetup.writeBooleanToDatapool(1241, ASLPhoneData.getInstance().phoneReminderSetting);
                this.getPrimary().requestSetPhoneReminderSetting(ASLPhoneData.getInstance().phoneReminderSetting);
                break;
            }
            case 1073742871: 
            case 1073742877: 
            case 1075141851: {
                this.spellerHsmPIN.handleEvent(eventGeneric);
                this.enablePinSpellerOKButton();
                break;
            }
            case 0x4000040F: 
            case 0x40000410: {
                this.spellerHsmPINName.initSpeller(eventGeneric.getString(0));
                TargetASLPhoneSetup.writeBooleanToDatapool(1233, true);
                break;
            }
            case 1073744407: {
                this.isUnlockOtherPINrequested = true;
                this.getNad().requestUnlockOtherSIM(0, this.spellerHsmPIN.getSpellerData().getEnteredText());
                this.fakeLockstateInProgress();
                break;
            }
            case 1073744406: {
                this.getNad().requestRemoveOtherSIM();
                break;
            }
            case 1073744400: {
                int n = eventGeneric.getInt(0);
                if (n != 1) break;
                TargetASLPhoneSetup.writeStringToDatapool(3607, ASLPhoneData.getInstance().alternativePIN);
                TargetASLPhoneSetup.writeStringToDatapool(3608, ASLPhoneData.getInstance().currentPIN);
                ASLPhoneData.getInstance().isToggleOtherPINrequested = true;
                this.getNad().requestUnlockOtherSIM(0, "");
                if (this.isNadPrimary()) {
                    this.fakeLockstateInProgress();
                }
                if (this.isTraceEnabled()) {
                    this.trace().append("send PHONE_INIT_UPDATE from SET_ACTIVE_PIN").log();
                }
                this.sendHMIEvent(452);
                this.sendHMIEvent(-245209600);
                break;
            }
            case 3600018: {
                boolean bl = eventGeneric.getBoolean(1);
                String string = eventGeneric.getString(0);
                ASLPhoneData.getInstance().isPukUnlockRequested = !bl;
                this.getNad().requestUnlockSIM(bl ? 0 : 2, string, bl ? "" : this.spellerHsmPIN.getSpellerData().getEnteredText());
                break;
            }
            case 0x4000040E: 
            case 0x40000414: 
            case 1075141850: {
                this.spellerHsmPINName.handleEvent(eventGeneric);
                break;
            }
        }
    }

    private void fakeLockstateInProgress() {
        AbstractASLHsmTarget.writeIntegerToDatapool(1082, 1);
        AbstractASLHsmTarget.writeIntegerToDatapool(332357888, 1);
        AbstractASLHsmTarget.writeIntegerToDatapool(-228432384, 1);
        this.sendHMIEvent(315580672);
        this.sendHMIEvent(-228432384);
        this.sendHMIEvent(192);
        ASLPhoneData.getInstance().isToggleOtherPINrequested = true;
    }

    private void enablePinSpellerOKButton() {
        TargetASLPhoneSetup.writeBooleanToDatapool(1235, this.pinSpellerType != 2 || this.tempPin.equals(this.spellerHsmPIN.getSpellerData().getEnteredText()));
    }

    private void setOtherSimAvailable() {
        ASLPhoneData.getInstance().isOtherSIMAvailable = this.otherPINAvailable && this.automaticPINActive;
    }

    @Override
    protected DSIMobileEquipmentListener createPrimaryListener() {
        return new TargetASLPhoneSetup$PrimaryListener(this, null);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ boolean access$102(TargetASLPhoneSetup targetASLPhoneSetup, boolean bl) {
        targetASLPhoneSetup.automaticPINActive = bl;
        return targetASLPhoneSetup.automaticPINActive;
    }

    static /* synthetic */ void access$200(TargetASLPhoneSetup targetASLPhoneSetup) {
        targetASLPhoneSetup.setOtherSimAvailable();
    }

    static /* synthetic */ boolean access$302(TargetASLPhoneSetup targetASLPhoneSetup, boolean bl) {
        targetASLPhoneSetup.otherPINAvailable = bl;
        return targetASLPhoneSetup.otherPINAvailable;
    }
}

