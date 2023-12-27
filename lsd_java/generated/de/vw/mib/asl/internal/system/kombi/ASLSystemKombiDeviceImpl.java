/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.system.kombi;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSystemKombiDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSystemKombiDeviceImpl INSTANCE = new ASLSystemKombiDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSystemKombiDeviceImpl() {
    }

    public static ASLSystemKombiDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "System.Kombi";
    }

    @Override
    public int getTargetId() {
        return 13101;
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
        serviceRegister.registerService(604708928, 13101);
        serviceRegister.registerService(621486144, 13101);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device System.Kombi: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device System.Kombi: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device System.Kombi: ").append(n).toString());
    }
}

