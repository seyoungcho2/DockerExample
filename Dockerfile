# JDK 17 이미지 사용하기
FROM eclipse-temurin:17

# 모든 명령이가 실행될 디렉토리 설정
WORKDIR /app

# 이미지 내부에 들어가야 할 경로 설정. 현재 경로의 모든 파일들이 도커 컨테이너의 app 디렉토리에 복사
COPY build/libs/SimpleApplication-0.0.1-SNAPSHOT.jar app.jar

# 도커 컨테이너 내부의 8080번 포트를 외부로 노출
EXPOSE 8080

# ENTRYPOINT를 사용해 컨테이너가 시작될 때 실행할 명령어를 지정
ENTRYPOINT ["java", "-jar", "app.jar"]
