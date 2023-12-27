/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.vicsetc;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLVICSETCDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLVICSETCDeviceImpl INSTANCE = new ASLVICSETCDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLVICSETCDeviceImpl() {
    }

    public static ASLVICSETCDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "VICSETC";
    }

    @Override
    public int getTargetId() {
        return 16601;
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
        serviceRegister.registerService(913528128, 16601);
        serviceRegister.registerService(1165186368, 16601);
        serviceRegister.registerService(1181963584, 16601);
        serviceRegister.registerService(1198740800, 16601);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device VICSETC: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device VICSETC: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device VICSETC: ").append(n).toString());
    }
}

