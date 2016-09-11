FROM node:5

MAINTAINER David Calle "davidfcalle@gmail.com"

COPY ./code/package.json ./code/typings.json /code/

WORKDIR /code
RUN npm install
RUN rm -rf *.json


ENTRYPOINT ["npm", "start"]
EXPOSE 3000