# Kubernetes certificate files with docket desktop in mmacos 

/Users/rahulanand/Library/Containers/com.docker.docker 


ETCDCTL_API=3 etcdctl \
   --cacert=/Users/rahulanand/Library/Containers/com.docker.docker/pki/etcd/ca.crt   \
   --cert=/Users/rahulanand/Library/Containers/com.docker.docker/pki/etcd/server.crt \
   --key=/Users/rahulanand/Library/Containers/com.docker.docker/pki/etcd/server.key  \
   get /registry/secrets/default/secret1 | hexdump -C