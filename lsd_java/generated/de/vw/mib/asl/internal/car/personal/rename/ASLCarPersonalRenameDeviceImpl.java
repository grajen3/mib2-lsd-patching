/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.personal.rename;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLCarPersonalRenameDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLCarPersonalRenameDeviceImpl INSTANCE = new ASLCarPersonalRenameDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLCarPersonalRenameDeviceImpl() {
    }

    public static ASLCarPersonalRenameDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Car.Personal.Rename";
    }

    @Override
    public int getTargetId() {
        return 11024;
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
        serviceRegister.registerService(-770965440, 11024);
        serviceRegister.registerService(-754188224, 11024);
        serviceRegister.registerService(520945728, 11024);
        serviceRegister.registerService(-720633792, 11024);
        serviceRegister.registerService(-703856576, 11024);
        serviceRegister.registerService(1477247040, 11024);
        serviceRegister.registerService(-687079360, 11024);
        serviceRegister.registerService(-670302144, 11024);
        serviceRegister.registerService(0x40D0040, 11024);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.Personal.Rename: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.Personal.Rename: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.Personal.Rename: ").append(n).toString());
    }
}

