/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.webradio;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.asl.internal.webradio.transformer.WebRadioEpisodesListTransformer;
import de.vw.mib.asl.internal.webradio.transformer.WebRadioLastListenedListTransformer;
import de.vw.mib.asl.internal.webradio.transformer.WebRadioPresetListTransformer;
import de.vw.mib.asl.internal.webradio.transformer.WebRadioRelatedPodcastListTransformer;
import de.vw.mib.asl.internal.webradio.transformer.WebRadioRelatedStationListTransformer;
import de.vw.mib.asl.internal.webradio.transformer.WebRadioResultsListTransformer;
import de.vw.mib.asl.internal.webradio.transformer.WebRadioSimilarStationListTransformer;
import de.vw.mib.asl.internal.webradio.transformer.WebRadioStationListTransformer;
import de.vw.mib.asl.internal.webradio.transformer.WebRadioTruffleSearchProposalTransformer;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.webradio.transformer.WebRadioCurrentStationCollector;
import generated.de.vw.mib.asl.internal.webradio.transformer.WebRadioCurrentStationTransformer;

public final class ASLWebRadioDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLWebRadioDeviceImpl INSTANCE = new ASLWebRadioDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(10);
    private ASLListFactory listFactory;

    private ASLWebRadioDeviceImpl() {
    }

    public static ASLWebRadioDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "WebRadio";
    }

    @Override
    public int getTargetId() {
        return 17001;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-1464575232, this);
        aSLListRegistry.registerASLDevice(-1850451200, this);
        aSLListRegistry.registerASLDevice(-1816896768, this);
        aSLListRegistry.registerASLDevice(-1699456256, this);
        aSLListRegistry.registerASLDevice(-1665901824, this);
        aSLListRegistry.registerASLDevice(-1649124608, this);
        aSLListRegistry.registerASLDevice(-1632347392, this);
        aSLListRegistry.registerASLDevice(-1531684096, this);
        aSLListRegistry.registerASLDevice(-1615570176, this);
        aSLListRegistry.registerASLDevice(-1514906880, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1886561472, 17001);
        serviceRegister.registerService(-1869784256, 17001);
        serviceRegister.registerService(-2087888064, 17001);
        serviceRegister.registerService(-1953670336, 17001);
        serviceRegister.registerService(-2071110848, 17001);
        serviceRegister.registerService(-1936893120, 17001);
        serviceRegister.registerService(-2037556416, 17001);
        serviceRegister.registerService(-1920115904, 17001);
        serviceRegister.registerService(-1735566528, 17001);
        serviceRegister.registerService(-1903338688, 17001);
        serviceRegister.registerService(-1836229824, 17001);
        serviceRegister.registerService(-1819452608, 17001);
        serviceRegister.registerService(-1802675392, 17001);
        serviceRegister.registerService(-1785898176, 17001);
        serviceRegister.registerService(-1769120960, 17001);
        serviceRegister.registerService(-1752343744, 17001);
        serviceRegister.registerService(-2138219712, 17001);
        serviceRegister.registerService(-1651680448, 17001);
        serviceRegister.registerService(-2020779200, 17001);
        serviceRegister.registerService(-2004001984, 17001);
        serviceRegister.registerService(-1987224768, 17001);
        serviceRegister.registerService(-1970447552, 17001);
        serviceRegister.registerService(-2121442496, 17001);
        serviceRegister.registerService(-2104665280, 17001);
        serviceRegister.registerService(-2054333632, 17001);
        serviceRegister.registerService(-1853007040, 17001);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 6010024: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 6010001: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 6010003: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 6010010: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            case 6010012: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 6010013: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 6010014: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 6010020: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 6010015: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 6010021: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device WebRadio: ").append(n).toString());
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
        return ASLWebRadioDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLWebRadioDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 6010024: {
                genericASLList = aSLListFactory.createGenericASLList(new WebRadioEpisodesListTransformer(), n, "WebRadio", "EpisodesList");
                break;
            }
            case 6010001: {
                genericASLList = aSLListFactory.createGenericASLList(new WebRadioPresetListTransformer(), n, "WebRadio", "PresetList");
                break;
            }
            case 6010003: {
                genericASLList = aSLListFactory.createGenericASLList(new WebRadioCurrentStationTransformer(), n, "WebRadio", "CurrentStation");
                genericASLList.updateList(new WebRadioCurrentStationCollector[]{new WebRadioCurrentStationCollector()});
                break;
            }
            case 6010010: {
                genericASLList = aSLListFactory.createGenericASLList(new WebRadioStationListTransformer(), n, "WebRadio", "StationList");
                break;
            }
            case 6010012: {
                genericASLList = aSLListFactory.createGenericASLList(new WebRadioSimilarStationListTransformer(), n, "WebRadio", "SimilarStationList");
                break;
            }
            case 6010013: {
                genericASLList = aSLListFactory.createGenericASLList(new WebRadioRelatedStationListTransformer(), n, "WebRadio", "RelatedStationList");
                break;
            }
            case 6010014: {
                genericASLList = aSLListFactory.createGenericASLList(new WebRadioRelatedPodcastListTransformer(), n, "WebRadio", "RelatedPodcastList");
                break;
            }
            case 6010020: {
                genericASLList = aSLListFactory.createGenericASLList(new WebRadioResultsListTransformer(), n, "WebRadio", "ResultsList");
                break;
            }
            case 6010015: {
                genericASLList = aSLListFactory.createGenericASLList(new WebRadioLastListenedListTransformer(), n, "WebRadio", "LastListenedList");
                break;
            }
            case 6010021: {
                genericASLList = aSLListFactory.createGenericASLList(new WebRadioTruffleSearchProposalTransformer(), n, "WebRadio", "TruffleSearchProposal");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device WebRadio: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

