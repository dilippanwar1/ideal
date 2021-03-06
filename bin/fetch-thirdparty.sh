#!/bin/sh

THIRDPARTY=thirdparty

if [ ! -d isource -o ! -d ideal ] ; then
  echo This script must be run from the top-level directory.
  exit
else
  echo Preparing to initialize ${THIRDPARTY}.
fi

if [ ! -d ${THIRDPARTY} ] ; then
  mkdir ${THIRDPARTY}
fi

cd ${THIRDPARTY}

echo Fetching JSR 305 annotations via https://code.google.com/p/jsr-305/
curl -O https://google-collections.googlecode.com/svn/trunk/lib/jsr305.jar
echo

MAVEN2=http://central.maven.org/maven2

echo Fetching JUnit4 via http://junit.org/
JUNIT_VERSION=4.12
curl -O ${MAVEN2}/junit/junit/${JUNIT_VERSION}/junit-${JUNIT_VERSION}.jar
echo

echo Fetching Google Gson via https://github.com/google/gson
GSON_VERSION=2.5
curl -O ${MAVEN2}/com/google/code/gson/gson/${GSON_VERSION}/gson-${GSON_VERSION}.jar
echo

echo Fetching JavaCUP via http://www2.cs.tum.edu/projects/cup/
JAVACUP_VERSION=11b-20151001
JAVACUP_TGZ=java-cup-bin-${JAVACUP_VERSION}.tar.gz
curl -O http://www2.cs.tum.edu/projects/cup/releases/${JAVACUP_TGZ}
tar xfz ${JAVACUP_TGZ}
echo

echo Fetching AppEngine SDK for Java via https://developers.google.com/appengine/downloads
APPENGINE_VERSION=1.9.30
APPENGINE_ZIP=appengine-java-sdk-${APPENGINE_VERSION}.zip
curl -O https://storage.googleapis.com/appengine-sdks/featured/${APPENGINE_ZIP}
unzip -q ${APPENGINE_ZIP}
echo

JDK=jdk
if [ ! -d ${JDK} ] ; then
  echo ${THIRDPARTY}/${JDK} must be symlinked to JDK home.
  echo Trying to detect JDK home automatically--should work on OS X...
  ln -s `/usr/libexec/java_home` ${JDK}
fi
