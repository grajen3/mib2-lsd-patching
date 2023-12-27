/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.setup.bluetooth.name;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLPhoneSetupBluetoothNameDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneSetupBluetoothNameDeviceImpl INSTANCE = new ASLPhoneSetupBluetoothNameDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLPhoneSetupBluetoothNameDeviceImpl() {
    }

    public static ASLPhoneSetupBluetoothNameDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Phone.Setup.Bluetooth.Name";
    }

    @Override
    public int getTargetId() {
        return 10090;
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
        serviceRegister.registerService(-452788160, 10090);
        serviceRegister.registerService(-436010944, 10090);
        serviceRegister.registerService(-419233728, 10090);
        serviceRegister.registerService(-402456512, 10090);
        serviceRegister.registerService(-681831104, 10090);
        serviceRegister.registerService(-368902080, 10090);
        serviceRegister.registerService(-352124864, 10090);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Setup.Bluetooth.Name: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Setup.Bluetooth.Name: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Setup.Bluetooth.Name: ").append(n).toString());
    }
}

