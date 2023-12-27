/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.postalcode;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.locationinput.inputfield.postalcode.transformer.NavigationLocationInputInputFieldPostalCodeListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.postalcode.transformer.NavigationLocationInputInputFieldPostalCodeListInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.postalcode.transformer.NavigationLocationInputInputFieldPostalCodeListInfoTransformer;

public final class ASLNavigationLocationInputInputFieldPostalCodeDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationLocationInputInputFieldPostalCodeDeviceImpl INSTANCE = new ASLNavigationLocationInputInputFieldPostalCodeDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLNavigationLocationInputInputFieldPostalCodeDeviceImpl() {
    }

    public static ASLNavigationLocationInputInputFieldPostalCodeDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.LocationInput.InputField.PostalCode";
    }

    @Override
    public int getTargetId() {
        return 10125;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(3046, this);
        aSLListRegistry.registerASLDevice(3047, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3046: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 3047: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.LocationInput.InputField.PostalCode: ").append(n).toString());
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
        return ASLNavigationLocationInputInputFieldPostalCodeDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationLocationInputInputFieldPostalCodeDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3046: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldPostalCodeListTransformer(), n, "Navigation.LocationInput.InputField.PostalCode", "List");
                break;
            }
            case 3047: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldPostalCodeListInfoTransformer(), n, "Navigation.LocationInput.InputField.PostalCode", "ListInfo");
                genericASLList.updateList(new NavigationLocationInputInputFieldPostalCodeListInfoCollector[]{new NavigationLocationInputInputFieldPostalCodeListInfoCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.LocationInput.InputField.PostalCode: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

