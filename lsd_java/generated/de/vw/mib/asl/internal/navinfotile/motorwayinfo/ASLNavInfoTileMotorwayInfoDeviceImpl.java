/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navinfotile.motorwayinfo;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navinfotile.motorwayinfo.transformer.NavInfoTileMotorwayInfoMotorwayInfoDataTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLNavInfoTileMotorwayInfoDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavInfoTileMotorwayInfoDeviceImpl INSTANCE = new ASLNavInfoTileMotorwayInfoDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;

    private ASLNavInfoTileMotorwayInfoDeviceImpl() {
    }

    public static ASLNavInfoTileMotorwayInfoDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "NavInfoTile.MotorwayInfo";
    }

    @Override
    public int getTargetId() {
        return 16905;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(388913664, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 5910039: {
                nArray = ListColumnsUtil.getSimpleIntArray(12);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device NavInfoTile.MotorwayInfo: ").append(n).toString());
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
        return ASLNavInfoTileMotorwayInfoDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavInfoTileMotorwayInfoDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 5910039: {
                genericASLList = aSLListFactory.createGenericASLList(new NavInfoTileMotorwayInfoMotorwayInfoDataTransformer(), n, "NavInfoTile.MotorwayInfo", "MotorwayInfoData");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device NavInfoTile.MotorwayInfo: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

