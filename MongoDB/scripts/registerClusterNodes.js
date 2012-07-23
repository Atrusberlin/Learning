// im Context von einem Cluster-Node ausführen
db.runCommand({"replSetInitiate":{
  "_id":"testCluster",
  "members":[
    {
      "_id":1,
      "host":"localhost:10001"
    },
    {
      "_id":2,
      "host":"localhost:10002"
    }
  ]}})
