/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navinfotile;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navinfotile.transformer.NavInfoTileManeuverViewDataListTransformer;
import de.vw.mib.asl.internal.navinfotile.transformer.NavInfoTileManeuverViewDataTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navinfotile.transformer.NavInfoTileCompassDataCollector;
import generated.de.vw.mib.asl.internal.navinfotile.transformer.NavInfoTileCompassDataTransformer;
import generated.de.vw.mib.asl.internal.navinfotile.transformer.NavInfoTileGPSViewerDataCollector;
import generated.de.vw.mib.asl.internal.navinfotile.transformer.NavInfoTileGPSViewerDataTransformer;
import generated.de.vw.mib.asl.internal.navinfotile.transformer.NavInfoTileManeuverExitViewDataCollector;
import generated.de.vw.mib.asl.internal.navinfotile.transformer.NavInfoTileManeuverExitViewDataTransformer;
import generated.de.vw.mib.asl.internal.navinfotile.transformer.NavInfoTileSymbolDataCollector;
import generated.de.vw.mib.asl.internal.navinfotile.transformer.NavInfoTileSymbolDataTransformer;

public final class ASLNavInfoTileDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavInfoTileDeviceImpl INSTANCE = new ASLNavInfoTileDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(6);
    private ASLListFactory listFactory;

    private ASLNavInfoTileDeviceImpl() {
    }

    public static ASLNavInfoTileDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "NavInfoTile";
    }

    @Override
    public int getTargetId() {
        return 16901;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-248686080, this);
        aSLListRegistry.registerASLDevice(-231908864, this);
        aSLListRegistry.registerASLDevice(3037696, this);
        aSLListRegistry.registerASLDevice(19814912, this);
        aSLListRegistry.registerASLDevice(36592128, this);
        aSLListRegistry.registerASLDevice(690903552, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-519677376, 16901);
        serviceRegister.registerService(-536454592, 16901);
        serviceRegister.registerService(-502900160, 16901);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 5910001: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 5910002: {
                nArray = ListColumnsUtil.getSimpleIntArray(21);
                break;
            }
            case 5910016: {
                nArray = ListColumnsUtil.getSimpleIntArray(18);
                break;
            }
            case 5910017: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 5910018: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 5910057: {
                nArray = ListColumnsUtil.getSimpleIntArray(19);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device NavInfoTile: ").append(n).toString());
            }
        }
        return nArray;
    }

    @Override
    public ASLList getASLList(int n) {
        return this.getGenericASLList(n);
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        return ASLNavInfoTileDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavInfoTileDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 5910001: {
                genericASLList = aSLListFactory.createGenericASLList(new NavInfoTileCompassDataTransformer(), n, "NavInfoTile", "CompassData");
                genericASLList.updateList(new NavInfoTileCompassDataCollector[]{new NavInfoTileCompassDataCollector()});
                break;
            }
            case 5910002: {
                genericASLList = aSLListFactory.createGenericASLList(new NavInfoTileGPSViewerDataTransformer(), n, "NavInfoTile", "GPSViewerData");
                genericASLList.updateList(new NavInfoTileGPSViewerDataCollector[]{new NavInfoTileGPSViewerDataCollector()});
                break;
            }
            case 5910016: {
                genericASLList = aSLListFactory.createGenericASLList(new NavInfoTileManeuverViewDataTransformer(), n, "NavInfoTile", "ManeuverViewData");
                break;
            }
            case 5910017: {
                genericASLList = aSLListFactory.createGenericASLList(new NavInfoTileManeuverExitViewDataTransformer(), n, "NavInfoTile", "ManeuverExitViewData");
                genericASLList.updateList(new NavInfoTileManeuverExitViewDataCollector[]{new NavInfoTileManeuverExitViewDataCollector()});
                break;
            }
            case 5910018: {
                genericASLList = aSLListFactory.createGenericASLList(new NavInfoTileSymbolDataTransformer(), n, "NavInfoTile", "SymbolData");
                genericASLList.updateList(new NavInfoTileSymbolDataCollector[]{new NavInfoTileSymbolDataCollector()});
                break;
            }
            case 5910057: {
                genericASLList = aSLListFactory.createGenericASLList(new NavInfoTileManeuverViewDataListTransformer(), n, "NavInfoTile", "ManeuverViewDataList");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device NavInfoTile: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

