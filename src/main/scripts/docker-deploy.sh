#!/bin/bash
# chkconfig: 345 99 01
# description: Application Deploy Script
# Deployment procedure:
# 1. Copy service init script file
# 2. Run docker restart with env and version

if [ "$#" -le 0 ]; then
    echo "Usage: $0 hostname1 [hostname2 ...]"
    exit 1
fi

if [ -z "$ENV" ]; then
    echo "Need to set ENV (dev, qa, prod, stage)"
    exit 1
fi

if [ -z "$SOURCE_BUILD_NUMBER" ]; then
    echo "Need to set SOURCE_BUILD_NUMBER (1.0.400)"
    exit 1
fi

API_DIR=/data/servers/cmi-template
LOGS_DIR=/data/servers/logs
LOGGED_USER=root
: ${APP_PORT:=8080}

# Invoke script on each host
for ARG in "$@"
do
	HOSTNAME=$ARG

    ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no -t -t \
            $LOGGED_USER@$HOSTNAME \
            mkdir -p $API_DIR $LOGS_DIR
    
	scp -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no \
			src/main/scripts/docker.init.sh \
			$LOGGED_USER@$HOSTNAME:$API_DIR/docker.cmitemplate.init.sh

    scp -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no \
            src/main/resources/logs/* \
            $LOGGED_USER@$HOSTNAME:$LOGS_DIR/

	ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no -t -t \
			$LOGGED_USER@$HOSTNAME \
			ENV=$ENV VERSION=1.0.$SOURCE_BUILD_NUMBER APP_PORT=$APP_PORT \
			bash -ex \
			$API_DIR/docker.cmitemplate.init.sh restart
done

