# WENET ILOGBASE

## Introduction

The iLogBase is a component that manages streams of data. The streams of data are mainly coming from the iLog application (user sensors and user feedback). The other flow of information comes from other external services. The iLogBase provides the services for saving and sharing the streams so that any component of the WeNet infrastructure can collaborate and use the streams of data.

The iLogBase provides services for handling big data. The services include the management of streams of data with batch services and with subscription/notification services. The internal components of the WeNet infrastructure can obtain batch information or register to a feed subscription.

The services developed in this repository give the Users access to the streams. Follow the existing documentation for more details.

## Setup and Configuration

The iLogBase component requires Java version 8 or later.

You can run the iLogBase using maven:

```
mvn clean package

java -jar target/ilogbase-<version>.jar 
```

## Usage

Once the component is up and running, it will expose a set of APIs to retrieve data and make new subscriptions. You can issue your own requests as described in the documentation.

## Testing

Run the tests:

```
mvn test
```
## Docker Support 

Alternatively you can run iLogBase using docker.

You will need to install docker and docker-compose. 

Once you have both of them installed you can simply run the following command:

```
docker-compose -f docker-compose-ilogbase.yml up
```

## Server

The testing server instance of this component can be found at https://wenet.u-hopper.com/dev/streambase

## Documentation

For details on how to use the APIs read the [iLogBase documentation](http://swagger.u-hopper.com/?url=https://bitbucket.org/wenet/wenet-components-documentation/raw/master/sources/wenet-ilogbase-openapi.json#/).

## Contacts


- Marcelo Dario Rodas Britez (marcelo.rodasbritez@unitn.it)

- Sergio de Cristofaro (s.decristofaro@unitn.it)
