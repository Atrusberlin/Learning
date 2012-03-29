use
learn;
// leeren der Collection durch entfernen der selben
// db.unicorns.drop();
db.unicorns.remove();

// einfuegen der Beispieldokumente
//db.unicorns.insert({name: 'Aurora', gender: 'f', weight: 450});
//db.unicorns.insert({name: 'Leto', gender: 'm', home: 'Arrakeen', worm: false});
db.unicorns.insert({name:'Horny', dob:new Date(1992, 2, 13, 7, 47), loves:['carrot', 'papaya'], weight:600, gender:'m', vampires:63});
db.unicorns.insert({name:'Aurora', dob:new Date(1991, 0, 24, 13, 0), loves:['carrot', 'grape'], gender:'f', weight:450, vampires:43});
db.unicorns.insert({name:'Unicrom', dob:new Date(1973, 1, 9, 22, 10), loves:['energon', 'redbull'], weight:450, gender:'m', vampires:182});
db.unicorns.insert({name:'Roooooodles', dob:new Date(1979, 7, 18, 18, 44), loves:['aple'], weight:575, gender:'m', vampires:99});
db.unicorns.insert({name:'Solnara', dob:new Date(1985, 6, 4, 2, 1), loves:['apple', 'carrot', 'choclate'], weight:550, gender:'f', vampires:80});
db.unicorns.insert({name:'Ayna', dob:new Date(1998, 2, 7, 8, 30), loves:['strawberry', 'lemon'], weight:730, gender:'f', vampires:70});
db.unicorns.insert({name:'Kenny', dob:new Date(1997, 6, 1, 10, 42), loves:['grape', 'lemon'], weight:690, gender:'m', vampires:39});
db.unicorns.insert({name:'Raleigh', dob:new Date(2005, 4, 3, 0, 57), loves:['apple', 'sugar'], weight:421, gender:'m', vampires:2});
db.unicorns.insert({name:'Leia', dob:new Date(2001, 9, 8, 14, 53), loves:['apple', 'watermelon'], weight:601, gender:'f', vampires:33});
db.unicorns.insert({name:'Pilot', dob:new Date(1997, 2, 1, 5, 3), loves:['apple', 'watermelon'], weight:650, gender:'m', vampires:54});
db.unicorns.insert({name:'Nimue', dob:new Date(1999, 11, 20, 16, 15), loves:['grape', 'carrot'], weight:540, gender:'f'});
db.unicorns.insert({name:'Dunx', dob:new Date(1976, 6, 18, 18, 18), loves:['grape', 'watermelon'], weight:704, gender:'m', vampires:165});

// employee collection
db.employees.drop();
db.employees.insert({_id:ObjectId("4d85c7039ab0fd70a117d730"), name:'Leto'});
db.employees.insert({_id:ObjectId("4d85c7039ab0fd70a117d731"), name:'Duncan', manager:ObjectId("4d85c7039ab0fd70a117d730")});
db.employees.insert({_id:ObjectId("4d85c7039ab0fd70a117d732"), name:'Moneo', manager:ObjectId("4d85c7039ab0fd70a117d730")});
db.employees.insert({_id:ObjectId("4d85c7039ab0fd70a117d733"), name:'Siona', manager:[ObjectId("4d85c7039ab0fd70a117d730"), ObjectId("4d85c7039ab0fd70a117d732")]});
db.employees.insert({_id:ObjectId("4d85c7039ab0fd70a117d734"), name:'Ghanima', family:{mother:'Chani', father:'Paul', brother:ObjectId("4d85c7039ab0fd70a117d730")}});