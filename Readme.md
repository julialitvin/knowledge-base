**Build & Push**

docker build . -t yuliialytvyn/knowledge-base

docker push yuliialytvyn/knowledge-base

**Run on server**

docker rm -f kb

docker pull yuliialytvyn/knowledge-base

docker run -p 80:8080 -d --name kb yuliialytvyn/knowledge-base