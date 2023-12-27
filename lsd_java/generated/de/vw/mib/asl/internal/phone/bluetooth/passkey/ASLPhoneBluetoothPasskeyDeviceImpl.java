/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.bluetooth.passkey;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLPhoneBluetoothPasskeyDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneBluetoothPasskeyDeviceImpl INSTANCE = new ASLPhoneBluetoothPasskeyDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLPhoneBluetoothPasskeyDeviceImpl() {
    }

    public static ASLPhoneBluetoothPasskeyDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Phone.Bluetooth.Passkey";
    }

    @Override
    public int getTargetId() {
        return 10072;
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
        serviceRegister.registerService(-1996292032, 10072);
        serviceRegister.registerService(-1979514816, 10072);
        serviceRegister.registerService(-1962737600, 10072);
        serviceRegister.registerService(-1945960384, 10072);
        serviceRegister.registerService(-799271616, 10072);
        serviceRegister.registerService(-1912405952, 10072);
        serviceRegister.registerService(-1895628736, 10072);
        serviceRegister.registerService(-1878851520, 10072);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Bluetooth.Passkey: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Bluetooth.Passkey: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Bluetooth.Passkey: ").append(n).toString());
    }
}

