#!/bin/sh
mvn clean package && docker build -t com.sandeep/HelloWorld .
docker rm -f HelloWorld || true && docker run -d -p 8080:8080 -p 4848:4848 --name HelloWorld com.sandeep/HelloWorld 
