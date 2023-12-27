/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.messages.write;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLMessagesWriteDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLMessagesWriteDeviceImpl INSTANCE = new ASLMessagesWriteDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLMessagesWriteDeviceImpl() {
    }

    public static ASLMessagesWriteDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Messages.Write";
    }

    @Override
    public int getTargetId() {
        return 10035;
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
        serviceRegister.registerService(-1627324352, 10035);
        serviceRegister.registerService(-1610547136, 10035);
        serviceRegister.registerService(-1593769920, 10035);
        serviceRegister.registerService(-1576992704, 10035);
        serviceRegister.registerService(-1560215488, 10035);
        serviceRegister.registerService(-1543438272, 10035);
        serviceRegister.registerService(-1380250304, 10035);
        serviceRegister.registerService(-1526661056, 10035);
        serviceRegister.registerService(-1363473088, 10035);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Messages.Write: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Messages.Write: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Messages.Write: ").append(n).toString());
    }
}

