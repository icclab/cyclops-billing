#!/bin/bash
apt-get update
echo "---------------------------------------------------------------------------"
echo "| Installing the Java openjdk-7-jre"
echo "| Java 7 is the baseline Java version"
echo "---------------------------------------------------------------------------"
apt-get install -y openjdk-7-jre
apt-get install -y openjdk-7-jdk
echo "---------------------------------------------------------------------------"
echo "| Installing Ruby, ruby-dev and Ruby build-essential"
echo "---------------------------------------------------------------------------"
apt-get install -y ruby ruby-dev build-essential
echo "---------------------------------------------------------------------------"
echo "| Installing Maven and Git"
echo "---------------------------------------------------------------------------"
apt-get install -y maven2
apt-get install -y git-core
echo "---------------------------------------------------------------------------"
echo "| Installing curl"
echo "| Dependent packages - libc6 libcurl3 zlib1g "
echo "---------------------------------------------------------------------------"
apt-get install -y curl
echo "---------------------------------------------------------------------------"
echo "| Installing tomcat7 and tomcat7-admin"
echo "---------------------------------------------------------------------------"
apt-get install -y tomcat7
apt-get install -y tomcat7-admin
echo "---------------------------------------------------------------------------"
echo "| Installing the v0.8.8 release of InfluxDB"
echo "---------------------------------------------------------------------------"
mkdir -p /tmp/rcservice
wget http://get.influxdb.org/influxdb_0.8.8_amd64.deb -P /tmp/rcservice
echo "---------------------------------------------------------------------------"
echo "| Decompressing the InfluxDB package"
echo "---------------------------------------------------------------------------"
dpkg -i /tmp/rcservice/influxdb_0.8.8_amd64.deb
echo "---------------------------------------------------------------------------"
echo "| Starting InfluxDB"
echo "---------------------------------------------------------------------------"
/etc/init.d/influxdb restart
echo "---------------------------------------------------------------------------"
echo "| Adding a manager for Tomcat "
echo "| user : admin ¦ password: Yh9hvmhGeBl"
echo "---------------------------------------------------------------------------"
cat > /etc/tomcat7/tomcat-users.xml << EOF
<?xml version='1.0' encoding='utf-8'?>
<!--
  Licensed to the Apache Software Foundation (ASF) under one or more
  contributor license agreements.  See the NOTICE file distributed with
  this work for additional information regarding copyright ownership.
  The ASF licenses this file to You under the Apache License, Version 2.0
  (the "License"); you may not use this file except in compliance with
  the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
-->
<!--
  NOTE:  By default, no user is included in the "manager-gui" role required
  to operate the "/manager/html" web application.  If you wish to use this app,
  you must define such a user - the username and password are arbitrary.
-->
<!--
  NOTE:  The sample user and role entries below are wrapped in a comment
  and thus are ignored when reading this file. Do not forget to remove
  <!.. ..> that surrounds them.
-->
<!--
  <role rolename="tomcat"/>
  <role rolename="role1"/>
  <user username="tomcat" password="tomcat" roles="tomcat"/>
  <user username="both" password="tomcat" roles="tomcat,role1"/>
  <user username="role1" password="tomcat" roles="role1"/>
-->
<tomcat-users>
    <user username="admin" password="Yh9hvmhGeBl" roles="manager-gui"/>
</tomcat-users>
EOF
echo "---------------------------------------------------------------------------"
echo "| Triggering the build for RC Service and creation of WAR file "
echo "---------------------------------------------------------------------------"
cd ${CURRDIR}
cd ..
mvn clean install
echo "---------------------------------------------------------------------------"
echo "| Deploying the WAR file to the Tomcat "
echo "---------------------------------------------------------------------------"
cd target
cp cyclops*.war /var/lib/tomcat7/webapps/billing.war
echo "---------------------------------------------------------------------------"
echo "| Restarting Tomcat "
echo "---------------------------------------------------------------------------"
service tomcat7 restart
echo "---------------------------------------------------------------------------"
echo "| Starting Redis"
echo "---------------------------------------------------------------------------"
service redis-server restart
echo "---------------------------------------------------------------------------"
echo "| Removing the temp/udrservice folder"
echo "---------------------------------------------------------------------------"
rm -fR /tmp/rcservice