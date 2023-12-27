/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.phone;

import de.vw.mib.asl.framework.api.persistence.AbstractSharedPersistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import java.util.HashSet;

public final class PhonePersistence
extends AbstractSharedPersistable {
    private static final short VERSION;
    private static final short[] SUPPORTED_VERSIONS;
    public static final int PRE_VALET_PARKING_STATE_C0_NO_VALET_PARKING;
    public static final int PRE_VALET_PARKING_STATE_C1_OFF;
    public static final int PRE_VALET_PARKING_STATE_C2_ON;
    private static PhonePersistence instance;
    public static final String DEFAULT_LAST_CONNECTED_SIMID;
    public static final boolean DEFAULT_AUTOMATIC_MESSAGING_ACCOUNT;
    private boolean mAutomaticMessagingAccount = false;
    private int mDefaultMessagingAccount = 0;
    private String mLastConnectedSimId = "";
    private boolean mConnectedSimDataOnlyStateDifferentThanAdaptationDefault = false;
    private boolean mWizardStateCompleted = false;
    private int mPreValetParkingWiFiState = -1;
    private int mPreValetParkingBtState = -1;
    private int mPreValetParkingNadState = -1;
    private HashSet mAlreadyShownBtaDisclaimerMacAddresses = new HashSet();

    public static PhonePersistence getInstance() {
        if (instance == null) {
            instance = new PhonePersistence();
            ServiceManager.persistence.registerSharedPersistable(instance);
            try {
                ServiceManager.persistence.loadPersistable(instance.getNamespace(), instance.getKey(), instance);
            }
            catch (Exception exception) {
                ServiceManager.logger.error(4).append("Exception in PHONE/loadPersistable. Clearing!  ").attachThrowable(exception).log();
                instance.clear();
            }
        }
        return instance;
    }

    private PhonePersistence() {
        super(5008, 0);
        this.clear();
    }

    @Override
    public short[] getSupportedVersions() {
        return SUPPORTED_VERSIONS;
    }

    @Override
    public short getVersion() {
        return 9;
    }

    @Override
    public void clear() {
        if (ServiceManager.logger.isTraceEnabled(4)) {
            ServiceManager.logger.trace(4).append("PhonePersistence.clear()").log();
        }
        this.mAutomaticMessagingAccount = false;
        this.mDefaultMessagingAccount = 0;
        this.mLastConnectedSimId = "";
        this.mConnectedSimDataOnlyStateDifferentThanAdaptationDefault = false;
        this.mWizardStateCompleted = false;
        this.mPreValetParkingWiFiState = -1;
        this.mPreValetParkingBtState = -1;
        this.mPreValetParkingNadState = -1;
        this.mAlreadyShownBtaDisclaimerMacAddresses.clear();
    }

    public void resetValues() {
        this.clear();
        this.markDirty(true);
    }

    @Override
    public void clearUnknownValues(short s) {
    }

    @Override
    public void fromStreamInternal(PersistenceInputStream persistenceInputStream, short s) {
        if (ServiceManager.logger.isTraceEnabled(4)) {
            ServiceManager.logger.trace(4).append("PhonePersistence.fromStreamInternal(): ").append(this.toString()).log();
        }
        this.mAutomaticMessagingAccount = persistenceInputStream.readBoolean();
        this.mDefaultMessagingAccount = persistenceInputStream.readInt();
        this.mLastConnectedSimId = persistenceInputStream.readString();
        this.mConnectedSimDataOnlyStateDifferentThanAdaptationDefault = persistenceInputStream.readBoolean();
        this.mWizardStateCompleted = persistenceInputStream.readBoolean();
        this.mPreValetParkingWiFiState = persistenceInputStream.readInt();
        this.mPreValetParkingBtState = persistenceInputStream.readInt();
        this.mPreValetParkingNadState = persistenceInputStream.readInt();
        int n = persistenceInputStream.readInt();
        this.mAlreadyShownBtaDisclaimerMacAddresses = new HashSet(n);
        for (int i2 = 0; i2 < n; ++i2) {
            this.mAlreadyShownBtaDisclaimerMacAddresses.add(persistenceInputStream.readString());
        }
    }

    @Override
    public void toStreamInternal(PersistenceOutputStream persistenceOutputStream) {
        Object object;
        if (ServiceManager.logger.isTraceEnabled(4)) {
            object = ServiceManager.logger.trace(4);
            object.append("PhonePersistence.toStreamInternal(): ").append(this.toString()).log();
        }
        persistenceOutputStream.writeBoolean(this.isAutomaticMessagingAccount());
        persistenceOutputStream.writeInt(this.mDefaultMessagingAccount);
        persistenceOutputStream.writeString(this.getLastConnectedSimId());
        persistenceOutputStream.writeBoolean(this.mConnectedSimDataOnlyStateDifferentThanAdaptationDefault);
        persistenceOutputStream.writeBoolean(this.mWizardStateCompleted);
        persistenceOutputStream.writeInt(this.mPreValetParkingWiFiState);
        persistenceOutputStream.writeInt(this.mPreValetParkingBtState);
        persistenceOutputStream.writeInt(this.mPreValetParkingNadState);
        persistenceOutputStream.writeInt(this.mAlreadyShownBtaDisclaimerMacAddresses.size());
        object = this.mAlreadyShownBtaDisclaimerMacAddresses.iterator();
        while (object.hasNext()) {
            String string = (String)object.next();
            persistenceOutputStream.writeString(string);
        }
    }

    public boolean isAutomaticMessagingAccount() {
        return this.mAutomaticMessagingAccount;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PhonePersistence [mAutomaticMessagingAccount=");
        stringBuffer.append(this.mAutomaticMessagingAccount);
        stringBuffer.append(", mDefaultMessagingAccount=");
        stringBuffer.append(this.mDefaultMessagingAccount);
        stringBuffer.append(", mLastConnectedSimId=");
        stringBuffer.append(this.mLastConnectedSimId);
        stringBuffer.append(", mConnectedSimDataOnlyStateDifferentThanAdaptationDefault=");
        stringBuffer.append(this.mConnectedSimDataOnlyStateDifferentThanAdaptationDefault);
        stringBuffer.append(", mWizardStateCompleted=");
        stringBuffer.append(this.mWizardStateCompleted);
        stringBuffer.append(", mPreValetParkingWiFiState=");
        stringBuffer.append(this.mPreValetParkingWiFiState);
        stringBuffer.append(", mPreValetParkingBtState=");
        stringBuffer.append(this.mPreValetParkingBtState);
        stringBuffer.append(", mPreValetParkingNadState=");
        stringBuffer.append(this.mPreValetParkingNadState);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public void setAutomaticMessagingAccount(boolean bl) {
        this.mAutomaticMessagingAccount = bl;
        this.markDirty(true);
    }

    public void setDefaultMessagingAccount(int n) {
        this.mDefaultMessagingAccount = n;
        this.markDirty(true);
    }

    public int getDefaultMessagingAccount() {
        return this.mDefaultMessagingAccount;
    }

    public String getLastConnectedSimId() {
        return this.mLastConnectedSimId;
    }

    public void setLastConnectedSimId(String string) {
        this.mLastConnectedSimId = string;
        this.markDirty(true);
    }

    public boolean getConnectedSimDataOnlyStateDifferentThanAdaptationDefault() {
        return this.mConnectedSimDataOnlyStateDifferentThanAdaptationDefault;
    }

    public void setConnectedSimDataOnlyStateDifferentThanAdaptationDefault(boolean bl) {
        this.mConnectedSimDataOnlyStateDifferentThanAdaptationDefault = bl;
        this.markDirty(true);
    }

    public boolean isWizardStateCompleted() {
        return this.mWizardStateCompleted;
    }

    public void setWizardStateCompleted(boolean bl) {
        this.mWizardStateCompleted = bl;
        this.markDirty(true);
    }

    public int getPreValetParkingWiFiState() {
        return this.mPreValetParkingWiFiState;
    }

    public void setPreValetParkingWiFiState(int n) {
        this.mPreValetParkingWiFiState = n;
        this.markDirty(true);
    }

    public int getPreValetParkingBtState() {
        return this.mPreValetParkingBtState;
    }

    public void setPreValetParkingBtState(int n) {
        this.mPreValetParkingBtState = n;
        this.markDirty(true);
    }

    public int getPreValetParkingNadState() {
        return this.mPreValetParkingNadState;
    }

    public void setPreValetParkingNadState(int n) {
        this.mPreValetParkingNadState = n;
        this.markDirty(true);
    }

    public void addAlreadyShownBtaDisclaimerMacAddress(String string) {
        this.mAlreadyShownBtaDisclaimerMacAddresses.add(string);
        this.markDirty(true);
    }

    public void removeAlreadyShownBtaDisclaimerMacAddress(String string) {
        this.mAlreadyShownBtaDisclaimerMacAddresses.remove(string);
        this.markDirty(true);
    }

    public boolean isBtaDisclaimerAlreadyShownForMacAddress(String string) {
        return this.mAlreadyShownBtaDisclaimerMacAddresses.contains(string);
    }

    static {
        SUPPORTED_VERSIONS = NO_SUPPORTED_VERSION;
    }
}

