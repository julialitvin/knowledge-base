**Build & Push**

docker build . -t yuliialytvyn/knowledge-base

docker push yuliialytvyn/knowledge-base

**Run on server**

docker rm -f kb

docker pull yuliialytvyn/knowledge-base

docker run -p 80:8080 -d --name kb yuliialytvyn/knowledge-base


**docker run -p 9200:9200 -e "http.host=0.0.0.0" -e "transport.host=127.0.0.1" docker.elastic.co/elasticsearch/elasticsearch:6.3.2**