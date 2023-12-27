/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navmaptile.map.view;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLNavMapTileMapViewDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavMapTileMapViewDeviceImpl INSTANCE = new ASLNavMapTileMapViewDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLNavMapTileMapViewDeviceImpl() {
    }

    public static ASLNavMapTileMapViewDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "NavMapTile.Map.View";
    }

    @Override
    public int getTargetId() {
        return 16802;
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
        serviceRegister.registerService(1082153024, 16802);
        serviceRegister.registerService(1098930240, 16802);
        serviceRegister.registerService(1115707456, 16802);
        serviceRegister.registerService(1132484672, 16802);
        serviceRegister.registerService(1149261888, 16802);
        serviceRegister.registerService(1166039104, 16802);
        serviceRegister.registerService(1182816320, 16802);
        serviceRegister.registerService(1199593536, 16802);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device NavMapTile.Map.View: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device NavMapTile.Map.View: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device NavMapTile.Map.View: ").append(n).toString());
    }
}

