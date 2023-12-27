/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.streetdisambiguation;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.locationinput.inputfield.streetdisambiguation.transformer.NavigationLocationInputInputFieldStreetDisambiguationListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.streetdisambiguation.transformer.NavigationLocationInputInputFieldStreetDisambiguationListInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.streetdisambiguation.transformer.NavigationLocationInputInputFieldStreetDisambiguationListInfoTransformer;

public final class ASLNavigationLocationInputInputFieldStreetDisambiguationDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationLocationInputInputFieldStreetDisambiguationDeviceImpl INSTANCE = new ASLNavigationLocationInputInputFieldStreetDisambiguationDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLNavigationLocationInputInputFieldStreetDisambiguationDeviceImpl() {
    }

    public static ASLNavigationLocationInputInputFieldStreetDisambiguationDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.LocationInput.InputField.StreetDisambiguation";
    }

    @Override
    public int getTargetId() {
        return 10128;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(3066, this);
        aSLListRegistry.registerASLDevice(3067, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3066: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 3067: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.LocationInput.InputField.StreetDisambiguation: ").append(n).toString());
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
        return ASLNavigationLocationInputInputFieldStreetDisambiguationDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationLocationInputInputFieldStreetDisambiguationDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3066: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldStreetDisambiguationListTransformer(), n, "Navigation.LocationInput.InputField.StreetDisambiguation", "List");
                break;
            }
            case 3067: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldStreetDisambiguationListInfoTransformer(), n, "Navigation.LocationInput.InputField.StreetDisambiguation", "ListInfo");
                genericASLList.updateList(new NavigationLocationInputInputFieldStreetDisambiguationListInfoCollector[]{new NavigationLocationInputInputFieldStreetDisambiguationListInfoCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.LocationInput.InputField.StreetDisambiguation: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

