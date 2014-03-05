Ref : https://github.com/rajithd/smart-rewards/blob/master/README.md

# Components
1. Campaign-management UI (war)
2. Decoder - Standalone
3. Rule-Executor - Standalone
4. API - war
5. Simulator

# Prerequisites
1. Java 1.6 or above
2. Maven 3.1.1 or above
3. Tomcat 7 or above
4. Perl 5 or above
5. Apache Hadoop 1.2.1
6. Apache Hive
7. MongoDB

# Server setup
## 1. Hadoop Setup
1. SSH Password less login
   `cat $HOME/.ssh/id_rsa.pub >> $HOME/.ssh/authorized_keys`
2. Extract hadoop-1.2.1.tar.gz located in smart-rewards/distribution by `tar -zxvf hadoop-1.2.1.tar.gz`
3. Open `~/.bashrc` file and add following lines.
   `HADOOP_HOME=/path/to/hadoop-1.2.1`
   'PATH=$PATH:$HADOOP_HOME/bin`
   `source ~/.bashrc`
4. Create a directory to store hadoop data files (HDFS files)
   `mkdir -p /tmp/hadoop`
   If you wish to create the directory in different location change the `/path/to/hadoop-1.2.1/conf/core-site.xml` `hadoop.tmp.dir` value
5. Finally follow this command to format namenode
   `hadoop namenode -format`
6. Start Hadoop
   `start-all.sh`
7. Type `jps` in console to find the hadoop processes are running

## 2. Hive Setup
1. Extract hive-0.11.0.tar.gz located in smart-rewards/distribution by `tar-zxvf hive-0.11.0.tar.gz`
2. Start hive server by `./hive --service hiveserver`

## 3. Mongo Setup
    `cd smart-rewards/distribution`
    `chmod 776 setup-mongo.sh`
    `./setup-mongo.sh`

## 4. Generate Java Keystore
1. `cd smart-rewards/distribution/keystore`
2. `javac InstallCert.java`
3. `java InstallCert localhost:8443`
4. Type 1
5. `cp jssecacerts $JAVA_HOME/jre/lib/security`

# System Setup
Upload all the component distribution to smart-rewards/distribution. If willing to build the system use the following command.
1. cd smart-rewards
2. `mvn clean install -DskipTests`

## 1. ESB Setup(Ultra Esb)
## 2. Log file simulate
## 3. Mongo data import (Admin)
## 4. API component setup
## 5. Campaign management setup
## 6. Decoder setup
## 7. Rule engine setup








