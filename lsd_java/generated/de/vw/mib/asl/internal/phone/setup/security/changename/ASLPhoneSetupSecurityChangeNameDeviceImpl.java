/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.setup.security.changename;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLPhoneSetupSecurityChangeNameDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneSetupSecurityChangeNameDeviceImpl INSTANCE = new ASLPhoneSetupSecurityChangeNameDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLPhoneSetupSecurityChangeNameDeviceImpl() {
    }

    public static ASLPhoneSetupSecurityChangeNameDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Phone.Setup.Security.ChangeName";
    }

    @Override
    public int getTargetId() {
        return 10096;
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
        serviceRegister.registerService(0xD040040, 10096);
        serviceRegister.registerService(0xE040040, 10096);
        serviceRegister.registerService(0xF040040, 10096);
        serviceRegister.registerService(0x10040040, 10096);
        serviceRegister.registerService(0x11040040, 10096);
        serviceRegister.registerService(302252096, 10096);
        serviceRegister.registerService(-631499456, 10096);
        serviceRegister.registerService(0x14040040, 10096);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Setup.Security.ChangeName: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Setup.Security.ChangeName: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Setup.Security.ChangeName: ").append(n).toString());
    }
}

