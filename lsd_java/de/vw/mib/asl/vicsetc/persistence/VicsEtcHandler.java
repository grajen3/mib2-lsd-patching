/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.vicsetc.persistence;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.internal.vicsetc.PersistenceDefaults;
import de.vw.mib.asl.vicsetc.persistence.VicsEtc;
import de.vw.mib.log4mib.Logger;
import java.util.Map$Entry;

class VicsEtcHandler
extends AbstractPersistenceDataHandler {
    private final VicsEtc handledPersistable;
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$vicsetc$persistence$VicsEtcHandler;

    VicsEtcHandler(VicsEtc vicsEtc, Logger logger, PersistenceModule persistenceModule) {
        super(logger);
        if (!$assertionsDisabled && vicsEtc == null) {
            throw new AssertionError();
        }
        this.handledPersistable = vicsEtc;
        this.module = persistenceModule;
    }

    @Override
    public void handle(int n, boolean bl) {
        switch (n) {
            case 4: {
                this.handledPersistable.setDataUploadChecked(bl);
                this.markAsProcessed(n);
                break;
            }
            case 5: {
                this.handledPersistable.setEtcCardNotInsertedChecked(bl);
                this.markAsProcessed(n);
                break;
            }
            case 6: {
                this.handledPersistable.setEtcCardReminderChecked(bl);
                this.markAsProcessed(n);
                break;
            }
            case 7: {
                this.handledPersistable.setPopupEtcDrivingSupportChecked(bl);
                this.markAsProcessed(n);
                break;
            }
            case 8: {
                this.handledPersistable.setPopupEtcTrafficAnnouncementChecked(bl);
                this.markAsProcessed(n);
                break;
            }
            case 9: {
                this.handledPersistable.setPopupEtcTrafficInformationChecked(bl);
                this.markAsProcessed(n);
                break;
            }
            case 10: {
                this.handledPersistable.setTollFeeAnnouncementChecked(bl);
                this.markAsProcessed(n);
                break;
            }
            case 11: {
                this.handledPersistable.setTollFeePopupChecked(bl);
                this.markAsProcessed(n);
                break;
            }
            case 12: {
                this.handledPersistable.setVicsEventNoticeMapChecked(bl);
                this.markAsProcessed(n);
                break;
            }
            case 13: {
                this.handledPersistable.setVicsBeaconMessagesChecked(bl);
                this.markAsProcessed(n);
                break;
            }
            case 14: {
                this.handledPersistable.setVicsBeaconGraphicsChecked(bl);
                this.markAsProcessed(n);
                break;
            }
            case 16: {
                this.handledPersistable.setShortcutMessageChecked(bl);
                this.markAsProcessed(n);
                break;
            }
            default: {
                this.logUnknownField(n, "boolean");
            }
        }
    }

    @Override
    public void handle(int n, char c2) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "char");
    }

    @Override
    public void handle(int n, byte by) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "byte");
    }

    @Override
    public void handle(int n, short s) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "short");
    }

    @Override
    public void handle(int n, int n2) {
        switch (n) {
            case 1: {
                this.handledPersistable.setPopupDurationTime(n2);
                this.markAsProcessed(n);
                break;
            }
            case 3: {
                this.handledPersistable.setStationSelectMode(n2);
                this.markAsProcessed(n);
                break;
            }
            default: {
                this.logUnknownField(n, "int");
            }
        }
    }

    @Override
    public void handle(int n, long l) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "long");
    }

    @Override
    public void handle(int n, float f2) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "float");
    }

    @Override
    public void handle(int n, double d2) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "double");
    }

    @Override
    public void handle(int n, String string) {
        switch (n) {
            case 15: {
                this.handledPersistable.setPrefectureString(string);
                this.markAsProcessed(n);
                break;
            }
            case 17: {
                this.handledPersistable.setShortcutMessageValue(string);
                this.markAsProcessed(n);
                break;
            }
            default: {
                this.logUnknownField(n, "String");
            }
        }
    }

    @Override
    public void handle(int n, Persistable persistable) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "Persistable");
    }

    @Override
    public void handle(int n, Map$Entry map$Entry) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "Map");
    }

    @Override
    public void handleEmptyCollection(int n) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "Container");
    }

    @Override
    protected int[] getFieldIds() {
        return new int[]{1, 15, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 17};
    }

    @Override
    protected void installDefaultValue(int n) {
        switch (n) {
            case 1: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setPopupDurationTime(PersistenceDefaults.getPopupDurationTime());
                break;
            }
            case 15: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setPrefectureString(PersistenceDefaults.getDefaultPrefectureString());
                break;
            }
            case 3: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setStationSelectMode(PersistenceDefaults.getStationSelectMode());
                break;
            }
            case 4: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setDataUploadChecked(PersistenceDefaults.isDataUploadChecked());
                break;
            }
            case 5: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setEtcCardNotInsertedChecked(PersistenceDefaults.isEtcCardNotInsertedChecked());
                break;
            }
            case 6: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setEtcCardReminderChecked(PersistenceDefaults.isEtcCardReminderChecked());
                break;
            }
            case 7: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setPopupEtcDrivingSupportChecked(PersistenceDefaults.isPopupEtcDrivingSupportChecked());
                break;
            }
            case 8: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setPopupEtcTrafficAnnouncementChecked(PersistenceDefaults.isPopupEtcTrafficAnnouncementChecked());
                break;
            }
            case 9: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setPopupEtcTrafficInformationChecked(PersistenceDefaults.isPopupEtcTrafficInformationChecked());
                break;
            }
            case 10: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setTollFeeAnnouncementChecked(PersistenceDefaults.isTollFeeAnnouncementChecked());
                break;
            }
            case 11: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setTollFeePopupChecked(PersistenceDefaults.isTollFeePopupChecked());
                break;
            }
            case 12: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setVicsEventNoticeMapChecked(PersistenceDefaults.isVicsEventNoticeMapChecked());
                break;
            }
            case 13: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setVicsBeaconMessagesChecked(PersistenceDefaults.isVicsBeaconMessagesChecked());
                break;
            }
            case 14: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setVicsBeaconGraphicsChecked(PersistenceDefaults.isVicsBeaconGraphicsChecked());
                break;
            }
            case 16: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setShortcutMessageChecked(PersistenceDefaults.isShortcutMessageChecked());
                break;
            }
            case 17: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setShortcutMessageValue(PersistenceDefaults.getShortcutMessageValue());
                break;
            }
            default: {
                this.getLogger().warn(32).append("Cannot install default value: Unknown field ID (").append(n).append(")").log();
            }
        }
    }

    @Override
    protected boolean validate() {
        return true;
    }

    @Override
    protected int getPersistableId() {
        return 1;
    }

    protected boolean performValidation() {
        return true;
    }

    protected boolean invokeExternalMethods() {
        return true;
    }

    void preventUnusedModuleWarning__doNotInvoke() {
        this.module.getVersion();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$asl$vicsetc$persistence$VicsEtcHandler == null ? (class$de$vw$mib$asl$vicsetc$persistence$VicsEtcHandler = VicsEtcHandler.class$("de.vw.mib.asl.vicsetc.persistence.VicsEtcHandler")) : class$de$vw$mib$asl$vicsetc$persistence$VicsEtcHandler).desiredAssertionStatus();
    }
}

