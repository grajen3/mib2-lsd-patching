/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phonetiles;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLPhoneTileSDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneTileSDeviceImpl INSTANCE = new ASLPhoneTileSDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLPhoneTileSDeviceImpl() {
    }

    public static ASLPhoneTileSDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "PhoneTileS";
    }

    @Override
    public int getTargetId() {
        return 17701;
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
        serviceRegister.registerService(-365205952, 17701);
        serviceRegister.registerService(-348428736, 17701);
        serviceRegister.registerService(-147102144, 17701);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device PhoneTileS: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device PhoneTileS: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device PhoneTileS: ").append(n).toString());
    }
}

