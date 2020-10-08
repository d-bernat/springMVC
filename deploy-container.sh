#!sh
docker rm $(docker ps -a -q)
docker build . -t dbernat/springmvc-parent
docker build . -t dbernat/springmvc -f console/Dockerfile
docker run -ti dbernat/springmvc