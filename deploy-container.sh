#!sh
docker rm $(docker ps -a -q)
docker build . -t dbernat/springmvc-parent
docker build . -t dbernat/springmvc -f web/Dockerfile
docker run -d -ti -p 8088:8080 dbernat/springmvc