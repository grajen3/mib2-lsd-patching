/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.callstacks;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLPhoneCallstacksDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneCallstacksDeviceImpl INSTANCE = new ASLPhoneCallstacksDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLPhoneCallstacksDeviceImpl() {
    }

    public static ASLPhoneCallstacksDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Phone.Callstacks";
    }

    @Override
    public int getTargetId() {
        return 10082;
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
        serviceRegister.registerService(-1123876800, 10082);
        serviceRegister.registerService(-1107099584, 10082);
        serviceRegister.registerService(-1090322368, 10082);
        serviceRegister.registerService(-497281728, 10082);
        serviceRegister.registerService(-514058944, 10082);
        serviceRegister.registerService(-1056767936, 10082);
        serviceRegister.registerService(-1039990720, 10082);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Callstacks: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Callstacks: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Callstacks: ").append(n).toString());
    }
}

