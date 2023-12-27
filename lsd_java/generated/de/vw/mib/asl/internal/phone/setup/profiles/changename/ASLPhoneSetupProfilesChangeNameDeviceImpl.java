/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.setup.profiles.changename;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLPhoneSetupProfilesChangeNameDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneSetupProfilesChangeNameDeviceImpl INSTANCE = new ASLPhoneSetupProfilesChangeNameDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLPhoneSetupProfilesChangeNameDeviceImpl() {
    }

    public static ASLPhoneSetupProfilesChangeNameDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Phone.Setup.Profiles.ChangeName";
    }

    @Override
    public int getTargetId() {
        return 10094;
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
        serviceRegister.registerService(0x3040040, 10094);
        serviceRegister.registerService(0x4040040, 10094);
        serviceRegister.registerService(0x5040040, 10094);
        serviceRegister.registerService(0x6040040, 10094);
        serviceRegister.registerService(-648276672, 10094);
        serviceRegister.registerService(0x8040040, 10094);
        serviceRegister.registerService(0x9040040, 10094);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Setup.Profiles.ChangeName: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Setup.Profiles.ChangeName: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Setup.Profiles.ChangeName: ").append(n).toString());
    }
}

