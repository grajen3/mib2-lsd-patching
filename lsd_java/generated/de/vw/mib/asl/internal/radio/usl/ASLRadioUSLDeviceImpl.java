/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.radio.usl;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.radio.usl.transformer.RadioUSLPresetListTransformer;
import de.vw.mib.asl.internal.radio.usl.transformer.RadioUSLStationListInfoTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.radio.usl.transformer.RadioUSLCurrentStationCollector;
import generated.de.vw.mib.asl.internal.radio.usl.transformer.RadioUSLCurrentStationTransformer;

public final class ASLRadioUSLDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLRadioUSLDeviceImpl INSTANCE = new ASLRadioUSLDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(3);
    private ASLListFactory listFactory;

    private ASLRadioUSLDeviceImpl() {
    }

    public static ASLRadioUSLDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Radio.USL";
    }

    @Override
    public int getTargetId() {
        return 13401;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1237722112, this);
        aSLListRegistry.registerASLDevice(1288053760, this);
        aSLListRegistry.registerASLDevice(1321608192, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(463414336, 13401);
        serviceRegister.registerService(480191552, 13401);
        serviceRegister.registerService(496968768, 13401);
        serviceRegister.registerService(513745984, 13401);
        serviceRegister.registerService(530523200, 13401);
        serviceRegister.registerService(547300416, 13401);
        serviceRegister.registerService(564077632, 13401);
        serviceRegister.registerService(580854848, 13401);
        serviceRegister.registerService(597632064, 13401);
        serviceRegister.registerService(614409280, 13401);
        serviceRegister.registerService(899621952, 13401);
        serviceRegister.registerService(631186496, 13401);
        serviceRegister.registerService(916399168, 13401);
        serviceRegister.registerService(647963712, 13401);
        serviceRegister.registerService(832513088, 13401);
        serviceRegister.registerService(664740928, 13401);
        serviceRegister.registerService(681518144, 13401);
        serviceRegister.registerService(698295360, 13401);
        serviceRegister.registerService(715072576, 13401);
        serviceRegister.registerService(731849792, 13401);
        serviceRegister.registerService(748627008, 13401);
        serviceRegister.registerService(765404224, 13401);
        serviceRegister.registerService(782181440, 13401);
        serviceRegister.registerService(798958656, 13401);
        serviceRegister.registerService(815735872, 13401);
        serviceRegister.registerService(849290304, 13401);
        serviceRegister.registerService(866067520, 13401);
        serviceRegister.registerService(882844736, 13401);
        serviceRegister.registerService(933176384, 13401);
        serviceRegister.registerService(949953600, 13401);
        serviceRegister.registerService(966730816, 13401);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 2410057: {
                nArray = ListColumnsUtil.getSimpleIntArray(10);
                break;
            }
            case 2410060: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            case 2410062: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Radio.USL: ").append(n).toString());
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
        return ASLRadioUSLDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLRadioUSLDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 2410057: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioUSLStationListInfoTransformer(), n, "Radio.USL", "StationListInfo");
                break;
            }
            case 2410060: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioUSLCurrentStationTransformer(), n, "Radio.USL", "CurrentStation");
                genericASLList.updateList(new RadioUSLCurrentStationCollector[]{new RadioUSLCurrentStationCollector()});
                break;
            }
            case 2410062: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioUSLPresetListTransformer(), n, "Radio.USL", "PresetList");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Radio.USL: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

