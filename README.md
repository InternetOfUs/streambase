# WENET ILogbase and Commons APIs

## Introduction

The repository is a component that manages streams of data. The streams of data are mainly coming from the iLog application (user sensors and user feedback). The other flow of information comes from other external services. The iLogBase provides the services for saving and sharing the streams so that any component of the WeNet infrastructure can collaborate and use the streams of data.

The iLogbase provides services for handling big data. The services include the management of streams of data with batch services and with subscription/notification services.

The Commons APIS provides services for the external Applications that want to collaborate with the platform by inputing data. 

The services developed in this repository give the Users access to the streams. Follow the existing documentations for more details.

## Implementation Organization

From the logical architecture of the WeNet Platform we have two related modules: Commons APIs and ILogbase. 

The WeNet Commons APIs and iLogbase components are tightly coupled and shipped together as a single software package (this repository). 

## Setup and Configuration

### Software requirements

This package requires Java version 8 or later and maven for the library management.

### Additional Required Components

For the full storage of the information this package requires 3 additional components:

1. Cassandra Server: Database for managing the storage and access to the streams.
2. MySql Server: Database for handling the users and configurations.
3. Batch-subscriptions-data module: Services needed for handling the storage of data which works together with iLogbase services. This module is property of UNITN.

### Running

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

* The Production server instance of ILogbase can be found at https://internetofus.u-hopper.com/prod/streambase (only for internal components)
* The Production server instance of Commons APIs can be found at https://internetofus.u-hopper.com/prod/api/commons

## Documentation

* For details on how to use the APIs read the [iLogBase documentation](http://swagger.u-hopper.com/?url=https://bitbucket.org/wenet/wenet-components-documentation/raw/master/sources/wenet-ilogbase-openapi.yaml#/).
* For details on how to use the APIs read the [Commons APIs documentation](http://swagger.u-hopper.com/?url=https://bitbucket.org/wenet/wenet-components-documentation/raw/master/sources/wenet-common_api-openapi.yaml#/).

## Contacts


- Marcelo Rodas Britez (marcelo.rodasbritez@unitn.it)

- Alessio Zamboni (alessio.zamboni@unitn.it)

## Collaborators 

* Sergio de Cristofaro
* Ronald Chenu Abente
* Marcelo Rodas Britez
* Alessio Zamboni
