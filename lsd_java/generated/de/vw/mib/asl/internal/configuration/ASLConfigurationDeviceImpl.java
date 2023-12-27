/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.configuration;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLConfigurationDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLConfigurationDeviceImpl INSTANCE = new ASLConfigurationDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLConfigurationDeviceImpl() {
    }

    public static ASLConfigurationDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Configuration";
    }

    @Override
    public int getTargetId() {
        return 10023;
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
        serviceRegister.registerService(0x1010040, 10023);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Configuration: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Configuration: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Configuration: ").append(n).toString());
    }
}

