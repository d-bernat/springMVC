#!sh
TIMESTAMP=$(date "+%Y%m%d%H%M%S")
echo $TIMESTAMP
docker build . -t dbernat/springmvc-parent
docker build . -t dbernat/springmvc:latest -t dbernat/springmvc:$TIMESTAMP -f web/Dockerfile
docker push dbernat/springmvc:$TIMESTAMP
docker push dbernat/springmvc:latest
kubectl apply -f k8s
kubectl set image deployments/springmvc-deployment  springmvc=dbernat/springmvc:$TIMESTAMP