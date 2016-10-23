FROM openjdk:8

MAINTAINER David Calle "davidfcalle@gmail.com"


RUN apt-get -y update && apt-get -f -y install && apt-get install -y --no-install-recommends build-essential checkinstall
# Install Node.js
RUN \
  cd /tmp && \
  wget http://nodejs.org/dist/node-latest.tar.gz && \
  tar xvzf node-latest.tar.gz && \
  rm -f node-latest.tar.gz && \
  cd node-v* && \
  ./configure && \
  CXX="g++ -Wno-unused-local-typedefs" make && \
  CXX="g++ -Wno-unused-local-typedefs" make install && \
  cd /tmp && \
  rm -rf /tmp/node-v* && \
  npm install -g npm && \
  printf '\n# Node.js\nexport PATH="node_modules/.bin:$PATH"' >> /root/.bashrc

ADD /clubmat-backend /App

WORKDIR /App/src/main/resources/code

RUN ["npm", "install"]

RUN ["npm", "run", "tsc"]

RUN npm rebuild node-sass

RUN ["npm", "run", "gulp"]

WORKDIR /App

ENTRYPOINT ["./mvnw", "spring-boot:run"]

EXPOSE 80
