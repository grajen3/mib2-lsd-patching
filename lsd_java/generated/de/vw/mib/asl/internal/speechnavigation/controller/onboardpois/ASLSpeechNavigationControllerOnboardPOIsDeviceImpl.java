/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechnavigation.controller.onboardpois;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.speechnavigation.controller.onboardpois.transformer.SpeechNavigationControllerOnboardPOIsOnboardPOICategoriesDetailTransformer;
import de.vw.mib.asl.internal.speechnavigation.controller.onboardpois.transformer.SpeechNavigationControllerOnboardPOIsOnboardPOICategoriesTransformer;
import de.vw.mib.asl.internal.speechnavigation.controller.onboardpois.transformer.SpeechNavigationControllerOnboardPOIsOnboardPOIsTransformer;
import de.vw.mib.asl.internal.speechnavigation.controller.onboardpois.transformer.SpeechNavigationControllerOnboardPOIsSelectedOnboardPOICategoriesTransformer;
import de.vw.mib.asl.internal.speechnavigation.controller.onboardpois.transformer.SpeechNavigationControllerOnboardPOIsSelectedOnboardPOITransformer;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechNavigationControllerOnboardPOIsDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechNavigationControllerOnboardPOIsDeviceImpl INSTANCE = new ASLSpeechNavigationControllerOnboardPOIsDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(5);
    private ASLListFactory listFactory;

    private ASLSpeechNavigationControllerOnboardPOIsDeviceImpl() {
    }

    public static ASLSpeechNavigationControllerOnboardPOIsDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechNavigation.Controller.OnboardPOIs";
    }

    @Override
    public int getTargetId() {
        return 14423;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1829254144, this);
        aSLListRegistry.registerASLDevice(1846031360, this);
        aSLListRegistry.registerASLDevice(1862808576, this);
        aSLListRegistry.registerASLDevice(1879585792, this);
        aSLListRegistry.registerASLDevice(1997026304, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-1595854016, 14423);
        serviceRegister.registerService(-1579076800, 14423);
        serviceRegister.registerService(-1562299584, 14423);
        serviceRegister.registerService(-1545522368, 14423);
        serviceRegister.registerService(-1528745152, 14423);
        serviceRegister.registerService(-1511967936, 14423);
        serviceRegister.registerService(-220122304, 14423);
        serviceRegister.registerService(-203345088, 14423);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 3410029: {
                nArray = ListColumnsUtil.getSimpleIntArray(6);
                break;
            }
            case 3410030: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 3410031: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 3410032: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            case 3410039: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.OnboardPOIs: ").append(n).toString());
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
        return ASLSpeechNavigationControllerOnboardPOIsDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLSpeechNavigationControllerOnboardPOIsDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 3410029: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerOnboardPOIsOnboardPOICategoriesTransformer(), n, "SpeechNavigation.Controller.OnboardPOIs", "OnboardPOICategories");
                break;
            }
            case 3410030: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerOnboardPOIsOnboardPOICategoriesDetailTransformer(), n, "SpeechNavigation.Controller.OnboardPOIs", "OnboardPOICategoriesDetail");
                break;
            }
            case 3410031: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerOnboardPOIsSelectedOnboardPOICategoriesTransformer(), n, "SpeechNavigation.Controller.OnboardPOIs", "SelectedOnboardPOICategories");
                break;
            }
            case 3410032: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerOnboardPOIsOnboardPOIsTransformer(), n, "SpeechNavigation.Controller.OnboardPOIs", "OnboardPOIs");
                break;
            }
            case 3410039: {
                genericASLList = aSLListFactory.createGenericASLList(new SpeechNavigationControllerOnboardPOIsSelectedOnboardPOITransformer(), n, "SpeechNavigation.Controller.OnboardPOIs", "SelectedOnboardPOI");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device SpeechNavigation.Controller.OnboardPOIs: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

