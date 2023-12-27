/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.hmioffclock;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLHMIOffClockDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLHMIOffClockDeviceImpl INSTANCE = new ASLHMIOffClockDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLHMIOffClockDeviceImpl() {
    }

    public static ASLHMIOffClockDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "HMIOffClock";
    }

    @Override
    public int getTargetId() {
        return 17301;
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
        serviceRegister.registerService(1612800064, 17301);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device HMIOffClock: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device HMIOffClock: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device HMIOffClock: ").append(n).toString());
    }
}

