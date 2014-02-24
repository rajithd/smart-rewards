#!/bin/sh
echo "=============== Starting to install mongo as a service ==================="
sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 7F0CEB10
echo 'deb http://downloads-distro.mongodb.org/repo/ubuntu-upstart dist 10gen' | sudo tee /etc/apt/sources.list.d/mongodb.list
sudo apt-get update
echo "================== Installing mongo ============================"
sudo apt-get install mongodb-10gen
echo "================== Install Completed ============================"