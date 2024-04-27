# Use a imagem base do OpenJDK 8 com Alpine Linux
FROM alpine:3.19.1

# Instale o Maven
RUN apk add --no-cache maven

# Diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie os arquivos necessário para a execução do contêiner
COPY ../src /app/src
COPY ../pom.xml /app/



# Porta em que sua aplicação será executada exposta (substitua pela porta correta)
EXPOSE 8080

# Comando para executar sua aplicação usando Maven e o plugin Jetty
CMD ["mvn", "jetty:run"]
