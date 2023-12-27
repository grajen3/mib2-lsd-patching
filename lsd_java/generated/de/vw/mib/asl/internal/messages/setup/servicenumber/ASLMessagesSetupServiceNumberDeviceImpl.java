/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.messages.setup.servicenumber;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLMessagesSetupServiceNumberDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLMessagesSetupServiceNumberDeviceImpl INSTANCE = new ASLMessagesSetupServiceNumberDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLMessagesSetupServiceNumberDeviceImpl() {
    }

    public static ASLMessagesSetupServiceNumberDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Messages.Setup.ServiceNumber";
    }

    @Override
    public int getTargetId() {
        return 10034;
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
        serviceRegister.registerService(-1744764864, 10034);
        serviceRegister.registerService(-1727987648, 10034);
        serviceRegister.registerService(-1711210432, 10034);
        serviceRegister.registerService(-1694433216, 10034);
        serviceRegister.registerService(-1677656000, 10034);
        serviceRegister.registerService(-1660878784, 10034);
        serviceRegister.registerService(-1644101568, 10034);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Messages.Setup.ServiceNumber: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Messages.Setup.ServiceNumber: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Messages.Setup.ServiceNumber: ").append(n).toString());
    }
}

