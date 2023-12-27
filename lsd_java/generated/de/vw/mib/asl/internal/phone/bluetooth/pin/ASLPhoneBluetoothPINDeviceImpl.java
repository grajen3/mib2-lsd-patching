/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.bluetooth.pin;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLPhoneBluetoothPINDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneBluetoothPINDeviceImpl INSTANCE = new ASLPhoneBluetoothPINDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLPhoneBluetoothPINDeviceImpl() {
    }

    public static ASLPhoneBluetoothPINDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Phone.Bluetooth.PIN";
    }

    @Override
    public int getTargetId() {
        return 10073;
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
        serviceRegister.registerService(-1862074304, 10073);
        serviceRegister.registerService(-1845297088, 10073);
        serviceRegister.registerService(-1828519872, 10073);
        serviceRegister.registerService(-1811742656, 10073);
        serviceRegister.registerService(-782494400, 10073);
        serviceRegister.registerService(-1778188224, 10073);
        serviceRegister.registerService(-1761411008, 10073);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Bluetooth.PIN: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Bluetooth.PIN: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Bluetooth.PIN: ").append(n).toString());
    }
}

