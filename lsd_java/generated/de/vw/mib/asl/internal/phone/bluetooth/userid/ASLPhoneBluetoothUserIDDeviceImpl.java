/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.bluetooth.userid;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLPhoneBluetoothUserIDDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneBluetoothUserIDDeviceImpl INSTANCE = new ASLPhoneBluetoothUserIDDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLPhoneBluetoothUserIDDeviceImpl() {
    }

    public static ASLPhoneBluetoothUserIDDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Phone.Bluetooth.UserID";
    }

    @Override
    public int getTargetId() {
        return 10074;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1744633792, 10074);
        serviceRegister.registerService(-1727856576, 10074);
        serviceRegister.registerService(-1711079360, 10074);
        serviceRegister.registerService(-1694302144, 10074);
        serviceRegister.registerService(-765717184, 10074);
        serviceRegister.registerService(-1660747712, 10074);
        serviceRegister.registerService(-1643970496, 10074);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Bluetooth.UserID: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Bluetooth.UserID: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Bluetooth.UserID: ").append(n).toString());
    }
}

