/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.navigation.speech.oneshot;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.speech.oneshot.transformer.NavigationSpeechOneshotCityTransformer;
import de.vw.mib.asl.internal.navigation.speech.oneshot.transformer.NavigationSpeechOneshotHouseNumberTransformer;
import de.vw.mib.asl.internal.navigation.speech.oneshot.transformer.NavigationSpeechOneshotStreetTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLNavigationSpeechOneshotDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLNavigationSpeechOneshotDeviceImpl INSTANCE = new ASLNavigationSpeechOneshotDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(3);
    private ASLListFactory listFactory;

    private ASLNavigationSpeechOneshotDeviceImpl() {
    }

    public static ASLNavigationSpeechOneshotDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Navigation.Speech.Oneshot";
    }

    @Override
    public int getTargetId() {
        return 10058;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(993, this);
        aSLListRegistry.registerASLDevice(994, this);
        aSLListRegistry.registerASLDevice(995, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 993: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 994: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 995: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Navigation.Speech.Oneshot: ").append(n).toString());
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
        return ASLNavigationSpeechOneshotDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLNavigationSpeechOneshotDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 993: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationSpeechOneshotCityTransformer(), n, "Navigation.Speech.Oneshot", "City");
                break;
            }
            case 994: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationSpeechOneshotStreetTransformer(), n, "Navigation.Speech.Oneshot", "Street");
                break;
            }
            case 995: {
                genericASLList = aSLListFactory.createGenericASLList(new NavigationSpeechOneshotHouseNumberTransformer(), n, "Navigation.Speech.Oneshot", "HouseNumber");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Navigation.Speech.Oneshot: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

