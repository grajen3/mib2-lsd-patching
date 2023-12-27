/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.testmode;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeAFList_InformationTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeAMFMTimerValuesTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeAmplifierTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeAudioDevicesTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeAudioSourceListTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeAudioSubstatesTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeAudioUserConnectionsTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeAvailableSystemLanguagesTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeBluetoothDevicesInRangeTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeBluetoothDevicesSupportedServiceTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeBluetoothErrorLogTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeCarDeviceListsTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeCarViewOptionsTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeClampsGroupTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeConnectedUSBDeviceGroupTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeConstGroupTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeDABDataServiceListTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeDABLinkListTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeDABTIIListTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeDVDRegionSystemSettingsTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeDataBaseComponentsGroupTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeFeatFlagsGroupTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeHWRMatchListTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeHardKeysCounterTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeHardwareInfoTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeKernInfoString1Transformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeLanguageCodingsGroupTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeMOSTShutDownDeviceTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeMOSTSteuergeraeteFblockListTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeMOSTSteuergeraeteInformationListTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeMOSTSteuergeraeteListTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeMicrophonesTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeMostRegistryInformationsTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeMostTemperatureTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeNavTravelGuideGroupTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodePersistedProfileTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodePhoneMicrophoneListsTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodePluggedDevicesTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeSDSStatisticsTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeTMCMessagesListTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeTMCStationInfoTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeTopTwentySpeechCommandsTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeTracesHMICategoryTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeTracesHMISubTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeTracesSystemTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeUsersTransformer;
import de.vw.mib.asl.internal.testmode.transformer.TestmodeVolumeLevelSourcesTransformer;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeAMFMGroup1Collector;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeAMFMGroup1Transformer;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeAMFMGroup2Collector;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeAMFMGroup2Transformer;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeAMFMGroup3Collector;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeAMFMGroup3Transformer;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeAMFMGroupTMCCollector;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeAMFMGroupTMCTransformer;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeCurrentDABFaderCollector;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeCurrentDABFaderTransformer;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeIBOCGroupCollector;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeIBOCGroupTransformer;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeMediaFileInfoCollector;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeMediaFileInfoTransformer;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARSChannelParameterDecAlgCollector;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARSChannelParameterDecAlgTransformer;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARSChannelVectorCollector;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARSChannelVectorTransformer;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARSDemodSNRCollector;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARSDemodSNRTransformer;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARSGlobalInfoServiceChannelModeCollector;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARSGlobalInfoServiceChannelModeTransformer;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARSTDMAGCLockCollector;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARSTDMAGCLockTransformer;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARSTDMCAZACLockCollector;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARSTDMCAZACLockTransformer;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARSTDMClusterLockCollector;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARSTDMClusterLockTransformer;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARSTDMDemodLockCollector;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARSTDMDemodLockTransformer;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARSTDMLostLockCollector;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARSTDMLostLockTransformer;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARSTDMQuadLockCollector;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARSTDMQuadLockTransformer;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARSTDMTimingLockCollector;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARSTDMTimingLockTransformer;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARS_AGC_cofdmCollector;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARS_AGC_cofdmTransformer;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARS_AGC_tdmCollector;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARS_AGC_tdmIFCollector;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARS_AGC_tdmIFTransformer;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSDARS_AGC_tdmTransformer;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSoundsettingsCollector;
import generated.de.vw.mib.asl.internal.testmode.transformer.TestmodeSoundsettingsTransformer;

public final class ASLTestmodeDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLTestmodeDeviceImpl INSTANCE = new ASLTestmodeDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(69);
    private ASLListFactory listFactory;

    private ASLTestmodeDeviceImpl() {
    }

    public static ASLTestmodeDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Testmode";
    }

    @Override
    public int getTargetId() {
        return 10112;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(2246, this);
        aSLListRegistry.registerASLDevice(2247, this);
        aSLListRegistry.registerASLDevice(2248, this);
        aSLListRegistry.registerASLDevice(2249, this);
        aSLListRegistry.registerASLDevice(2250, this);
        aSLListRegistry.registerASLDevice(2251, this);
        aSLListRegistry.registerASLDevice(2252, this);
        aSLListRegistry.registerASLDevice(2253, this);
        aSLListRegistry.registerASLDevice(2254, this);
        aSLListRegistry.registerASLDevice(2255, this);
        aSLListRegistry.registerASLDevice(2256, this);
        aSLListRegistry.registerASLDevice(2257, this);
        aSLListRegistry.registerASLDevice(2258, this);
        aSLListRegistry.registerASLDevice(2259, this);
        aSLListRegistry.registerASLDevice(2260, this);
        aSLListRegistry.registerASLDevice(2261, this);
        aSLListRegistry.registerASLDevice(2262, this);
        aSLListRegistry.registerASLDevice(2263, this);
        aSLListRegistry.registerASLDevice(2264, this);
        aSLListRegistry.registerASLDevice(2265, this);
        aSLListRegistry.registerASLDevice(2266, this);
        aSLListRegistry.registerASLDevice(2267, this);
        aSLListRegistry.registerASLDevice(2268, this);
        aSLListRegistry.registerASLDevice(2269, this);
        aSLListRegistry.registerASLDevice(2270, this);
        aSLListRegistry.registerASLDevice(2271, this);
        aSLListRegistry.registerASLDevice(2272, this);
        aSLListRegistry.registerASLDevice(2273, this);
        aSLListRegistry.registerASLDevice(2274, this);
        aSLListRegistry.registerASLDevice(2275, this);
        aSLListRegistry.registerASLDevice(2276, this);
        aSLListRegistry.registerASLDevice(2277, this);
        aSLListRegistry.registerASLDevice(2278, this);
        aSLListRegistry.registerASLDevice(2279, this);
        aSLListRegistry.registerASLDevice(2280, this);
        aSLListRegistry.registerASLDevice(2281, this);
        aSLListRegistry.registerASLDevice(2282, this);
        aSLListRegistry.registerASLDevice(2283, this);
        aSLListRegistry.registerASLDevice(2284, this);
        aSLListRegistry.registerASLDevice(2285, this);
        aSLListRegistry.registerASLDevice(2286, this);
        aSLListRegistry.registerASLDevice(2287, this);
        aSLListRegistry.registerASLDevice(2288, this);
        aSLListRegistry.registerASLDevice(2289, this);
        aSLListRegistry.registerASLDevice(2290, this);
        aSLListRegistry.registerASLDevice(2291, this);
        aSLListRegistry.registerASLDevice(2292, this);
        aSLListRegistry.registerASLDevice(3935, this);
        aSLListRegistry.registerASLDevice(3936, this);
        aSLListRegistry.registerASLDevice(-659021568, this);
        aSLListRegistry.registerASLDevice(-608689920, this);
        aSLListRegistry.registerASLDevice(1719, this);
        aSLListRegistry.registerASLDevice(-692576000, this);
        aSLListRegistry.registerASLDevice(1957, this);
        aSLListRegistry.registerASLDevice(1976, this);
        aSLListRegistry.registerASLDevice(1979, this);
        aSLListRegistry.registerASLDevice(2002, this);
        aSLListRegistry.registerASLDevice(2020, this);
        aSLListRegistry.registerASLDevice(2021, this);
        aSLListRegistry.registerASLDevice(2022, this);
        aSLListRegistry.registerASLDevice(2094, this);
        aSLListRegistry.registerASLDevice(2157, this);
        aSLListRegistry.registerASLDevice(2163, this);
        aSLListRegistry.registerASLDevice(2164, this);
        aSLListRegistry.registerASLDevice(2165, this);
        aSLListRegistry.registerASLDevice(2170, this);
        aSLListRegistry.registerASLDevice(2196, this);
        aSLListRegistry.registerASLDevice(2208, this);
        aSLListRegistry.registerASLDevice(2220, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1064230592, 10112);
        serviceRegister.registerService(-1047453376, 10112);
        serviceRegister.registerService(-1030676160, 10112);
        serviceRegister.registerService(-1013898944, 10112);
        serviceRegister.registerService(1862598720, 10112);
        serviceRegister.registerService(1879375936, 10112);
        serviceRegister.registerService(1896153152, 10112);
        serviceRegister.registerService(1912930368, 10112);
        serviceRegister.registerService(1929707584, 10112);
        serviceRegister.registerService(1946484800, 10112);
        serviceRegister.registerService(1963262016, 10112);
        serviceRegister.registerService(1980039232, 10112);
        serviceRegister.registerService(1996816448, 10112);
        serviceRegister.registerService(2013593664, 10112);
        serviceRegister.registerService(2030370880, 10112);
        serviceRegister.registerService(2047148096, 10112);
        serviceRegister.registerService(2063925312, 10112);
        serviceRegister.registerService(2080702528, 10112);
        serviceRegister.registerService(2097479744, 10112);
        serviceRegister.registerService(2114256960, 10112);
        serviceRegister.registerService(2131034176, 10112);
        serviceRegister.registerService(-2147155904, 10112);
        serviceRegister.registerService(-2130378688, 10112);
        serviceRegister.registerService(-2113601472, 10112);
        serviceRegister.registerService(-2096824256, 10112);
        serviceRegister.registerService(-2080047040, 10112);
        serviceRegister.registerService(-2063269824, 10112);
        serviceRegister.registerService(-2046492608, 10112);
        serviceRegister.registerService(-2029715392, 10112);
        serviceRegister.registerService(-2012938176, 10112);
        serviceRegister.registerService(-1996160960, 10112);
        serviceRegister.registerService(-1979383744, 10112);
        serviceRegister.registerService(-1962606528, 10112);
        serviceRegister.registerService(-1945829312, 10112);
        serviceRegister.registerService(-1929052096, 10112);
        serviceRegister.registerService(-1912274880, 10112);
        serviceRegister.registerService(-1895497664, 10112);
        serviceRegister.registerService(-1878720448, 10112);
        serviceRegister.registerService(-1861943232, 10112);
        serviceRegister.registerService(-1845166016, 10112);
        serviceRegister.registerService(-1828388800, 10112);
        serviceRegister.registerService(-1811611584, 10112);
        serviceRegister.registerService(-1794834368, 10112);
        serviceRegister.registerService(-1778057152, 10112);
        serviceRegister.registerService(-1761279936, 10112);
        serviceRegister.registerService(-1744502720, 10112);
        serviceRegister.registerService(-1727725504, 10112);
        serviceRegister.registerService(-1710948288, 10112);
        serviceRegister.registerService(-1694171072, 10112);
        serviceRegister.registerService(-1677393856, 10112);
        serviceRegister.registerService(-1660616640, 10112);
        serviceRegister.registerService(-1643839424, 10112);
        serviceRegister.registerService(-1627062208, 10112);
        serviceRegister.registerService(-1610284992, 10112);
        serviceRegister.registerService(-1593507776, 10112);
        serviceRegister.registerService(-1576730560, 10112);
        serviceRegister.registerService(-1559953344, 10112);
        serviceRegister.registerService(-1543176128, 10112);
        serviceRegister.registerService(-1526398912, 10112);
        serviceRegister.registerService(-1509621696, 10112);
        serviceRegister.registerService(-1492844480, 10112);
        serviceRegister.registerService(-1476067264, 10112);
        serviceRegister.registerService(-1459290048, 10112);
        serviceRegister.registerService(-1442512832, 10112);
        serviceRegister.registerService(-1425735616, 10112);
        serviceRegister.registerService(-1408958400, 10112);
        serviceRegister.registerService(-1392181184, 10112);
        serviceRegister.registerService(-1375403968, 10112);
        serviceRegister.registerService(-1358626752, 10112);
        serviceRegister.registerService(-1341849536, 10112);
        serviceRegister.registerService(-1325072320, 10112);
        serviceRegister.registerService(-1308295104, 10112);
        serviceRegister.registerService(-1291517888, 10112);
        serviceRegister.registerService(-1274740672, 10112);
        serviceRegister.registerService(-1257963456, 10112);
        serviceRegister.registerService(-1241186240, 10112);
        serviceRegister.registerService(-1224409024, 10112);
        serviceRegister.registerService(-1207631808, 10112);
        serviceRegister.registerService(-1190854592, 10112);
        serviceRegister.registerService(-997121728, 10112);
        serviceRegister.registerService(-1174077376, 10112);
        serviceRegister.registerService(-1157300160, 10112);
        serviceRegister.registerService(-1140522944, 10112);
        serviceRegister.registerService(-1123745728, 10112);
        serviceRegister.registerService(-1106968512, 10112);
        serviceRegister.registerService(-1090191296, 10112);
        serviceRegister.registerService(-1073414080, 10112);
        serviceRegister.registerService(-1056636864, 10112);
        serviceRegister.registerService(-1039859648, 10112);
        serviceRegister.registerService(-1023082432, 10112);
        serviceRegister.registerService(-1006305216, 10112);
        serviceRegister.registerService(-989528000, 10112);
        serviceRegister.registerService(-972750784, 10112);
        serviceRegister.registerService(-955973568, 10112);
        serviceRegister.registerService(-939196352, 10112);
        serviceRegister.registerService(-922419136, 10112);
        serviceRegister.registerService(-905641920, 10112);
        serviceRegister.registerService(-888864704, 10112);
        serviceRegister.registerService(-872087488, 10112);
        serviceRegister.registerService(-855310272, 10112);
        serviceRegister.registerService(-838533056, 10112);
        serviceRegister.registerService(-821755840, 10112);
        serviceRegister.registerService(-804978624, 10112);
        serviceRegister.registerService(-788201408, 10112);
        serviceRegister.registerService(-771424192, 10112);
        serviceRegister.registerService(-754646976, 10112);
        serviceRegister.registerService(-737869760, 10112);
        serviceRegister.registerService(-721092544, 10112);
        serviceRegister.registerService(-704315328, 10112);
        serviceRegister.registerService(-687538112, 10112);
        serviceRegister.registerService(-670760896, 10112);
        serviceRegister.registerService(-653983680, 10112);
        serviceRegister.registerService(-637206464, 10112);
        serviceRegister.registerService(-620429248, 10112);
        serviceRegister.registerService(-603652032, 10112);
        serviceRegister.registerService(-586874816, 10112);
        serviceRegister.registerService(-570097600, 10112);
        serviceRegister.registerService(-553320384, 10112);
        serviceRegister.registerService(-536543168, 10112);
        serviceRegister.registerService(-519765952, 10112);
        serviceRegister.registerService(-502988736, 10112);
        serviceRegister.registerService(-486211520, 10112);
        serviceRegister.registerService(-469434304, 10112);
        serviceRegister.registerService(-452657088, 10112);
        serviceRegister.registerService(-435879872, 10112);
        serviceRegister.registerService(-419102656, 10112);
        serviceRegister.registerService(-402325440, 10112);
        serviceRegister.registerService(-385548224, 10112);
        serviceRegister.registerService(-368771008, 10112);
        serviceRegister.registerService(-351993792, 10112);
        serviceRegister.registerService(-335216576, 10112);
        serviceRegister.registerService(-318439360, 10112);
        serviceRegister.registerService(-301662144, 10112);
        serviceRegister.registerService(-284884928, 10112);
        serviceRegister.registerService(-268107712, 10112);
        serviceRegister.registerService(-251330496, 10112);
        serviceRegister.registerService(-234553280, 10112);
        serviceRegister.registerService(-217776064, 10112);
        serviceRegister.registerService(-200998848, 10112);
        serviceRegister.registerService(-184221632, 10112);
        serviceRegister.registerService(-167444416, 10112);
        serviceRegister.registerService(-150667200, 10112);
        serviceRegister.registerService(-133889984, 10112);
        serviceRegister.registerService(-117112768, 10112);
        serviceRegister.registerService(-100335552, 10112);
        serviceRegister.registerService(-83558336, 10112);
        serviceRegister.registerService(-66781120, 10112);
        serviceRegister.registerService(-50003904, 10112);
        serviceRegister.registerService(-33226688, 10112);
        serviceRegister.registerService(-16449472, 10112);
        serviceRegister.registerService(393280, 10112);
        serviceRegister.registerService(17170496, 10112);
        serviceRegister.registerService(33947712, 10112);
        serviceRegister.registerService(50724928, 10112);
        serviceRegister.registerService(0x4060040, 10112);
        serviceRegister.registerService(84279360, 10112);
        serviceRegister.registerService(0x6060040, 10112);
        serviceRegister.registerService(117833792, 10112);
        serviceRegister.registerService(134611008, 10112);
        serviceRegister.registerService(151388224, 10112);
        serviceRegister.registerService(168165440, 10112);
        serviceRegister.registerService(184942656, 10112);
        serviceRegister.registerService(201719872, 10112);
        serviceRegister.registerService(218497088, 10112);
        serviceRegister.registerService(235274304, 10112);
        serviceRegister.registerService(252051520, 10112);
        serviceRegister.registerService(268828736, 10112);
        serviceRegister.registerService(285605952, 10112);
        serviceRegister.registerService(302383168, 10112);
        serviceRegister.registerService(319160384, 10112);
        serviceRegister.registerService(335937600, 10112);
        serviceRegister.registerService(352714816, 10112);
        serviceRegister.registerService(369492032, 10112);
        serviceRegister.registerService(386269248, 10112);
        serviceRegister.registerService(403046464, 10112);
        serviceRegister.registerService(419823680, 10112);
        serviceRegister.registerService(436600896, 10112);
        serviceRegister.registerService(453378112, 10112);
        serviceRegister.registerService(470155328, 10112);
        serviceRegister.registerService(486932544, 10112);
        serviceRegister.registerService(503709760, 10112);
        serviceRegister.registerService(520486976, 10112);
        serviceRegister.registerService(537264192, 10112);
        serviceRegister.registerService(554041408, 10112);
        serviceRegister.registerService(570818624, 10112);
        serviceRegister.registerService(587595840, 10112);
        serviceRegister.registerService(604373056, 10112);
        serviceRegister.registerService(621150272, 10112);
        serviceRegister.registerService(637927488, 10112);
        serviceRegister.registerService(654704704, 10112);
        serviceRegister.registerService(671481920, 10112);
        serviceRegister.registerService(688259136, 10112);
        serviceRegister.registerService(705036352, 10112);
        serviceRegister.registerService(721813568, 10112);
        serviceRegister.registerService(738590784, 10112);
        serviceRegister.registerService(755368000, 10112);
        serviceRegister.registerService(772145216, 10112);
        serviceRegister.registerService(788922432, 10112);
        serviceRegister.registerService(805699648, 10112);
        serviceRegister.registerService(822476864, 10112);
        serviceRegister.registerService(-980344512, 10112);
        serviceRegister.registerService(-963567296, 10112);
        serviceRegister.registerService(-946790080, 10112);
        serviceRegister.registerService(-930012864, 10112);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 2246: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2247: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2248: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2249: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2250: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2251: {
                nArray = ListColumnsUtil.getSimpleIntArray(8);
                break;
            }
            case 2252: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 2253: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2254: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2255: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2256: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2257: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2258: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2259: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2260: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2261: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            case 2262: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 2263: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            case 2264: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 2265: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2266: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2267: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2268: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2269: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2270: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 2271: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2272: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 2273: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2274: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2275: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 2276: {
                nArray = ListColumnsUtil.getSimpleIntArray(26);
                break;
            }
            case 2277: {
                nArray = ListColumnsUtil.getSimpleIntArray(31);
                break;
            }
            case 2278: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            case 2279: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 2280: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2281: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2282: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2283: {
                nArray = ListColumnsUtil.getSimpleIntArray(8);
                break;
            }
            case 2284: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 2285: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 2286: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2287: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2288: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2289: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2290: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 2291: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2292: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            case 3935: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 3936: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2210008: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2210011: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1719: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2210006: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 1957: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 1976: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 1979: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2002: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2020: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2021: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2022: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2094: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2157: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2163: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2164: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2165: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2170: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2196: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2208: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2220: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Testmode: ").append(n).toString());
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
        return ASLTestmodeDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLTestmodeDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 2246: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeCurrentDABFaderTransformer(), n, "Testmode", "currentDABFader");
                genericASLList.updateList(new TestmodeCurrentDABFaderCollector[]{new TestmodeCurrentDABFaderCollector()});
                break;
            }
            case 2247: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeSDARS_AGC_cofdmTransformer(), n, "Testmode", "sDARS_AGC_cofdm");
                genericASLList.updateList(new TestmodeSDARS_AGC_cofdmCollector[]{new TestmodeSDARS_AGC_cofdmCollector()});
                break;
            }
            case 2248: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeSDARS_AGC_tdmTransformer(), n, "Testmode", "sDARS_AGC_tdm");
                genericASLList.updateList(new TestmodeSDARS_AGC_tdmCollector[]{new TestmodeSDARS_AGC_tdmCollector()});
                break;
            }
            case 2249: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeSDARS_AGC_tdmIFTransformer(), n, "Testmode", "sDARS_AGC_tdmIF");
                genericASLList.updateList(new TestmodeSDARS_AGC_tdmIFCollector[]{new TestmodeSDARS_AGC_tdmIFCollector()});
                break;
            }
            case 2250: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeSDARSChannelParameterDecAlgTransformer(), n, "Testmode", "sDARSChannelParameterDecAlg");
                genericASLList.updateList(new TestmodeSDARSChannelParameterDecAlgCollector[]{new TestmodeSDARSChannelParameterDecAlgCollector()});
                break;
            }
            case 2251: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeSDARSChannelVectorTransformer(), n, "Testmode", "sDARSChannelVector");
                genericASLList.updateList(new TestmodeSDARSChannelVectorCollector[]{new TestmodeSDARSChannelVectorCollector()});
                break;
            }
            case 2252: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeSDARSDemodSNRTransformer(), n, "Testmode", "sDARSDemodSNR");
                genericASLList.updateList(new TestmodeSDARSDemodSNRCollector[]{new TestmodeSDARSDemodSNRCollector()});
                break;
            }
            case 2253: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeSDARSGlobalInfoServiceChannelModeTransformer(), n, "Testmode", "sDARSGlobalInfoServiceChannelMode");
                genericASLList.updateList(new TestmodeSDARSGlobalInfoServiceChannelModeCollector[]{new TestmodeSDARSGlobalInfoServiceChannelModeCollector()});
                break;
            }
            case 2254: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeSDARSTDMAGCLockTransformer(), n, "Testmode", "sDARSTDMAGCLock");
                genericASLList.updateList(new TestmodeSDARSTDMAGCLockCollector[]{new TestmodeSDARSTDMAGCLockCollector()});
                break;
            }
            case 2255: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeSDARSTDMCAZACLockTransformer(), n, "Testmode", "sDARSTDMCAZACLock");
                genericASLList.updateList(new TestmodeSDARSTDMCAZACLockCollector[]{new TestmodeSDARSTDMCAZACLockCollector()});
                break;
            }
            case 2256: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeSDARSTDMClusterLockTransformer(), n, "Testmode", "sDARSTDMClusterLock");
                genericASLList.updateList(new TestmodeSDARSTDMClusterLockCollector[]{new TestmodeSDARSTDMClusterLockCollector()});
                break;
            }
            case 2257: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeSDARSTDMDemodLockTransformer(), n, "Testmode", "sDARSTDMDemodLock");
                genericASLList.updateList(new TestmodeSDARSTDMDemodLockCollector[]{new TestmodeSDARSTDMDemodLockCollector()});
                break;
            }
            case 2258: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeSDARSTDMLostLockTransformer(), n, "Testmode", "sDARSTDMLostLock");
                genericASLList.updateList(new TestmodeSDARSTDMLostLockCollector[]{new TestmodeSDARSTDMLostLockCollector()});
                break;
            }
            case 2259: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeSDARSTDMQuadLockTransformer(), n, "Testmode", "sDARSTDMQuadLock");
                genericASLList.updateList(new TestmodeSDARSTDMQuadLockCollector[]{new TestmodeSDARSTDMQuadLockCollector()});
                break;
            }
            case 2260: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeSDARSTDMTimingLockTransformer(), n, "Testmode", "sDARSTDMTimingLock");
                genericASLList.updateList(new TestmodeSDARSTDMTimingLockCollector[]{new TestmodeSDARSTDMTimingLockCollector()});
                break;
            }
            case 2261: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeAFList_InformationTransformer(), n, "Testmode", "AFList_Information");
                break;
            }
            case 2262: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeTMCStationInfoTransformer(), n, "Testmode", "TMCStationInfo");
                break;
            }
            case 2263: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeDABLinkListTransformer(), n, "Testmode", "DABLinkList");
                break;
            }
            case 2264: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeDABTIIListTransformer(), n, "Testmode", "DABTIIList");
                break;
            }
            case 2265: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodePluggedDevicesTransformer(), n, "Testmode", "PluggedDevices");
                break;
            }
            case 2266: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeAmplifierTransformer(), n, "Testmode", "Amplifier");
                break;
            }
            case 2267: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeVolumeLevelSourcesTransformer(), n, "Testmode", "VolumeLevelSources");
                break;
            }
            case 2268: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeDataBaseComponentsGroupTransformer(), n, "Testmode", "DataBaseComponentsGroup");
                break;
            }
            case 2269: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeNavTravelGuideGroupTransformer(), n, "Testmode", "NavTravelGuideGroup");
                break;
            }
            case 2270: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeConnectedUSBDeviceGroupTransformer(), n, "Testmode", "ConnectedUSBDeviceGroup");
                break;
            }
            case 2271: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeClampsGroupTransformer(), n, "Testmode", "ClampsGroup");
                break;
            }
            case 2272: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeDABDataServiceListTransformer(), n, "Testmode", "DABDataServiceList");
                break;
            }
            case 2273: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeMostTemperatureTransformer(), n, "Testmode", "MostTemperature");
                break;
            }
            case 2274: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeHardKeysCounterTransformer(), n, "Testmode", "HardKeysCounter");
                break;
            }
            case 2275: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeMostRegistryInformationsTransformer(), n, "Testmode", "MostRegistryInformations");
                break;
            }
            case 2276: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeAMFMGroup1Transformer(), n, "Testmode", "AMFMGroup1");
                genericASLList.updateList(new TestmodeAMFMGroup1Collector[]{new TestmodeAMFMGroup1Collector()});
                break;
            }
            case 2277: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeAMFMGroup2Transformer(), n, "Testmode", "AMFMGroup2");
                genericASLList.updateList(new TestmodeAMFMGroup2Collector[]{new TestmodeAMFMGroup2Collector()});
                break;
            }
            case 2278: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeAMFMGroup3Transformer(), n, "Testmode", "AMFMGroup3");
                genericASLList.updateList(new TestmodeAMFMGroup3Collector[]{new TestmodeAMFMGroup3Collector()});
                break;
            }
            case 2279: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeAMFMGroupTMCTransformer(), n, "Testmode", "AMFMGroupTMC");
                genericASLList.updateList(new TestmodeAMFMGroupTMCCollector[]{new TestmodeAMFMGroupTMCCollector()});
                break;
            }
            case 2280: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeTracesHMICategoryTransformer(), n, "Testmode", "TracesHMICategory");
                break;
            }
            case 2281: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeTracesHMISubTransformer(), n, "Testmode", "TracesHMISub");
                break;
            }
            case 2282: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeTracesSystemTransformer(), n, "Testmode", "TracesSystem");
                break;
            }
            case 2283: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeSoundsettingsTransformer(), n, "Testmode", "Soundsettings");
                genericASLList.updateList(new TestmodeSoundsettingsCollector[]{new TestmodeSoundsettingsCollector()});
                break;
            }
            case 2284: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeHardwareInfoTransformer(), n, "Testmode", "HardwareInfo");
                break;
            }
            case 2285: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeAudioUserConnectionsTransformer(), n, "Testmode", "AudioUserConnections");
                break;
            }
            case 2286: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeBluetoothDevicesSupportedServiceTransformer(), n, "Testmode", "BluetoothDevicesSupportedService");
                break;
            }
            case 2287: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeMicrophonesTransformer(), n, "Testmode", "Microphones");
                break;
            }
            case 2288: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeCarViewOptionsTransformer(), n, "Testmode", "CarViewOptions");
                break;
            }
            case 2289: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeCarDeviceListsTransformer(), n, "Testmode", "CarDeviceLists");
                break;
            }
            case 2290: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeMediaFileInfoTransformer(), n, "Testmode", "MediaFileInfo");
                genericASLList.updateList(new TestmodeMediaFileInfoCollector[]{new TestmodeMediaFileInfoCollector()});
                break;
            }
            case 2291: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodePhoneMicrophoneListsTransformer(), n, "Testmode", "PhoneMicrophoneLists");
                break;
            }
            case 2292: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeIBOCGroupTransformer(), n, "Testmode", "IBOCGroup");
                genericASLList.updateList(new TestmodeIBOCGroupCollector[]{new TestmodeIBOCGroupCollector()});
                break;
            }
            case 3935: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeFeatFlagsGroupTransformer(), n, "Testmode", "FeatFlagsGroup");
                break;
            }
            case 3936: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeConstGroupTransformer(), n, "Testmode", "ConstGroup");
                break;
            }
            case 2210008: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeLanguageCodingsGroupTransformer(), n, "Testmode", "LanguageCodingsGroup");
                break;
            }
            case 2210011: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodePersistedProfileTransformer(), n, "Testmode", "PersistedProfile");
                break;
            }
            case 1719: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeBluetoothDevicesInRangeTransformer(), n, "Testmode", "BluetoothDevicesInRange");
                break;
            }
            case 2210006: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeHWRMatchListTransformer(), n, "Testmode", "HWRMatchList");
                break;
            }
            case 1957: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeTMCMessagesListTransformer(), n, "Testmode", "TMCMessagesList");
                break;
            }
            case 1976: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeDVDRegionSystemSettingsTransformer(), n, "Testmode", "DVDRegionSystemSettings");
                break;
            }
            case 1979: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeUsersTransformer(), n, "Testmode", "Users");
                break;
            }
            case 2002: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeBluetoothErrorLogTransformer(), n, "Testmode", "BluetoothErrorLog");
                break;
            }
            case 2020: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeAudioDevicesTransformer(), n, "Testmode", "AudioDevices");
                break;
            }
            case 2021: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeAudioSubstatesTransformer(), n, "Testmode", "AudioSubstates");
                break;
            }
            case 2022: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeAudioSourceListTransformer(), n, "Testmode", "AudioSourceList");
                break;
            }
            case 2094: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeKernInfoString1Transformer(), n, "Testmode", "KernInfoString1");
                break;
            }
            case 2157: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeTopTwentySpeechCommandsTransformer(), n, "Testmode", "TopTwentySpeechCommands");
                break;
            }
            case 2163: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeMOSTSteuergeraeteListTransformer(), n, "Testmode", "MOSTSteuergeraeteList");
                break;
            }
            case 2164: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeMOSTSteuergeraeteInformationListTransformer(), n, "Testmode", "MOSTSteuergeraeteInformationList");
                break;
            }
            case 2165: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeMOSTSteuergeraeteFblockListTransformer(), n, "Testmode", "MOSTSteuergeraeteFblockList");
                break;
            }
            case 2170: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeMOSTShutDownDeviceTransformer(), n, "Testmode", "MOSTShutDownDevice");
                break;
            }
            case 2196: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeSDSStatisticsTransformer(), n, "Testmode", "SDSStatistics");
                break;
            }
            case 2208: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeAMFMTimerValuesTransformer(), n, "Testmode", "AMFMTimerValues");
                break;
            }
            case 2220: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeAvailableSystemLanguagesTransformer(), n, "Testmode", "AvailableSystemLanguages");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Testmode: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

