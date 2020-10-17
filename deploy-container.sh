#!sh
docker build . -t dbernat/springmvc-parent
docker build . -t dbernat/springmvc -f web/Dockerfile
docker push dbernat/springmvc
kubectl delete pods springmvc-pod
kubectl apply -f k8s