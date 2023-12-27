/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.call.ocu;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLPhoneCallOCUDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneCallOCUDeviceImpl INSTANCE = new ASLPhoneCallOCUDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLPhoneCallOCUDeviceImpl() {
    }

    public static ASLPhoneCallOCUDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Phone.Call.OCU";
    }

    @Override
    public int getTargetId() {
        return 12401;
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
        serviceRegister.registerService(-346286784, 12401);
        serviceRegister.registerService(-295955136, 12401);
        serviceRegister.registerService(-279177920, 12401);
        serviceRegister.registerService(-262400704, 12401);
        serviceRegister.registerService(-329509568, 12401);
        serviceRegister.registerService(-480504512, 12401);
        serviceRegister.registerService(-312732352, 12401);
        serviceRegister.registerService(-463727296, 12401);
        serviceRegister.registerService(-1050929856, 12401);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Call.OCU: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Call.OCU: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Call.OCU: ").append(n).toString());
    }
}

