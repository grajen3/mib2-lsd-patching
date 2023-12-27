/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.homescreen.info;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLHomeScreenInfoDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLHomeScreenInfoDeviceImpl INSTANCE = new ASLHomeScreenInfoDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLHomeScreenInfoDeviceImpl() {
    }

    public static ASLHomeScreenInfoDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "HomeScreen.Info";
    }

    @Override
    public int getTargetId() {
        return 15902;
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
        serviceRegister.registerService(-1530639808, 15902);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device HomeScreen.Info: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device HomeScreen.Info: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device HomeScreen.Info: ").append(n).toString());
    }
}

