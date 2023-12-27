/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navtraffictiles;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLNavTrafficTileSDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavTrafficTileSDeviceImpl INSTANCE = new ASLNavTrafficTileSDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLNavTrafficTileSDeviceImpl() {
    }

    public static ASLNavTrafficTileSDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "NavTrafficTileS";
    }

    @Override
    public int getTargetId() {
        return 17801;
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
        serviceRegister.registerService(-2134743232, 17801);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device NavTrafficTileS: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device NavTrafficTileS: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device NavTrafficTileS: ").append(n).toString());
    }
}

