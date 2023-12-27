/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.map.rubberband;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLNavigationMapRubberbandDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationMapRubberbandDeviceImpl INSTANCE = new ASLNavigationMapRubberbandDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLNavigationMapRubberbandDeviceImpl() {
    }

    public static ASLNavigationMapRubberbandDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.Map.Rubberband";
    }

    @Override
    public int getTargetId() {
        return 12107;
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
        serviceRegister.registerService(-255324096, 12107);
        serviceRegister.registerService(-238546880, 12107);
        serviceRegister.registerService(-221769664, 12107);
        serviceRegister.registerService(-204992448, 12107);
        serviceRegister.registerService(-188215232, 12107);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.Map.Rubberband: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.Map.Rubberband: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.Map.Rubberband: ").append(n).toString());
    }
}

