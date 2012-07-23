start "Mongo TestCluster - Node1" mongod --dbpath data/dbs/node1 --port 10001 --replSet testCluster/localhost:10002
start "Mongo TestCluster - Node2" mongod --dbpath data/dbs/node2 --port 10002 --replSet testCluster/localhost:10001
