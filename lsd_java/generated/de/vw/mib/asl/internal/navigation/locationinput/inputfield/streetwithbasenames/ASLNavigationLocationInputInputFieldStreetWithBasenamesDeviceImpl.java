/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.streetwithbasenames;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.locationinput.inputfield.streetwithbasenames.transformer.NavigationLocationInputInputFieldStreetWithBasenamesListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.streetwithbasenames.transformer.NavigationLocationInputInputFieldStreetWithBasenamesListInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.streetwithbasenames.transformer.NavigationLocationInputInputFieldStreetWithBasenamesListInfoTransformer;

public final class ASLNavigationLocationInputInputFieldStreetWithBasenamesDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationLocationInputInputFieldStreetWithBasenamesDeviceImpl INSTANCE = new ASLNavigationLocationInputInputFieldStreetWithBasenamesDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLNavigationLocationInputInputFieldStreetWithBasenamesDeviceImpl() {
    }

    public static ASLNavigationLocationInputInputFieldStreetWithBasenamesDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.LocationInput.InputField.StreetWithBasenames";
    }

    @Override
    public int getTargetId() {
        return 10135;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(3441, this);
        aSLListRegistry.registerASLDevice(3442, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3441: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 3442: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.LocationInput.InputField.StreetWithBasenames: ").append(n).toString());
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
        return ASLNavigationLocationInputInputFieldStreetWithBasenamesDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationLocationInputInputFieldStreetWithBasenamesDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3441: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldStreetWithBasenamesListTransformer(), n, "Navigation.LocationInput.InputField.StreetWithBasenames", "List");
                break;
            }
            case 3442: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldStreetWithBasenamesListInfoTransformer(), n, "Navigation.LocationInput.InputField.StreetWithBasenames", "ListInfo");
                genericASLList.updateList(new NavigationLocationInputInputFieldStreetWithBasenamesListInfoCollector[]{new NavigationLocationInputInputFieldStreetWithBasenamesListInfoCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.LocationInput.InputField.StreetWithBasenames: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

