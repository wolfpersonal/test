FROM docker-registry-default.dev.ipaas.frxs.com/openshift/redhat-openjdk18-openshift:1.2 AS BUILD
COPY . /usr/src/app/

FROM docker-registry-default.dev.ipaas.frxs.com/openshift/redhat-openjdk18-openshift:1.2
LABEL maintainer=wenglifeng@xsyxsc.com

WORKDIR /home
COPY --from=BUILD /usr/src/app/ocean-gateway/ocean-api/target/ocean-api-0.0.1-SNAPSHOT.jar /home

CMD ["java","-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-XX:MaxRAMFraction=2", \
     "-jar","-Dfile.encoding=UTF-8","ocean-api-0.0.1-SNAPSHOT.jar"]
