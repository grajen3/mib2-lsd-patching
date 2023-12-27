/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.housenumber;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.locationinput.inputfield.housenumber.transformer.NavigationLocationInputInputFieldHousenumberMatchOrAlternativeListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.housenumber.transformer.NavigationLocationInputInputFieldHousenumberListInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.housenumber.transformer.NavigationLocationInputInputFieldHousenumberListInfoTransformer;

public final class ASLNavigationLocationInputInputFieldHousenumberDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationLocationInputInputFieldHousenumberDeviceImpl INSTANCE = new ASLNavigationLocationInputInputFieldHousenumberDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLNavigationLocationInputInputFieldHousenumberDeviceImpl() {
    }

    public static ASLNavigationLocationInputInputFieldHousenumberDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.LocationInput.InputField.Housenumber";
    }

    @Override
    public int getTargetId() {
        return 10130;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(3079, this);
        aSLListRegistry.registerASLDevice(3080, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3079: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 3080: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.LocationInput.InputField.Housenumber: ").append(n).toString());
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
        return ASLNavigationLocationInputInputFieldHousenumberDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationLocationInputInputFieldHousenumberDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3079: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldHousenumberMatchOrAlternativeListTransformer(), n, "Navigation.LocationInput.InputField.Housenumber", "MatchOrAlternativeList");
                break;
            }
            case 3080: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldHousenumberListInfoTransformer(), n, "Navigation.LocationInput.InputField.Housenumber", "ListInfo");
                genericASLList.updateList(new NavigationLocationInputInputFieldHousenumberListInfoCollector[]{new NavigationLocationInputInputFieldHousenumberListInfoCollector()});
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.LocationInput.InputField.Housenumber: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

