/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory.sd;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.map.MapConfiguration;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.navigation.gateway.AbstractResettableNavGatewayTarget;
import de.vw.mib.asl.internal.navigation.gateway.Command;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLocationDescriptionTransform;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLastStateHistoryAdd;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiStartSpellerAlongRouteAdvanced;
import de.vw.mib.asl.internal.navigation.memory.sd.FileBrowserHelper;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.ExifInfo;
import de.vw.mib.graphics.image.ImageInfo;
import de.vw.mib.graphics.image.ImageLoadingListener;
import de.vw.mib.log4mib.LogMessage;
import edu.emory.mathcs.backport.java.util.Arrays;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.memory.sd.transformer.NavigationMemorySDGpsPicListSelectedDetailsCollector;
import java.util.HashMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;

public class TargetMemorySdGpsPictures
extends AbstractResettableNavGatewayTarget
implements ASLListElementFetcher,
ImageLoadingListener,
DSIServiceStateListener {
    public static final int EV_SEND_CMD;
    private static final int[] OBSERVERS;
    private static final int[] REQUIRED_EXIF_TAGS;
    private FileBrowserHelper fileBrowserHelper = new FileBrowserHelper(this, 926, 2);
    private NavLocation gpsPicNavLocation;
    private ResourceLocator currentGpsPicResource;
    private String selectedImageDescription;
    private boolean wasServiceStateListenerRegistered = false;
    private DSIListener navigationListener = null;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    public TargetMemorySdGpsPictures(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.addObservers(OBSERVERS);
                this.initDSI();
                break;
            }
            case 107: {
                this.removeObservers(OBSERVERS);
                break;
            }
            case 1073742477: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetMemorySdGpsPictures: ASL_NAVIGATION_MEMORY_SD_LOAD_ALL_GPS_PICS");
                }
                this.fileBrowserHelper.startFileBrowserSession(eventGeneric.getInt(0), 75956480);
                break;
            }
            case 1073742481: {
                this.error("The event ASL_NAVIGATION_MEMORY_SD_SELECT_DEST_LIST_GPS_PIC is not obsolete and not handled.");
                break;
            }
            case 1073742483: {
                this.error("The event ASL_NAVIGATION_MEMORY_SD_SELECT_NEXT_DEST_LIST_GPS_PIC is not obsolete and not handled.");
                break;
            }
            case 1073742485: {
                this.error("The event ASL_NAVIGATION_MEMORY_SD_SELECT_PREV_DEST_LIST_GPS_PIC is not obsolete and not handled.");
                break;
            }
            case 1073742478: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetMemorySdGpsPictures: ASL_NAVIGATION_MEMORY_SD_LOAD_GPS_PIC_DETAILS_FROM_PICTURE");
                }
                this.currentGpsPicResource = (ResourceLocator)eventGeneric.getObject(0);
                this.gpsPicNavLocation = null;
                ServiceManager.imageManager.getExifInfoFromResource(this.currentGpsPicResource, 3, REQUIRED_EXIF_TAGS, this);
                break;
            }
            case 1073742475: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetMemorySdGpsPictures: ASL_NAVIGATION_MEMORY_SD_GPS_PIC_SET_AS_CURRENT_DEST");
                }
                if (this.gpsPicNavLocation == null || !this.gpsPicNavLocation.positionValid) break;
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setMemoryLocation(this.gpsPicNavLocation);
                this.sendHMIEvent(103);
                break;
            }
            case 100100: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetMemorySdGpsPictures: EV_RECEIVE_FILEBROWSER_SESSION_START_RESULT");
                }
                this.fileBrowserHelper.handleStartSessionResult(eventGeneric, 159842560);
                break;
            }
            case 100105: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetMemorySdGpsPictures: EV_FILEBROWSER_SET_DIRECTORY_ABSOLUTE");
                }
                this.fileBrowserHelper.handleSetDirectoryAbsolute(eventGeneric, 92733696);
                break;
            }
            case 100101: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetMemorySdGpsPictures: EV_FILEBROWSER_SET_CONTENTFILTER_RESULT");
                }
                this.fileBrowserHelper.handleSetContentFilterResult(eventGeneric, 109510912);
                break;
            }
            case 100102: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetMemorySdGpsPictures: EV_FILEBROWSER_UPDATE_LIST_SIZE");
                }
                this.fileBrowserHelper.handleListSizeUpdate(eventGeneric);
                break;
            }
            case 100103: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetMemorySdGpsPictures: EV_FILEBROWSER_RECEIVE_ENTRIES");
                }
                this.fileBrowserHelper.handleReceivedEntries(eventGeneric, 143065344);
                break;
            }
            case 100104: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetMemorySdGpsPictures: EV_FILEBROWSER_RECEIVE_RESOURCE_LOCATORS");
                }
                this.fileBrowserHelper.handleReceivedResourceLocators(eventGeneric);
                break;
            }
            case 100106: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetMemorySdGpsPictures: EV_FILEBROWSER_DIRECTORY_CHANGED");
                }
                Path path = (Path)eventGeneric.getObject(0);
                int n = eventGeneric.getInt(1);
                this.fileBrowserHelper.startFileBrowserSession(path, 75956480);
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent();
                eventGeneric2.setReceiverEventId(-1524292096);
                eventGeneric2.setReceiverTargetId(-1058336256);
                eventGeneric2.setSenderEventId(109510912);
                eventGeneric2.setInt(0, n);
                break;
            }
            case 100107: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetMemorySdGpsPictures: EV_SEND_CMD");
                    this.trace("TargetMemorySdGPSPictures: executing CmdGetLocationDescriptionTransform");
                }
                ((Command)eventGeneric.getObject(0)).execute();
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.trace().append("Target Navigation.Memory.SD.GpsPictures entered DEFAULT event with ID:").append(eventGeneric.getReceiverEventId()).log();
            }
        }
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    @Override
    public void handleCommandCmdGetLocationDescriptionTransform(CmdGetLocationDescriptionTransform cmdGetLocationDescriptionTransform) {
        this.gpsPicNavLocation = cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation;
        String string = "Resolved EXIF data from picture to location:";
        if (this.gpsPicNavLocation != null) {
            if (this.isTraceEnabled()) {
                this.trace().append(string).append(this.gpsPicNavLocation.toString()).log();
            }
        } else if (this.isTraceEnabled()) {
            this.trace().append(string).append("was null").log();
        }
        this.updateDatapoolGpsPicDetails(this.gpsPicNavLocation, this.currentGpsPicResource);
    }

    @Override
    public void fetchItems(ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetMemorySdGpsPictures - fetch items called: ").append(n).append("  ").append(n2).log();
        }
        this.fileBrowserHelper.fetchItems(n, n2);
    }

    @Override
    public void fetchNextPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.fetchItems(aSLCachedWindowList, n, n2);
    }

    @Override
    public void fetchPreviousPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.fetchItems(aSLCachedWindowList, n, n2);
    }

    private void initDSI() {
        if (!this.wasServiceStateListenerRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            dSIProxy.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetMemorySdGpsPictures.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
            this.wasServiceStateListenerRegistered = true;
        }
    }

    private void updateDatapoolGpsPicDetails(NavLocation navLocation, ResourceLocator resourceLocator) {
        if (navLocation != null && resourceLocator != null) {
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
            this.setMapLocation(navLocation);
            NavigationMemorySDGpsPicListSelectedDetailsCollector navigationMemorySDGpsPicListSelectedDetailsCollector = (NavigationMemorySDGpsPicListSelectedDetailsCollector)ListManager.getGenericASLList(923).getRowItemCacheOnly(0);
            String string = resourceLocator.getUrl();
            String string2 = "";
            if (string != null && string.length() > 0) {
                int n = Math.max(string.lastIndexOf(47), string.lastIndexOf(92)) + 1;
                if (string.length() > n) {
                    string2 = string.substring(n);
                }
            }
            navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_title = string2;
            navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_v_gps_pic_list_selected_details_info = this.selectedImageDescription;
            navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_country = iLocationWrapper.getCountry();
            navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_country_code = iLocationWrapper.getCountryCode();
            navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_zip = iLocationWrapper.getPostalCode();
            navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_city = iLocationWrapper.getCity();
            navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_city_refinement = iLocationWrapper.getCityRefinement();
            navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_street = iLocationWrapper.getStreet();
            navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_street_refinement = iLocationWrapper.getStreetRefinement();
            navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_junction = iLocationWrapper.getCrossing();
            navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_number = iLocationWrapper.getHousenumber();
            navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_image_path = resourceLocator;
            navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_coordinates = iLocationWrapper.isGeoLocationAvailable();
            navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_address = "";
            navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_is_guidable = iLocationWrapper.isNavigable();
            navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_lat_degree = iLocationWrapper.getLatitudeDegrees();
            navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_lat_minutes = iLocationWrapper.getLatitudeMinutes();
            navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_lat_seconds = iLocationWrapper.getLatitudeSeconds();
            navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_lon_degree = iLocationWrapper.getLongitudeDegrees();
            navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_lon_minutes = iLocationWrapper.getLongitudeMinutes();
            navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_lon_seconds = iLocationWrapper.getLongitudeSeconds();
            navigationMemorySDGpsPicListSelectedDetailsCollector.navigation_memory_sd_gps_pic_list_selected_details_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper);
            ListManager.getGenericASLList(923).updateList(new NavigationMemorySDGpsPicListSelectedDetailsCollector[]{navigationMemorySDGpsPicListSelectedDetailsCollector});
            ServiceManager.aslPropertyManager.valueChangedInteger(752, 0);
        } else {
            if (this.isTraceEnabled()) {
                LogMessage logMessage = this.trace();
                logMessage.append(super.getClass().getName()).append(" #updateDatapoolGpsPicDetails: NavLocation/ResourceLocator not ready ");
                logMessage.append(navLocation).append("/").append(resourceLocator);
                logMessage.log();
            }
            ServiceManager.aslPropertyManager.valueChangedInteger(752, 1);
        }
    }

    private boolean checkExifInfo(ExifInfo exifInfo) {
        if (exifInfo == null) {
            this.warn("checkExifData(): ExifData was null");
            return false;
        }
        int n = this.retrieveDsiLatitude(exifInfo);
        if (this.isTraceEnabled()) {
            this.trace("Dsi Latitude is: ", n);
        }
        int n2 = this.retrieveDsiLongitude(exifInfo);
        if (this.isTraceEnabled()) {
            this.trace("Dsi Longitude is: ", n2);
        }
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(n, n2).getLocation();
        this.gpsPicNavLocation = null;
        if (this.isTraceEnabled()) {
            this.trace("TargetMemorySdGPSPictures: preparing CmdGetLocationDescriptionTransform");
        }
        CmdGetLocationDescriptionTransform cmdGetLocationDescriptionTransform = new CmdGetLocationDescriptionTransform(this, navLocation);
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent();
        eventGeneric.setReceiverEventId(193396992);
        eventGeneric.setReceiverTargetId(2118849536);
        eventGeneric.setObject(0, cmdGetLocationDescriptionTransform);
        try {
            this.send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            // empty catch block
        }
        return true;
    }

    private int retrieveDsiLongitude(ExifInfo exifInfo) {
        Object[] objectArray;
        int n;
        Object[] objectArray2 = (Object[])exifInfo.getExifValue(4);
        double[] dArray = new double[3];
        if (objectArray2.length == 3) {
            for (n = 0; n < 3; ++n) {
                objectArray = (Long[])objectArray2[n];
                if (objectArray == null) {
                    if (this.isTraceEnabled()) {
                        this.trace("Exif coordinate in longitude Array was null");
                    }
                    objectArray = this.getInvalidGeoCoordinateArray();
                } else if (this.isTraceEnabled()) {
                    this.trace().append("Longitude: ").append(Arrays.toString(objectArray)).log();
                }
                dArray[n] = objectArray[1].equals(new Long(0L)) ? 0.0 : ((Long)objectArray[0]).doubleValue() / ((Long)objectArray[1]).doubleValue();
            }
        } else {
            this.error("Exif Data longitued array was of wrong length. Verify implementation of ImageSPI.");
        }
        n = 0;
        objectArray = this.getLongitudeEastWestIndicator(exifInfo);
        if (objectArray.equals("W")) {
            n = 1;
        }
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().degMinSecToDsi(dArray, n != 0);
    }

    private int retrieveDsiLatitude(ExifInfo exifInfo) {
        Object[] objectArray;
        int n;
        Object[] objectArray2 = (Object[])exifInfo.getExifValue(2);
        double[] dArray = new double[3];
        if (objectArray2.length == 3) {
            for (n = 0; n < 3; ++n) {
                objectArray = (Long[])objectArray2[n];
                if (objectArray == null) {
                    if (this.isTraceEnabled()) {
                        this.trace("Exif coordinate in latitude Array was null");
                    }
                    objectArray = this.getInvalidGeoCoordinateArray();
                } else if (this.isTraceEnabled()) {
                    this.trace().append("Latitude: ").append(Arrays.toString(objectArray)).log();
                }
                dArray[n] = objectArray[1].equals(new Long(0L)) ? 0.0 : ((Long)objectArray[0]).doubleValue() / ((Long)objectArray[1]).doubleValue();
            }
        } else {
            this.error("Exif Data latitude array was of wrong length. Verify implementation of ImageSPI.");
        }
        n = 0;
        objectArray = this.getLatitudeNorthSouthIndicator(exifInfo);
        if (objectArray.equals("S")) {
            n = 1;
        }
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().degMinSecToDsi(dArray, n != 0);
    }

    private String getLongitudeEastWestIndicator(ExifInfo exifInfo) {
        String string;
        String string2 = (String)exifInfo.getExifValue(3);
        if (this.isTraceEnabled()) {
            this.trace("GpsLongitudeRef: ");
            this.traceStringDetails(string2);
        }
        if (string2 != null && string2.length() > 0) {
            string = string2.substring(0, 1);
        } else {
            this.error("Error while processing ExifData.EXIF_TAG_GPS_LONGITUDE_REF");
            string = "Error";
        }
        return string;
    }

    private String getLatitudeNorthSouthIndicator(ExifInfo exifInfo) {
        String string;
        String string2 = (String)exifInfo.getExifValue(1);
        if (this.isTraceEnabled()) {
            this.trace("GpsLatitudeRef: ");
            this.traceStringDetails(string2);
        }
        if (string2 != null && string2.length() > 0) {
            string = string2.substring(0, 1);
        } else {
            this.error("Error while processing ExifData.EXIF_TAG_GPS_LATITUDE_REF");
            string = "Error";
        }
        return string;
    }

    private void traceStringDetails(String string) {
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.trace();
            logMessage.append("String: ").append(string);
            if (string != null) {
                logMessage.append(" - Chars/Bits: ");
                for (int i2 = 0; i2 < string.length(); ++i2) {
                    char c2 = string.charAt(i2);
                    logMessage.append(c2).append("(").append(Integer.toBinaryString(c2)).append(")");
                }
            }
            if (this.isTraceEnabled()) {
                logMessage.log();
            }
        }
    }

    private Long[] getInvalidGeoCoordinateArray() {
        return new Long[]{new Long(0L), new Long(1L)};
    }

    private void setMapLocation(NavLocation navLocation) {
        if (this.isTraceEnabled()) {
            this.trace("TargetMemorySdGpsPictures: Setting map to center on the GPS pic location");
        }
        MapConfiguration mapConfiguration = new MapConfiguration(navLocation, 25, 0);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainContentGotoLocation(16, mapConfiguration);
    }

    @Override
    public void imageAvailable(ResourceLocator resourceLocator, BufferImage bufferImage) {
    }

    @Override
    public void imageError(ResourceLocator resourceLocator, Exception exception) {
    }

    @Override
    public void imageInfoAvailable(ResourceLocator resourceLocator, ImageInfo imageInfo) {
    }

    @Override
    public void imageInfoError(ResourceLocator resourceLocator, Exception exception) {
    }

    @Override
    public void imageLoadingProgress(ResourceLocator resourceLocator, int n) {
    }

    @Override
    public void thumbnailImageAvailable(ResourceLocator resourceLocator, BufferImage bufferImage) {
    }

    @Override
    public void thumbnailImageError(ResourceLocator resourceLocator, Exception exception) {
    }

    @Override
    public void exifInfoAvailable(ResourceLocator resourceLocator, int n, int[] nArray, ExifInfo exifInfo) {
        if (!this.checkExifInfo(exifInfo)) {
            this.error("TargetMemorySdGpsPictures: Exif Info available, but couldn't retrieve coordinates");
        }
    }

    @Override
    public void exifInfoError(ResourceLocator resourceLocator, int n, int[] nArray, Exception exception) {
        this.warn("ImageAPI reported ExifInfoError: ", exception.getMessage());
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetMemorySdGpsPictures.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0)) {
            if (this.isTraceEnabled()) {
                this.trace("TargetMemorySdGpsPictures: resetting values after DSI restart");
            }
            this.gpsPicNavLocation = null;
            this.initDsiNavigation();
        } else if (this.isTraceEnabled()) {
            this.trace("TargetMemorySdGpsPictures: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    @Override
    public void registered(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetMemorySdGpsPictures.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern() && !this.isFirstStartupDone) {
            this.isFirstStartupDone = true;
            if (this.isTraceEnabled()) {
                this.trace(new StringBuffer().append("TargetMemorySdGpsPictures: register ").append(string).toString());
            }
            this.initDsiNavigation();
        }
    }

    public void initDsiNavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.navigationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetMemorySdGpsPictures.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetMemorySdGpsPictures.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
    }

    @Override
    public void unregistered(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetMemorySdGpsPictures.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            if (this.isTraceEnabled()) {
                this.trace(new StringBuffer().append("TargetMemorySdGpsPictures: unregister ").append(string).toString());
            }
            if (this.navigationListener != null) {
                DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
                dSIProxy.removeResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetMemorySdGpsPictures.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
            }
        }
    }

    @Override
    public void handleCommandCmdPoiStartSpellerAlongRouteAdvanced(CmdPoiStartSpellerAlongRouteAdvanced cmdPoiStartSpellerAlongRouteAdvanced) {
    }

    @Override
    public void handleCommandCmdLastStateHistoryAdd(CmdLastStateHistoryAdd cmdLastStateHistoryAdd) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        OBSERVERS = new int[]{-1929248704, -1912471488, -1962803136, -1862139840, -1828585408, -1795030976};
        REQUIRED_EXIF_TAGS = new int[]{2, 1, 4, 3};
    }
}

