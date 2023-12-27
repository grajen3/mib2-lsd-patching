/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.setup.security.pin;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLPhoneSetupSecurityPINDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneSetupSecurityPINDeviceImpl INSTANCE = new ASLPhoneSetupSecurityPINDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLPhoneSetupSecurityPINDeviceImpl() {
    }

    public static ASLPhoneSetupSecurityPINDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Phone.Setup.Security.PIN";
    }

    @Override
    public int getTargetId() {
        return 10097;
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
        serviceRegister.registerService(352583744, 10097);
        serviceRegister.registerService(369360960, 10097);
        serviceRegister.registerService(386138176, 10097);
        serviceRegister.registerService(402915392, 10097);
        serviceRegister.registerService(419692608, 10097);
        serviceRegister.registerService(436469824, 10097);
        serviceRegister.registerService(386531392, 10097);
        serviceRegister.registerService(-614722240, 10097);
        serviceRegister.registerService(486801472, 10097);
        serviceRegister.registerService(503578688, 10097);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Setup.Security.PIN: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Setup.Security.PIN: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Setup.Security.PIN: ").append(n).toString());
    }
}

