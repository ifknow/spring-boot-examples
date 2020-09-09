# 使用 JDK 8 环境为基础环境，如果镜像不是本地的将会从 DockerHub进行下载
FROM openjdk:8-jdk-alpine
# 在宿主机的 /var/lib/docker 目录下创建一个临时文件并把它链接到 tomcat 容器的工作目录 /tmp目录
VOLUME /tmp
# 复制文件并重命名
ADD spring-boot-docker-1.0.jar app.jar
# 为了缩短Tomcat启动时间，添加 java.security.egd 的系统属性指向 /dev/urandom 作为ENTRYPOINT
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

