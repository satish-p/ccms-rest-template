#!/bin/bash
# chkconfig: 345 99 01
# description: Application Deploy Script
# Deployment procedure:
# 1. Copy version file
# 2. Run chef client

if [ "$#" -le 0 ]; then
    echo "Usage: $0 hostname1 [hostname2 ...]"
    exit 1
fi

if [ -z "$ENV" ]; then
    echo "Need to set ENV (dev, qa, prod, stage)"
    exit 1
fi

# Base Dir
SERVER_DIR=/data/servers
API_TOMCAT_DIR=$SERVER_DIR/cmi_template_tomcat
LOGGED_USER=root

# Set the version of app in data bag
echo "{\"id\":\"${ENV}-app\", \"version\": \"1.0.${SOURCE_BUILD_NUMBER}\"}" > build.json
knife data bag from file cmi-template build.json -c /home/b/bpsdv/chef_cc/${ENV}/.chef/knife.rb

# Invoke chef client on each host
for ARG in "$@"
do
	ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no -t -t $LOGGED_USER@$ARG chef-client
done

