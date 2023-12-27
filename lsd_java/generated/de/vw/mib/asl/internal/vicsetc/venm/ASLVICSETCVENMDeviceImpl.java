/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.vicsetc.venm;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.vicsetc.venm.transformer.VICSETCVENMVenmDetailsCollector;
import generated.de.vw.mib.asl.internal.vicsetc.venm.transformer.VICSETCVENMVenmDetailsTransformer;

public final class ASLVICSETCVENMDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLVICSETCVENMDeviceImpl INSTANCE = new ASLVICSETCVENMDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;

    private ASLVICSETCVENMDeviceImpl() {
    }

    public static ASLVICSETCVENMDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "VICSETC.VENM";
    }

    @Override
    public int getTargetId() {
        return 16610;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1419400448, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(863196480, 16610);
        serviceRegister.registerService(879973696, 16610);
        serviceRegister.registerService(1064523072, 16610);
        serviceRegister.registerService(896750912, 16610);
        serviceRegister.registerService(1030968640, 16610);
        serviceRegister.registerService(1215518016, 16610);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 5610068: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device VICSETC.VENM: ").append(n).toString());
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
        return ASLVICSETCVENMDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLVICSETCVENMDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 5610068: {
                genericASLList = aSLListFactory.createGenericASLList(new VICSETCVENMVenmDetailsTransformer(), n, "VICSETC.VENM", "VenmDetails");
                genericASLList.updateList(new VICSETCVENMVenmDetailsCollector[]{new VICSETCVENMVenmDetailsCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device VICSETC.VENM: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

