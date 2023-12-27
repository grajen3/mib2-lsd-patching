/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.startupanimation;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLStartupAnimationDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLStartupAnimationDeviceImpl INSTANCE = new ASLStartupAnimationDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLStartupAnimationDeviceImpl() {
    }

    public static ASLStartupAnimationDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "StartupAnimation";
    }

    @Override
    public int getTargetId() {
        return 18001;
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
        serviceRegister.registerService(-1060148672, 18001);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device StartupAnimation: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device StartupAnimation: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device StartupAnimation: ").append(n).toString());
    }
}

