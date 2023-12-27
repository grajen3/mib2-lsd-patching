/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navmaptile.map;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLNavMapTileMapDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavMapTileMapDeviceImpl INSTANCE = new ASLNavMapTileMapDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLNavMapTileMapDeviceImpl() {
    }

    public static ASLNavMapTileMapDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "NavMapTile.Map";
    }

    @Override
    public int getTargetId() {
        return 16803;
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
        serviceRegister.registerService(1216370752, 16803);
        serviceRegister.registerService(1249925184, 16803);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device NavMapTile.Map: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device NavMapTile.Map: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device NavMapTile.Map: ").append(n).toString());
    }
}

