/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.street;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.locationinput.inputfield.street.transformer.NavigationLocationInputInputFieldStreetListTransformer;
import de.vw.mib.asl.internal.navigation.locationinput.inputfield.street.transformer.NavigationLocationInputInputFieldStreetPreviewListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.street.transformer.NavigationLocationInputInputFieldStreetListInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.street.transformer.NavigationLocationInputInputFieldStreetListInfoTransformer;

public final class ASLNavigationLocationInputInputFieldStreetDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationLocationInputInputFieldStreetDeviceImpl INSTANCE = new ASLNavigationLocationInputInputFieldStreetDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(3);
    private ASLListFactory listFactory;

    private ASLNavigationLocationInputInputFieldStreetDeviceImpl() {
    }

    public static ASLNavigationLocationInputInputFieldStreetDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.LocationInput.InputField.Street";
    }

    @Override
    public int getTargetId() {
        return 10127;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(3059, this);
        aSLListRegistry.registerASLDevice(3060, this);
        aSLListRegistry.registerASLDevice(3061, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3059: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 3060: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 3061: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.LocationInput.InputField.Street: ").append(n).toString());
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
        return ASLNavigationLocationInputInputFieldStreetDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationLocationInputInputFieldStreetDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3059: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldStreetPreviewListTransformer(), n, "Navigation.LocationInput.InputField.Street", "PreviewList");
                break;
            }
            case 3060: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldStreetListTransformer(), n, "Navigation.LocationInput.InputField.Street", "List");
                break;
            }
            case 3061: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldStreetListInfoTransformer(), n, "Navigation.LocationInput.InputField.Street", "ListInfo");
                genericASLList.updateList(new NavigationLocationInputInputFieldStreetListInfoCollector[]{new NavigationLocationInputInputFieldStreetListInfoCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.LocationInput.InputField.Street: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

