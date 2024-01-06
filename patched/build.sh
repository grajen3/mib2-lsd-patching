#!/bin/bash
set -e
. ../process.sh

FILES="\
de/esolutions/fw/comm/dsi/androidauto2/impl/DSIAndroidAuto2ReplyService.java \
de/esolutions/fw/comm/dsi/carplay/impl/DSICarplayProxy.java \
de/vw/mib/asl/internal/androidauto/target/RequestHandler.java \
de/vw/mib/asl/internal/androidauto/target/NavigationListener.java \
de/vw/mib/asl/internal/navigation/api/impl/ASLNavigationServices.java \
de/vw/mib/asl/internal/exboxm/api/impl/guidance/ExboxGuidanceManagerImpl.java \
de/esolutions/fw/dsi/androidauto/DSIAndroidAutoDispatcher.java \
de/esolutions/fw/dsi/androidauto2/DSIAndroidAuto2Dispatcher.java \
de/vw/mib/bap/mqbab2/audiosd/functions/CurrentStationInfo.java \
de/vw/mib/bap/mqbab2/navsd/functions/DistanceToNextManeuver.java \
de/vw/mib/bap/mqbab2/navsd/functions/ManeuverDescriptor.java \
de/vw/mib/bap/mqbab2/navsd/functions/RGStatus.java \
de/vw/mib/bap/mqbab2/navsd/functions/TurnToInfo.java \
"

find . -name "*.class" -type f -delete
for j in $FILES; do
echo "Compiling $j"
${JAVA_HOME}/bin/javac -source 1.2 -target 1.2 -cp ".:${JAR}" $j
done

#python2 ../Krakatau/assemble.py de/vw/mib/asl/internal/mostkombi/streamsink/usecases/ChangeDataRateSequence.j

#javac -source 1.2 -target 1.2 de/vw/mib/log4mib/internal/LoggingThread.java
#jar cvf LoggingPatcher.jar de/vw/mib/log4mib/internal/LoggingThread.class

CLASSES=""
for i in $FILES; do
    classPattern=$(echo $i | sed -r 's:\.java:*.class:g')
    classFiles=$(find . -path "./$classPattern" -type f)
    CLASSES="$CLASSES $classFiles"
done
# echo "$CLASSES"

jar cvf NavActiveIgnore.jar $CLASSES

ssh mibw sh -l /root/.profile
#scp LoggingPatcher.jar mibw:/mnt/app/eso/hmi/lsd/jars/
scp NavActiveIgnore.jar mibw:/mnt/app/eso/hmi/lsd/jars/

