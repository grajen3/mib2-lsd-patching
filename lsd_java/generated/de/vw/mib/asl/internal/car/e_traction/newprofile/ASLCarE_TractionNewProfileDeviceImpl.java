/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.e_traction.newprofile;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLCarE_TractionNewProfileDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLCarE_TractionNewProfileDeviceImpl INSTANCE = new ASLCarE_TractionNewProfileDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLCarE_TractionNewProfileDeviceImpl() {
    }

    public static ASLCarE_TractionNewProfileDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Car.E_Traction.NewProfile";
    }

    @Override
    public int getTargetId() {
        return 11017;
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
        serviceRegister.registerService(-1190395840, 11017);
        serviceRegister.registerService(-1173618624, 11017);
        serviceRegister.registerService(487391296, 11017);
        serviceRegister.registerService(-1140064192, 11017);
        serviceRegister.registerService(-1123286976, 11017);
        serviceRegister.registerService(-1106509760, 11017);
        serviceRegister.registerService(118292544, 11017);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.E_Traction.NewProfile: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.E_Traction.NewProfile: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.E_Traction.NewProfile: ").append(n).toString());
    }
}

