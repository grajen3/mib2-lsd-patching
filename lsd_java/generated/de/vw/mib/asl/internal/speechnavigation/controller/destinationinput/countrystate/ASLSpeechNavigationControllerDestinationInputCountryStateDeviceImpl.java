/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.countrystate;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.countrystate.transformer.SpeechNavigationControllerDestinationInputCountryStateCountryStateResultDetailsTransformer;
import de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.countrystate.transformer.SpeechNavigationControllerDestinationInputCountryStateCountryStateResultsTransformer;
import de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.countrystate.transformer.SpeechNavigationControllerDestinationInputCountryStateCountryStateSelectedResultsTransformer;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechNavigationControllerDestinationInputCountryStateDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechNavigationControllerDestinationInputCountryStateDeviceImpl INSTANCE = new ASLSpeechNavigationControllerDestinationInputCountryStateDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(6);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_IMPL;

    private ASLSpeechNavigationControllerDestinationInputCountryStateDeviceImpl() {
    }

    public static ASLSpeechNavigationControllerDestinationInputCountryStateDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechNavigation.Controller.DestinationInput.CountryState";
    }

    @Override
    public int getTargetId() {
        return 14426;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-2063059968, this);
        aSLListRegistry.registerASLDevice(-2046282752, this);
        aSLListRegistry.registerASLDevice(-2029505536, this);
        aSLListRegistry.registerASLDevice(-2012728320, this);
        aSLListRegistry.registerASLDevice(-1995951104, this);
        aSLListRegistry.registerASLDevice(-1979173888, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1075760320, 14426);
        serviceRegister.registerService(-1058983104, 14426);
        serviceRegister.registerService(-1008651456, 14426);
        serviceRegister.registerService(-991874240, 14426);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3410053: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 3410054: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 3410055: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 3410056: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 3410057: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 3410058: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.DestinationInput.CountryState: ").append(n).toString());
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
        return ASLSpeechNavigationControllerDestinationInputCountryStateDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLSpeechNavigationControllerDestinationInputCountryStateDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3410053: {
                genericASLList = aSLListFactory.createGenericASLList(ASLSpeechNavigationControllerDestinationInputCountryStateDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "CountryStateResultList"), n, "SpeechNavigation.Controller.DestinationInput.CountryState", "CountryStateResultList");
                break;
            }
            case 3410054: {
                genericASLList = aSLListFactory.createGenericASLList(ASLSpeechNavigationControllerDestinationInputCountryStateDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "CountryStateResultDetailList"), n, "SpeechNavigation.Controller.DestinationInput.CountryState", "CountryStateResultDetailList");
                break;
            }
            case 3410055: {
                genericASLList = aSLListFactory.createGenericASLList(ASLSpeechNavigationControllerDestinationInputCountryStateDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "CountryStateSelectedResult"), n, "SpeechNavigation.Controller.DestinationInput.CountryState", "CountryStateSelectedResult");
                break;
            }
            case 3410056: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerDestinationInputCountryStateCountryStateResultsTransformer(), n, "SpeechNavigation.Controller.DestinationInput.CountryState", "CountryStateResults");
                break;
            }
            case 3410057: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerDestinationInputCountryStateCountryStateResultDetailsTransformer(), n, "SpeechNavigation.Controller.DestinationInput.CountryState", "CountryStateResultDetails");
                break;
            }
            case 3410058: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerDestinationInputCountryStateCountryStateSelectedResultsTransformer(), n, "SpeechNavigation.Controller.DestinationInput.CountryState", "CountryStateSelectedResults");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device SpeechNavigation.Controller.DestinationInput.CountryState: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 3410053: {
                string3 = "de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.countrystate.transformer.";
                string2 = "SpeechNavigationControllerDestinationInputCountryStateCountryStateResultListTransformer";
                break;
            }
            case 3410054: {
                string3 = "de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.countrystate.transformer.";
                string2 = "SpeechNavigationControllerDestinationInputCountryStateCountryStateResultDetailListTransformer";
                break;
            }
            case 3410055: {
                string3 = "de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.countrystate.transformer.";
                string2 = "SpeechNavigationControllerDestinationInputCountryStateCountryStateSelectedResultTransformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device SpeechNavigation.Controller.DestinationInput.CountryState: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "SpeechNavigation.Controller.DestinationInput.CountryState", string);
    }
}

