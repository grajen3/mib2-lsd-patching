/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.mirrorlink;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.mirrorlink.transformer.MirrorlinkAppListTransformer;
import de.vw.mib.asl.internal.mirrorlink.transformer.MirrorlinkDeviceListTransformer;
import de.vw.mib.asl.internal.mirrorlink.transformer.MirrorlinkDeviceListsTransformer;
import de.vw.mib.asl.internal.mirrorlink.transformer.MirrorlinkOpenAppListTransformer;
import de.vw.mib.asl.internal.mirrorlink.transformer.MirrorlinkSoftbuttonListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.mirrorlink.transformer.MirrorlinkAppNotificationPopupInfoCollector;
import generated.de.vw.mib.asl.internal.mirrorlink.transformer.MirrorlinkAppNotificationPopupInfoTransformer;
import generated.de.vw.mib.asl.internal.mirrorlink.transformer.MirrorlinkCanvasDimensionCollector;
import generated.de.vw.mib.asl.internal.mirrorlink.transformer.MirrorlinkCanvasDimensionTransformer;

public final class ASLMirrorlinkDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLMirrorlinkDeviceImpl INSTANCE = new ASLMirrorlinkDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(7);
    private ASLListFactory listFactory;

    private ASLMirrorlinkDeviceImpl() {
    }

    public static ASLMirrorlinkDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Mirrorlink";
    }

    @Override
    public int getTargetId() {
        return 10134;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(3545, this);
        aSLListRegistry.registerASLDevice(3419, this);
        aSLListRegistry.registerASLDevice(3700, this);
        aSLListRegistry.registerASLDevice(1550388992, this);
        aSLListRegistry.registerASLDevice(1567166208, this);
        aSLListRegistry.registerASLDevice(3556, this);
        aSLListRegistry.registerASLDevice(3773, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(1577713728, 10134);
        serviceRegister.registerService(-989200320, 10134);
        serviceRegister.registerService(-972423104, 10134);
        serviceRegister.registerService(-955645888, 10134);
        serviceRegister.registerService(1644822592, 10134);
        serviceRegister.registerService(1078071104, 10134);
        serviceRegister.registerService(1661599808, 10134);
        serviceRegister.registerService(1678377024, 10134);
        serviceRegister.registerService(1695154240, 10134);
        serviceRegister.registerService(1594490944, 10134);
        serviceRegister.registerService(-1643511744, 10134);
        serviceRegister.registerService(1460207680, 10134);
        serviceRegister.registerService(-167182272, 10134);
        serviceRegister.registerService(-301400000, 10134);
        serviceRegister.registerService(1476984896, 10134);
        serviceRegister.registerService(1145179968, 10134);
        serviceRegister.registerService(1094848320, 10134);
        serviceRegister.registerService(1527316544, 10134);
        serviceRegister.registerService(1376387136, 10134);
        serviceRegister.registerService(-267845568, 10134);
        serviceRegister.registerService(-251068352, 10134);
        serviceRegister.registerService(-234291136, 10134);
        serviceRegister.registerService(1544093760, 10134);
        serviceRegister.registerService(1161957184, 10134);
        serviceRegister.registerService(1779040320, 10134);
        serviceRegister.registerService(1560936512, 10134);
        serviceRegister.registerService(1225392192, 10134);
        serviceRegister.registerService(0x4A0A0040, 10134);
        serviceRegister.registerService(1560870976, 10134);
        serviceRegister.registerService(-1140195264, 10134);
        serviceRegister.registerService(-1609957312, 10134);
        serviceRegister.registerService(-1240858560, 10134);
        serviceRegister.registerService(2114650176, 10134);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3545: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 3419: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 3700: {
                nArray = ListColumnsUtil.getIntArrayByBits(5, 2);
                break;
            }
            case 1010012: {
                nArray = ListColumnsUtil.getIntArrayByBits(504, 6);
                break;
            }
            case 1010013: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 3556: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 3773: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Mirrorlink: ").append(n).toString());
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
        return ASLMirrorlinkDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLMirrorlinkDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3545: {
                genericASLList = aSLListFactory.createGenericASLList(new MirrorlinkOpenAppListTransformer(), n, "Mirrorlink", "OpenAppList");
                break;
            }
            case 3419: {
                genericASLList = aSLListFactory.createGenericASLList(new MirrorlinkAppListTransformer(), n, "Mirrorlink", "AppList");
                break;
            }
            case 3700: {
                genericASLList = aSLListFactory.createGenericASLList(new MirrorlinkDeviceListsTransformer(), n, "Mirrorlink", "DeviceLists");
                break;
            }
            case 1010012: {
                genericASLList = aSLListFactory.createGenericASLList(new MirrorlinkAppNotificationPopupInfoTransformer(), n, "Mirrorlink", "AppNotificationPopupInfo");
                genericASLList.updateList(new MirrorlinkAppNotificationPopupInfoCollector[]{new MirrorlinkAppNotificationPopupInfoCollector()});
                break;
            }
            case 1010013: {
                genericASLList = aSLListFactory.createGenericASLList(new MirrorlinkCanvasDimensionTransformer(), n, "Mirrorlink", "CanvasDimension");
                genericASLList.updateList(new MirrorlinkCanvasDimensionCollector[]{new MirrorlinkCanvasDimensionCollector()});
                break;
            }
            case 3556: {
                genericASLList = aSLListFactory.createGenericASLList(new MirrorlinkDeviceListTransformer(), n, "Mirrorlink", "DeviceList");
                break;
            }
            case 3773: {
                genericASLList = aSLListFactory.createGenericASLList(new MirrorlinkSoftbuttonListTransformer(), n, "Mirrorlink", "SoftbuttonList");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Mirrorlink: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

