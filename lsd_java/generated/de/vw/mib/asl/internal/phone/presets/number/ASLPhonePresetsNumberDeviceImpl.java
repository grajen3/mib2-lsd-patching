/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.presets.number;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLPhonePresetsNumberDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhonePresetsNumberDeviceImpl INSTANCE = new ASLPhonePresetsNumberDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLPhonePresetsNumberDeviceImpl() {
    }

    public static ASLPhonePresetsNumberDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Phone.Presets.Number";
    }

    @Override
    public int getTargetId() {
        return 10153;
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
        serviceRegister.registerService(1091240000, 10153);
        serviceRegister.registerService(1108017216, 10153);
        serviceRegister.registerService(1124794432, 10153);
        serviceRegister.registerService(0x440B0040, 10153);
        serviceRegister.registerService(-698608320, 10153);
        serviceRegister.registerService(1175126080, 10153);
        serviceRegister.registerService(-849603264, 10153);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Presets.Number: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Presets.Number: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Presets.Number: ").append(n).toString());
    }
}

