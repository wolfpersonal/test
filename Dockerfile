FROM docker-registry-default.dev.ipaas.frxs.com/openshift/redhat-openjdk18-openshift:1.2
LABEL maintainer=wenglifeng@xsyxsc.com

RUN mkdir /bootstrap

RUN mkdir -p /opt/settings/
RUN touch /opt/settings/server.propertis
RUN echo "env=DEV \n apollo.meta=http://172.16.10.221:8112" > /opt/settings/server.propertis

COPY ocean-api/target/ocean-api-0.0.1-SNAPSHOT.jar /bootstrap

WORKDIR /bootstrap	

CMD ["java","-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-XX:MaxRAMFraction=2", \
     "-jar","-Dfile.encoding=UTF-8","ocean-api-0.0.1-SNAPSHOT.jar"]
