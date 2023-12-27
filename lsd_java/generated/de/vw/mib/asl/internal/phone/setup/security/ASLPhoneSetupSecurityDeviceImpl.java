/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.setup.security;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLPhoneSetupSecurityDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneSetupSecurityDeviceImpl INSTANCE = new ASLPhoneSetupSecurityDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLPhoneSetupSecurityDeviceImpl() {
    }

    public static ASLPhoneSetupSecurityDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Phone.Setup.Security";
    }

    @Override
    public int getTargetId() {
        return 10095;
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
        serviceRegister.registerService(369754176, 10095);
        serviceRegister.registerService(269090880, 10095);
        serviceRegister.registerService(0xB040040, 10095);
        serviceRegister.registerService(0xC040040, 10095);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Setup.Security: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Setup.Security: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Setup.Security: ").append(n).toString());
    }
}

