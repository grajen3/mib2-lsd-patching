/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.homebutton;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLHomebuttonDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLHomebuttonDeviceImpl INSTANCE = new ASLHomebuttonDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLHomebuttonDeviceImpl() {
    }

    public static ASLHomebuttonDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Homebutton";
    }

    @Override
    public int getTargetId() {
        return 15601;
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
        serviceRegister.registerService(-1070578112, 15601);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Homebutton: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Homebutton: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Homebutton: ").append(n).toString());
    }
}

