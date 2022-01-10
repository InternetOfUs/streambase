#!/bin/bash
SERVER="internetofus"
MODULE_NAME="ilogbase"
MODULE_VERSION="2.5.0"
USERNAME="wenetsw"
TAG="2.5.0"
# Read Password
echo -n Password: 
read -s password
echo
PASSWORD=$password


docker build . -t $SERVER/$MODULE_NAME:$MODULE_VERSION


if [[ $1 = "" ]]; then
    exit 0
else
    if [ $1 = "push" ]; then
        docker login -u $USERNAME -p $PASSWORD
        docker push $SERVER/$MODULE_NAME:$MODULE_VERSION
    fi
fi

# docker tag internetofus/ilogbase:1.6.3 internetofus/ilogbase:latest
docker tag $SERVER/$MODULE_NAME:$MODULE_VERSION $SERVER/$MODULE_NAME:$TAG
