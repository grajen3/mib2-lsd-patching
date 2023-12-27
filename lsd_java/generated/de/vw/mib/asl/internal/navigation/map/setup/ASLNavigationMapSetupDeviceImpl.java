/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.map.setup;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLNavigationMapSetupDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationMapSetupDeviceImpl INSTANCE = new ASLNavigationMapSetupDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLNavigationMapSetupDeviceImpl() {
    }

    public static ASLNavigationMapSetupDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.Map.Setup";
    }

    @Override
    public int getTargetId() {
        return 10048;
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
        serviceRegister.registerService(805437504, 10048);
        serviceRegister.registerService(822214720, 10048);
        serviceRegister.registerService(838991936, 10048);
        serviceRegister.registerService(855769152, 10048);
        serviceRegister.registerService(872546368, 10048);
        serviceRegister.registerService(889323584, 10048);
        serviceRegister.registerService(906100800, 10048);
        serviceRegister.registerService(922878016, 10048);
        serviceRegister.registerService(-32964544, 10048);
        serviceRegister.registerService(0xA0A0040, 10048);
        serviceRegister.registerService(-1962213312, 10048);
        serviceRegister.registerService(-1945436096, 10048);
        serviceRegister.registerService(-1928658880, 10048);
        serviceRegister.registerService(-456650688, 10048);
        serviceRegister.registerService(-439873472, 10048);
        serviceRegister.registerService(-423096256, 10048);
        serviceRegister.registerService(-406319040, 10048);
        serviceRegister.registerService(1506349120, 10048);
        serviceRegister.registerService(1774784576, 10048);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.Map.Setup: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.Map.Setup: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.Map.Setup: ").append(n).toString());
    }
}

