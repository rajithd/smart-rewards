Ref : https://github.com/rajithd/smart-rewards/blob/master/README.md

### Please check https://github.com/rajithd/smart-rewards/blob/master/Design-patterns.md for design patterns used in this project.
--
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
2. Download hadoop http://www.webhostingjams.com/mirror/apache/hadoop/common/hadoop-1.2.1/hadoop-1.2.1.tar.gz
3. Extract hadoop-1.2.1.tar.gz by `tar -zxvf hadoop-1.2.1.tar.gz`
4. Copy three files in smart-rewards/distribution/hadoop_conf to /path/to/hadoop-1.2.1/conf
5. Open `~/.bashrc` file and add following lines.
   `HADOOP_HOME=/path/to/hadoop-1.2.1`
   'PATH=$PATH:$HADOOP_HOME/bin`
   `source ~/.bashrc`
6. Create a directory to store hadoop data files (HDFS files)
   `mkdir -p /tmp/hadoop`
   If you wish to create the directory in different location change the `/path/to/hadoop-1.2.1/conf/core-site.xml` `hadoop.tmp.dir` value
7. Finally follow this command to format namenode
   `hadoop namenode -format`
8. Start Hadoop
   `start-all.sh`
9. Type `jps` in console to find the hadoop processes are running

## 2. Hive Setup
1. Download hive : http://psg.mtu.edu/pub/apache/hive/hive-0.11.0/hive-0.11.0-bin.tar.gz
2. Extract hive-0.11.0-bin.tar.gz by `tar-zxvf hive-0.11.0.tar.gz`
2. Start hive server by `./hive --service hiveserver`

## 3. Mongo Setup
    `cd smart-rewards/distribution`
    `chmod 776 setup-mongo.sh`
    `./setup-mongo.sh`

    To create admin account
    `mongoimport --db rewards --collection users --file distribution/mongo-user.json --jsonArray`
    This will create admin/1234 user account for campaign management UI.

## 4. Generate Java Keystore
1. `cd smart-rewards/distribution/keystore`
2. `javac InstallCert.java`
3. `java InstallCert localhost:8443`
4. Type 1
5. `cp jssecacerts $JAVA_HOME/jre/lib/security`

# System Setup
Use the following command to build the system.
1. cd smart-rewards
2. `mvn clean install -DskipTests`

## 1. ESB Setup(Ultra Esb)
    Download link : http://downloads.adroitlogic.com/2.0.0/5b0bd7f9-c8b4-45de-9806-a200f67db666/adroitlogic-ultraesb-2.0.0.zip
    unzip the ultra-esb by unzip adroitlogic-ultraesb-2.0.0.zip
    Create folder in ultra esb to store configuration files by mkdir -p ultraesb-2.0.0/conf/deployments/rewards
    Copy file by using cp smart-rewards/distribution/ultra-esb-conf/ultra-unit.xml /path/to/ultraesb/conf/deployments/rewards
    cd ultra-esb-2.0.0/bin
    ./ultraesb.sh to start the esb server.

## 2. Log file simulate
    Since we don't have real CDR files we can use the simulators to generate.
    1. Create ftp folder in home directory.
        cd smart-rewards/distribution
        ./create-ftp-folder.sh
        
    2. cd smart-rewards/simulators
        cd sms_cdr
        perl sms_log_generator.pl
        Give number of records to generate (Tested with 100,000)
        Path to file shoud be ~/ftp/sms/source/sms-cdrlog1
        Give 1 

## 3. API component setup
    1. cp smart-rewards/modules/api/target/api.war <path-to-tomcat>/webapps
## 4. Campaign management setup
    1. cp smart-rewards/modules/campaign-management/target/campaign-management.war <path-to-tomcat>/webapps
    2. Start tomcat 
    3. http://localhost:8080/campaign-management/login (admin/1234)
## 5. Decoder setup
    1. unzip smart-rewards/modules/decoder/target/decoder.zip
    2. cd decoder
    3. vi conf/decoder.properties
    4. Changes folder path to appropriate paths
    5. cd bin
    6. `./decoder console` to start in console or `./decoder start` to start in background
## 6. Rule engine setup
    1. unzip smart-rewards/modules/rule-engine/target/rule-engine.zip
    2. cd rule-engine
    3. vi conf/rule-engine.properties 
    4. change email.recipient email address. This email will receive the winners phone numbers.
    3. cd bin
    4. `./rule-engine console` to start in console or `./rule-engine start` to start in background
    
# How to create a campaign
1. Before creating a campaign decoder needs to run successfully. It will decode any CDR log files and upload in mongo repository.
2. Then http://localhost:8080/campaign-management/login with admin/1234
3. Click create-campaign link locate in left side bar.
4. Fill up with fields. Please note start date and end date are crucial. So fill start date as today and end date as 1 month ahead. (use > sign)
5. Then run rule engine. Before that make sure all the hadoop and hive processes are running. Use jps to verify.
6. If winners found it will email to give mail address.
