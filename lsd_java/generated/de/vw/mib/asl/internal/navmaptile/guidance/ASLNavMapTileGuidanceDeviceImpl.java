/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navmaptile.guidance;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navmaptile.guidance.transformer.NavMapTileGuidanceVZEVZAIconsTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navmaptile.guidance.transformer.NavMapTileGuidanceLaneGuidanceCollector;
import generated.de.vw.mib.asl.internal.navmaptile.guidance.transformer.NavMapTileGuidanceLaneGuidanceTransformer;

public final class ASLNavMapTileGuidanceDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavMapTileGuidanceDeviceImpl INSTANCE = new ASLNavMapTileGuidanceDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLNavMapTileGuidanceDeviceImpl() {
    }

    public static ASLNavMapTileGuidanceDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "NavMapTile.Guidance";
    }

    @Override
    public int getTargetId() {
        return 16804;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1537693696, this);
        aSLListRegistry.registerASLDevice(1571248128, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(1233147968, 16804);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 5810011: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 5810013: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device NavMapTile.Guidance: ").append(n).toString());
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
        return ASLNavMapTileGuidanceDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavMapTileGuidanceDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 5810011: {
                genericASLList = aSLListFactory.createGenericASLList(new NavMapTileGuidanceLaneGuidanceTransformer(), n, "NavMapTile.Guidance", "LaneGuidance");
                genericASLList.updateList(new NavMapTileGuidanceLaneGuidanceCollector[]{new NavMapTileGuidanceLaneGuidanceCollector()});
                break;
            }
            case 5810013: {
                genericASLList = aSLListFactory.createGenericASLList(new NavMapTileGuidanceVZEVZAIconsTransformer(), n, "NavMapTile.Guidance", "VZEVZAIcons");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device NavMapTile.Guidance: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

