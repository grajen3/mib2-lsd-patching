/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mirrorlink.target;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.mirrorlink.target.MirrorLinkTarget;
import de.vw.mib.log4mib.LogMessage;

final class MirrorLinkErrorHandler {
    private final String classname;
    private final MirrorLinkTarget target;

    MirrorLinkErrorHandler(MirrorLinkTarget mirrorLinkTarget) {
        this.classname = "MirrorLinkErrorHandler";
        this.target = mirrorLinkTarget;
    }

    private MirrorLinkTarget getTarget() {
        return this.target;
    }

    public void asyncException(int n, String string, int n2) {
        LogMessage logMessage;
        if (this.getTarget().isTraceEnabled()) {
            logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkErrorHandler").append(".asyncException(errorCode=").append(n).append(", errorMsg=").append(string).append(", requestType=").append(n2).append(" )").log();
        }
        if (n == 8304) {
            switch (n2) {
                case 1000: {
                    logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkErrorHandler").append("->requestClientCapabilities()-> DSI TIMEOUT").log();
                    break;
                }
                case 1001: {
                    logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkErrorHandler").append(new StringBuffer().append("->requestAccessMode()-> DSI TIMEOUT and value is set to default").append(string).toString()).log();
                    this.getTarget().getController().handleDsiApiResponseAccessMode(0, 0);
                    break;
                }
                case 1002: {
                    logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkErrorHandler").append(new StringBuffer().append("->requestDayNightMode()-> DSI TIMEOUT and value is set to default").append(string).toString()).log();
                    this.getTarget().getController().handleDsiApiResponseDayNightMode(0, 0);
                    break;
                }
                case 1003: {
                    logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkErrorHandler").append(new StringBuffer().append("->requestUsableViewport()-> DSI TIMEOUT").append(string).toString()).log();
                    break;
                }
                case 1004: {
                    logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkErrorHandler").append(new StringBuffer().append("->requestAccessMode()-> DSI TIMEOUT").append(string).toString()).log();
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(513);
                    break;
                }
                case 1005: {
                    logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkErrorHandler").append(new StringBuffer().append("->requestAccessMode()-> DSI TIMEOUT").append(string).toString()).log();
                    break;
                }
                case 1006: {
                    logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkErrorHandler").append(new StringBuffer().append("->requestRotateScreen()-> DSI TIMEOUT and the value for rotate screen is not set ").append(string).toString()).log();
                    break;
                }
                case 1007: {
                    logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkErrorHandler").append(new StringBuffer().append("->requestChangeOrientation()-> DSI TIMEOUT").append(string).toString()).log();
                    break;
                }
                case 1008: {
                    logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkErrorHandler").append(new StringBuffer().append("->requestSoftKeyEvent()-> DSI TIMEOUT ").append(string).toString()).log();
                    break;
                }
                case 1009: {
                    logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkErrorHandler").append(new StringBuffer().append("->requestAccessMode()-> DSI TIMEOUT and value is set to default ").append(string).toString()).log();
                    break;
                }
                case 1010: {
                    logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkErrorHandler").append("->requestAccessMode()-> DSI TIMEOUT and value is set to default").log();
                    this.getTarget().getController().handleDsiApiResponseTerminateApp(this.getTarget().getController().getRequestedAppID(), 0);
                    break;
                }
                case 1011: {
                    logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkErrorHandler").append(new StringBuffer().append("->requestStartSpeller()-> DSI TIMEOUT ").append(string).toString()).log();
                    break;
                }
                case 1012: {
                    logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkErrorHandler").append(new StringBuffer().append("->requestAddSpellerChars()-> DSI TIMEOUT ").append(string).toString()).log();
                    break;
                }
                case 1013: {
                    logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkErrorHandler").append(new StringBuffer().append("->requestRemoveSpellerChar()-> DSI TIMEOUT ").append(string).toString()).log();
                    break;
                }
                case 1014: {
                    logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkErrorHandler").append(new StringBuffer().append("->requestClearSpeller()-> DSI TIMEOUT ").append(string).toString()).log();
                    break;
                }
                case 1017: {
                    logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkErrorHandler").append(new StringBuffer().append("->requestAudioOption()-> DSI TIMEOUT ").append(string).toString()).log();
                    break;
                }
                case 1018: {
                    logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkErrorHandler").append(new StringBuffer().append("->requestAudioConnectionAudible()-> DSI TIMEOUT ").append(string).toString()).log();
                    break;
                }
                case 1019: {
                    logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkErrorHandler").append(new StringBuffer().append("->requestSendTouchEvents()-> DSI TIMEOUT ").append(string).toString()).log();
                    break;
                }
                case 1020: {
                    logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkErrorHandler").append(new StringBuffer().append("->requestContextVisible()-> DSI TIMEOUT ").append(string).toString()).log();
                    break;
                }
                case 1021: {
                    logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkErrorHandler").append(new StringBuffer().append("->requestKeyboardMode()-> DSI TIMEOUT ").append(string).toString()).log();
                    break;
                }
                case 1022: {
                    logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkErrorHandler").append(new StringBuffer().append("->requestAvailableApplicationsWindow()-> DSI TIMEOUT ").append(string).toString()).log();
                    break;
                }
                case 1023: {
                    logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkErrorHandler").append(new StringBuffer().append("->requestDisplayKeyboard()-> DSI TIMEOUT ").append(string).toString()).log();
                    break;
                }
                case 1025: {
                    logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkErrorHandler").append(new StringBuffer().append("->requestFactorySettings()-> DSI TIMEOUT ").append(string).toString()).log();
                    break;
                }
                case 1026: {
                    logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkErrorHandler").append(new StringBuffer().append("->requestPhoneView()-> DSI TIMEOUT ").append(string).toString()).log();
                    this.getTarget().getController().handleDsiApiResponsePhoneView(8);
                    break;
                }
                case 1027: {
                    logMessage = this.getTarget().warn();
                    logMessage.append("MirrorLinkErrorHandler").append(new StringBuffer().append("->requestContextSwitched()-> DSI TIMEOUT ").append(string).toString()).log();
                    break;
                }
            }
        }
    }
}

