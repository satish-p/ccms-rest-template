#!/bin/bash
#

set -e

# Version and runtime
: ${VERSION:=1.0}
: ${ENV:=dev}

# Application
: ${APP_NAME:=cmitemplate}
: ${APP_PORT:=8080}
: ${LOGS_DIR:=/data/servers/logs}
: ${DOCKER_IMAGE:=docker.obi.aol.com/cmitemplate}

# New Relic Info
: ${NEW_RELIC_PATH:=/app}
: ${NEW_RELIC_LICENSE_KEY:=eb5e89da9efee611602fa805e64334f750c1776f}
: ${NEW_RELIC_APP_NAME:=api.dev.cmi.aol.com}

# JAVA_OPTS
JAVA_OPTS="-javaagent:${NEW_RELIC_PATH}/newrelic.jar \
-Dnewrelic.config.license_key=${NEW_RELIC_LICENSE_KEY} \
-Dnewrelic.config.app_name=${NEW_RELIC_APP_NAME}"

start() {
    docker_pull
    docker_run
    
    # Check status
    sleep 40
    pid="$(docker_pid)"
    if [ -n "$pid" ]
    then
        echo -e "\n$APP_NAME docker container started successfully."
    else
        echo -e "\n$APP_NAME docker container start failed, see logs."
        return 1
    fi
    
    return 0
}

docker_pull() {
    echo -e "Pulling docker image ${DOCKER_IMAGE}:${VERSION}"
    docker pull ${DOCKER_IMAGE}:${VERSION}
    return 0
}

docker_run() {
    echo -e "Running a container ${APP_NAME} with image ${DOCKER_IMAGE}:${VERSION}"
    docker run -d \
        --name ${APP_NAME} \
        -p ${APP_PORT}:8080 \
        -v ${LOGS_DIR}:${LOGS_DIR} \
        -e JAVA_OPTS="${JAVA_OPTS}" \
        ${DOCKER_IMAGE}:${VERSION} \
        --env=${ENV} \
        --logging.config=${LOGS_DIR}/logback-cmitemplate-${ENV}.xml
        
    return 0
}

docker_pid() {
    echo `docker ps $1 | grep $APP_NAME: | awk '{print $1}'`
}

stop() {
    pid=$(docker_pid)
    if [ -n "$pid" ]
    then
        # Shut down app
        echo -e "Turning off nstest"
        curl -m 5 http://localhost:${APP_PORT}/_ns_/nstest.html.stop
        
        # Wait for a few
        echo -e "\nWaiting for a 10 seconds"
        sleep 10
        
        # Stop the container
        echo "Stopping $APP_NAME docker container (pid: $pid)"
        docker stop ${APP_NAME}
        sleep 1
    else
        echo "$APP_NAME docker container is not running"
    fi
    return 0
}

remove() {
    pid=$(docker_pid -a)
    if [ -n "$pid" ]
    then
        echo "Removing $APP_NAME docker container (pid: $pid)"
        docker rm ${APP_NAME}
    else
        echo "$APP_NAME docker container not found"
    fi
    return 0
}

status() {
    pid=$(docker_pid)
    if [ -n "$pid" ]
    then
        echo "$APP_NAME container is running with pid: $pid"
    else
        echo "$APP_NAME container is not running"
    fi
}

case $1 in
    start)
        start
        ;;
    stop)
        stop
        ;;
    remove)
        remove
        ;;
    restart)
        docker_pull
        stop
        remove
        start
        ;;
    status)
        status
        ;;
    *)
        echo "Usage: $0 {start|stop|remove|restart|status}"
        exit 1
        ;;
esac

exit 0


