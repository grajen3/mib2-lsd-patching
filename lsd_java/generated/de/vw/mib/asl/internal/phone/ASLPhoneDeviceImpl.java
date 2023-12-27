/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLPhoneDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneDeviceImpl INSTANCE = new ASLPhoneDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLPhoneDeviceImpl() {
    }

    public static ASLPhoneDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Phone";
    }

    @Override
    public int getTargetId() {
        return 10063;
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
        serviceRegister.registerService(1711472704, 10063);
        serviceRegister.registerService(1728249920, 10063);
        serviceRegister.registerService(1745027136, 10063);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone: ").append(n).toString());
    }
}

