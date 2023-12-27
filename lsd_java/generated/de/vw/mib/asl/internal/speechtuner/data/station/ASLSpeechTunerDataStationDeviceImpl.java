/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechtuner.data.station;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.speechtuner.data.station.transformer.SpeechTunerDataStationDABServiceDetailListTransformer;
import de.vw.mib.asl.internal.speechtuner.data.station.transformer.SpeechTunerDataStationDABServiceListSelectedItemTransformer;
import de.vw.mib.asl.internal.speechtuner.data.station.transformer.SpeechTunerDataStationDABServiceListTransformer;
import de.vw.mib.asl.internal.speechtuner.data.station.transformer.SpeechTunerDataStationFMStationDetailListTransformer;
import de.vw.mib.asl.internal.speechtuner.data.station.transformer.SpeechTunerDataStationFMStationListSelectedItemTransformer;
import de.vw.mib.asl.internal.speechtuner.data.station.transformer.SpeechTunerDataStationFMStationListTransformer;
import de.vw.mib.asl.internal.speechtuner.data.station.transformer.SpeechTunerDataStationNbestTextTransformer;
import de.vw.mib.asl.internal.speechtuner.data.station.transformer.SpeechTunerDataStationSiriusChannelDetailListTransformer;
import de.vw.mib.asl.internal.speechtuner.data.station.transformer.SpeechTunerDataStationSiriusChannelListSelectedItemTransformer;
import de.vw.mib.asl.internal.speechtuner.data.station.transformer.SpeechTunerDataStationSiriusChannelListTransformer;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechTunerDataStationDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechTunerDataStationDeviceImpl INSTANCE = new ASLSpeechTunerDataStationDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(10);
    private ASLListFactory listFactory;

    private ASLSpeechTunerDataStationDeviceImpl() {
    }

    public static ASLSpeechTunerDataStationDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechTuner.Data.Station";
    }

    @Override
    public int getTargetId() {
        return 14805;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-752731648, this);
        aSLListRegistry.registerASLDevice(-735954432, this);
        aSLListRegistry.registerASLDevice(-719177216, this);
        aSLListRegistry.registerASLDevice(-635291136, this);
        aSLListRegistry.registerASLDevice(-618513920, this);
        aSLListRegistry.registerASLDevice(-601736704, this);
        aSLListRegistry.registerASLDevice(-517850624, this);
        aSLListRegistry.registerASLDevice(-501073408, this);
        aSLListRegistry.registerASLDevice(-484296192, this);
        aSLListRegistry.registerASLDevice(-467518976, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3810003: {
                nArray = ListColumnsUtil.getIntArrayByBits(480, 4);
                break;
            }
            case 3810004: {
                nArray = ListColumnsUtil.getIntArrayByBits(56, 3);
                break;
            }
            case 3810005: {
                nArray = ListColumnsUtil.getIntArrayByBits(480, 4);
                break;
            }
            case 3810010: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 3810011: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 3810012: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 3810017: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 3810018: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 3810019: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 3810020: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechTuner.Data.Station: ").append(n).toString());
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
        return ASLSpeechTunerDataStationDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLSpeechTunerDataStationDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3810003: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechTunerDataStationFMStationListTransformer(), n, "SpeechTuner.Data.Station", "FMStationList");
                break;
            }
            case 3810004: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechTunerDataStationFMStationDetailListTransformer(), n, "SpeechTuner.Data.Station", "FMStationDetailList");
                break;
            }
            case 3810005: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechTunerDataStationFMStationListSelectedItemTransformer(), n, "SpeechTuner.Data.Station", "FMStationListSelectedItem");
                break;
            }
            case 3810010: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechTunerDataStationDABServiceListTransformer(), n, "SpeechTuner.Data.Station", "DABServiceList");
                break;
            }
            case 3810011: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechTunerDataStationDABServiceDetailListTransformer(), n, "SpeechTuner.Data.Station", "DABServiceDetailList");
                break;
            }
            case 3810012: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechTunerDataStationDABServiceListSelectedItemTransformer(), n, "SpeechTuner.Data.Station", "DABServiceListSelectedItem");
                break;
            }
            case 3810017: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechTunerDataStationSiriusChannelListTransformer(), n, "SpeechTuner.Data.Station", "SiriusChannelList");
                break;
            }
            case 3810018: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechTunerDataStationSiriusChannelDetailListTransformer(), n, "SpeechTuner.Data.Station", "SiriusChannelDetailList");
                break;
            }
            case 3810019: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechTunerDataStationSiriusChannelListSelectedItemTransformer(), n, "SpeechTuner.Data.Station", "SiriusChannelListSelectedItem");
                break;
            }
            case 3810020: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechTunerDataStationNbestTextTransformer(), n, "SpeechTuner.Data.Station", "NbestText");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device SpeechTuner.Data.Station: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

