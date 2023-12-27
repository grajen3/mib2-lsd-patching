/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.radio.bap;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.radio.bap.transformer.RadioBapReceptionListAmTransformer;
import de.vw.mib.asl.internal.radio.bap.transformer.RadioBapReceptionListDabTransformer;
import de.vw.mib.asl.internal.radio.bap.transformer.RadioBapReceptionListFmTransformer;
import de.vw.mib.asl.internal.radio.bap.transformer.RadioBapReceptionListSdarsTransformer;
import de.vw.mib.asl.internal.radio.bap.transformer.RadioBapReceptionListTransformer;
import de.vw.mib.asl.internal.radio.bap.transformer.RadioBapReceptionListTvTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.radio.bap.transformer.RadioBapCurrentStationIndicesCollector;
import generated.de.vw.mib.asl.internal.radio.bap.transformer.RadioBapCurrentStationIndicesTransformer;
import generated.de.vw.mib.asl.internal.radio.bap.transformer.RadioBapStationLogoAMCollector;
import generated.de.vw.mib.asl.internal.radio.bap.transformer.RadioBapStationLogoAMTransformer;
import generated.de.vw.mib.asl.internal.radio.bap.transformer.RadioBapStationLogoDABCollector;
import generated.de.vw.mib.asl.internal.radio.bap.transformer.RadioBapStationLogoDABTransformer;
import generated.de.vw.mib.asl.internal.radio.bap.transformer.RadioBapStationLogoFMCollector;
import generated.de.vw.mib.asl.internal.radio.bap.transformer.RadioBapStationLogoFMTransformer;
import generated.de.vw.mib.asl.internal.radio.bap.transformer.RadioBapStationLogoSiriusCollector;
import generated.de.vw.mib.asl.internal.radio.bap.transformer.RadioBapStationLogoSiriusTransformer;
import generated.de.vw.mib.asl.internal.radio.bap.transformer.RadioBapStationLogoUnifiedRadioCollector;
import generated.de.vw.mib.asl.internal.radio.bap.transformer.RadioBapStationLogoUnifiedRadioTransformer;
import generated.de.vw.mib.asl.internal.radio.bap.transformer.RadioBapStationLogoWebRadioCollector;
import generated.de.vw.mib.asl.internal.radio.bap.transformer.RadioBapStationLogoWebRadioTransformer;

public final class ASLRadioBapDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLRadioBapDeviceImpl INSTANCE = new ASLRadioBapDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(13);
    private ASLListFactory listFactory;

    private ASLRadioBapDeviceImpl() {
    }

    public static ASLRadioBapDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Radio.Bap";
    }

    @Override
    public int getTargetId() {
        return 10103;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1270, this);
        aSLListRegistry.registerASLDevice(3900, this);
        aSLListRegistry.registerASLDevice(1908810752, this);
        aSLListRegistry.registerASLDevice(3901, this);
        aSLListRegistry.registerASLDevice(3902, this);
        aSLListRegistry.registerASLDevice(3903, this);
        aSLListRegistry.registerASLDevice(2486, this);
        aSLListRegistry.registerASLDevice(1002841088, this);
        aSLListRegistry.registerASLDevice(1019618304, this);
        aSLListRegistry.registerASLDevice(1036395520, this);
        aSLListRegistry.registerASLDevice(1053172736, this);
        aSLListRegistry.registerASLDevice(1808147456, this);
        aSLListRegistry.registerASLDevice(1824924672, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(0x4A040040, 10103);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 1270: {
                nArray = ListColumnsUtil.getSimpleIntArray(12);
                break;
            }
            case 3900: {
                nArray = ListColumnsUtil.getSimpleIntArray(9);
                break;
            }
            case 2410097: {
                nArray = ListColumnsUtil.getSimpleIntArray(10);
                break;
            }
            case 3901: {
                nArray = ListColumnsUtil.getSimpleIntArray(9);
                break;
            }
            case 3902: {
                nArray = ListColumnsUtil.getSimpleIntArray(8);
                break;
            }
            case 3903: {
                nArray = ListColumnsUtil.getSimpleIntArray(10);
                break;
            }
            case 2486: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 2410043: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2410044: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2410045: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2410046: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2410091: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2410092: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Radio.Bap: ").append(n).toString());
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
        return ASLRadioBapDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLRadioBapDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 1270: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioBapReceptionListTransformer(), n, "Radio.Bap", "ReceptionList");
                break;
            }
            case 3900: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioBapReceptionListAmTransformer(), n, "Radio.Bap", "ReceptionListAm");
                break;
            }
            case 2410097: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioBapReceptionListFmTransformer(), n, "Radio.Bap", "ReceptionListFm");
                break;
            }
            case 3901: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioBapReceptionListDabTransformer(), n, "Radio.Bap", "ReceptionListDab");
                break;
            }
            case 3902: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioBapReceptionListSdarsTransformer(), n, "Radio.Bap", "ReceptionListSdars");
                break;
            }
            case 3903: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioBapReceptionListTvTransformer(), n, "Radio.Bap", "ReceptionListTv");
                break;
            }
            case 2486: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioBapCurrentStationIndicesTransformer(), n, "Radio.Bap", "CurrentStationIndices");
                genericASLList.updateList(new RadioBapCurrentStationIndicesCollector[]{new RadioBapCurrentStationIndicesCollector()});
                break;
            }
            case 2410043: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioBapStationLogoFMTransformer(), n, "Radio.Bap", "StationLogoFM");
                genericASLList.updateList(new RadioBapStationLogoFMCollector[]{new RadioBapStationLogoFMCollector()});
                break;
            }
            case 2410044: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioBapStationLogoAMTransformer(), n, "Radio.Bap", "StationLogoAM");
                genericASLList.updateList(new RadioBapStationLogoAMCollector[]{new RadioBapStationLogoAMCollector()});
                break;
            }
            case 2410045: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioBapStationLogoDABTransformer(), n, "Radio.Bap", "StationLogoDAB");
                genericASLList.updateList(new RadioBapStationLogoDABCollector[]{new RadioBapStationLogoDABCollector()});
                break;
            }
            case 2410046: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioBapStationLogoSiriusTransformer(), n, "Radio.Bap", "StationLogoSirius");
                genericASLList.updateList(new RadioBapStationLogoSiriusCollector[]{new RadioBapStationLogoSiriusCollector()});
                break;
            }
            case 2410091: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioBapStationLogoUnifiedRadioTransformer(), n, "Radio.Bap", "StationLogoUnifiedRadio");
                genericASLList.updateList(new RadioBapStationLogoUnifiedRadioCollector[]{new RadioBapStationLogoUnifiedRadioCollector()});
                break;
            }
            case 2410092: {
                genericASLList = aSLListFactory.createGenericASLList(new RadioBapStationLogoWebRadioTransformer(), n, "Radio.Bap", "StationLogoWebRadio");
                genericASLList.updateList(new RadioBapStationLogoWebRadioCollector[]{new RadioBapStationLogoWebRadioCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Radio.Bap: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

