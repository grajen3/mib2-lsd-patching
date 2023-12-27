/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.setup.settings.dialprefix;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLPhoneSetupSettingsDialPrefixDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneSetupSettingsDialPrefixDeviceImpl INSTANCE = new ASLPhoneSetupSettingsDialPrefixDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLPhoneSetupSettingsDialPrefixDeviceImpl() {
    }

    public static ASLPhoneSetupSettingsDialPrefixDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Phone.Setup.Settings.DialPrefix";
    }

    @Override
    public int getTargetId() {
        return 10099;
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
        serviceRegister.registerService(704905280, 10099);
        serviceRegister.registerService(721682496, 10099);
        serviceRegister.registerService(738459712, 10099);
        serviceRegister.registerService(755236928, 10099);
        serviceRegister.registerService(-597945024, 10099);
        serviceRegister.registerService(788791360, 10099);
        serviceRegister.registerService(0x30040040, 10099);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Setup.Settings.DialPrefix: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Setup.Settings.DialPrefix: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Setup.Settings.DialPrefix: ").append(n).toString());
    }
}

