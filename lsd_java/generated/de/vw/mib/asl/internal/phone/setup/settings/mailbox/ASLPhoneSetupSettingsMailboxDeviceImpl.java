/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.setup.settings.mailbox;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLPhoneSetupSettingsMailboxDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneSetupSettingsMailboxDeviceImpl INSTANCE = new ASLPhoneSetupSettingsMailboxDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLPhoneSetupSettingsMailboxDeviceImpl() {
    }

    public static ASLPhoneSetupSettingsMailboxDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Phone.Setup.Settings.Mailbox";
    }

    @Override
    public int getTargetId() {
        return 10100;
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
        serviceRegister.registerService(822345792, 10100);
        serviceRegister.registerService(839123008, 10100);
        serviceRegister.registerService(0x33040040, 10100);
        serviceRegister.registerService(0x34040040, 10100);
        serviceRegister.registerService(889454656, 10100);
        serviceRegister.registerService(-581167808, 10100);
        serviceRegister.registerService(923009088, 10100);
        serviceRegister.registerService(939786304, 10100);
        serviceRegister.registerService(-816048832, 10100);
        serviceRegister.registerService(956563520, 10100);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Setup.Settings.Mailbox: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Setup.Settings.Mailbox: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Setup.Settings.Mailbox: ").append(n).toString());
    }
}

