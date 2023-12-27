/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.city;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.locationinput.inputfield.city.transformer.NavigationLocationInputInputFieldCityListTransformer;
import de.vw.mib.asl.internal.navigation.locationinput.inputfield.city.transformer.NavigationLocationInputInputFieldCityPreviewListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.city.transformer.NavigationLocationInputInputFieldCityListInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.city.transformer.NavigationLocationInputInputFieldCityListInfoTransformer;

public final class ASLNavigationLocationInputInputFieldCityDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationLocationInputInputFieldCityDeviceImpl INSTANCE = new ASLNavigationLocationInputInputFieldCityDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(3);
    private ASLListFactory listFactory;

    private ASLNavigationLocationInputInputFieldCityDeviceImpl() {
    }

    public static ASLNavigationLocationInputInputFieldCityDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.LocationInput.InputField.City";
    }

    @Override
    public int getTargetId() {
        return 10126;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(3052, this);
        aSLListRegistry.registerASLDevice(3053, this);
        aSLListRegistry.registerASLDevice(3054, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3052: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 3053: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 3054: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.LocationInput.InputField.City: ").append(n).toString());
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
        return ASLNavigationLocationInputInputFieldCityDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationLocationInputInputFieldCityDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3052: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldCityPreviewListTransformer(), n, "Navigation.LocationInput.InputField.City", "PreviewList");
                break;
            }
            case 3053: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldCityListTransformer(), n, "Navigation.LocationInput.InputField.City", "List");
                break;
            }
            case 3054: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldCityListInfoTransformer(), n, "Navigation.LocationInput.InputField.City", "ListInfo");
                genericASLList.updateList(new NavigationLocationInputInputFieldCityListInfoCollector[]{new NavigationLocationInputInputFieldCityListInfoCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.LocationInput.InputField.City: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

