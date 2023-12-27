/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.travellink;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkClosestMovieTheaterFilmsListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkClosestTrafficMessagesListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkCurrentSportsFavoritesListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkFavoriteSkiResortListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkFavoriteTeamListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkFuelResultsListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkFuelStationsInfoForMainViewTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkIconmapClickListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkIsobarmapClickListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkLeagueListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkMovieActorsListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkMovieStarttimesTodayListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkMovieStarttimesTomorrowListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkMovieTheaterResultsShowTimesListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkMovieTheatersResultsListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkMoviesResultsListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSelectableMovieListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSelectableSkiResortListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSelectableSkiStateListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSelectableStateListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSelectableStationResortListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSelectableWeatherStateListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSelectableWeatherStationListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSelectedFuelResultPricesListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSelectedLeagueNewsTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSetSpoAddNewFavSelLea_TeaNam2310095Transformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSetupFuelTypeTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSetupSportsAddNewFavoriteLeaguesListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSetupSportsSelectteamLevelOneListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSpoRanLisEveInfLisEveInfLis2310078Transformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSportsFavoritesGameListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSportsHeadToHeadGameListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSportsLiveBroadcastListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSportsRankedListEventRankingsFinalListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSportsRankedListEventRankingsListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSportsRankedListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSportsRankedlistEventinfoTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSportsRankedlistEventrankingsFinalTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSportsRankedlistEventrankingsTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkWeatherDailyForecastListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkWeatherFavoriteCityListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkWeatherHourlyForecastListTransformer;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkWeatherMapClickResultListTransformer;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkAddressCollector;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkAddressTransformer;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkCurrentSkiResortInfoCollector;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkCurrentSkiResortInfoTransformer;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkCurrentWeatherReportCollector;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkCurrentWeatherReportTransformer;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkFuelStationAddressCollector;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkFuelStationAddressTransformer;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkMovieInfoCollector;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkMovieInfoTransformer;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkMovieTheaterAddressCollector;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkMovieTheaterAddressTransformer;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkSportsHeadToHeadGameDetailsCollector;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkSportsHeadToHeadGameDetailsTransformer;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkSportsHeadlineCollector;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkSportsHeadlineTransformer;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkWeatherIsobarMapClickResultDetailsCollector;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkWeatherIsobarMapClickResultDetailsTransformer;

public final class ASLTravelLinkDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLTravelLinkDeviceImpl INSTANCE = new ASLTravelLinkDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(56);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_IMPL;

    private ASLTravelLinkDeviceImpl() {
    }

    public static ASLTravelLinkDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "TravelLink";
    }

    @Override
    public int getTargetId() {
        return 10152;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-1019272448, this);
        aSLListRegistry.registerASLDevice(-1438702848, this);
        aSLListRegistry.registerASLDevice(-1421925632, this);
        aSLListRegistry.registerASLDevice(-2093014272, this);
        aSLListRegistry.registerASLDevice(-532733184, this);
        aSLListRegistry.registerASLDevice(2134844160, this);
        aSLListRegistry.registerASLDevice(4110, this);
        aSLListRegistry.registerASLDevice(4111, this);
        aSLListRegistry.registerASLDevice(-1757469952, this);
        aSLListRegistry.registerASLDevice(-415292672, this);
        aSLListRegistry.registerASLDevice(-885054720, this);
        aSLListRegistry.registerASLDevice(-901831936, this);
        aSLListRegistry.registerASLDevice(-1975573760, this);
        aSLListRegistry.registerASLDevice(-1371593984, this);
        aSLListRegistry.registerASLDevice(-1338039552, this);
        aSLListRegistry.registerASLDevice(-566287616, this);
        aSLListRegistry.registerASLDevice(-549510400, this);
        aSLListRegistry.registerASLDevice(-398515456, this);
        aSLListRegistry.registerASLDevice(-1589697792, this);
        aSLListRegistry.registerASLDevice(-1656806656, this);
        aSLListRegistry.registerASLDevice(-1388371200, this);
        aSLListRegistry.registerASLDevice(-1891687680, this);
        aSLListRegistry.registerASLDevice(-1874910464, this);
        aSLListRegistry.registerASLDevice(-1673583872, this);
        aSLListRegistry.registerASLDevice(-2042682624, this);
        aSLListRegistry.registerASLDevice(-868277504, this);
        aSLListRegistry.registerASLDevice(-851500288, this);
        aSLListRegistry.registerASLDevice(-1187044608, this);
        aSLListRegistry.registerASLDevice(-784391424, this);
        aSLListRegistry.registerASLDevice(-1036049664, this);
        aSLListRegistry.registerASLDevice(-1170267392, this);
        aSLListRegistry.registerASLDevice(-1203821824, this);
        aSLListRegistry.registerASLDevice(-1119935744, this);
        aSLListRegistry.registerASLDevice(-700505344, this);
        aSLListRegistry.registerASLDevice(-1103158528, this);
        aSLListRegistry.registerASLDevice(-750836992, this);
        aSLListRegistry.registerASLDevice(-734059776, this);
        aSLListRegistry.registerASLDevice(-1086381312, this);
        aSLListRegistry.registerASLDevice(-1069604096, this);
        aSLListRegistry.registerASLDevice(-2126568704, this);
        aSLListRegistry.registerASLDevice(4109, this);
        aSLListRegistry.registerASLDevice(-2143345920, this);
        aSLListRegistry.registerASLDevice(-1942019328, this);
        aSLListRegistry.registerASLDevice(-1925242112, this);
        aSLListRegistry.registerASLDevice(-213966080, this);
        aSLListRegistry.registerASLDevice(-180411648, this);
        aSLListRegistry.registerASLDevice(-113302784, this);
        aSLListRegistry.registerASLDevice(-583064832, this);
        aSLListRegistry.registerASLDevice(-1002495232, this);
        aSLListRegistry.registerASLDevice(-985718016, this);
        aSLListRegistry.registerASLDevice(-968940800, this);
        aSLListRegistry.registerASLDevice(-952163584, this);
        aSLListRegistry.registerASLDevice(-1908464896, this);
        aSLListRegistry.registerASLDevice(-381738240, this);
        aSLListRegistry.registerASLDevice(-817945856, this);
        aSLListRegistry.registerASLDevice(-197188864, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(1981293376, 10152);
        serviceRegister.registerService(1964516160, 10152);
        serviceRegister.registerService(1746412352, 10152);
        serviceRegister.registerService(1729635136, 10152);
        serviceRegister.registerService(1862991936, 10152);
        serviceRegister.registerService(1896546368, 10152);
        serviceRegister.registerService(1829437504, 10152);
        serviceRegister.registerService(1879769152, 10152);
        serviceRegister.registerService(-1458035904, 10152);
        serviceRegister.registerService(1913323584, 10152);
        serviceRegister.registerService(-1307040960, 10152);
        serviceRegister.registerService(-2095570112, 10152);
        serviceRegister.registerService(1846214720, 10152);
        serviceRegister.registerService(-1290263744, 10152);
        serviceRegister.registerService(-1877466304, 10152);
        serviceRegister.registerService(-1860689088, 10152);
        serviceRegister.registerService(-1407704256, 10152);
        serviceRegister.registerService(-1390927040, 10152);
        serviceRegister.registerService(-1508367552, 10152);
        serviceRegister.registerService(-1357372608, 10152);
        serviceRegister.registerService(-1491590336, 10152);
        serviceRegister.registerService(-1541921984, 10152);
        serviceRegister.registerService(-1424481472, 10152);
        serviceRegister.registerService(-1525144768, 10152);
        serviceRegister.registerService(-1374149824, 10152);
        serviceRegister.registerService(-1558699200, 10152);
        serviceRegister.registerService(-1592253632, 10152);
        serviceRegister.registerService(-1575476416, 10152);
        serviceRegister.registerService(-2045238464, 10152);
        serviceRegister.registerService(-2028461248, 10152);
        serviceRegister.registerService(-1776803008, 10152);
        serviceRegister.registerService(-1760025792, 10152);
        serviceRegister.registerService(-1340595392, 10152);
        serviceRegister.registerService(1040908352, 10152);
        serviceRegister.registerService(-1323818176, 10152);
        serviceRegister.registerService(1057685568, 10152);
        serviceRegister.registerService(0x400B0040, 10152);
        serviceRegister.registerService(-1441258688, 10152);
        serviceRegister.registerService(1679303488, 10152);
        serviceRegister.registerService(1998070592, 10152);
        serviceRegister.registerService(1191903296, 10152);
        serviceRegister.registerService(2132288320, 10152);
        serviceRegister.registerService(2031625024, 10152);
        serviceRegister.registerService(-1994906816, 10152);
        serviceRegister.registerService(1696080704, 10152);
        serviceRegister.registerService(-2145901760, 10152);
        serviceRegister.registerService(2014847808, 10152);
        serviceRegister.registerService(1796744000, 10152);
        serviceRegister.registerService(2098733888, 10152);
        serviceRegister.registerService(1847075648, 10152);
        serviceRegister.registerService(1863852864, 10152);
        serviceRegister.registerService(1880630080, 10152);
        serviceRegister.registerService(-2011684032, 10152);
        serviceRegister.registerService(-2129124544, 10152);
        serviceRegister.registerService(-2112347328, 10152);
        serviceRegister.registerService(1779966784, 10152);
        serviceRegister.registerService(1947738944, 10152);
        serviceRegister.registerService(-1843911872, 10152);
        serviceRegister.registerService(-1911020736, 10152);
        serviceRegister.registerService(1914184512, 10152);
        serviceRegister.registerService(-1895104448, 10152);
        serviceRegister.registerService(1897407296, 10152);
        serviceRegister.registerService(-1676139712, 10152);
        serviceRegister.registerService(1712857920, 10152);
        serviceRegister.registerService(1930961728, 10152);
        serviceRegister.registerService(1645749056, 10152);
        serviceRegister.registerService(-1642585280, 10152);
        serviceRegister.registerService(-1625808064, 10152);
        serviceRegister.registerService(1763189568, 10152);
        serviceRegister.registerService(-2078792896, 10152);
        serviceRegister.registerService(-2062015680, 10152);
        serviceRegister.registerService(-1927797952, 10152);
        serviceRegister.registerService(-1894243520, 10152);
        serviceRegister.registerService(-1609030848, 10152);
        serviceRegister.registerService(1813521216, 10152);
        serviceRegister.registerService(1830298432, 10152);
        serviceRegister.registerService(2115511104, 10152);
        serviceRegister.registerService(-1474813120, 10152);
        serviceRegister.registerService(1662526272, 10152);
        serviceRegister.registerService(-1659362496, 10152);
        serviceRegister.registerService(-1978129600, 10152);
        serviceRegister.registerService(-1961352384, 10152);
        serviceRegister.registerService(-1944575168, 10152);
        serviceRegister.registerService(-1743248576, 10152);
        serviceRegister.registerService(-1692916928, 10152);
        serviceRegister.registerService(-1273486528, 10152);
        serviceRegister.registerService(-1256709312, 10152);
        serviceRegister.registerService(-1793580224, 10152);
        serviceRegister.registerService(-1827134656, 10152);
        serviceRegister.registerService(-1810357440, 10152);
        serviceRegister.registerService(-1878327232, 10152);
        serviceRegister.registerService(-1726471360, 10152);
        serviceRegister.registerService(-1709694144, 10152);
        serviceRegister.registerService(-1239932096, 10152);
        serviceRegister.registerService(-1223154880, 10152);
        serviceRegister.registerService(-1206377664, 10152);
        serviceRegister.registerService(-1189600448, 10152);
        serviceRegister.registerService(-1172823232, 10152);
        serviceRegister.registerService(-1156046016, 10152);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 2310083: {
                nArray = ListColumnsUtil.getSimpleIntArray(10);
                break;
            }
            case 2310058: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 2310059: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2310019: {
                nArray = ListColumnsUtil.getSimpleIntArray(21);
                break;
            }
            case 2310112: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 2310015: {
                nArray = ListColumnsUtil.getSimpleIntArray(23);
                break;
            }
            case 4110: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 4111: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 2310039: {
                nArray = ListColumnsUtil.getSimpleIntArray(11);
                break;
            }
            case 2310119: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            case 2310091: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            case 2310090: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            case 2310026: {
                nArray = ListColumnsUtil.getIntArrayByBits(19, 3);
                break;
            }
            case 2310062: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 2310064: {
                nArray = ListColumnsUtil.getSimpleIntArray(22);
                break;
            }
            case 2310110: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 2310111: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 2310120: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            case 2310049: {
                nArray = ListColumnsUtil.getSimpleIntArray(13);
                break;
            }
            case 2310045: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            case 2310061: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 2310031: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2310032: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2310044: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 2310022: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 2310092: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2310093: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2310073: {
                nArray = ListColumnsUtil.getSimpleIntArray(17);
                break;
            }
            case 2310097: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2310082: {
                nArray = ListColumnsUtil.getSimpleIntArray(23);
                break;
            }
            case 2310074: {
                nArray = ListColumnsUtil.getSimpleIntArray(16);
                break;
            }
            case 2310072: {
                nArray = ListColumnsUtil.getSimpleIntArray(9);
                break;
            }
            case 2310077: {
                nArray = ListColumnsUtil.getSimpleIntArray(12);
                break;
            }
            case 2310102: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2310078: {
                nArray = ListColumnsUtil.getIntArrayByBits(5, 2);
                break;
            }
            case 2310099: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            case 2310100: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            case 2310079: {
                nArray = ListColumnsUtil.getSimpleIntArray(8);
                break;
            }
            case 2310080: {
                nArray = ListColumnsUtil.getSimpleIntArray(8);
                break;
            }
            case 2310017: {
                nArray = ListColumnsUtil.getIntArrayByBits(671023104, 12);
                break;
            }
            case 4109: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 2310016: {
                nArray = ListColumnsUtil.getIntArrayByBits(487, 7);
                break;
            }
            case 2310028: {
                nArray = ListColumnsUtil.getIntArrayByBits(0xFFFFFFF80000L, 29);
                break;
            }
            case 2310029: {
                nArray = ListColumnsUtil.getIntArrayByBits(183, 6);
                break;
            }
            case 0x233FF3: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 2310133: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2310137: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 2310109: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2310084: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2310085: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2310086: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2310087: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2310030: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2310121: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2310095: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 2310132: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device TravelLink: ").append(n).toString());
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
        return ASLTravelLinkDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLTravelLinkDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 2310083: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkAddressTransformer(), n, "TravelLink", "Address");
                genericASLList.updateList(new TravelLinkAddressCollector[]{new TravelLinkAddressCollector()});
                break;
            }
            case 2310058: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkClosestMovieTheaterFilmsListTransformer(), n, "TravelLink", "ClosestMovieTheaterFilmsList");
                break;
            }
            case 2310059: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkClosestTrafficMessagesListTransformer(), n, "TravelLink", "ClosestTrafficMessagesList");
                break;
            }
            case 2310019: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkCurrentSkiResortInfoTransformer(), n, "TravelLink", "CurrentSkiResortInfo");
                genericASLList.updateList(new TravelLinkCurrentSkiResortInfoCollector[]{new TravelLinkCurrentSkiResortInfoCollector()});
                break;
            }
            case 2310112: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkCurrentSportsFavoritesListTransformer(), n, "TravelLink", "CurrentSportsFavoritesList");
                break;
            }
            case 2310015: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkCurrentWeatherReportTransformer(), n, "TravelLink", "CurrentWeatherReport");
                genericASLList.updateList(new TravelLinkCurrentWeatherReportCollector[]{new TravelLinkCurrentWeatherReportCollector()});
                break;
            }
            case 4110: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkFavoriteSkiResortListTransformer(), n, "TravelLink", "FavoriteSkiResortList");
                break;
            }
            case 4111: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkFavoriteTeamListTransformer(), n, "TravelLink", "FavoriteTeamList");
                break;
            }
            case 2310039: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkFuelResultsListTransformer(), n, "TravelLink", "FuelResultsList");
                break;
            }
            case 2310119: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkFuelStationAddressTransformer(), n, "TravelLink", "FuelStationAddress");
                genericASLList.updateList(new TravelLinkFuelStationAddressCollector[]{new TravelLinkFuelStationAddressCollector()});
                break;
            }
            case 2310091: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkIconmapClickListTransformer(), n, "TravelLink", "IconmapClickList");
                break;
            }
            case 2310090: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkIsobarmapClickListTransformer(), n, "TravelLink", "IsobarmapClickList");
                break;
            }
            case 2310026: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkLeagueListTransformer(), n, "TravelLink", "LeagueList");
                break;
            }
            case 2310062: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkMovieInfoTransformer(), n, "TravelLink", "MovieInfo");
                genericASLList.updateList(new TravelLinkMovieInfoCollector[]{new TravelLinkMovieInfoCollector()});
                break;
            }
            case 2310064: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkMoviesResultsListTransformer(), n, "TravelLink", "MoviesResultsList");
                break;
            }
            case 2310110: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkMovieStarttimesTodayListTransformer(), n, "TravelLink", "MovieStarttimesTodayList");
                break;
            }
            case 2310111: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkMovieStarttimesTomorrowListTransformer(), n, "TravelLink", "MovieStarttimesTomorrowList");
                break;
            }
            case 2310120: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkMovieTheaterAddressTransformer(), n, "TravelLink", "MovieTheaterAddress");
                genericASLList.updateList(new TravelLinkMovieTheaterAddressCollector[]{new TravelLinkMovieTheaterAddressCollector()});
                break;
            }
            case 2310049: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkMovieTheaterResultsShowTimesListTransformer(), n, "TravelLink", "MovieTheaterResultsShowTimesList");
                break;
            }
            case 2310045: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkMovieTheatersResultsListTransformer(), n, "TravelLink", "MovieTheatersResultsList");
                break;
            }
            case 2310061: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkSelectableMovieListTransformer(), n, "TravelLink", "SelectableMovieList");
                break;
            }
            case 2310031: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkSelectableStateListTransformer(), n, "TravelLink", "SelectableStateList");
                break;
            }
            case 2310032: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkSelectableStationResortListTransformer(), n, "TravelLink", "SelectableStationResortList");
                break;
            }
            case 2310044: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkSelectedFuelResultPricesListTransformer(), n, "TravelLink", "SelectedFuelResultPricesList");
                break;
            }
            case 2310022: {
                genericASLList = aSLListFactory.createGenericASLList(ASLTravelLinkDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "SetupSportsAddNewFavoriteContentList"), n, "TravelLink", "SetupSportsAddNewFavoriteContentList");
                break;
            }
            case 2310092: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkSetupSportsAddNewFavoriteLeaguesListTransformer(), n, "TravelLink", "SetupSportsAddNewFavoriteLeaguesList");
                break;
            }
            case 2310093: {
                genericASLList = aSLListFactory.createGenericASLList(ASLTravelLinkDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "SetupSportsAddNewFavoriteTeamsList"), n, "TravelLink", "SetupSportsAddNewFavoriteTeamsList");
                break;
            }
            case 2310073: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkSportsFavoritesGameListTransformer(), n, "TravelLink", "SportsFavoritesGameList");
                break;
            }
            case 2310097: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkSportsHeadlineTransformer(), n, "TravelLink", "SportsHeadline");
                genericASLList.updateList(new TravelLinkSportsHeadlineCollector[]{new TravelLinkSportsHeadlineCollector()});
                break;
            }
            case 2310082: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkSportsHeadToHeadGameDetailsTransformer(), n, "TravelLink", "SportsHeadToHeadGameDetails");
                genericASLList.updateList(new TravelLinkSportsHeadToHeadGameDetailsCollector[]{new TravelLinkSportsHeadToHeadGameDetailsCollector()});
                break;
            }
            case 2310074: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkSportsHeadToHeadGameListTransformer(), n, "TravelLink", "SportsHeadToHeadGameList");
                break;
            }
            case 2310072: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkSportsLiveBroadcastListTransformer(), n, "TravelLink", "SportsLiveBroadcastList");
                break;
            }
            case 2310077: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkSportsRankedListTransformer(), n, "TravelLink", "SportsRankedList");
                break;
            }
            case 2310102: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkSportsRankedlistEventinfoTransformer(), n, "TravelLink", "SportsRankedlistEventinfo");
                break;
            }
            case 2310078: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkSpoRanLisEveInfLisEveInfLis2310078Transformer(), n, "TravelLink", "SportsRankedListEventInfoListEventInfoList");
                break;
            }
            case 2310099: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkSportsRankedlistEventrankingsTransformer(), n, "TravelLink", "SportsRankedlistEventrankings");
                break;
            }
            case 2310100: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkSportsRankedlistEventrankingsFinalTransformer(), n, "TravelLink", "SportsRankedlistEventrankingsFinal");
                break;
            }
            case 2310079: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkSportsRankedListEventRankingsFinalListTransformer(), n, "TravelLink", "SportsRankedListEventRankingsFinalList");
                break;
            }
            case 2310080: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkSportsRankedListEventRankingsListTransformer(), n, "TravelLink", "SportsRankedListEventRankingsList");
                break;
            }
            case 2310017: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkWeatherDailyForecastListTransformer(), n, "TravelLink", "WeatherDailyForecastList");
                break;
            }
            case 4109: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkWeatherFavoriteCityListTransformer(), n, "TravelLink", "WeatherFavoriteCityList");
                break;
            }
            case 2310016: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkWeatherHourlyForecastListTransformer(), n, "TravelLink", "WeatherHourlyForecastList");
                break;
            }
            case 2310028: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkWeatherIsobarMapClickResultDetailsTransformer(), n, "TravelLink", "WeatherIsobarMapClickResultDetails");
                genericASLList.updateList(new TravelLinkWeatherIsobarMapClickResultDetailsCollector[]{new TravelLinkWeatherIsobarMapClickResultDetailsCollector()});
                break;
            }
            case 2310029: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkWeatherMapClickResultListTransformer(), n, "TravelLink", "WeatherMapClickResultList");
                break;
            }
            case 0x233FF3: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkSetupFuelTypeTransformer(), n, "TravelLink", "SetupFuelType");
                break;
            }
            case 2310133: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkSetupSportsSelectteamLevelOneListTransformer(), n, "TravelLink", "SetupSportsSelectteamLevelOneList");
                break;
            }
            case 2310137: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkFuelStationsInfoForMainViewTransformer(), n, "TravelLink", "FuelStationsInfoForMainView");
                break;
            }
            case 2310109: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkMovieActorsListTransformer(), n, "TravelLink", "MovieActorsList");
                break;
            }
            case 2310084: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkSelectableSkiResortListTransformer(), n, "TravelLink", "SelectableSkiResortList");
                break;
            }
            case 2310085: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkSelectableSkiStateListTransformer(), n, "TravelLink", "SelectableSkiStateList");
                break;
            }
            case 2310086: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkSelectableWeatherStateListTransformer(), n, "TravelLink", "SelectableWeatherStateList");
                break;
            }
            case 2310087: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkSelectableWeatherStationListTransformer(), n, "TravelLink", "SelectableWeatherStationList");
                break;
            }
            case 2310030: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkSelectedLeagueNewsTransformer(), n, "TravelLink", "SelectedLeagueNews");
                break;
            }
            case 2310121: {
                genericASLList = aSLListFactory.createGenericASLList(ASLTravelLinkDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "SetupFuelTypeList"), n, "TravelLink", "SetupFuelTypeList");
                break;
            }
            case 2310095: {
                genericASLList = aSLListFactory.createGenericASLList(new TravelLinkSetSpoAddNewFavSelLea_TeaNam2310095Transformer(), n, "TravelLink", "SetupSportsAddNewFavoriteSelectedLeague_TeamName");
                break;
            }
            case 2310132: {
                genericASLList = aSLListFactory.createGenericASLList(ASLTravelLinkDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "SetupSportsAddNewFavoriteSelectedLeague_Activated"), n, "TravelLink", "SetupSportsAddNewFavoriteSelectedLeague_Activated");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device TravelLink: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 2310022: {
                string3 = "de.vw.mib.asl.internal.travellink.transformer.";
                string2 = "TravelLinkSetupSportsAddNewFavoriteContentListTransformer";
                break;
            }
            case 2310093: {
                string3 = "de.vw.mib.asl.internal.travellink.transformer.";
                string2 = "TravelLinkSetupSportsAddNewFavoriteTeamsListTransformer";
                break;
            }
            case 2310121: {
                string3 = "de.vw.mib.asl.internal.travellink.transformer.";
                string2 = "TravelLinkSetupFuelTypeListTransformer";
                break;
            }
            case 2310132: {
                string3 = "de.vw.mib.asl.internal.travellink.transformer.";
                string2 = "TravelLinkSetSpoAddNewFavSelLea_Act2310132Transformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device TravelLink: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "TravelLink", string);
    }
}

