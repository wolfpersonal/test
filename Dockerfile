FROM docker-registry-default.dev.ipaas.frxs.com/openshift/redhat-openjdk18-openshift:1.2
LABEL maintainer=wenglifeng@xsyxsc.com

RUN mkdir /opt

COPY ocean-api/target/ocean-api-0.0.1-SNAPSHOT.jar /opt

WORKDIR /opt	

CMD ["java","-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-XX:MaxRAMFraction=2", \
     "-jar","-Dfile.encoding=UTF-8","ocean-api-0.0.1-SNAPSHOT.jar"]
