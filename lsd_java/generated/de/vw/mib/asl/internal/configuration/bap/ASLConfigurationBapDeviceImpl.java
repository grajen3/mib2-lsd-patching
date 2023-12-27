/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.configuration.bap;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLConfigurationBapDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLConfigurationBapDeviceImpl INSTANCE = new ASLConfigurationBapDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLConfigurationBapDeviceImpl() {
    }

    public static ASLConfigurationBapDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Configuration.Bap";
    }

    @Override
    public int getTargetId() {
        return 10022;
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
        serviceRegister.registerService(65600, 10022);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Configuration.Bap: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Configuration.Bap: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Configuration.Bap: ").append(n).toString());
    }
}

