/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.audio;

import de.vw.mib.asl.internal.speechengine.audio.AudioConnection;
import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionClient;
import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionProvider;
import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionProviderImpl$HoldSDSConnectionTimeout;
import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionState;
import de.vw.mib.asl.internal.speechengine.audio.AudioManagementAdapter;
import de.vw.mib.asl.internal.speechengine.audio.AudioManagementAdapterListener;
import de.vw.mib.asl.internal.speechengine.audio.start.AudioProviderParameters;
import de.vw.mib.collections.ints.IntObjectMultimap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerManager;
import java.util.Iterator;

public final class AudioConnectionProviderImpl
implements AudioManagementAdapterListener,
AudioConnectionProvider {
    IntObjectOptHashMap audioConnections = new IntObjectOptHashMap(5);
    IntObjectMultimap releasingConnectionClients;
    private final int TRACE_CLASSIFIER;
    private static final String TRACE_PREFIX;
    private final Logger logger;
    private final ThreadSwitchingTarget threadSwichtingTarget;
    private final TimerManager timerManager;
    Timer timer;
    private AudioManagementAdapter audioManagementAdapter;
    private boolean holdSDSConnection = false;
    private boolean isAudioManagementAvailable = true;

    public AudioConnectionProviderImpl(AudioProviderParameters audioProviderParameters, AudioManagementAdapter audioManagementAdapter) {
        this.TRACE_CLASSIFIER = audioProviderParameters.getSubClassifier();
        this.logger = audioProviderParameters.getLogger();
        this.releasingConnectionClients = new IntObjectMultimap();
        this.audioManagementAdapter = audioManagementAdapter;
        this.audioManagementAdapter.setAdapterListener(this);
        this.threadSwichtingTarget = audioProviderParameters.getThreadSwitchingTarget();
        this.timerManager = audioProviderParameters.getTimerManager();
    }

    @Override
    public void requestConnection(int n, AudioConnectionClient audioConnectionClient) {
        Object object;
        if (this.logger.isTraceEnabled(this.TRACE_CLASSIFIER)) {
            object = new StringBuffer("[SpeechAudio] ");
            ((StringBuffer)object).append("AudioConnectionProvider-requestConnection: ");
            ((StringBuffer)object).append(n);
            this.logger.trace(this.TRACE_CLASSIFIER, ((StringBuffer)object).toString());
        }
        if (!this.isAudioManagementAvailable) {
            this.logger.warn(this.TRACE_CLASSIFIER, "AudioConnectionProvider-requestConnection: no request possible! AudioManagement (ASL-Sound/DSI) is not availbale!");
            audioConnectionClient.updateAudioConnectionState(n, AudioConnectionState.LOST);
            return;
        }
        if (this.audioConnections.containsKey(n)) {
            object = (AudioConnection)this.audioConnections.get(n);
            ((AudioConnection)object).addClient(audioConnectionClient);
        } else {
            object = new AudioConnection(n, audioConnectionClient);
            this.audioConnections.put(n, object);
            this.audioManagementAdapter.requestConnection(n);
            ((AudioConnection)object).setAudioConnectionState(AudioConnectionState.REQUESTED);
        }
        this.checkAndRemoveReleaseConnectionClients(n, audioConnectionClient);
    }

    @Override
    public void releaseConnection(int n, AudioConnectionClient audioConnectionClient) {
        Object object;
        if (this.logger.isTraceEnabled(this.TRACE_CLASSIFIER)) {
            object = new StringBuffer("[SpeechAudio] ");
            ((StringBuffer)object).append("request releaseConnection: ");
            ((StringBuffer)object).append(n);
            this.logger.trace(this.TRACE_CLASSIFIER, ((StringBuffer)object).toString());
        }
        if (!this.isAudioManagementAvailable) {
            this.logger.warn(this.TRACE_CLASSIFIER, "AudioConnectionProvider-releaseConnection: no release possible! AudioManagement (ASL-Sound/DSI) is not availbale!");
            new AudioConnection(n, audioConnectionClient, AudioConnectionState.LOST);
            return;
        }
        if (this.audioConnections.containsKey(n)) {
            this.addReleasingConnectionClient(n, audioConnectionClient);
            object = (AudioConnection)this.audioConnections.get(n);
            if (this.canConnectionBeReleased(n, ((AudioConnection)object).getNumberOfClients())) {
                this.audioManagementAdapter.releaseConnection(n);
                ((AudioConnection)object).setAudioConnectionState(AudioConnectionState.RELEASING);
            } else {
                this.logger.info(this.TRACE_CLASSIFIER, new StringBuffer().append("Discard release connection ").append(n).append(" because other clients still need it. ").toString());
            }
        } else {
            object = new StringBuffer("[SpeechAudio] ");
            ((StringBuffer)object).append("AudioConnectionProvider-releaseConnection: No such requested connection known yet: ");
            ((StringBuffer)object).append(n);
            this.logger.warn(this.TRACE_CLASSIFIER, ((StringBuffer)object).toString());
            new AudioConnection(n, audioConnectionClient, AudioConnectionState.RELEASED);
        }
    }

    private void addReleasingConnectionClient(int n, AudioConnectionClient audioConnectionClient) {
        if (!this.releasingConnectionClients.containsKeyValuePair(n, audioConnectionClient)) {
            this.releasingConnectionClients.put(n, audioConnectionClient);
        }
    }

    private void checkAndRemoveReleaseConnectionClients(int n, AudioConnectionClient audioConnectionClient) {
        if (this.releasingConnectionClients.containsKeyValuePair(n, audioConnectionClient)) {
            this.releasingConnectionClients.removeValue(n, audioConnectionClient);
        }
    }

    private boolean canConnectionBeReleased(int n, int n2) {
        if (this.isHoldSDSConnectionRequested() && n == 112) {
            this.logger.trace(this.TRACE_CLASSIFIER, "AudioConnectionProvider: hold SDS-AC but send ConnectionReleasedToSpeechIO");
            this.timer = this.timerManager.createTimer("AudioPendingRequestListener-WatchdogTimer", 0, false, new AudioConnectionProviderImpl$HoldSDSConnectionTimeout(this), this.threadSwichtingTarget);
            this.timer.start();
            AudioConnection audioConnection = (AudioConnection)this.audioConnections.get(112);
            audioConnection.setAudioConnectionState(AudioConnectionState.RELEASED);
            audioConnection.removeALLClients();
        } else if (this.releasingConnectionClients != null && this.releasingConnectionClients.containsKey(n) && this.releasingConnectionClients.getAll(n).size() == n2) {
            return true;
        }
        return false;
    }

    @Override
    public void releaseSDSConnection() {
        if (this.audioConnections.containsKey(112)) {
            this.releaseConnection((AudioConnection)this.audioConnections.get(112));
        }
    }

    private void releaseConnection(AudioConnection audioConnection) {
        int n = audioConnection.getConnectionID();
        if (this.logger.isTraceEnabled(this.TRACE_CLASSIFIER)) {
            StringBuffer stringBuffer = new StringBuffer("[SpeechAudio] ");
            stringBuffer.append("AudioConnectionProvider-releaseConnection: ");
            stringBuffer.append(n);
            this.logger.trace(this.TRACE_CLASSIFIER, stringBuffer.toString());
        }
        this.audioManagementAdapter.releaseConnection(n);
        audioConnection.setAudioConnectionState(AudioConnectionState.RELEASING);
    }

    @Override
    public void resultRequestConnection(int n, int n2) {
        AudioConnection audioConnection = (AudioConnection)this.audioConnections.get(n);
        if (audioConnection != null) {
            if (n2 == 0) {
                if (this.logger.isTraceEnabled(this.TRACE_CLASSIFIER)) {
                    StringBuffer stringBuffer = new StringBuffer("[SpeechAudio] ");
                    stringBuffer.append("AudioConnectionProvider-resultRequestConnection: AudioConnection fade-in: ");
                    stringBuffer.append(n);
                    this.logger.trace(this.TRACE_CLASSIFIER, stringBuffer.toString());
                }
                audioConnection.setAudioConnectionState(AudioConnectionState.ACTIVE);
            } else {
                if (this.logger.isTraceEnabled(this.TRACE_CLASSIFIER)) {
                    StringBuffer stringBuffer = new StringBuffer("[SpeechAudio] ");
                    stringBuffer.append("AudioConnectionProvider-resultRequestConnection: AudioConnection could NOT be fade-in: ");
                    stringBuffer.append(n);
                    this.logger.trace(this.TRACE_CLASSIFIER, stringBuffer.toString());
                }
                audioConnection.setAudioConnectionState(AudioConnectionState.DENIED);
                this.removeAudioConnection(n);
            }
        } else {
            StringBuffer stringBuffer = new StringBuffer("[SpeechAudio] ");
            stringBuffer.append("AudioConnectionProvider-resultRequestConnection: connection is not known by speechAudioManagement -> release this connection: ");
            stringBuffer.append(n);
            this.logger.warn(this.TRACE_CLASSIFIER, stringBuffer.toString());
            this.releaseConnection(new AudioConnection(n, null));
        }
    }

    @Override
    public void resultReleaseConnection(int n, int n2) {
        AudioConnection audioConnection = (AudioConnection)this.audioConnections.get(n);
        if (audioConnection != null) {
            if (n2 == 0) {
                if (this.logger.isTraceEnabled(this.TRACE_CLASSIFIER)) {
                    StringBuffer stringBuffer = new StringBuffer("[SpeechAudio] ");
                    stringBuffer.append("AudioConnectionProvider-resultReleaseConnection: AudioConnection released: ");
                    stringBuffer.append(n);
                    this.logger.trace(this.TRACE_CLASSIFIER, stringBuffer.toString());
                }
                audioConnection.setAudioConnectionState(AudioConnectionState.RELEASED);
                this.removeAudioConnection(n);
            } else if (n2 == 1 || n2 == 11) {
                if (this.logger.isTraceEnabled(this.TRACE_CLASSIFIER)) {
                    StringBuffer stringBuffer = new StringBuffer("[SpeechAudio] ");
                    stringBuffer.append("AudioConnectionProvider-resultReleaseConnection: AudioConnection could NOT be released: ");
                    stringBuffer.append(n);
                    this.logger.trace(this.TRACE_CLASSIFIER, stringBuffer.toString());
                }
                audioConnection.setAudioConnectionState(AudioConnectionState.ACTIVE);
            } else if (this.logger.isTraceEnabled(this.TRACE_CLASSIFIER)) {
                StringBuffer stringBuffer = new StringBuffer("[SpeechAudio] ");
                stringBuffer.append("AudioConnectionProvider-resultReleaseConnection: result not known: ");
                stringBuffer.append(n2);
                this.logger.trace(this.TRACE_CLASSIFIER, stringBuffer.toString());
            }
        } else {
            StringBuffer stringBuffer = new StringBuffer(this.TRACE_CLASSIFIER);
            stringBuffer.append("AudioConnectionProvider-resultReleaseConnection: connection is not known by speechAudioManagement: ");
            stringBuffer.append(n);
            this.logger.warn(this.TRACE_CLASSIFIER, stringBuffer.toString());
        }
    }

    @Override
    public void updateLossOfConnection(int n) {
        Object object;
        if (this.logger.isTraceEnabled(this.TRACE_CLASSIFIER)) {
            object = new StringBuffer("AudioConnectionProvider-updateLossOfConnection: LOSS of AudioConnection: ");
            ((StringBuffer)object).append(n);
            this.logger.trace(this.TRACE_CLASSIFIER, ((StringBuffer)object).toString());
        }
        if ((object = (AudioConnection)this.audioConnections.get(n)) != null) {
            ((AudioConnection)object).setAudioConnectionState(AudioConnectionState.LOST);
            this.removeAudioConnection(n);
        }
    }

    private void removeAudioConnection(int n) {
        this.audioConnections.remove(n);
        this.releasingConnectionClients.remove(n);
    }

    public boolean isAudioConnectionActive(int n) {
        if (this.audioConnections != null && !this.audioConnections.isEmpty() && this.audioConnections.containsKey(n)) {
            AudioConnectionState audioConnectionState = ((AudioConnection)this.audioConnections.get(n)).getAudioConnectionState();
            return audioConnectionState.getValue() == AudioConnectionState.ACTIVE.getValue();
        }
        return false;
    }

    @Override
    public void updateAudioPendingRequest(boolean bl, int n) {
        this.logger.error(this.TRACE_CLASSIFIER, "Feature 'Audio-Pending' currently not supported");
    }

    private boolean isHoldSDSConnectionRequested() {
        return this.holdSDSConnection;
    }

    @Override
    public void updateAudioManagementState(int n) {
        if (n == 0) {
            this.isAudioManagementAvailable = false;
            this.logger.error(this.TRACE_CLASSIFIER, "AudioConnectionProvider-updateAudioManagementState: AudioManagement (ASLSound and DSI) is not available anymore!");
            this.holdSDSConnection = false;
            this.setAllConnectionStatesLost();
        } else {
            this.isAudioManagementAvailable = true;
            this.logger.info(this.TRACE_CLASSIFIER, "AudioConnectionProvider-updateAudioManagementState: AudioManagement (ASLSound and DSI) is available again");
        }
    }

    private void setAllConnectionStatesLost() {
        if (this.audioConnections != null) {
            if (!this.audioConnections.isEmpty()) {
                Iterator iterator = this.audioConnections.valueIterator();
                while (iterator.hasNext()) {
                    AudioConnection audioConnection = (AudioConnection)iterator.next();
                    audioConnection.setAudioConnectionState(AudioConnectionState.LOST);
                }
            }
            this.audioConnections.clear();
        }
        this.releasingConnectionClients.clear();
    }
}

