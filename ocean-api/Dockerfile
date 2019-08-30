FROM docker-registry-default.dev.ipaas.frxs.com/openshift/openjdk:8u222

RUN mkdir -p  /opt/webapps

COPY ./ocean-api/target/ocean-api-0.0.1.jar  /opt/webapps

LABEL maintainer=wenglifeng@xsyxsc.com

WORKDIR /opt/webapps

CMD ["java","-jar","ocean-api-0.0.1.jar"]
