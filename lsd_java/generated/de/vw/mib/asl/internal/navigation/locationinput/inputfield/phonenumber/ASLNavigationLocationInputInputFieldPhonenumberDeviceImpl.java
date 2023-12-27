/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.phonenumber;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.locationinput.inputfield.phonenumber.transformer.NavigationLocationInputInputFieldPhonenumberResultListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.phonenumber.transformer.NavigationLocationInputInputFieldPhonenumberListInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.phonenumber.transformer.NavigationLocationInputInputFieldPhonenumberListInfoTransformer;

public final class ASLNavigationLocationInputInputFieldPhonenumberDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationLocationInputInputFieldPhonenumberDeviceImpl INSTANCE = new ASLNavigationLocationInputInputFieldPhonenumberDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLNavigationLocationInputInputFieldPhonenumberDeviceImpl() {
    }

    public static ASLNavigationLocationInputInputFieldPhonenumberDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.LocationInput.InputField.Phonenumber";
    }

    @Override
    public int getTargetId() {
        return 12115;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-923791360, this);
        aSLListRegistry.registerASLDevice(-839905280, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 1110216: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 1110221: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.LocationInput.InputField.Phonenumber: ").append(n).toString());
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
        return ASLNavigationLocationInputInputFieldPhonenumberDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationLocationInputInputFieldPhonenumberDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 1110216: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldPhonenumberListInfoTransformer(), n, "Navigation.LocationInput.InputField.Phonenumber", "ListInfo");
                genericASLList.updateList(new NavigationLocationInputInputFieldPhonenumberListInfoCollector[]{new NavigationLocationInputInputFieldPhonenumberListInfoCollector()});
                break;
            }
            case 1110221: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationLocationInputInputFieldPhonenumberResultListTransformer(), n, "Navigation.LocationInput.InputField.Phonenumber", "ResultList");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.LocationInput.InputField.Phonenumber: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

