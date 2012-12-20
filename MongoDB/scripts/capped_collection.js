db.createCollection("audit", {capped: true, size: 1024, max: 100})
db.audit.validate()