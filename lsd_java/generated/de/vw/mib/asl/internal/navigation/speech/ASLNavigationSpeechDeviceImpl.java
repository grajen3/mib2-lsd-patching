/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.speech;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.speech.transformer.NavigationSpeechCityListTransformer;
import de.vw.mib.asl.internal.navigation.speech.transformer.NavigationSpeechContactNamesTransformer;
import de.vw.mib.asl.internal.navigation.speech.transformer.NavigationSpeechCountryListTransformer;
import de.vw.mib.asl.internal.navigation.speech.transformer.NavigationSpeechCrossingListTransformer;
import de.vw.mib.asl.internal.navigation.speech.transformer.NavigationSpeechNARCountryListTransformer;
import de.vw.mib.asl.internal.navigation.speech.transformer.NavigationSpeechNARStateListTransformer;
import de.vw.mib.asl.internal.navigation.speech.transformer.NavigationSpeechPostalCodeListAlphanumericTransformer;
import de.vw.mib.asl.internal.navigation.speech.transformer.NavigationSpeechPostalCodeListNumericTransformer;
import de.vw.mib.asl.internal.navigation.speech.transformer.NavigationSpeechStateListTransformer;
import de.vw.mib.asl.internal.navigation.speech.transformer.NavigationSpeechStreetListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.speech.transformer.NavigationSpeechCapabiltiesCollector;
import generated.de.vw.mib.asl.internal.navigation.speech.transformer.NavigationSpeechCapabiltiesTransformer;
import generated.de.vw.mib.asl.internal.navigation.speech.transformer.NavigationSpeechRecognizedContactCollector;
import generated.de.vw.mib.asl.internal.navigation.speech.transformer.NavigationSpeechRecognizedContactTransformer;

public final class ASLNavigationSpeechDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationSpeechDeviceImpl INSTANCE = new ASLNavigationSpeechDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(12);
    private ASLListFactory listFactory;

    private ASLNavigationSpeechDeviceImpl() {
    }

    public static ASLNavigationSpeechDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.Speech";
    }

    @Override
    public int getTargetId() {
        return 10057;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(2503, this);
        aSLListRegistry.registerASLDevice(992, this);
        aSLListRegistry.registerASLDevice(985, this);
        aSLListRegistry.registerASLDevice(986, this);
        aSLListRegistry.registerASLDevice(987, this);
        aSLListRegistry.registerASLDevice(988, this);
        aSLListRegistry.registerASLDevice(989, this);
        aSLListRegistry.registerASLDevice(990, this);
        aSLListRegistry.registerASLDevice(991, this);
        aSLListRegistry.registerASLDevice(3486, this);
        aSLListRegistry.registerASLDevice(3487, this);
        aSLListRegistry.registerASLDevice(-1980755968, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-335413184, 10057);
        serviceRegister.registerService(-1996029888, 10057);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 2503: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 992: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 985: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 986: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 987: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 988: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 989: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 990: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 991: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 3486: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 3487: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 1110153: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.Speech: ").append(n).toString());
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
        return ASLNavigationSpeechDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationSpeechDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 2503: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationSpeechCapabiltiesTransformer(), n, "Navigation.Speech", "capabilties");
                genericASLList.updateList(new NavigationSpeechCapabiltiesCollector[]{new NavigationSpeechCapabiltiesCollector()});
                break;
            }
            case 992: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationSpeechRecognizedContactTransformer(), n, "Navigation.Speech", "recognizedContact");
                genericASLList.updateList(new NavigationSpeechRecognizedContactCollector[]{new NavigationSpeechRecognizedContactCollector()});
                break;
            }
            case 985: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationSpeechCityListTransformer(), n, "Navigation.Speech", "CityList");
                break;
            }
            case 986: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationSpeechContactNamesTransformer(), n, "Navigation.Speech", "ContactNames");
                break;
            }
            case 987: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationSpeechCountryListTransformer(), n, "Navigation.Speech", "CountryList");
                break;
            }
            case 988: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationSpeechPostalCodeListAlphanumericTransformer(), n, "Navigation.Speech", "PostalCodeListAlphanumeric");
                break;
            }
            case 989: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationSpeechPostalCodeListNumericTransformer(), n, "Navigation.Speech", "PostalCodeListNumeric");
                break;
            }
            case 990: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationSpeechStreetListTransformer(), n, "Navigation.Speech", "StreetList");
                break;
            }
            case 991: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationSpeechCrossingListTransformer(), n, "Navigation.Speech", "CrossingList");
                break;
            }
            case 3486: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationSpeechNARCountryListTransformer(), n, "Navigation.Speech", "NARCountryList");
                break;
            }
            case 3487: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationSpeechNARStateListTransformer(), n, "Navigation.Speech", "NARStateList");
                break;
            }
            case 1110153: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationSpeechStateListTransformer(), n, "Navigation.Speech", "StateList");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.Speech: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

