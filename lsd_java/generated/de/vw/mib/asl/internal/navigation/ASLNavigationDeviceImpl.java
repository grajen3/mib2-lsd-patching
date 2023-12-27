/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLNavigationDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationDeviceImpl INSTANCE = new ASLNavigationDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLNavigationDeviceImpl() {
    }

    public static ASLNavigationDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation";
    }

    @Override
    public int getTargetId() {
        return 10039;
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
        serviceRegister.registerService(-1089994688, 10039);
        serviceRegister.registerService(-889126848, 10039);
        serviceRegister.registerService(-872349632, 10039);
        serviceRegister.registerService(-972554176, 10039);
        serviceRegister.registerService(-855572416, 10039);
        serviceRegister.registerService(1493893184, 10039);
        serviceRegister.registerService(-838795200, 10039);
        serviceRegister.registerService(-389541824, 10039);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation: ").append(n).toString());
    }
}

