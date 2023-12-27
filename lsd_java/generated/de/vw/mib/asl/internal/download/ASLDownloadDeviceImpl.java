/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.download;

import de.vw.mib.asl.internal.download.transformer.DownloadAvailableReleaseNamesTransformer;
import de.vw.mib.asl.internal.download.transformer.DownloadCompatibilityRequirementsTransformer;
import de.vw.mib.asl.internal.download.transformer.DownloadCurrentDownloadItemTransformer;
import de.vw.mib.asl.internal.download.transformer.DownloadInstalledSWTransformer;
import de.vw.mib.asl.internal.download.transformer.DownloadLoggedDevicesAsStringTransformer;
import de.vw.mib.asl.internal.download.transformer.DownloadLoggedDevicesTransformer;
import de.vw.mib.asl.internal.download.transformer.DownloadLoggedFirmwarePartAsStringTransformer;
import de.vw.mib.asl.internal.download.transformer.DownloadLoggedFirmwarePartTransformer;
import de.vw.mib.asl.internal.download.transformer.DownloadLoggedModulesAsStringTransformer;
import de.vw.mib.asl.internal.download.transformer.DownloadLoggedModulesTransformer;
import de.vw.mib.asl.internal.download.transformer.DownloadLoggingListTransformer;
import de.vw.mib.asl.internal.download.transformer.DownloadSourceMediaAvailableTransformer;
import de.vw.mib.asl.internal.download.transformer.DownloadUnReadyDevicesTransformer;
import de.vw.mib.asl.internal.download.transformer.DownloadUpdateableDevicesAsStringTransformer;
import de.vw.mib.asl.internal.download.transformer.DownloadUpdateableDevicesTransformer;
import de.vw.mib.asl.internal.download.transformer.DownloadUpdateableFirmwarePartAsStringTransformer;
import de.vw.mib.asl.internal.download.transformer.DownloadUpdateableFirmwarePartTransformer;
import de.vw.mib.asl.internal.download.transformer.DownloadUpdateableModulesAsStringTransformer;
import de.vw.mib.asl.internal.download.transformer.DownloadUpdateableModulesTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.download.transformer.DownloadPopupInfoCollector;
import generated.de.vw.mib.asl.internal.download.transformer.DownloadPopupInfoTransformer;

public final class ASLDownloadDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLDownloadDeviceImpl INSTANCE = new ASLDownloadDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(20);
    private ASLListFactory listFactory;

    private ASLDownloadDeviceImpl() {
    }

    public static ASLDownloadDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Download";
    }

    @Override
    public int getTargetId() {
        return 10025;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(402, this);
        aSLListRegistry.registerASLDevice(403, this);
        aSLListRegistry.registerASLDevice(-1733616128, this);
        aSLListRegistry.registerASLDevice(404, this);
        aSLListRegistry.registerASLDevice(-1716838912, this);
        aSLListRegistry.registerASLDevice(405, this);
        aSLListRegistry.registerASLDevice(-1800724992, this);
        aSLListRegistry.registerASLDevice(406, this);
        aSLListRegistry.registerASLDevice(407, this);
        aSLListRegistry.registerASLDevice(-1700061696, this);
        aSLListRegistry.registerASLDevice(408, this);
        aSLListRegistry.registerASLDevice(-1683284480, this);
        aSLListRegistry.registerASLDevice(409, this);
        aSLListRegistry.registerASLDevice(-1750393344, this);
        aSLListRegistry.registerASLDevice(410, this);
        aSLListRegistry.registerASLDevice(411, this);
        aSLListRegistry.registerASLDevice(374, this);
        aSLListRegistry.registerASLDevice(375, this);
        aSLListRegistry.registerASLDevice(377, this);
        aSLListRegistry.registerASLDevice(399, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(570490944, 10025);
        serviceRegister.registerService(587268160, 10025);
        serviceRegister.registerService(604045376, 10025);
        serviceRegister.registerService(620822592, 10025);
        serviceRegister.registerService(637599808, 10025);
        serviceRegister.registerService(654377024, 10025);
        serviceRegister.registerService(671154240, 10025);
        serviceRegister.registerService(-2138825152, 10025);
        serviceRegister.registerService(687931456, 10025);
        serviceRegister.registerService(704708672, 10025);
        serviceRegister.registerService(721485888, 10025);
        serviceRegister.registerService(738263104, 10025);
        serviceRegister.registerService(755040320, 10025);
        serviceRegister.registerService(771817536, 10025);
        serviceRegister.registerService(788594752, 10025);
        serviceRegister.registerService(805371968, 10025);
        serviceRegister.registerService(822149184, 10025);
        serviceRegister.registerService(838926400, 10025);
        serviceRegister.registerService(855703616, 10025);
        serviceRegister.registerService(872480832, 10025);
        serviceRegister.registerService(889258048, 10025);
        serviceRegister.registerService(906035264, 10025);
        serviceRegister.registerService(922812480, 10025);
        serviceRegister.registerService(939589696, 10025);
        serviceRegister.registerService(956366912, 10025);
        serviceRegister.registerService(973144128, 10025);
        serviceRegister.registerService(989921344, 10025);
        serviceRegister.registerService(1006698560, 10025);
        serviceRegister.registerService(1023475776, 10025);
        serviceRegister.registerService(1040252992, 10025);
        serviceRegister.registerService(-1257832384, 10025);
        serviceRegister.registerService(-1224277952, 10025);
        serviceRegister.registerService(-1241055168, 10025);
        serviceRegister.registerService(1460142144, 10025);
        serviceRegister.registerService(1476919360, 10025);
        serviceRegister.registerService(1493696576, 10025);
        serviceRegister.registerService(-1190657984, 10025);
        serviceRegister.registerService(1175060544, 10025);
        serviceRegister.registerService(1191837760, 10025);
        serviceRegister.registerService(-2122047936, 10025);
        serviceRegister.registerService(-2105270720, 10025);
        serviceRegister.registerService(-2088493504, 10025);
        serviceRegister.registerService(-2071716288, 10025);
        serviceRegister.registerService(-2054939072, 10025);
        serviceRegister.registerService(-2038161856, 10025);
        serviceRegister.registerService(-2021384640, 10025);
        serviceRegister.registerService(-2004607424, 10025);
        serviceRegister.registerService(-1987830208, 10025);
        serviceRegister.registerService(-1971052992, 10025);
        serviceRegister.registerService(-1954275776, 10025);
        serviceRegister.registerService(-1937498560, 10025);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 402: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 403: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2010008: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 404: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 2010009: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 405: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 2010004: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 406: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 407: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 2010010: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 408: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 2010011: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 409: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            case 2010007: {
                nArray = ListColumnsUtil.getSimpleIntArray(7);
                break;
            }
            case 410: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 411: {
                nArray = ListColumnsUtil.getSimpleIntArray(4);
                break;
            }
            case 374: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 375: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 377: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 399: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Download: ").append(n).toString());
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
        return ASLDownloadDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLDownloadDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 402: {
                genericASLList = aSLListFactory.createGenericASLList(new DownloadInstalledSWTransformer(), n, "Download", "InstalledSW");
                break;
            }
            case 403: {
                genericASLList = aSLListFactory.createGenericASLList(new DownloadUpdateableDevicesTransformer(), n, "Download", "UpdateableDevices");
                break;
            }
            case 2010008: {
                genericASLList = aSLListFactory.createGenericASLList(new DownloadUpdateableDevicesAsStringTransformer(), n, "Download", "UpdateableDevicesAsString");
                break;
            }
            case 404: {
                genericASLList = aSLListFactory.createGenericASLList(new DownloadUpdateableModulesTransformer(), n, "Download", "UpdateableModules");
                break;
            }
            case 2010009: {
                genericASLList = aSLListFactory.createGenericASLList(new DownloadUpdateableModulesAsStringTransformer(), n, "Download", "UpdateableModulesAsString");
                break;
            }
            case 405: {
                genericASLList = aSLListFactory.createGenericASLList(new DownloadUpdateableFirmwarePartTransformer(), n, "Download", "UpdateableFirmwarePart");
                break;
            }
            case 2010004: {
                genericASLList = aSLListFactory.createGenericASLList(new DownloadUpdateableFirmwarePartAsStringTransformer(), n, "Download", "UpdateableFirmwarePartAsString");
                break;
            }
            case 406: {
                genericASLList = aSLListFactory.createGenericASLList(new DownloadLoggingListTransformer(), n, "Download", "LoggingList");
                break;
            }
            case 407: {
                genericASLList = aSLListFactory.createGenericASLList(new DownloadLoggedDevicesTransformer(), n, "Download", "LoggedDevices");
                break;
            }
            case 2010010: {
                genericASLList = aSLListFactory.createGenericASLList(new DownloadLoggedDevicesAsStringTransformer(), n, "Download", "LoggedDevicesAsString");
                break;
            }
            case 408: {
                genericASLList = aSLListFactory.createGenericASLList(new DownloadLoggedModulesTransformer(), n, "Download", "LoggedModules");
                break;
            }
            case 2010011: {
                genericASLList = aSLListFactory.createGenericASLList(new DownloadLoggedModulesAsStringTransformer(), n, "Download", "LoggedModulesAsString");
                break;
            }
            case 409: {
                genericASLList = aSLListFactory.createGenericASLList(new DownloadLoggedFirmwarePartTransformer(), n, "Download", "LoggedFirmwarePart");
                break;
            }
            case 2010007: {
                genericASLList = aSLListFactory.createGenericASLList(new DownloadLoggedFirmwarePartAsStringTransformer(), n, "Download", "LoggedFirmwarePartAsString");
                break;
            }
            case 410: {
                genericASLList = aSLListFactory.createGenericASLList(new DownloadCurrentDownloadItemTransformer(), n, "Download", "CurrentDownloadItem");
                break;
            }
            case 411: {
                genericASLList = aSLListFactory.createGenericASLList(new DownloadPopupInfoTransformer(), n, "Download", "PopupInfo");
                genericASLList.updateList(new DownloadPopupInfoCollector[]{new DownloadPopupInfoCollector()});
                break;
            }
            case 374: {
                genericASLList = aSLListFactory.createGenericASLList(new DownloadUnReadyDevicesTransformer(), n, "Download", "UnReadyDevices");
                break;
            }
            case 375: {
                genericASLList = aSLListFactory.createGenericASLList(new DownloadAvailableReleaseNamesTransformer(), n, "Download", "AvailableReleaseNames");
                break;
            }
            case 377: {
                genericASLList = aSLListFactory.createGenericASLList(new DownloadCompatibilityRequirementsTransformer(), n, "Download", "CompatibilityRequirements");
                break;
            }
            case 399: {
                genericASLList = aSLListFactory.createGenericASLList(new DownloadSourceMediaAvailableTransformer(), n, "Download", "SourceMediaAvailable");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Download: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

