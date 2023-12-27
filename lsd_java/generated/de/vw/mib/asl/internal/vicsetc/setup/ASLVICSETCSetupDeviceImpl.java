/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.vicsetc.setup;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.asl.internal.vicsetc.setup.transformer.VICSETCSetupSetupVicsPrefectureListTransformer;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.vicsetc.setup.transformer.VICSETCSetupCardReaderInformationCollector;
import generated.de.vw.mib.asl.internal.vicsetc.setup.transformer.VICSETCSetupCardReaderInformationTransformer;
import generated.de.vw.mib.asl.internal.vicsetc.setup.transformer.VICSETCSetupSetupVicsStationInformationCollector;
import generated.de.vw.mib.asl.internal.vicsetc.setup.transformer.VICSETCSetupSetupVicsStationInformationTransformer;

public final class ASLVICSETCSetupDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLVICSETCSetupDeviceImpl INSTANCE = new ASLVICSETCSetupDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(3);
    private ASLListFactory listFactory;

    private ASLVICSETCSetupDeviceImpl() {
    }

    public static ASLVICSETCSetupDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "VICSETC.Setup";
    }

    @Override
    public int getTargetId() {
        return 16608;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(530208000, this);
        aSLListRegistry.registerASLDevice(798643456, this);
        aSLListRegistry.registerASLDevice(815420672, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(124998976, 16608);
        serviceRegister.registerService(1014191424, 16608);
        serviceRegister.registerService(259216704, 16608);
        serviceRegister.registerService(275993920, 16608);
        serviceRegister.registerService(292771136, 16608);
        serviceRegister.registerService(309548352, 16608);
        serviceRegister.registerService(141776192, 16608);
        serviceRegister.registerService(158553408, 16608);
        serviceRegister.registerService(175330624, 16608);
        serviceRegister.registerService(192107840, 16608);
        serviceRegister.registerService(208885056, 16608);
        serviceRegister.registerService(225662272, 16608);
        serviceRegister.registerService(393434432, 16608);
        serviceRegister.registerService(410211648, 16608);
        serviceRegister.registerService(426988864, 16608);
        serviceRegister.registerService(443766080, 16608);
        serviceRegister.registerService(460543296, 16608);
        serviceRegister.registerService(477320512, 16608);
        serviceRegister.registerService(494097728, 16608);
        serviceRegister.registerService(510874944, 16608);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 5610015: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 5610031: {
                nArray = ListColumnsUtil.getIntArrayByBits(62, 5);
                break;
            }
            case 5610032: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device VICSETC.Setup: ").append(n).toString());
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
        return ASLVICSETCSetupDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLVICSETCSetupDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 5610015: {
                genericASLList = aSLListFactory.createGenericASLList(new VICSETCSetupCardReaderInformationTransformer(), n, "VICSETC.Setup", "CardReaderInformation");
                genericASLList.updateList(new VICSETCSetupCardReaderInformationCollector[]{new VICSETCSetupCardReaderInformationCollector()});
                break;
            }
            case 5610031: {
                genericASLList = aSLListFactory.createGenericASLList(new VICSETCSetupSetupVicsStationInformationTransformer(), n, "VICSETC.Setup", "SetupVicsStationInformation");
                genericASLList.updateList(new VICSETCSetupSetupVicsStationInformationCollector[]{new VICSETCSetupSetupVicsStationInformationCollector()});
                break;
            }
            case 5610032: {
                genericASLList = aSLListFactory.createGenericASLList(new VICSETCSetupSetupVicsPrefectureListTransformer(), n, "VICSETC.Setup", "SetupVicsPrefectureList");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device VICSETC.Setup: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

