#!/bin/bash
SCRIPT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )

JXE=car_lsd.jxe

JAVA_HOME=${SCRIPT_DIR}/jdk

JAR=${SCRIPT_DIR}/${JXE%.jxe}.jar
JAVA=${SCRIPT_DIR}/${JXE%.jxe}_java
ASM=${SCRIPT_DIR}/${JXE%.jxe}_asm

if [ ! -e $JAR ]; then
  python2 -m pip install bitstring
  python2 jxe2jar/src/JXE2JAR.py $JXE $JAR
fi

if [ ! -e $JAVA ]; then
  java -jar cfr-0.152.jar --previewfeatures false --switchexpression false --outputdir $JAVA $JAR
fi

if [ ! -e $ASM ]; then
  python2 Krakatau/disassemble.py -roundtrip -out $ASM $JAR
fi

if [ ! -e $JAVA_HOME ]; then
  mkdir $JAVA_HOME
  pushd $JAVA_HOME
  unzip ../ibm-java-ws-sdk-pxi3260sr4ifx.zip
  popd
fi
