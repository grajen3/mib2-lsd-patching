/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.offroad;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLCarOffroadDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLCarOffroadDeviceImpl INSTANCE = new ASLCarOffroadDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLCarOffroadDeviceImpl() {
    }

    public static ASLCarOffroadDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Car.Offroad";
    }

    @Override
    public int getTargetId() {
        return 11021;
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
        serviceRegister.registerService(-435421120, 11021);
        serviceRegister.registerService(1510801472, 11021);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.Offroad: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.Offroad: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.Offroad: ").append(n).toString());
    }
}

