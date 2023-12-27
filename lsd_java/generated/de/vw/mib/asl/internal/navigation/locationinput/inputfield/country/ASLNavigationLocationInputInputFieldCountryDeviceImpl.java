/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.country;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.locationinput.inputfield.country.transformer.NavigationLocationInputInputFieldCountryListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.country.transformer.NavigationLocationInputInputFieldCountryListInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.country.transformer.NavigationLocationInputInputFieldCountryListInfoTransformer;

public final class ASLNavigationLocationInputInputFieldCountryDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationLocationInputInputFieldCountryDeviceImpl INSTANCE = new ASLNavigationLocationInputInputFieldCountryDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLNavigationLocationInputInputFieldCountryDeviceImpl() {
    }

    public static ASLNavigationLocationInputInputFieldCountryDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.LocationInput.InputField.Country";
    }

    @Override
    public int getTargetId() {
        return 10122;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(3027, this);
        aSLListRegistry.registerASLDevice(3028, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3027: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 3028: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.LocationInput.InputField.Country: ").append(n).toString());
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
        return ASLNavigationLocationInputInputFieldCountryDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationLocationInputInputFieldCountryDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3027: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldCountryListTransformer(), n, "Navigation.LocationInput.InputField.Country", "List");
                break;
            }
            case 3028: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldCountryListInfoTransformer(), n, "Navigation.LocationInput.InputField.Country", "ListInfo");
                genericASLList.updateList(new NavigationLocationInputInputFieldCountryListInfoCollector[]{new NavigationLocationInputInputFieldCountryListInfoCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.LocationInput.InputField.Country: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

