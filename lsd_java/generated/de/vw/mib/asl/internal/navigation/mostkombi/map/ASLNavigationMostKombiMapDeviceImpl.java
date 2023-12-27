/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.mostkombi.map;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLNavigationMostKombiMapDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationMostKombiMapDeviceImpl INSTANCE = new ASLNavigationMostKombiMapDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLNavigationMostKombiMapDeviceImpl() {
    }

    public static ASLNavigationMostKombiMapDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.MostKombi.Map";
    }

    @Override
    public int getTargetId() {
        return 12108;
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
        serviceRegister.registerService(-171438016, 12108);
        serviceRegister.registerService(-154660800, 12108);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.MostKombi.Map: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.MostKombi.Map: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.MostKombi.Map: ").append(n).toString());
    }
}

