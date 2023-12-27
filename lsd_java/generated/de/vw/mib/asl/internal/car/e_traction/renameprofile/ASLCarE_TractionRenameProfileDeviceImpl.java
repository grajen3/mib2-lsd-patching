/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.car.e_traction.renameprofile;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLCarE_TractionRenameProfileDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLCarE_TractionRenameProfileDeviceImpl INSTANCE = new ASLCarE_TractionRenameProfileDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLCarE_TractionRenameProfileDeviceImpl() {
    }

    public static ASLCarE_TractionRenameProfileDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Car.E_Traction.RenameProfile";
    }

    @Override
    public int getTargetId() {
        return 11020;
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
        serviceRegister.registerService(-1022623680, 11020);
        serviceRegister.registerService(-1005846464, 11020);
        serviceRegister.registerService(504168512, 11020);
        serviceRegister.registerService(-972292032, 11020);
        serviceRegister.registerService(-955514816, 11020);
        serviceRegister.registerService(-938737600, 11020);
        serviceRegister.registerService(-921960384, 11020);
        serviceRegister.registerService(135069760, 11020);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.E_Traction.RenameProfile: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.E_Traction.RenameProfile: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Car.E_Traction.RenameProfile: ").append(n).toString());
    }
}

