/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.trafficminimap;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.trafficminimap.transformer.TrafficMiniMapAreaListTransformer;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.trafficminimap.transformer.TrafficMiniMapHotSpotMapCollector;
import generated.de.vw.mib.asl.internal.trafficminimap.transformer.TrafficMiniMapHotSpotMapTransformer;
import generated.de.vw.mib.asl.internal.trafficminimap.transformer.TrafficMiniMapLastRequestedMapDataCollector;
import generated.de.vw.mib.asl.internal.trafficminimap.transformer.TrafficMiniMapLastRequestedMapDataTransformer;

public final class ASLTrafficMiniMapDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLTrafficMiniMapDeviceImpl INSTANCE = new ASLTrafficMiniMapDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(3);
    private ASLListFactory listFactory;

    private ASLTrafficMiniMapDeviceImpl() {
    }

    public static ASLTrafficMiniMapDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "TrafficMiniMap";
    }

    @Override
    public int getTargetId() {
        return 13801;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-1847580160, this);
        aSLListRegistry.registerASLDevice(-1830802944, this);
        aSLListRegistry.registerASLDevice(-1763694080, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-2135348672, 13801);
        serviceRegister.registerService(-2118571456, 13801);
        serviceRegister.registerService(-2085017024, 13801);
        serviceRegister.registerService(-2034685376, 13801);
        serviceRegister.registerService(-2101794240, 13801);
        serviceRegister.registerService(-2068239808, 13801);
        serviceRegister.registerService(-2017908160, 13801);
        serviceRegister.registerService(-2051462592, 13801);
        serviceRegister.registerService(-2001130944, 13801);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 2810001: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 2810002: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 2810006: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device TrafficMiniMap: ").append(n).toString());
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
        return ASLTrafficMiniMapDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLTrafficMiniMapDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 2810001: {
                genericASLList = aSLListFactory.createGenericASLList(new TrafficMiniMapAreaListTransformer(), n, "TrafficMiniMap", "AreaList");
                break;
            }
            case 2810002: {
                genericASLList = aSLListFactory.createGenericASLList(new TrafficMiniMapHotSpotMapTransformer(), n, "TrafficMiniMap", "HotSpotMap");
                genericASLList.updateList(new TrafficMiniMapHotSpotMapCollector[]{new TrafficMiniMapHotSpotMapCollector()});
                break;
            }
            case 2810006: {
                genericASLList = aSLListFactory.createGenericASLList(new TrafficMiniMapLastRequestedMapDataTransformer(), n, "TrafficMiniMap", "LastRequestedMapData");
                genericASLList.updateList(new TrafficMiniMapLastRequestedMapDataCollector[]{new TrafficMiniMapLastRequestedMapDataCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device TrafficMiniMap: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

