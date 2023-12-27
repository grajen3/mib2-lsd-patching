/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navinfotile.maneuverviewtenitems;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navinfotile.maneuverviewtenitems.transformer.NavInfoTileManeuverViewTenItemsManeuverViewDataListTransformer;
import de.vw.mib.asl.internal.navinfotile.maneuverviewtenitems.transformer.NavInfoTileManeuverViewTenItemsManeuverViewDataTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLNavInfoTileManeuverViewTenItemsDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavInfoTileManeuverViewTenItemsDeviceImpl INSTANCE = new ASLNavInfoTileManeuverViewTenItemsDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLNavInfoTileManeuverViewTenItemsDeviceImpl() {
    }

    public static ASLNavInfoTileManeuverViewTenItemsDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "NavInfoTile.ManeuverViewTenItems";
    }

    @Override
    public int getTargetId() {
        return 16903;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(86923776, this);
        aSLListRegistry.registerASLDevice(707680768, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 5910021: {
                nArray = ListColumnsUtil.getSimpleIntArray(44);
                break;
            }
            case 5910058: {
                nArray = ListColumnsUtil.getSimpleIntArray(45);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device NavInfoTile.ManeuverViewTenItems: ").append(n).toString());
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
        return ASLNavInfoTileManeuverViewTenItemsDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavInfoTileManeuverViewTenItemsDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 5910021: {
                genericASLList = aSLListFactory.createGenericASLList(new NavInfoTileManeuverViewTenItemsManeuverViewDataTransformer(), n, "NavInfoTile.ManeuverViewTenItems", "ManeuverViewData");
                break;
            }
            case 5910058: {
                genericASLList = aSLListFactory.createGenericASLList(new NavInfoTileManeuverViewTenItemsManeuverViewDataListTransformer(), n, "NavInfoTile.ManeuverViewTenItems", "ManeuverViewDataList");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device NavInfoTile.ManeuverViewTenItems: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

