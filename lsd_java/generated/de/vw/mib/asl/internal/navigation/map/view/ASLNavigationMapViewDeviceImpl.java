/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.map.view;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLNavigationMapViewDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationMapViewDeviceImpl INSTANCE = new ASLNavigationMapViewDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLNavigationMapViewDeviceImpl() {
    }

    public static ASLNavigationMapViewDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.Map.View";
    }

    @Override
    public int getTargetId() {
        return 10050;
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
        serviceRegister.registerService(1674121280, 10050);
        serviceRegister.registerService(1157759040, 10050);
        serviceRegister.registerService(1174536256, 10050);
        serviceRegister.registerService(1191313472, 10050);
        serviceRegister.registerService(1208090688, 10050);
        serviceRegister.registerService(1086918720, 10050);
        serviceRegister.registerService(1224867904, 10050);
        serviceRegister.registerService(1241645120, 10050);
        serviceRegister.registerService(1258422336, 10050);
        serviceRegister.registerService(1275199552, 10050);
        serviceRegister.registerService(1607012416, 10050);
        serviceRegister.registerService(1308753984, 10050);
        serviceRegister.registerService(1325531200, 10050);
        serviceRegister.registerService(420151360, 10050);
        serviceRegister.registerService(1342308416, 10050);
        serviceRegister.registerService(1359085632, 10050);
        serviceRegister.registerService(1375862848, 10050);
        serviceRegister.registerService(1392640064, 10050);
        serviceRegister.registerService(1409417280, 10050);
        serviceRegister.registerService(1426194496, 10050);
        serviceRegister.registerService(1442971712, 10050);
        serviceRegister.registerService(-1458962368, 10050);
        serviceRegister.registerService(1459748928, 10050);
        serviceRegister.registerService(201982016, 10050);
        serviceRegister.registerService(420085824, 10050);
        serviceRegister.registerService(-523759552, 10050);
        serviceRegister.registerService(-506982336, 10050);
        serviceRegister.registerService(348721216, 10050);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.Map.View: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.Map.View: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.Map.View: ").append(n).toString());
    }
}

