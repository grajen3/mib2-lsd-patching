/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navinfotile.waypointmode;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLNavInfoTileWayPointModeDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavInfoTileWayPointModeDeviceImpl INSTANCE = new ASLNavInfoTileWayPointModeDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLNavInfoTileWayPointModeDeviceImpl() {
    }

    public static ASLNavInfoTileWayPointModeDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "NavInfoTile.WayPointMode";
    }

    @Override
    public int getTargetId() {
        return 16902;
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
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device NavInfoTile.WayPointMode: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device NavInfoTile.WayPointMode: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device NavInfoTile.WayPointMode: ").append(n).toString());
    }
}

