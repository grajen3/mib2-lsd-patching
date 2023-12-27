/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.exboxm;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLExBoxMDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLExBoxMDeviceImpl INSTANCE = new ASLExBoxMDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLExBoxMDeviceImpl() {
    }

    public static ASLExBoxMDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "ExBoxM";
    }

    @Override
    public int getTargetId() {
        return 10119;
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
        serviceRegister.registerService(1393033280, 10119);
        serviceRegister.registerService(1359609920, 10119);
        serviceRegister.registerService(-16252864, 10119);
        serviceRegister.registerService(1409810496, 10119);
        serviceRegister.registerService(-603455424, 10119);
        serviceRegister.registerService(-1123483584, 10119);
        serviceRegister.registerService(1622018624, 10119);
        serviceRegister.registerService(1638795840, 10119);
        serviceRegister.registerService(1655573056, 10119);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device ExBoxM: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device ExBoxM: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device ExBoxM: ").append(n).toString());
    }
}

