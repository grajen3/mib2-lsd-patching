/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.setup.settings.browser;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.phone.setup.settings.browser.transformer.PhoneSetupSettingsBrowserAvailableAudioSourcesTransformer;
import de.vw.mib.asl.internal.phone.setup.settings.browser.transformer.PhoneSetupSettingsBrowserBrowserListTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.phone.setup.settings.browser.transformer.PhoneSetupSettingsBrowserDisplayedFolderCollector;
import generated.de.vw.mib.asl.internal.phone.setup.settings.browser.transformer.PhoneSetupSettingsBrowserDisplayedFolderTransformer;

public final class ASLPhoneSetupSettingsBrowserDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneSetupSettingsBrowserDeviceImpl INSTANCE = new ASLPhoneSetupSettingsBrowserDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(3);
    private ASLListFactory listFactory;

    private ASLPhoneSetupSettingsBrowserDeviceImpl() {
    }

    public static ASLPhoneSetupSettingsBrowserDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Phone.Setup.Settings.Browser";
    }

    @Override
    public int getTargetId() {
        return 10117;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(2623, this);
        aSLListRegistry.registerASLDevice(2624, this);
        aSLListRegistry.registerASLDevice(2625, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-569966528, 10117);
        serviceRegister.registerService(-553189312, 10117);
        serviceRegister.registerService(-536412096, 10117);
        serviceRegister.registerService(-519634880, 10117);
        serviceRegister.registerService(-469303232, 10117);
        serviceRegister.registerService(-502857664, 10117);
        serviceRegister.registerService(-486080448, 10117);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 2623: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 2624: {
                nArray = ListColumnsUtil.getIntArrayByBits(14, 3);
                break;
            }
            case 2625: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Setup.Settings.Browser: ").append(n).toString());
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
        return ASLPhoneSetupSettingsBrowserDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLPhoneSetupSettingsBrowserDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 2623: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneSetupSettingsBrowserDisplayedFolderTransformer(), n, "Phone.Setup.Settings.Browser", "displayedFolder");
                genericASLList.updateList(new PhoneSetupSettingsBrowserDisplayedFolderCollector[]{new PhoneSetupSettingsBrowserDisplayedFolderCollector()});
                break;
            }
            case 2624: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneSetupSettingsBrowserAvailableAudioSourcesTransformer(), n, "Phone.Setup.Settings.Browser", "availableAudioSources");
                break;
            }
            case 2625: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneSetupSettingsBrowserBrowserListTransformer(), n, "Phone.Setup.Settings.Browser", "browserList");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Phone.Setup.Settings.Browser: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

