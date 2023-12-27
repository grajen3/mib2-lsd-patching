/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.smartphoneintegration.persistence;

import de.vw.mib.asl.framework.api.persistence.AbstractSharedPersistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.smartphoneintegration.common.DeviceASLExtended;
import de.vw.mib.asl.internal.smartphoneintegration.target.HsmTarget;
import java.util.ArrayList;
import org.dsi.ifc.smartphoneintegration.Device;

public class SmartPhoneIntegrationPersistence
extends AbstractSharedPersistable {
    private final String classname;
    private static final Device INVALID_DEVICE = new Device(-1, "empty", 0, "empty", 0);
    private ArrayList lastConnectedDevicesASLExtended2;
    private int initialConnectionType = 1;
    private static final short VERSION;
    private static final short[] SUPPORTED_VERSIONS;
    private static final short LAST_CONNECTED_DEVICES_LIST_SIZE;
    private HsmTarget target;

    public SmartPhoneIntegrationPersistence(HsmTarget hsmTarget) {
        super(5028, 0);
        this.classname = "SmartPhoneIntegrationPersistence";
        this.target = hsmTarget;
        this.createLastConnectedDevicesList();
    }

    private void createLastConnectedDevicesList() {
        this.lastConnectedDevicesASLExtended2 = new ArrayList();
        for (int i2 = 0; i2 < 10; ++i2) {
            this.lastConnectedDevicesASLExtended2.add(new DeviceASLExtended(INVALID_DEVICE));
        }
    }

    @Override
    public void clear() {
        if (this.target.isTraceEnabled()) {
            this.getTarget().trace().append("SmartPhoneIntegrationPersistence").append(".clear( )").log();
        }
        this.initialConnectionType = 1;
        ServiceManager.aslPropertyManager.valueChangedInteger(1164389376, this.initialConnectionType);
        this.createLastConnectedDevicesList();
        this.printLastConnectedDevicesList();
        this.markDirty(true);
    }

    @Override
    public void toStreamInternal(PersistenceOutputStream persistenceOutputStream) {
        if (this.target.isTraceEnabled()) {
            this.getTarget().trace().append("SmartPhoneIntegrationPersistence").append(".toStreamInternal( )").log();
        }
        for (int i2 = 0; i2 < this.lastConnectedDevicesASLExtended2.size(); ++i2) {
            DeviceASLExtended deviceASLExtended = (DeviceASLExtended)this.lastConnectedDevicesASLExtended2.get(i2);
            persistenceOutputStream.writeString(deviceASLExtended.getDeviceAddress());
            persistenceOutputStream.writeInt(deviceASLExtended.getConnectionMethod());
            persistenceOutputStream.writeInt(deviceASLExtended.getLastConnectionMethod());
            persistenceOutputStream.writeBoolean(deviceASLExtended.isBlacklisted());
        }
        persistenceOutputStream.writeInt(this.getInitialConnectionType());
    }

    @Override
    public void fromStreamInternal(PersistenceInputStream persistenceInputStream, short s) {
        for (int i2 = 0; i2 < this.lastConnectedDevicesASLExtended2.size(); ++i2) {
            DeviceASLExtended deviceASLExtended = new DeviceASLExtended();
            deviceASLExtended.getDsiDevice().deviceAddress = persistenceInputStream.readString();
            deviceASLExtended.getDsiDevice().connectionMethod = persistenceInputStream.readInt();
            deviceASLExtended.setLastConnectionMethod(persistenceInputStream.readInt());
            this.lastConnectedDevicesASLExtended2.set(i2, deviceASLExtended);
            deviceASLExtended.setBlacklisted(persistenceInputStream.readBoolean());
        }
        this.setInitialConnectionType(persistenceInputStream.readInt());
        if (this.target.isTraceEnabled()) {
            this.getTarget().trace().append("SmartPhoneIntegrationPersistence").append(new StringBuffer().append(".fromStreamInternal(initial connectiontype=").append(this.getInitialConnectionType()).append(")").toString()).log();
        }
    }

    @Override
    public void clearUnknownValues(short s) {
    }

    @Override
    public short[] getSupportedVersions() {
        return SUPPORTED_VERSIONS;
    }

    @Override
    public short getVersion() {
        return 6;
    }

    public void updateLastConnectedDevices(DeviceASLExtended deviceASLExtended) {
        if (this.target.isTraceEnabled()) {
            this.getTarget().trace().append("SmartPhoneIntegrationPersistence").append(new StringBuffer().append(".updateLastConnectedDevices(").append(deviceASLExtended != null ? deviceASLExtended.toString() : "NULL").append(")").toString()).log();
        }
        if (deviceASLExtended != null) {
            if (!this.lastConnectedDevicesASLExtended2.contains(deviceASLExtended)) {
                if (this.lastConnectedDevicesASLExtended2.size() == 10) {
                    this.lastConnectedDevicesASLExtended2.remove(this.lastConnectedDevicesASLExtended2.size() - 1);
                }
                this.lastConnectedDevicesASLExtended2.add(0, deviceASLExtended);
            } else {
                int n = this.lastConnectedDevicesASLExtended2.indexOf(deviceASLExtended);
                this.lastConnectedDevicesASLExtended2.remove(n);
                this.lastConnectedDevicesASLExtended2.add(0, deviceASLExtended);
            }
        }
        this.printLastConnectedDevicesList();
        this.markDirty(true);
    }

    private HsmTarget getTarget() {
        return this.target;
    }

    public DeviceASLExtended[] getLastConnectedDevicesList() {
        DeviceASLExtended[] deviceASLExtendedArray = (DeviceASLExtended[])this.lastConnectedDevicesASLExtended2.toArray(new DeviceASLExtended[this.lastConnectedDevicesASLExtended2.size()]);
        if (this.target.isTraceEnabled()) {
            this.getTarget().trace().append("SmartPhoneIntegrationPersistence").append(".getLastConnectedDevicesList()").log();
            this.printLastConnectedDevicesList();
        }
        return deviceASLExtendedArray;
    }

    public void printLastConnectedDevicesList() {
        if (this.target.isTraceEnabled() && this.lastConnectedDevicesASLExtended2 != null) {
            for (int i2 = 0; i2 < this.lastConnectedDevicesASLExtended2.size(); ++i2) {
                DeviceASLExtended deviceASLExtended = (DeviceASLExtended)this.lastConnectedDevicesASLExtended2.get(i2);
                this.getTarget().trace().append("SmartPhoneIntegrationPersistence").append(new StringBuffer().append(".######## printLastConnectedDevicesList: device[").append(i2).append("](").append(deviceASLExtended.toString()).append(")").toString()).log();
            }
        }
    }

    public int getInitialConnectionType() {
        if (this.target.isTraceEnabled()) {
            this.getTarget().trace().append("SmartPhoneIntegrationPersistence").append(".getInitialConnectionType( ").append(new StringBuffer().append(this.initialConnectionType).append(" )").toString()).log();
        }
        return this.initialConnectionType;
    }

    public void setInitialConnectionType(int n) {
        this.initialConnectionType = n;
        this.markDirty(true);
    }

    public void addDeviceToBlackList(DeviceASLExtended deviceASLExtended) {
        if (this.target.isTraceEnabled()) {
            this.getTarget().trace().append("SmartPhoneIntegrationPersistence").append(".addDeviceToBlackList()").append(deviceASLExtended.toString()).log();
        }
        deviceASLExtended.setBlacklisted(true);
        this.updateLastConnectedDevices(deviceASLExtended);
    }

    static {
        SUPPORTED_VERSIONS = NO_SUPPORTED_VERSION;
    }
}

