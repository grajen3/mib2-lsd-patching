/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.messages.setup.email;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLMessagesSetupEMailDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLMessagesSetupEMailDeviceImpl INSTANCE = new ASLMessagesSetupEMailDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLMessagesSetupEMailDeviceImpl() {
    }

    public static ASLMessagesSetupEMailDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Messages.Setup.EMail";
    }

    @Override
    public int getTargetId() {
        return 10033;
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
        serviceRegister.registerService(-1778319296, 10033);
        serviceRegister.registerService(-1761542080, 10033);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Messages.Setup.EMail: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Messages.Setup.EMail: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Messages.Setup.EMail: ").append(n).toString());
    }
}

