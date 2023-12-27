/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.destinput;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.destinput.transformer.NavigationDestInputHousenumberListTransformer;
import de.vw.mib.asl.internal.navigation.destinput.transformer.NavigationDestInputPostalCodeListTransformer;
import de.vw.mib.asl.internal.navigation.destinput.transformer.NavigationDestInputStreetListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.destinput.transformer.NavigationDestInputCurrentDestDataCollector;
import generated.de.vw.mib.asl.internal.navigation.destinput.transformer.NavigationDestInputLastEnteredDestinationCollector;
import generated.de.vw.mib.asl.internal.navigation.destinput.transformer.NavigationDestInputLocationCollector;
import generated.de.vw.mib.asl.internal.navigation.destinput.transformer.NavigationDestInputMapInputDataCollector;

public final class ASLNavigationDestInputDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationDestInputDeviceImpl INSTANCE = new ASLNavigationDestInputDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(12);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_IMPL;
    private static final String PACKAGE_BASE_GEN;

    private ASLNavigationDestInputDeviceImpl() {
    }

    public static ASLNavigationDestInputDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.DestInput";
    }

    @Override
    public int getTargetId() {
        return 10042;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(783, this);
        aSLListRegistry.registerASLDevice(784, this);
        aSLListRegistry.registerASLDevice(785, this);
        aSLListRegistry.registerASLDevice(786, this);
        aSLListRegistry.registerASLDevice(787, this);
        aSLListRegistry.registerASLDevice(788, this);
        aSLListRegistry.registerASLDevice(789, this);
        aSLListRegistry.registerASLDevice(790, this);
        aSLListRegistry.registerASLDevice(791, this);
        aSLListRegistry.registerASLDevice(2826, this);
        aSLListRegistry.registerASLDevice(763, this);
        aSLListRegistry.registerASLDevice(768, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-788463552, 10042);
        serviceRegister.registerService(-771686336, 10042);
        serviceRegister.registerService(-754909120, 10042);
        serviceRegister.registerService(-738131904, 10042);
        serviceRegister.registerService(-704577472, 10042);
        serviceRegister.registerService(-687800256, 10042);
        serviceRegister.registerService(-284753856, 10042);
        serviceRegister.registerService(-671023040, 10042);
        serviceRegister.registerService(-654245824, 10042);
        serviceRegister.registerService(-637468608, 10042);
        serviceRegister.registerService(-620691392, 10042);
        serviceRegister.registerService(-603914176, 10042);
        serviceRegister.registerService(-587136960, 10042);
        serviceRegister.registerService(-570359744, 10042);
        serviceRegister.registerService(-553582528, 10042);
        serviceRegister.registerService(-536805312, 10042);
        serviceRegister.registerService(-503250880, 10042);
        serviceRegister.registerService(-486473664, 10042);
        serviceRegister.registerService(-469696448, 10042);
        serviceRegister.registerService(-452919232, 10042);
        serviceRegister.registerService(-436142016, 10042);
        serviceRegister.registerService(-419364800, 10042);
        serviceRegister.registerService(-402587584, 10042);
        serviceRegister.registerService(-385810368, 10042);
        serviceRegister.registerService(-369033152, 10042);
        serviceRegister.registerService(-301924288, 10042);
        serviceRegister.registerService(-285147072, 10042);
        serviceRegister.registerService(-218038208, 10042);
        serviceRegister.registerService(-201260992, 10042);
        serviceRegister.registerService(-184483776, 10042);
        serviceRegister.registerService(-167706560, 10042);
        serviceRegister.registerService(-150929344, 10042);
        serviceRegister.registerService(-134152128, 10042);
        serviceRegister.registerService(-117374912, 10042);
        serviceRegister.registerService(-100597696, 10042);
        serviceRegister.registerService(-83820480, 10042);
        serviceRegister.registerService(-67043264, 10042);
        serviceRegister.registerService(-50266048, 10042);
        serviceRegister.registerService(-33488832, 10042);
        serviceRegister.registerService(-1777663936, 10042);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 783: {
                nArray = ListColumnsUtil.getIntArrayByBits(-8448, 23);
                break;
            }
            case 784: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 785: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 786: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 787: {
                nArray = ListColumnsUtil.getIntArrayByBits(-16834816, 20);
                break;
            }
            case 788: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 789: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 790: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 791: {
                nArray = ListColumnsUtil.getSimpleIntArray(17);
                break;
            }
            case 2826: {
                nArray = ListColumnsUtil.getSimpleIntArray(32);
                break;
            }
            case 763: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 768: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.DestInput: ").append(n).toString());
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
        return ASLNavigationDestInputDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationDestInputDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 783: {
                genericASLList = aSLListFactory.createGenericASLList(ASLNavigationDestInputDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "currentDestData"), n, "Navigation.DestInput", "currentDestData");
                genericASLList.updateList(new NavigationDestInputCurrentDestDataCollector[]{new NavigationDestInputCurrentDestDataCollector()});
                break;
            }
            case 784: {
                genericASLList = aSLListFactory.createGenericASLList(ASLNavigationDestInputDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "CityList"), n, "Navigation.DestInput", "CityList");
                break;
            }
            case 785: {
                genericASLList = aSLListFactory.createGenericASLList(ASLNavigationDestInputDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "CountryList"), n, "Navigation.DestInput", "CountryList");
                break;
            }
            case 786: {
                genericASLList = aSLListFactory.createGenericASLList(ASLNavigationDestInputDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "CrossingList"), n, "Navigation.DestInput", "CrossingList");
                break;
            }
            case 787: {
                genericASLList = aSLListFactory.createGenericASLList(ASLNavigationDestInputDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "MapInputData"), n, "Navigation.DestInput", "MapInputData");
                genericASLList.updateList(new NavigationDestInputMapInputDataCollector[]{new NavigationDestInputMapInputDataCollector()});
                break;
            }
            case 788: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationDestInputPostalCodeListTransformer(), n, "Navigation.DestInput", "PostalCodeList");
                break;
            }
            case 789: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationDestInputStreetListTransformer(), n, "Navigation.DestInput", "StreetList");
                break;
            }
            case 790: {
                genericASLList = aSLListFactory.createGenericASLList(ASLNavigationDestInputDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "StreetDisambiguationList"), n, "Navigation.DestInput", "StreetDisambiguationList");
                break;
            }
            case 791: {
                genericASLList = aSLListFactory.createGenericASLList(ASLNavigationDestInputDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "lastEnteredDestination"), n, "Navigation.DestInput", "lastEnteredDestination");
                genericASLList.updateList(new NavigationDestInputLastEnteredDestinationCollector[]{new NavigationDestInputLastEnteredDestinationCollector()});
                break;
            }
            case 2826: {
                genericASLList = aSLListFactory.createGenericASLList(ASLNavigationDestInputDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "Location"), n, "Navigation.DestInput", "Location");
                genericASLList.updateList(new NavigationDestInputLocationCollector[]{new NavigationDestInputLocationCollector()});
                break;
            }
            case 763: {
                genericASLList = aSLListFactory.createGenericASLList(ASLNavigationDestInputDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "CityCenterList"), n, "Navigation.DestInput", "CityCenterList");
                break;
            }
            case 768: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationDestInputHousenumberListTransformer(), n, "Navigation.DestInput", "HousenumberList");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.DestInput: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 783: {
                string3 = "generated.de.vw.mib.asl.internal.navigation.destinput.transformer.";
                string2 = "NavigationDestInputCurrentDestDataTransformer";
                break;
            }
            case 784: {
                string3 = "de.vw.mib.asl.internal.navigation.destinput.transformer.";
                string2 = "NavigationDestInputCityListTransformer";
                break;
            }
            case 785: {
                string3 = "de.vw.mib.asl.internal.navigation.destinput.transformer.";
                string2 = "NavigationDestInputCountryListTransformer";
                break;
            }
            case 786: {
                string3 = "de.vw.mib.asl.internal.navigation.destinput.transformer.";
                string2 = "NavigationDestInputCrossingListTransformer";
                break;
            }
            case 787: {
                string3 = "generated.de.vw.mib.asl.internal.navigation.destinput.transformer.";
                string2 = "NavigationDestInputMapInputDataTransformer";
                break;
            }
            case 790: {
                string3 = "de.vw.mib.asl.internal.navigation.destinput.transformer.";
                string2 = "NavigationDestInputStreetDisambiguationListTransformer";
                break;
            }
            case 791: {
                string3 = "generated.de.vw.mib.asl.internal.navigation.destinput.transformer.";
                string2 = "NavigationDestInputLastEnteredDestinationTransformer";
                break;
            }
            case 2826: {
                string3 = "generated.de.vw.mib.asl.internal.navigation.destinput.transformer.";
                string2 = "NavigationDestInputLocationTransformer";
                break;
            }
            case 763: {
                string3 = "de.vw.mib.asl.internal.navigation.destinput.transformer.";
                string2 = "NavigationDestInputCityCenterListTransformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device Navigation.DestInput: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "Navigation.DestInput", string);
    }
}

