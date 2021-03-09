FROM jdk:8
ARG JAR_FILE
ARG JAR_VERSION
ARG JAR_CREATETIME
ARG JMX_OPTS
ENV JMX_OPTS $JMX_OPTS
LABEL app-version ${JAR_VERSION}
LABEL app-createtime ${JAR_CREATETIME}
ADD target/${JAR_FILE} /app/app.jar
EXPOSE 8080 5555
ENTRYPOINT exec /sbin/tini -- java ${JMX_OPTS} -Djava.security.egd=file:/dev/./urandom -Dspring.config.location=/etc/config/ -Denv=${ENV} -Dapollo.meta=${ENV_META} -Dspring.profiles.active=${ENV_ACTIVE} -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5555  -jar /app/app.jar