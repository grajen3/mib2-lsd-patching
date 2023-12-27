/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.webradio;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.webradio.SessionManager;
import de.vw.mib.asl.internal.webradio.WebRadioServiceManager;
import org.dsi.ifc.connectedradio.DSIOnlineRadio;
import org.dsi.ifc.connectedradio.RadioStation;
import org.dsi.ifc.search.SearchQuery;

public final class DsiWebRadioAdapter {
    public void requestSupportedCountries() {
    }

    public void requestStationList(SearchQuery searchQuery) {
    }

    public void getRadioStationLogo(RadioStation radioStation, int n) {
        try {
            DSIOnlineRadio dSIOnlineRadio = WebRadioServiceManager.getServiceManager().getDsiOnlineRadio();
            if (null == dSIOnlineRadio) {
                ServiceManager.logger2.error(2).append("DsiWebRadioAdapter - getRadioStationLogo() - null == dsiOnlineRadio").log();
            } else {
                int n2 = WebRadioServiceManager.getServiceManager().getSessionManager().getNewSessionId();
                WebRadioServiceManager.getServiceManager().getSessionManager().setCurrentSessionId(SessionManager.SESSION_TYPE_GET_RADIO_STATION_LOGO, n2);
                dSIOnlineRadio.getRadioStationLogo(n2, radioStation, n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void getStreamUrl(RadioStation radioStation) {
        try {
            DSIOnlineRadio dSIOnlineRadio = WebRadioServiceManager.getServiceManager().getDsiOnlineRadio();
            if (null == dSIOnlineRadio) {
                ServiceManager.logger2.error(2).append("DsiWebRadioAdapter - getStreamUrl() - null == dsiOnlineRadio").log();
            } else {
                int n = WebRadioServiceManager.getServiceManager().getSessionManager().getNewSessionId();
                WebRadioServiceManager.getServiceManager().getSessionManager().setCurrentSessionId(SessionManager.SESSION_TYPE_GET_STREAM_URL, n);
                dSIOnlineRadio.getStreamUrl(n, radioStation);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void getMetaInformation(RadioStation radioStation) {
        try {
            DSIOnlineRadio dSIOnlineRadio = WebRadioServiceManager.getServiceManager().getDsiOnlineRadio();
            if (null == dSIOnlineRadio) {
                ServiceManager.logger2.error(2).append("DsiWebRadioAdapter - getMetaInformation() - null == dsiOnlineRadio").log();
            } else {
                int n = WebRadioServiceManager.getServiceManager().getSessionManager().getNewSessionId();
                WebRadioServiceManager.getServiceManager().getSessionManager().setCurrentSessionId(SessionManager.SESSION_TYPE_GET_META_INFORMATION, n);
                dSIOnlineRadio.getStreamUrl(n, radioStation);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void downloadDatabase() {
        try {
            DSIOnlineRadio dSIOnlineRadio = WebRadioServiceManager.getServiceManager().getDsiOnlineRadio();
            if (null == dSIOnlineRadio) {
                ServiceManager.logger2.error(2).append("DsiWebRadioAdapter - downloadDatabase() - null == dsiOnlineRadio").log();
            } else {
                int n = WebRadioServiceManager.getServiceManager().getSessionManager().getNewSessionId();
                WebRadioServiceManager.getServiceManager().getSessionManager().setCurrentSessionId(SessionManager.SESSION_TYPE_DOWNLOAD_DATABASE, n);
                dSIOnlineRadio.downloadDatabase(n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void cancelDownloadDatabase() {
        try {
            DSIOnlineRadio dSIOnlineRadio = WebRadioServiceManager.getServiceManager().getDsiOnlineRadio();
            if (null == dSIOnlineRadio) {
                ServiceManager.logger2.error(2).append("DsiWebRadioAdapter - cancelDownloadDatabase() - null == dsiOnlineRadio").log();
            } else {
                int n = WebRadioServiceManager.getServiceManager().getSessionManager().getNewSessionId();
                WebRadioServiceManager.getServiceManager().getSessionManager().setCurrentSessionId(SessionManager.SESSION_TYPE_CANCEL_DOWNLOAD_DATABASE, n);
                dSIOnlineRadio.cancelDownloadDatabase(n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

